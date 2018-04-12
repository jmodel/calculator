package com.github.jmodel.calculator;

import java.util.SortedMap;
import java.util.function.BiConsumer;

import com.github.jmodel.calculator.function.GetStepFunc;
import com.github.jmodel.calculator.function.MultipleStepFunc;
import com.github.jmodel.calculator.function.TableStepFunc;
import com.github.jmodel.calculator.function.TreeStepFunc;
import com.github.jmodel.japp.spi.BiConsumerFactory;

/**
 * FunctionFactory is used to create step calculation function. The function
 * factory can be extended by using JVM service loader machanism.
 * 
 * @author jianni@hotmail.com
 *
 */
public class FunctionFactory extends BiConsumerFactory {

	@Override
	protected void create(SortedMap<String, BiConsumer<?, ?>> map) {
		map.put(CalculatorTerms.STEP_GET, GetStepFunc.getInstance());
		map.put(CalculatorTerms.STEP_TABLE, TableStepFunc.getInstance());
		map.put(CalculatorTerms.STEP_TREE, TreeStepFunc.getInstance());
		map.put(CalculatorTerms.STEP_MULTIPLE, MultipleStepFunc.getInstance());
	}

}
