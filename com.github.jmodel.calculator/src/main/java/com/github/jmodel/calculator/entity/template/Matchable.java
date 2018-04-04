package com.github.jmodel.calculator.entity.template;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.github.jmodel.calculator.entity.template.matcher.IgnoreMatcher;
import com.github.jmodel.calculator.entity.template.matcher.IntegerScopeMatcher;
import com.github.jmodel.calculator.entity.template.matcher.StringMatcher;

/**
 * A kind of data source generally has a certain data structure. When picking
 * (i.e., calculation) data from a data source, need to check if match the meta
 * definition.
 * 
 * @author jianni@hotmail.com
 *
 */
@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "typeId", visible = true)
@JsonSubTypes({ @Type(value = IgnoreMatcher.class, name = "1"), @Type(value = StringMatcher.class, name = "2"),
		@Type(value = IntegerScopeMatcher.class, name = "3"), })
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Matchable {

	/**
	 * To achieve polymorphism in serialization and deserialization with Jackson.
	 * <p>
	 * <ul>
	 * <li>1. IgnoreMatcher</li>
	 * <li>2. StringMatcher</li>
	 * <li>3. IntegerScopeMatcher</li>
	 * </ul>
	 */
	private String typeId;

	/**
	 * An optional attribute, used in certain data structure, e.g. Table, as column
	 * and row meta directly.
	 */
	private int index;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * If match meta definition, return true, otherwise, return false.
	 * 
	 * @param rawValue
	 *            the raw value in instance
	 * @return boolean
	 */
	public abstract boolean match(String rawValue);
}
