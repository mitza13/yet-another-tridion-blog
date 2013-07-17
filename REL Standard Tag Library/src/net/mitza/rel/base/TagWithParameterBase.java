package net.mitza.rel.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

public class TagWithParameterBase<T extends ParameterTagBase> extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(TagWithParameterBase.class);

	protected List<T> parameterList;

	public TagWithParameterBase() {
		parameterList = new ArrayList<T>();
	}

	@Override
	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		super.doStartTag(tag, tagBody, context, target);
		if (shouldSkipEvaluation(context)) { // if current tag is nested
			shouldBuildOriginalTag = true;
			return Tag.CONTINUE_TAG_EVALUATION;
		}

		return Tag.CONTINUE_TAG_EVALUATION;
	}

	@Override
	public String buildOriginalTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target) {
		StringBuffer wholeTagWithBody = new StringBuffer();

		String tagName = tag.getQualifiedName();
		wholeTagWithBody.append("<").append(tagName);

		for (Entry<String, String> entry : tag.getAttributes().entrySet()) {
			String attribute = String.format(" %s=\"%s\"", entry.getKey(), entry.getValue());
			wholeTagWithBody.append(attribute);
		}

		if (parameterList.size() == 0) {
			wholeTagWithBody.append("/>");
		} else {
			wholeTagWithBody.append(">");
			for (ParameterTagBase param : parameterList) {
				try {
					int doStartTag = param.doStartTag(tag, tagBody, context, target);
					if (doStartTag == Tag.CONTINUE_TAG_EVALUATION) {
						String paramBody = param.doEndTag(tag, tagBody, context, target);
						wholeTagWithBody.append(paramBody);
					}
				} catch (TCDLTransformerException e) {
					log.error(e.getMessage(), e);
				}
			}
			wholeTagWithBody.append("</").append(tagName).append(">");
		}

		return wholeTagWithBody.toString();
	}
}
