package net.mitza.rel.xml;

import java.util.HashMap;
import java.util.Map;

import net.mitza.rel.base.ParameterTagBase;

/*
 * <x:transform>
 *   <x:param var="varName1" select="expr1" />
 *   <x:param var="varName2" select="expr2" />
 * </x:transform>
 */
public class ParamTag extends ParameterTagBase {

	private static final String TAG_NAME = "param";
	private static final String VAR_ATTRIBUTE_NAME = "var";
	private static final String SELECT_ATTRIBUTE_NAME = "select";

	private String var; // parameter name or ${}
	private String select; // parameter value or ${}

	@Override
	protected String getTagName() {
		return TAG_NAME;
	}

	@Override
	protected Map<String, String> getTagAttributes() {
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put(VAR_ATTRIBUTE_NAME, var);
		attributes.put(SELECT_ATTRIBUTE_NAME, select);
		return attributes;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}
}
