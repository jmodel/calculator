package com.github.jmodel.calculator.entity.instance.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Point {

	private String x;

	private Object y;

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public Object getY() {
		return y;
	}

	public void setY(Object y) {
		this.y = y;
	}

}
