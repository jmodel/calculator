package com.github.jmodel.calculator.entity.template;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Router is used to find a certain data source. The data source can be valid if
 * a series of conditons are met.
 * 
 * @author jianni@hotmail.com
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Router {

	/**
	 * the conditions router has to meet
	 */
	private List<Condition> conditions;

	/**
	 * the data source
	 */
	private DataSource dataSource;

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
