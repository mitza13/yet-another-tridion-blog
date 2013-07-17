package net.mitza.rel.core;

import net.mitza.rel.base.TagWithParameterBase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * Simple conditional tag that establishes a context for mutually exclusive
 * conditional operations, marked by <c:when> and <c:otherwise>
 * 
 * <c:choose>
 *   <c:when test="expr1"> Do something </c:when>
 *   <c:when test="expr2"> Do something </c:when>
 *   <c:otherwsie> Do something </c:otherwise>
 * </c:choose>
 */
public class ChooseTag extends TagWithParameterBase<WhenTag> {

	private static Logger log = LoggerFactory.getLogger(ChooseTag.class);

	private boolean matchedCondition;

	@Override
	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		super.doStartTag(tag, tagBody, context, target);
		if (shouldSkipEvaluation(context)) { // if current tag is nested
			shouldBuildOriginalTag = true;
			return Tag.CONTINUE_TAG_EVALUATION;
		}

		setSkipEvaluation(context);
		matchedCondition = false;
		return Tag.CONTINUE_TAG_EVALUATION;
	}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldBuildOriginalTag) { // if current tag is nested
			return buildOriginalTag(tag, tagBody, context, target);
		}

		removeSkipEvaluation(context);
		for (WhenTag when : parameterList) {
			int startResult = when.doStartTag(tag, tagBody, context, target);
			if (startResult == Tag.CONTINUE_TAG_EVALUATION) {
				String whenBody = when.doEndTag(tag, new StringBuffer(), context, target);
				tagBody.append(whenBody);
				log.debug("Appending to tag body '{}'", whenBody);
				if (matchedCondition) {
					break;
				}
			}
		}

		return tagBody.toString();
	}

	public boolean alreadyMatchedCondition() {
		return matchedCondition;
	}

	public void matchedCondition() {
		matchedCondition = true;
	}

	public void setWhen(WhenTag toAdd) {
		toAdd.setParentChoose(this);
		parameterList.add(toAdd);
	}

	public void setOtherwise(OtherwiseTag otherwise) {
		otherwise.setParentChoose(this);
		parameterList.add(otherwise);
	}
}
