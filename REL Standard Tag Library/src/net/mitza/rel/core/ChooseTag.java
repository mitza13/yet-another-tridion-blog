package net.mitza.rel.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.mitza.rel.base.AdapterTag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * <c:choose>
 *   <c:when test="expr1"> Do something </c:when>
 *   <c:when test="expr2"> Do something </c:when>
 *   <c:otherwsie> Do something </c:otherwise>
 * </c:choose>
 */
public class ChooseTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(ChooseTag.class);

	private boolean matchedCondition;
	private List<WhenTag> whens;

	public ChooseTag() {
		whens = new ArrayList<WhenTag>();
	}

	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		super.doStartTag(tag, tagBody, context, target);
		if (shouldSkipEvaluation(context)) {
			shouldBuildOriginalTag = true;
			return Tag.CONTINUE_TAG_EVALUATION;
		}

		setSkipEvaluation(context);
		matchedCondition = false;
		return Tag.CONTINUE_TAG_EVALUATION;
	}

	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldBuildOriginalTag) {
			StringBuffer wholeTagWithBody = new StringBuffer();

			String tagName = tag.getQualifiedName();
			wholeTagWithBody.append("<").append(tagName);

			for (Entry<String, String> entry : tag.getAttributes().entrySet()) {
				String attribute = String.format(" %s=\"%s\"", entry.getKey(), entry.getValue());
				wholeTagWithBody.append(attribute);
			}

			if (whens.size() == 0) {
				wholeTagWithBody.append("/>");
			} else {
				wholeTagWithBody.append(">");
				for (WhenTag when : whens) {
					int startResult = when.doStartTag(tag, tagBody, context, target);
					if (startResult == Tag.CONTINUE_TAG_EVALUATION) {
						String whenBody = when.doEndTag(tag, new StringBuffer(), context, target);
						wholeTagWithBody.append(whenBody);
					}
				}
				wholeTagWithBody.append("</").append(tagName).append(">");
			}

			return wholeTagWithBody.toString();
		}

		removeSkipEvaluation(context);
		for (WhenTag when : whens) {
			int startResult = when.doStartTag(tag, tagBody, context, target);
			if (startResult == Tag.CONTINUE_TAG_EVALUATION) {
				String whenBody = when.doEndTag(tag, new StringBuffer(), context, target);
				tagBody.append(whenBody);
				log.debug("Appending {} to tag body", whenBody);
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
		whens.add(toAdd);
	}

	public void setOtherwise(OtherwiseTag otherwise) {
		otherwise.setParentChoose(this);
		whens.add(otherwise);
	}
}
