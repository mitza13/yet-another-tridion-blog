package net.mitza.rel.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.mitza.rel.base.AdapterTag;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;
import com.tridion.util.StringUtils;

/*
 * <c:choose>
 *   <c:when test="expr1"> Do something </c:when>
 *   <c:when test="expr2"> Do something </c:when>
 *   <c:otherwsie> Do something </c:otherwise>
 * </c:choose>
 */
public class WhenTag extends AdapterTag {

	private String test;
	private String body;
	private ChooseTag parentChoose;
	private static final String DEFAULT_NAMESPACE = "tcdl:";
	private static final String TAG_NAME = "when";
	private static final String TEST_ATTRIBUTE_NAME = "test";

	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		super.doStartTag(tag, tagBody, context, target);
		if (shouldSkipEvaluation(context)) {
			shouldBuildOriginalTag = true;
			return Tag.CONTINUE_TAG_EVALUATION;
		}

		if (parentChoose.alreadyMatchedCondition()) {
			return Tag.SKIP_TAG;
		}
		if (condition(context)) {
			parentChoose.matchedCondition();
			return Tag.CONTINUE_TAG_EVALUATION;
		} else {
			return Tag.SKIP_TAG;
		}
	}

	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (!shouldSkipEvaluation(context)) {
			String whenBody = evaluateBody(body, context);
			tagBody.append(whenBody);
			return tagBody.toString();
		}

		StringBuffer wholeTagWithBody = new StringBuffer();
		String tagName = getTagQualifiedName(tag);
		wholeTagWithBody.append("<").append(tagName);

		for (Entry<String, String> entry : getTagAttributes().entrySet()) {
			String attribute = String.format(" %s=\"%s\"", entry.getKey(), entry.getValue());
			wholeTagWithBody.append(attribute);
		}

		if (StringUtils.isEmpty(body)) {
			wholeTagWithBody.append("/>");
		} else {
			wholeTagWithBody.append(">");
			wholeTagWithBody.append(body);
			wholeTagWithBody.append("</").append(tagName).append(">");
		}

		return wholeTagWithBody.toString();
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

	protected String getTagName() {
		return TAG_NAME;
	}

	protected Map<String, String> getTagAttributes() {
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put(TEST_ATTRIBUTE_NAME, test);
		return attributes;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public void setParentChoose(ChooseTag parentChoose) {
		this.parentChoose = parentChoose;
	}

	public void setElementData(String elementData) {
		body = elementData;
	}

	protected boolean condition(TransformContext context) {
		return evaluateExpression(test, context);
	}
}
