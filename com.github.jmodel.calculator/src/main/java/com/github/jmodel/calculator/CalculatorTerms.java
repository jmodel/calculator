package com.github.jmodel.calculator;

/**
 * Term is the most important thing for a domain. People communicates with
 * common language which named Term.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface CalculatorTerms {

	final static String namespace = CalculatorTerms.class.getPackage().getName();

	// matcher

	public final static String MATCHER_IGNORE = namespace + ":MATCHER_IGNORE";

	public final static String MATCHER_STRING = namespace + ":MATCHER_STRING";

	public final static String MATCHER_INTEGER_SCOPE = namespace + ":MATCHER_INTEGER_SCOPE";

	// step

	public final static String STEP_TABLE = namespace + ":STEP_TABLE";

	public final static String STEP_TREE = namespace + ":STEP_TREE";

	public final static String STEP_DISC = namespace + ":STEP_DISC";

	public final static String STEP_MULTIPLE = namespace + ":STEP_MULTIPLE";

	// operator

	public final static String OPERATOR_ADD = namespace + ":OPERATOR_ADD";

	public final static String OPERATOR_SUBSTRACT = namespace + ":OPERATOR_SUBSTRACT";

	// aggregation

	public final static String AGGREGATION = namespace + ":AGGREGATION";
}
