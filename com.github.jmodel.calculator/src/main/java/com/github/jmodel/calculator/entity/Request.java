package com.github.jmodel.calculator.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.CalculationException;
import com.github.jmodel.calculator.CalculatorTerms;
import com.github.jmodel.calculator.entity.instance.Instance;
import com.github.jmodel.calculator.entity.template.Template;

/**
 * Request is wrapper of multiple instances and corresponding templates.
 * 
 * @author jianni@hotmail.com
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Request {

	/**
	 * Template has to be provided along with the instance for a calculation
	 * request.
	 */
	private Map<String, Template> templates;

	/**
	 * Instances to be calculated
	 */
	private List<Instance> instances;

	public Map<String, Template> getTemplates() {
		return templates;
	}

	public void setTemplates(Map<String, Template> templates) {
		this.templates = templates;
	}

	public List<Instance> getInstances() {
		return instances;
	}

	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

	/**
	 * Parallel calculation for the instances.
	 */
	public final void execute() {

		if (instances == null || instances.size() == 0) {
			throw new CalculationException(CalculatorTerms.E_INSTANCE_NOT_FOUND);
		}

		instances.stream().forEach(instance -> {
			if (templates != null && instance.getTemplate() == null) {
				instance.setTemplate(templates.get(instance.getTemplateTerm()));
			}
			instance.execute();
		});
	}

}
