package net.mitza.rel.core;

import net.mitza.rel.base.AdapterTag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.dcp.ComponentPresentation;
import com.tridion.dynamiccontent.ComponentPresentationAssembler;
import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * Outputs the value to the tag body
 * 
 * <c:out value="expr" />
 */
public class OutTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(OutTag.class);

	private String value;

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldSkipEvaluation(context)) {
			return buildOriginalTag(tag, tagBody, context, target);
		}

		Object result = evaluateExpression(value, context);
		result = evaluateInvokable(result);
		log.debug("Appending to output '{}'", result);
		return result == null ? "" : result.toString();
	}

	public void setRequiredValue(String value) {
		this.value = value;
	}

	private Object evaluateInvokable(Object invokableObject) {
		if (invokableObject instanceof ComponentPresentation) {
			ComponentPresentation cp = (ComponentPresentation) invokableObject;
			ComponentPresentationAssembler assembler = new ComponentPresentationAssembler(cp.getPublicationId());
			return assembler.getContent(cp.getComponentId(), cp.getComponentTemplateId());
		}

		return invokableObject;
	}
}
