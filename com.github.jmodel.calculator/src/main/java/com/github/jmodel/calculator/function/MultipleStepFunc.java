package com.github.jmodel.calculator.function;

import java.math.BigDecimal;

import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.definition.StepDef;
import com.github.jmodel.calculator.entity.instance.Step;

public final class MultipleStepFunc extends StepFunc {

	private static MultipleStepFunc instance;

	private MultipleStepFunc() {
	}

	public final static MultipleStepFunc getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized (MultipleStepFunc.class) {
			if (instance == null) {
				instance = new MultipleStepFunc();
			}
			return instance;
		}
	}

	@Override
	protected BigDecimal calculate(Context context, StepDef stepDef, Step step, StepDef depStepDef, Step depStep) {

		BigDecimal multiplier = (BigDecimal) step.getObject();
		if (depStepDef == null) {
			// throw illegle exception
		}

		if (stepDef.isUseCvalue()) {
			return depStep.getCvalue().multiply(multiplier);
		} else {
			return depStep.getValue().multiply(multiplier);
		}
	}

}
