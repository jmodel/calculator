package com.github.jmodel.calculator.entity.template.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.template.DataSource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Table extends DataSource {

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
