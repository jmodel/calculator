package com.github.jmodel.calculator.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.instance.Instance;

/**
 * Request is a wrapper of multiple instances.
 * 
 * @author jianni@hotmail.com
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Request {

	/**
	 * instances which need calculated
	 */
	private List<Instance> instances;

	public List<Instance> getInstances() {
		return instances;
	}

	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

}
