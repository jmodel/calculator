package com.github.jmodel.calculator.entity.template;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Template extends TemplateItem {

	private String version;

	private Map<String, Map<String, TemplateItem>> subTemplateItemMaps;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Map<String, Map<String, TemplateItem>> getSubTemplateItemMaps() {
		return subTemplateItemMaps;
	}

	public void setSubTemplateItemMaps(Map<String, Map<String, TemplateItem>> subTemplateItemMaps) {
		this.subTemplateItemMaps = subTemplateItemMaps;
	}

}
