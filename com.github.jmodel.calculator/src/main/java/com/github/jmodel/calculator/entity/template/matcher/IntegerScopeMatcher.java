package com.github.jmodel.calculator.entity.template.matcher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.template.Matchable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IntegerScopeMatcher extends Matchable {

	private int maxValue;

	private boolean includeMax;

	private int minValue;

	private boolean includeMin;

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public boolean isIncludeMax() {
		return includeMax;
	}

	public void setIncludeMax(boolean includeMax) {
		this.includeMax = includeMax;
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public boolean isIncludeMin() {
		return includeMin;
	}

	public void setIncludeMin(boolean includeMin) {
		this.includeMin = includeMin;
	}

	@Override
	public boolean match(String rawValue) {
		Integer value = Integer.valueOf(rawValue);
		boolean bln = false;
		if (includeMax) {
			bln = (value <= maxValue);
		} else {
			bln = (value < maxValue);
		}
		if (bln) {
			if (includeMin) {
				bln = (value >= minValue);
			} else {
				bln = (value > minValue);
			}
		}
		return bln;
	}

}
