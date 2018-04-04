package com.github.jmodel.calculator.entity.template;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.github.jmodel.calculator.entity.template.table.Table;
import com.github.jmodel.calculator.entity.template.tree.Tree;

/**
 * DataSource is used to provide defined data for certain calculations, e.g.,
 * predefined value in a Table or Tree.
 * 
 * @author jianni@hotmail.com
 *
 */
@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "typeId", visible = true)
@JsonSubTypes({ @Type(value = Table.class, name = "1"), @Type(value = Tree.class, name = "2"), })
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class DataSource {

	/**
	 * To achieve polymorphism in serialization and deserialization with Jackson.
	 * <p>
	 * <ul>
	 * <li>1. Table</li>
	 * <li>2. Tree</li>
	 * </ul>
	 */
	private String typeId;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

}
