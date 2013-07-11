package net.mitza.rel.xml;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.mitza.rel.base.AdapterTag;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * <x:transform>
 *   <x:param var="varName1" select="expr1" />
 *   <x:param var="varName2" select="expr2" />
 * </x:transform>
 */
public class ParamTag extends AdapterTag {

	private static final String DEFAULT_NAMESPACE = "x:";
	private static final String TAG_NAME = "param";
	private static final String VAR_ATTRIBUTE_NAME = "var";
	private static final String SELECT_ATTRIBUTE_NAME = "select";

	private String var;
	private String select;

	@Override
	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		super.doStartTag(tag, tagBody, context, target);
		return Tag.CONTINUE_TAG_EVALUATION;
	}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldSkipEvaluation(context)) {
			return buildOriginalTag(tag, tagBody);
		}

		return tagBody.toString();
	}

	@Override
	public String buildOriginalTag(Tag tag, StringBuffer tagBody) {
		StringBuffer wholeTagWithBody = new StringBuffer();
		String tagName = getTagQualifiedName(tag);
		wholeTagWithBody.append("<").append(tagName);

		for (Entry<String, String> entry : getTagAttributes().entrySet()) {
			String attribute = String.format(" %s=\"%s\"", entry.getKey(), entry.getValue());
			wholeTagWithBody.append(attribute);
		}

		wholeTagWithBody.append("/>");
		return wholeTagWithBody.toString();
	}

	protected String getTagName() {
		return TAG_NAME;
	}

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

	public void setElementData(String elementData) {
	}

	private String getTagQualifiedName(Tag tag) {
		StringBuilder tqn;
		if (tag != null) {
			tqn = new StringBuilder(tag.getNamespace());
			tqn.append(":");
		} else {
			tqn = new StringBuilder(DEFAULT_NAMESPACE);
		}
		tqn.append(getTagName());
		return tqn.toString();
	}
}
