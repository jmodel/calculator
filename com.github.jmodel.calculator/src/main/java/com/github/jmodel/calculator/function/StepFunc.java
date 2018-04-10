package com.github.jmodel.calculator.function;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiConsumer;

import com.github.jmodel.calculator.CalculatorTerms;
import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.instance.Instance;
import com.github.jmodel.calculator.entity.instance.InstanceItem;
import com.github.jmodel.calculator.entity.instance.Step;
import com.github.jmodel.calculator.entity.template.AggregationDef;
import com.github.jmodel.calculator.entity.template.Condition;
import com.github.jmodel.calculator.entity.template.StepDef;
import com.github.jmodel.calculator.entity.template.Template;
import com.github.jmodel.calculator.entity.template.TemplateItem;

/**
 * General calculation procedure of a step.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class StepFunc implements BiConsumer<Context, Step> {

	@Override
	public final void accept(Context context, Step step) {

		//

		Template template = context.getTemplate();
		Instance instance = context.getInstance();
		InstanceItem instanceItem = context.getInstanceItem();
		TemplateItem templateItem = context.getTemplateItem();

		//

		List<StepDef> stepDefs = templateItem.getStepDefs();
		StepDef stepDef = stepDefs.get(step.getIndex());
		List<Step> steps = instanceItem.getSteps();
		Integer depStepIndex = stepDef.getDepStepIndex();
		if (depStepIndex != null) {
			StepDef depStepDef = stepDefs.get(depStepIndex);
			Step depStep = steps.get(depStepIndex);

			boolean isValid = true;
			List<Condition> conditions = stepDef.getConditions();
			if (conditions != null && conditions.size() > 0) {
				for (Condition condition : conditions) {

					InstanceItem matchedInstanceItem = findInstanceItem(context.getInstanceItem(),
							condition.getMapToTemplateItemTypeTerm(), condition.getMapToTemplateItemTerm());
					if (matchedInstanceItem != null) {
						String attributeValue = (String) matchedInstanceItem.getAttributes()
								.get(condition.getMapToAttribute());
						if (!(condition.getExpectValue().equals(attributeValue))) {
							isValid = false;
							break;
						}
					}
				}
			}

			if (isValid) {
				step.setValue(calculate(context, stepDef, step, depStepDef, depStep));

				String operatorTerm = stepDef.getOperatorTerm();
				if (operatorTerm != null && operatorTerm.equals(CalculatorTerms.OPERATOR_SUBSTRACT)) {
					step.setCvalue(depStep.getCvalue().subtract(step.getValue()));
				} else {
					step.setCvalue(step.getValue());
				}
			} else {
				step.setValue(BigDecimal.ZERO);
				step.setCvalue(depStep.getCvalue());
			}
		} else {
			step.setValue(calculate(context, stepDef, step, null, null));
			step.setCvalue(step.getValue());
		}

		//

		aggregate(template, instance, instanceItem, step);
	}

	/**
	 * Aggregate values based on the definition of aggregation. The aggregation is
	 * at instance level.
	 * 
	 * @param template
	 *            template
	 * @param instance
	 *            instance
	 * @param instanceItem
	 *            current instance item
	 * @param step
	 *            step instance
	 */
	protected final void aggregate(Template template, Instance instance, InstanceItem instanceItem, Step step) {

		instance.getAggregations().forEach((term, aggregation) -> {
			AggregationDef aggregationDef = (AggregationDef) template.getSubTemplateItemMaps()
					.get(CalculatorTerms.AGGREGATION).get(term);
			if (aggregationDef.getStepDefIndex().contains(step.getIndex())
					&& aggregationDef.getTemplateItemTerms().contains(instanceItem.getTerm())) {
				if (aggregationDef.isUseCvalue()) {
					aggregation.setValue(aggregation.getValue().add(step.getCvalue()));
				} else {
					aggregation.setValue(aggregation.getValue().add(step.getValue()));
				}
			}
		});
	}

	/**
	 * Get the raw value (String) of a attribute of the instance item which meets
	 * conditions.
	 * 
	 * @param instanceItem
	 *            the current instance item
	 * @param mapToTemplateItemTypeTerm
	 *            term of template item type
	 * @param mapToTemplateItemTerm
	 *            term of template item
	 * @param mapToAttribute
	 *            the attribute name of template item
	 * @return the raw value of a attribute
	 */
	protected String findRawAttributeValue(InstanceItem instanceItem, String mapToTemplateItemTypeTerm,
			String mapToTemplateItemTerm, String mapToAttribute) {

		InstanceItem foundInstanceItem = findInstanceItem(instanceItem, mapToTemplateItemTypeTerm,
				mapToTemplateItemTerm);
		if (foundInstanceItem != null && foundInstanceItem.getAttributes() != null) {
			return foundInstanceItem.getAttributes().get(mapToAttribute);
		}
		return null;
	}

	/**
	 * Look for the instance item (by template item type term and template item
	 * term) from current instance item up. Instance item is hierarchical.
	 * 
	 * @param instanceItem
	 *            the current instance item
	 * @param mapToTemplateItemTypeTerm
	 *            term of template item type
	 * @param mapToTemplateItemTerm
	 *            term of template item
	 * @return the instance item that meets conditions
	 */
	protected InstanceItem findInstanceItem(InstanceItem instanceItem, String mapToTemplateItemTypeTerm,
			String mapToTemplateItemTerm) {

		if (instanceItem.getTypeTerm().equals(mapToTemplateItemTypeTerm)
				&& instanceItem.getTemplateTerm().equals(mapToTemplateItemTerm)) {
			return instanceItem;
		}

		if (instanceItem.getParentInstanceItem() == null) {
			return null;
		}

		return findInstanceItem(instanceItem.getParentInstanceItem(), mapToTemplateItemTypeTerm, mapToTemplateItemTerm);
	}

	/**
	 * Calculate the value of a step.
	 * 
	 * @param context
	 *            context of calculation
	 * @param stepDef
	 *            definition of the step
	 * @param step
	 *            step instance
	 * @param depStepDef
	 *            definition of the dependent step
	 * @param depStep
	 *            dependent step instance
	 * @return the value of the step
	 */
	protected abstract BigDecimal calculate(Context context, StepDef stepDef, Step step, StepDef depStepDef,
			Step depStep);
}
