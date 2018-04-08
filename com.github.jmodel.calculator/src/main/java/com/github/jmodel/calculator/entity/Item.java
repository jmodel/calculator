package com.github.jmodel.calculator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.github.jmodel.calculator.entity.instance.InstanceItem;
import com.github.jmodel.calculator.entity.template.TemplateItem;

/**
 * Item is a calculable unit.
 * 
 * @author jianni@hotmail.com
 *
 */
@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "typeId", visible = true)
@JsonSubTypes({ @Type(value = TemplateItem.class, name = "1"), @Type(value = InstanceItem.class, name = "2"), })
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Item {

	/**
	 * To achieve polymorphism in serialization and deserialization with Jackson.
	 * <p>
	 * <ul>
	 * <li>1. TemplateItem</li>
	 * <li>2. InstanceItem</li>
	 * </ul>
	 */
	private String typeId;

	/**
	 * Type term of Item
	 */
	private String typeTerm;

	/**
	 * Term of Item
	 */
	private String term;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

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

}
