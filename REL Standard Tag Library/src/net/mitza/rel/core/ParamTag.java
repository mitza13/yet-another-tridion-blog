package net.mitza.rel.core;

import java.util.HashMap;
import java.util.Map;

import net.mitza.rel.base.ParameterTagBase;

/*
 * Adds a parameter to a containing 'c:import' tag's URL
 * 
 * <c:import name="varName" url="expr" componentTemplate="tcmUri">
 *     <c:param name="varName1" value="expr1"/>
 *     <c:param name="varName2" value="expr2"/>
 * </c:import>
 */
public class ParamTag extends ParameterTagBase {

	private static final String TAG_NAME = "param";
	private static final String NAME_ATTRIBUTE_NAME = "name";
	private static final String VALUE_ATTRIBUTE_NAME = "value";

	private String name; // param name or ${}
	private String value; // param value or ${}

	@Override
	protected String getTagName() {
		return TAG_NAME;
	}

	@Override
	protected Map<String, String> getTagAttributes() {
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put(NAME_ATTRIBUTE_NAME, name);
		attributes.put(VALUE_ATTRIBUTE_NAME, value);
		return attributes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
