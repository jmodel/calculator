package com.github.jmodel.calculator.entity.definition.table;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.definition.DataSource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Table implements DataSource {

	private TableMeta tableMeta;

	private BigDecimal[][] data;

	public TableMeta getTableMeta() {
		return tableMeta;
	}

	public void setTableMeta(TableMeta tableMeta) {
		this.tableMeta = tableMeta;
	}

	public BigDecimal[][] getData() {
		return data;
	}

	public void setData(BigDecimal[][] data) {
		this.data = data;
	}

}
