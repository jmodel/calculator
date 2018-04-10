package com.github.jmodel.calculator.function;

import java.math.BigDecimal;

import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.instance.Step;
import com.github.jmodel.calculator.entity.template.StepDef;

/**
 * General calculation procedure of a pick step.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class PickStepFunc extends StepFunc {

	@Override
	protected final BigDecimal calculate(Context context, StepDef stepDef, Step step, StepDef depStepDef,
			Step depStep) {

		prePickup(context, stepDef, step, depStepDef, depStep);

		return postPickup(context, stepDef, step, depStepDef, depStep,
				pickup(context, stepDef, step, depStepDef, depStep));
	}

	protected void prePickup(Context context, StepDef stepDef, Step step, StepDef depStepDef, Step depStep) {
	}

	/**
	 * Pick up data from particular data source, like Table or Tree.
	 * 
	 * @param context
	 *            calculation context
	 * @param stepDef
	 *            step definition
	 * @param step
	 *            step instance
	 * @param depStepDef
	 *            dependent step definition
	 * @param depStep
	 *            dependent step instance
	 * @return result data
	 */
	protected abstract BigDecimal pickup(Context context, StepDef stepDef, Step step, StepDef depStepDef, Step depStep);

	protected BigDecimal postPickup(Context context, StepDef stepDef, Step step, StepDef depStepDef, Step depStep,
			BigDecimal pickedData) {
		return pickedData;
	}
}
