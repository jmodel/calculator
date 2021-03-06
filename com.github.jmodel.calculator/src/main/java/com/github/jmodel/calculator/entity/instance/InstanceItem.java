package com.github.jmodel.calculator.entity.instance;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.Item;
import com.github.jmodel.calculator.entity.template.Template;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstanceItem extends Item {

	@JsonIgnore
	private InstanceItem parentInstanceItem;

	private String templateTerm;

	private Map<String, Map<String, InstanceItem>> subInstanceItemMaps;

	private Map<String, String> attributes;

	private List<Step> steps;

	private BigDecimal value = BigDecimal.ZERO;

	private boolean executable = false;

	public InstanceItem getParentInstanceItem() {
		return parentInstanceItem;
	}

	public void setParentInstanceItem(InstanceItem parentInstanceItem) {
		this.parentInstanceItem = parentInstanceItem;
	}

	public String getTemplateTerm() {
		return templateTerm;
	}

	public void setTemplateTerm(String templateTerm) {
		this.templateTerm = templateTerm;
	}

	public Map<String, Map<String, InstanceItem>> getSubInstanceItemMaps() {
		return subInstanceItemMaps;
	}

	public void setSubInstanceItemMaps(Map<String, Map<String, InstanceItem>> subInstanceItemMaps) {
		this.subInstanceItemMaps = subInstanceItemMaps;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public boolean isExecutable() {
		return executable;
	}

	public void setExecutable(boolean executable) {
		this.executable = executable;
	}

	public final void execute(Template template, Instance instance, InstanceItem parentInstanceItem) {

		if (parentInstanceItem != null) {
			this.setParentInstanceItem(parentInstanceItem);
		}

		if (!isExecutable()) {
			return;
		}
		
		Context context = new Context();
		context.setTemplate(template);
		context.setInstance(instance);
		context.setInstanceItem(this);
		context.setTemplateItem(template.getSubTemplateItemMaps().get(this.getTypeTerm()).get(this.getTemplateTerm()));

		if (this.getSteps() == null) {
			System.out.print("xx");
		}

		for (Step step : this.getSteps()) {
			step.execute(context);
		}
	}

}
