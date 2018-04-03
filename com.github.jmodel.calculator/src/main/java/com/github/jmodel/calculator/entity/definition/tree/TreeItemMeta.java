package com.github.jmodel.calculator.entity.definition.tree;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TreeItemMeta {

	private String mapToTemplateItemTypeTerm;

	private String mapToTemplateItemTerm;

	private String mapToAttribute;

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

}
