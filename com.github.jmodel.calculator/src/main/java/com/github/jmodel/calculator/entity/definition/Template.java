package com.github.jmodel.calculator.entity.definition;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Template extends TemplateItem {

	private Map<String, Map<String, TemplateItem>> subTemplateItemMaps;

	public Map<String, Map<String, TemplateItem>> getSubTemplateItemMaps() {
		return subTemplateItemMaps;
	}

	public void setSubTemplateItemMaps(Map<String, Map<String, TemplateItem>> subTemplateItemMaps) {
		this.subTemplateItemMaps = subTemplateItemMaps;
	}

}
