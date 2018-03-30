package com.github.jmodel.calculator.entity.definition.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IgnoreRowMeta extends TableRowMeta {

	@Override
	public boolean match(Object t) {
		return true;
	}

}
