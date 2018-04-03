package com.github.jmodel.calculator.entity.definition.matcher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.definition.Matchable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IgnoreMatcher extends Matchable {

	@Override
	public boolean match(String value) {
		return true;
	}
}
