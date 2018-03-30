package com.github.jmodel.calculator.function;

import java.math.BigDecimal;

import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.definition.StepDef;
import com.github.jmodel.calculator.entity.instance.Step;

public final class DiscStepFunc extends StepFunc {

	private static DiscStepFunc instance;

	private DiscStepFunc() {
	}

	public final static DiscStepFunc getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized (DiscStepFunc.class) {
			if (instance == null) {
				instance = new DiscStepFunc();
			}
			return instance;
		}
	}

	@Override
	protected BigDecimal calculate(Context context, StepDef stepDef, Step step, StepDef depStepDef, Step depStep) {

		BigDecimal disc = (BigDecimal) step.getObject();
		if (depStepDef == null) {
			// throw illegle exception
		}

		if (stepDef.isUseCvalue()) {
			return depStep.getCvalue().multiply(disc);
		} else {
			return depStep.getValue().multiply(disc);
		}
	}

}
