package com.github.jmodel.calculator.entity.template.matcher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.template.Matchable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StringMatcher extends Matchable {

	private String expectValue;

	public String getExpectValue() {
		return expectValue;
	}

	public void setExpectValue(String expectValue) {
		this.expectValue = expectValue;
	}

	@Override
	public boolean match(String value) {
		if (value.equals(expectValue)) {
			return true;
		}
		return false;
	}
}
