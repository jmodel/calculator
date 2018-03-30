package com.github.jmodel.calculator.entity.instance;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * 
 * 
 * @author johnson.ni@ebaotech.com
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aggregation {

	private String term;

	private BigDecimal value = BigDecimal.ZERO;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
