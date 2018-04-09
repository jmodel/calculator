package com.github.jmodel.calculator.entity.instance;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.template.Template;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Instance extends InstanceItem {

	/**
	 * Template instance is set during calculation procedure.
	 */
	@JsonIgnore
	private Template template;

	private Map<String, Aggregation> aggregations;

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

	public void execute() {
		for (Map.Entry<String, Map<String, InstanceItem>> entry : getSubInstanceItemMaps().entrySet()) {
			entry.getValue().forEach((iTerm, instanceItem) -> {
				recurrenceExecute(getTemplate(), this, this, instanceItem);
			});
		}
	}

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
