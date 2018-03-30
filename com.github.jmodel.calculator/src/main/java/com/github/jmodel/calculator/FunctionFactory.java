package com.github.jmodel.calculator;

import java.util.SortedMap;
import java.util.function.BiConsumer;

import com.github.jmodel.calculator.function.DiscStepFunc;
import com.github.jmodel.calculator.function.MultipleStepFunc;
import com.github.jmodel.calculator.function.TableStepFunc;
import com.github.jmodel.japp.spi.BiConsumerFactory;

public class FunctionFactory extends BiConsumerFactory {

	@Override
	protected void create(SortedMap<String, BiConsumer<?, ?>> map) {
		map.put(CalculatorTerms.STEP_TABLE, TableStepFunc.getInstance());
		map.put(CalculatorTerms.STEP_DISC, DiscStepFunc.getInstance());
		map.put(CalculatorTerms.STEP_MULTIPLE, MultipleStepFunc.getInstance());
	}

}
