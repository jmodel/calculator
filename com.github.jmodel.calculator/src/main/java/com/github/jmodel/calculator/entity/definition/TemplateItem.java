package com.github.jmodel.calculator.entity.definition;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateItem extends Item {

	private List<String> attributes;

	private List<StepDef> stepDefs;

	private List<Router> routers;

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

	public List<Router> getRouters() {
		return routers;
	}

	public void setRouters(List<Router> routers) {
		this.routers = routers;
	}

}
