package com.github.jmodel.calculator;

/**
 * 
 * Calculation exception.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class CalculationException extends RuntimeException {

	private static final long serialVersionUID = -1455952803941327137L;

	public CalculationException() {
	}

	public CalculationException(String message) {
		super(message);
	}

}
