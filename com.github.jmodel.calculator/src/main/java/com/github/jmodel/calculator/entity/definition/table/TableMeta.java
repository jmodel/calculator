package com.github.jmodel.calculator.entity.definition.table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TableMeta {

	private List<String> columnNames;

	private List<TableRowMeta> rows;

	private String rowMapToTemplateItemTypeTerm;

	private String rowMapToTemplateItemTerm;

	private String rowMapToAttribute;

	public List<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

	public List<TableRowMeta> getRows() {
		return rows;
	}

	public void setRows(List<TableRowMeta> rows) {
		this.rows = rows;
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
