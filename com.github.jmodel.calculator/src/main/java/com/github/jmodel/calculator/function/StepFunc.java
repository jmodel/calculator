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
 * 
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

					InstanceItem matchedInstanceItem = findInstanceElement(context.getInstanceItem(),
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

	protected String findRawAttributeValue(InstanceItem instanceItem, String mapToTemplateItemTypeTerm,
			String mapToTemplateItemTerm, String mapToAttribute) {
		InstanceItem foundInstanceItem = findInstanceElement(instanceItem, mapToTemplateItemTypeTerm,
				mapToTemplateItemTerm);
		if (foundInstanceItem != null && foundInstanceItem.getAttributes() != null) {
			return foundInstanceItem.getAttributes().get(mapToAttribute);
		}
		return null;
	}

	protected InstanceItem findInstanceElement(InstanceItem instanceItem, String mapToTemplateItemTypeTerm,
			String mapToTemplateItemTerm) {

		if (instanceItem.getTypeTerm().equals(mapToTemplateItemTypeTerm)
				&& instanceItem.getTemplateTerm().equals(mapToTemplateItemTerm)) {
			return instanceItem;
		}

		if (instanceItem.getParentInstanceItem() == null) {
			return null;
		}

		return findInstanceElement(instanceItem.getParentInstanceItem(), mapToTemplateItemTypeTerm,
				mapToTemplateItemTerm);
	}

	protected abstract BigDecimal calculate(Context context, StepDef stepDef, Step step, StepDef depStepDef,
			Step depStep);
}
