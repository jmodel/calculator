package com.github.jmodel.calculator.entity.definition.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.definition.DataSource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Table implements DataSource {

	private TableMeta tableMeta;

	private String[][] rawData;

	public TableMeta getTableMeta() {
		return tableMeta;
	}

	public void setTableMeta(TableMeta tableMeta) {
		this.tableMeta = tableMeta;
	}

	public String[][] getRawData() {
		return rawData;
	}

	public void setRawData(String[][] rawData) {
		this.rawData = rawData;
	}

}
