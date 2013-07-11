package net.mitza.rel.core;

import net.mitza.rel.base.AdapterTag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * <c:out value="expr" />
 */
public class OutTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(OutTag.class);

	private String value;

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldSkipEvaluation(context)) {
			return buildOriginalTag(tag, tagBody);
		}

		Object evaluatedVariable = evaluateVariable(value, context);
		log.debug("Appending {} to page body", evaluatedVariable);
		return evaluatedVariable == null ? "" : evaluatedVariable.toString();
	}

	public void setRequiredValue(String value) {
		this.value = value;
	}
}
