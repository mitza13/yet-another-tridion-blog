package net.mitza.rel.core;

import net.mitza.rel.base.AdapterTag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * Removes a variable from context
 * 
 * <c:remove var="varName" />
 */
public class RemoveTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(RemoveTag.class);

	private String var; // var name or ${}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldSkipEvaluation(context)) {
			return buildOriginalTag(tag, tagBody, context, target);
		}

		var = evaluateAttribute(var, context).toString();
		log.debug("Removing variable '{}' from context", var);
		context.remove(var);

		return "";
	}

	public void setRequiredVar(String var) {
		this.var = var;
	}
}
