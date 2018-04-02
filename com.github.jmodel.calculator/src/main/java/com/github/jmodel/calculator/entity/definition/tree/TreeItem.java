package com.github.jmodel.calculator.entity.definition.tree;

import java.math.BigDecimal;

public abstract class TreeItem<T> {

	private String term;

	private long layer;

	private long index;

	private boolean isLeft;

	private T condition;

	private BigDecimal value;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public long getLayer() {
		return layer;
	}

	public void setLayer(long layer) {
		this.layer = layer;
	}

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public T getCondition() {
		return condition;
	}

	public void setCondition(T condition) {
		this.condition = condition;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
