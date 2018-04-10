package com.github.jmodel.calculator.entity.instance;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.CalculationException;
import com.github.jmodel.calculator.CalculatorTerms;
import com.github.jmodel.calculator.entity.template.Template;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Instance extends InstanceItem {

	@JsonIgnore
	private Template template;

	private Map<String, Aggregation> aggregations;

	private String errorMsg;

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Map<String, Aggregation> getAggregations() {
		return aggregations;
	}

	public void setAggregations(Map<String, Aggregation> aggregations) {
		this.aggregations = aggregations;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * Calculate for the instance.
	 */
	public final void execute() {

		if (getTemplate() == null) {
			setErrorMsg(this.getTemplateTerm() + ":" + CalculatorTerms.E_TEMPLATE_NOT_FOUND);
			return;
		}

		try {
			for (Map.Entry<String, Map<String, InstanceItem>> entry : getSubInstanceItemMaps().entrySet()) {
				entry.getValue().forEach((iTerm, instanceItem) -> {
					recurrenceExecute(getTemplate(), this, this, instanceItem);
				});
			}
		} catch (CalculationException e) {
			setErrorMsg(e.getMessage());
		}
	}

	/**
	 * Instance has a hierarchy structure. The calculation is executed from the
	 * bottom up.
	 * 
	 * @param template
	 *            template
	 * @param instance
	 *            instance
	 * @param parentInstanceItem
	 *            parent instance item
	 * @param instanceItem
	 *            current instance item
	 */
	private void recurrenceExecute(Template template, Instance instance, InstanceItem parentInstanceItem,
			InstanceItem instanceItem) {

		Map<String, Map<String, InstanceItem>> subInstanceItemMaps = instanceItem.getSubInstanceItemMaps();
		if (subInstanceItemMaps != null && subInstanceItemMaps.size() > 0) {
			for (Map.Entry<String, Map<String, InstanceItem>> entry : subInstanceItemMaps.entrySet()) {
				entry.getValue().forEach((iTerm, subInstanceItem) -> {
					recurrenceExecute(template, instance, instanceItem, subInstanceItem);
				});
			}
		}
		instanceItem.execute(template, instance, parentInstanceItem);
	}
}
