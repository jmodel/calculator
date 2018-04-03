package com.github.jmodel.calculator.entity.template.table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.template.Matchable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TableMeta {

	private List<Matchable> columns;

	private List<Matchable> rows;

	private String colMapToTemplateItemTypeTerm;

	private String colMapToTemplateItemTerm;

	private String colMapToAttribute;

	private String rowMapToTemplateItemTypeTerm;

	private String rowMapToTemplateItemTerm;

	private String rowMapToAttribute;

	public List<Matchable> getColumns() {
		return columns;
	}

	public void setColumns(List<Matchable> columns) {
		this.columns = columns;
	}

	public List<Matchable> getRows() {
		return rows;
	}

	public void setRows(List<Matchable> rows) {
		this.rows = rows;
	}

	public String getColMapToTemplateItemTypeTerm() {
		return colMapToTemplateItemTypeTerm;
	}

	public void setColMapToTemplateItemTypeTerm(String colMapToTemplateItemTypeTerm) {
		this.colMapToTemplateItemTypeTerm = colMapToTemplateItemTypeTerm;
	}

	public String getColMapToTemplateItemTerm() {
		return colMapToTemplateItemTerm;
	}

	public void setColMapToTemplateItemTerm(String colMapToTemplateItemTerm) {
		this.colMapToTemplateItemTerm = colMapToTemplateItemTerm;
	}

	public String getColMapToAttribute() {
		return colMapToAttribute;
	}

	public void setColMapToAttribute(String colMapToAttribute) {
		this.colMapToAttribute = colMapToAttribute;
	}

	public String getRowMapToTemplateItemTypeTerm() {
		return rowMapToTemplateItemTypeTerm;
	}

	public void setRowMapToTemplateItemTypeTerm(String rowMapToTemplateItemTypeTerm) {
		this.rowMapToTemplateItemTypeTerm = rowMapToTemplateItemTypeTerm;
	}

	public String getRowMapToTemplateItemTerm() {
		return rowMapToTemplateItemTerm;
	}

	public void setRowMapToTemplateItemTerm(String rowMapToTemplateItemTerm) {
		this.rowMapToTemplateItemTerm = rowMapToTemplateItemTerm;
	}

	public String getRowMapToAttribute() {
		return rowMapToAttribute;
	}

	public void setRowMapToAttribute(String rowMapToAttribute) {
		this.rowMapToAttribute = rowMapToAttribute;
	}

}
