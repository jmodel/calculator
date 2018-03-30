package com.github.jmodel.calculator.entity.definition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class StepDef {

	private String typeTerm;

	private String term;

	private Integer index;

	private Integer depStepIndex;

	private String operatorTerm;

	private boolean useCvalue = false;

	private boolean isValid = true;

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

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
