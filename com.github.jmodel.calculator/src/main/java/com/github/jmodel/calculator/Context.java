package com.github.jmodel.calculator;

import com.github.jmodel.calculator.entity.instance.Instance;
import com.github.jmodel.calculator.entity.instance.InstanceItem;
import com.github.jmodel.calculator.entity.template.Template;
import com.github.jmodel.calculator.entity.template.TemplateItem;

/**
 * Context is used in calculation procedure. A calculation procedure is defined
 * at instance item level. Per instance item has own context instance.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Context {

	/**
	 * Template is a kind of particular TemplateItem which can be parent of other
	 * TemplateItem.
	 */
	private Template template;

	/**
	 * All of TemplateItem is the first child level of Template.
	 */
	private TemplateItem templateItem;

	/**
	 * Instance is a kind of particular InstanceItem which includes Aggregation.
	 */
	private Instance instance;

	/**
	 * InstanceItem support hierarchical structure.
	 */
	private InstanceItem instanceItem;

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public TemplateItem getTemplateItem() {
		return templateItem;
	}

	public void setTemplateItem(TemplateItem templateItem) {
		this.templateItem = templateItem;
	}

	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}

	public InstanceItem getInstanceItem() {
		return instanceItem;
	}

	public void setInstanceItem(InstanceItem instanceItem) {
		this.instanceItem = instanceItem;
	}

}
