package com.github.jmodel.calculator.entity.template;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Condition {

	private String mapToTemplateItemTypeTerm;

	private String mapToTemplateItemTerm;

	private String mapToAttribute;

	private String expectValue;

	public String getMapToTemplateItemTypeTerm() {
		return mapToTemplateItemTypeTerm;
	}

	public void setMapToTemplateItemTypeTerm(String mapToTemplateItemTypeTerm) {
		this.mapToTemplateItemTypeTerm = mapToTemplateItemTypeTerm;
	}

	public String getMapToTemplateItemTerm() {
		return mapToTemplateItemTerm;
	}

	public void setMapToTemplateItemTerm(String mapToTemplateItemTerm) {
		this.mapToTemplateItemTerm = mapToTemplateItemTerm;
	}

	public String getMapToAttribute() {
		return mapToAttribute;
	}

	public void setMapToAttribute(String mapToAttribute) {
		this.mapToAttribute = mapToAttribute;
	}

	public String getExpectValue() {
		return expectValue;
	}

	public void setExpectValue(String expectValue) {
		this.expectValue = expectValue;
	}

}
