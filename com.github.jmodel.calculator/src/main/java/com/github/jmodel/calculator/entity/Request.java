package com.github.jmodel.calculator.entity;

import java.util.List;

import com.github.jmodel.calculator.entity.instance.Instance;

public final class Request {

	private List<Instance> instances;

	public List<Instance> getInstances() {
		return instances;
	}

	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

}
