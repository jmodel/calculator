package com.github.jmodel.calculator.entity.instance;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.definition.Template;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Instance extends InstanceItem {

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

}