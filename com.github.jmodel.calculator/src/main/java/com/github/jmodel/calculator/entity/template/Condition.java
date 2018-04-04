package com.github.jmodel.calculator.entity.template;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * During calculation procedure, get raw value of attribute by 3 terms, then
 * compare to expect value defined in condition. If passed the checking, mean
 * that this condition is met.
 * 
 * @author jianni@hotmail.com
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Condition {

	/**
	 * map to type term of template item
	 */
	private String mapToTemplateItemTypeTerm;

	/**
	 * map to term of template item
	 */
	private String mapToTemplateItemTerm;

	/**
	 * map to attribute term of the template item
	 */
	private String mapToAttribute;

	/**
	 * expected value
	 */
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
