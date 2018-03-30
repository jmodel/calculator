package com.github.jmodel.calculator.entity;

import java.math.BigDecimal;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Item {

	private String typeTerm;

	private String term;

	private Map<String, String> attributes;

	private BigDecimal value;

	public String getTypeTerm() {
		return typeTerm;
	}

	public void setTypeTerm(String typeTerm) {
		this.typeTerm = typeTerm;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
