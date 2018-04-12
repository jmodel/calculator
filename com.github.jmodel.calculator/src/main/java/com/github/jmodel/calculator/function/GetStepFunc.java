package com.github.jmodel.calculator.function;

import java.math.BigDecimal;

import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.instance.Step;
import com.github.jmodel.calculator.entity.template.StepDef;

/**
 * Get step.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class GetStepFunc extends StepFunc {

	private static GetStepFunc instance;

	private GetStepFunc() {
	}

	public final static GetStepFunc getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized (GetStepFunc.class) {
			if (instance == null) {
				instance = new GetStepFunc();
			}
			return instance;
		}
	}

	@Override
	protected BigDecimal calculate(Context context, StepDef stepDef, Step step, StepDef depStepDef, Step depStep) {

		String rawValue = findRawAttributeValue(context.getInstanceItem(), stepDef.getMapToTemplateItemTypeTerm(),
				stepDef.getMapToTemplateItemTerm(), stepDef.getMapToAttribute());

		return new BigDecimal(rawValue);
	}

}
