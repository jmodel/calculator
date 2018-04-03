package com.github.jmodel.calculator.entity.template;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class StepDef {

	private String typeTerm;

	private String term;

	private Integer index;

	private Integer depStepIndex;

	private String operatorTerm;

	private boolean useCvalue = false;

	private List<Condition> conditions;

	public String getTypeTerm() {
		return typeTerm;
	}

	public void setTypeTerm(String typeTerm) {
		this.typeTerm = typeTerm;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getDepStepIndex() {
		return depStepIndex;
	}

	public void setDepStepIndex(Integer depStepIndex) {
		this.depStepIndex = depStepIndex;
	}

	public String getOperatorTerm() {
		return operatorTerm;
	}

	public void setOperatorTerm(String operatorTerm) {
		this.operatorTerm = operatorTerm;
	}

	public boolean isUseCvalue() {
		return useCvalue;
	}

	public void setUseCvalue(boolean useCvalue) {
		this.useCvalue = useCvalue;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

}
