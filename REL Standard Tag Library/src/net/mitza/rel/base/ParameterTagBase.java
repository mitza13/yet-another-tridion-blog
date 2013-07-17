package net.mitza.rel.base;

import java.util.Map;
import java.util.Map.Entry;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;
import com.tridion.util.StringUtils;

public abstract class ParameterTagBase extends AdapterTag {

	protected String paramTagBody;

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldSkipEvaluation(context)) {
			return buildOriginalTag(tag, tagBody, context, target);
		}

		return evaluateBody(paramTagBody, context);
	}

	@Override
	public String buildOriginalTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target) {
		StringBuffer wholeTagWithBody = new StringBuffer();
		String tagName = getTagQualifiedName(tag);
		wholeTagWithBody.append("<").append(tagName);

		for (Entry<String, String> entry : getTagAttributes().entrySet()) {
			String attribute = String.format(" %s=\"%s\"", entry.getKey(), entry.getValue());
			wholeTagWithBody.append(attribute);
		}

		if (StringUtils.isEmpty(paramTagBody)) {
			wholeTagWithBody.append("/>");
		} else {
			wholeTagWithBody.append(">");
			wholeTagWithBody.append(paramTagBody);
			wholeTagWithBody.append("</").append(tagName).append(">");
		}

		return wholeTagWithBody.toString();
	}

	protected abstract Map<String, String> getTagAttributes();

	protected abstract String getTagName();

	public void setElementData(String elementData) {
		paramTagBody = elementData;
	}

	protected String getTagQualifiedName(Tag tag) {
		return String.format("%s:%s", tag.getNamespace(), getTagName());
	}
}
