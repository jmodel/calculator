package com.github.jmodel.calculator;

import com.github.jmodel.calculator.entity.instance.Instance;
import com.github.jmodel.calculator.entity.instance.InstanceItem;
import com.github.jmodel.calculator.entity.template.Template;
import com.github.jmodel.calculator.entity.template.TemplateItem;

public final class Context {

	private Template template;

	private TemplateItem templateItem;

	private Instance instance;

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
