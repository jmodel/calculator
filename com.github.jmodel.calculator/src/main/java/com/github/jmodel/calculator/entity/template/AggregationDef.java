package com.github.jmodel.calculator.entity.template;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AggregationDef extends TemplateItem {

	private List<String> templateItemTerms;

	private List<Integer> stepDefIndex;

	private boolean useCvalue = false;

	public List<String> getTemplateItemTerms() {
		return templateItemTerms;
	}

	public void setTemplateItemTerms(List<String> templateItemTerms) {
		this.templateItemTerms = templateItemTerms;
	}

	public List<Integer> getStepDefIndex() {
		return stepDefIndex;
	}

	public void setStepDefIndex(List<Integer> stepDefIndex) {
		this.stepDefIndex = stepDefIndex;
	}

	public boolean isUseCvalue() {
		return useCvalue;
	}

	public void setUseCvalue(boolean useCvalue) {
		this.useCvalue = useCvalue;
	}

}
