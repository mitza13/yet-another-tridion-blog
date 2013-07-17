package net.mitza.rel.core;

import net.mitza.rel.base.AdapterTag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * Sets the value of an expression in context
 * 
 * <c:set var="varName" value="expr" />
 * 
 * or
 * 
 * <c:set var="varName">
 *     expr
 * </c:set>
 */
public class SetTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(SetTag.class);

	private String var; // var name or ${}
	private String value; // expression or ${}

	@Override
	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		super.doStartTag(tag, tagBody, context, target);
		if (shouldSkipEvaluation(context)) { // if current tag is nested
			shouldBuildOriginalTag = true;
			return Tag.CONTINUE_TAG_EVALUATION;
		}

		setSkipEvaluation(context);
		return Tag.CONTINUE_TAG_EVALUATION;
	}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldBuildOriginalTag) { // if current tag is nested
			return buildOriginalTag(tag, tagBody, context, target);
		}

		removeSkipEvaluation(context);
		Object evaluatedValue;
		if (value == null) {
			evaluatedValue = evaluateBody(tagBody.toString(), context);
		} else {
			evaluatedValue = evaluateAttribute(value, context);
		}

		evaluatedValue = evaluatedValue == null ? "" : evaluatedValue.toString();
		var = evaluateAttribute(var, context).toString();
		log.debug("Setting context variable '{}' with value '{}'", var, evaluatedValue);
		context.set(var, evaluatedValue);

		return "";
	}

	public void setRequiredVar(String var) {
		this.var = var;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
