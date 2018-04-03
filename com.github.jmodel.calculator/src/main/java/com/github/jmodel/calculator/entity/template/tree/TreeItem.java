package com.github.jmodel.calculator.entity.template.tree;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.template.Matchable;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class TreeItem {

	private String term;

	private int layer;

	private int index;

	private boolean isLeft;

	private Matchable matcher;

	private String rawValue;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Matchable getMatcher() {
		return matcher;
	}

	public void setMatcher(Matchable matcher) {
		this.matcher = matcher;
	}

	public String getRawValue() {
		return rawValue;
	}

	public void setRawValue(String rawValue) {
		this.rawValue = rawValue;
	}

}
