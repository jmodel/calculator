package com.github.jmodel.calculator.entity.instance;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.Context;
import com.github.jmodel.japp.api.BiConsumerService;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Step {

	private int index;

	private Object object;

	/**
	 * self value
	 */
	private BigDecimal value;

	/**
	 * context value
	 */
	private BigDecimal cvalue;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getCvalue() {
		return cvalue;
	}

	public void setCvalue(BigDecimal cvalue) {
		this.cvalue = cvalue;
	}

	public void execute(Context context) {
		@SuppressWarnings("unchecked")
		BiConsumer<Context, Step> b = (BiConsumer<Context, Step>) BiConsumerService.getInstance()
				.getBiConsumer(context.getTemplateItem().getStepDefs().get(index).getTypeTerm());
		b.accept(context, this);
	}

}
