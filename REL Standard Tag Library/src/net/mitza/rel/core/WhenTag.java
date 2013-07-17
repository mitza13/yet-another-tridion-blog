package net.mitza.rel.core;

import java.util.HashMap;
import java.util.Map;

import net.mitza.rel.base.ParameterTagBase;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * Subtag of <c:choose> that outputs its body if its condition evalutes to 'true'
 *
 * <c:choose>
 *   <c:when test="expr1"> Do something </c:when>
 *   <c:when test="expr2"> Do something </c:when>
 *   <c:otherwsie> Do something </c:otherwise>
 * </c:choose>
 */
public class WhenTag extends ParameterTagBase {

	private String test; // conditional expression evaluating to boolean value
	private ChooseTag parentChoose;
	private static final String TAG_NAME = "when";
	private static final String TEST_ATTRIBUTE_NAME = "test";

	@Override
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

	@Override
	protected String getTagName() {
		return TAG_NAME;
	}

	@Override
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

	protected boolean condition(TransformContext context) {
		return evaluateCondition(test, context);
	}
}
