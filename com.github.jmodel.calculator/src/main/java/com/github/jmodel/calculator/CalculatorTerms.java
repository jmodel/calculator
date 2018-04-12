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

	public final static String STEP_GET = namespace + ":STEP_GET";

	public final static String STEP_TABLE = namespace + ":STEP_TABLE";

	public final static String STEP_TREE = namespace + ":STEP_TREE";

	public final static String STEP_MULTIPLE = namespace + ":STEP_MULTIPLE";

	// operator

	public final static String OPERATOR_ADD = namespace + ":OPERATOR_ADD";

	public final static String OPERATOR_SUBSTRACT = namespace + ":OPERATOR_SUBSTRACT";

	// aggregation

	public final static String AGGREGATION = namespace + ":AGGREGATION";

	// exception

	public final static String E_INSTANCE_NOT_FOUND = "Instance to be calculated is not found";

	public final static String E_TEMPLATE_NOT_FOUND = "Template is not found";

	public final static String E_TABLE_NOT_FOUND = "Table is not found";

	public final static String E_TREE_NOT_FOUND = "Tree is not found";

	public final static String E_TREE_ITEM_NOT_DEFINED = "At least one side tree item should be defined";

}
