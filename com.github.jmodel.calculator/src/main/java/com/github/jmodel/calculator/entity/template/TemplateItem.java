package com.github.jmodel.calculator.entity.template;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateItem extends Item {

	private List<String> attributes;

	private List<StepDef> stepDefs;

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	public List<StepDef> getStepDefs() {
		return stepDefs;
	}

	public void setStepDefs(List<StepDef> stepDefs) {
		this.stepDefs = stepDefs;
	}

}
