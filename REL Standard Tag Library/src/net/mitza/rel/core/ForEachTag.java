package net.mitza.rel.core;

import java.util.Arrays;
import java.util.List;

import net.mitza.rel.base.AdapterTag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * The basic iteration tag
 * 
 * <c:ForEach var="varName" items="expr" > Do Something </c:ForEach>
 */
public class ForEachTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(ForEachTag.class);

	private String var; // var name or ${}
	private String itemsExpression; // expression evaluating to List or array to iterate
	private List<?> items;

	@Override
	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		super.doStartTag(tag, tagBody, context, target);
		if (shouldSkipEvaluation(context)) { // if current tag is nested
			shouldBuildOriginalTag = true;
			return Tag.CONTINUE_TAG_EVALUATION;
		}

		Object contextItems = evaluateExpression(itemsExpression, context);
		if (contextItems == null) {
			return Tag.SKIP_TAG;
		} else if (contextItems instanceof Object[]) {
			items = Arrays.asList((Object[]) contextItems);
		} else if (contextItems instanceof List) {
			items = (List<?>) contextItems;
		}

		if (items == null || items.isEmpty()) {
			return Tag.SKIP_TAG;
		} else {
			setSkipEvaluation(context);
			return Tag.CONTINUE_TAG_EVALUATION;
		}
	}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldBuildOriginalTag) { // if current tag is nested
			return buildOriginalTag(tag, tagBody, context, target);
		}

		removeSkipEvaluation(context);
		StringBuffer result = new StringBuffer();
		var = evaluateAttribute(var, context).toString();

		for (Object item : items) {
			context.set(var, item);
			log.debug("Setting context variable '{}' with value '{}'", var, item);
			String body = evaluateBody(tagBody.toString(), context);
			result.append(body);
		}

		log.debug("Removing context variable '{}'", var);
		context.remove(var);

		return result.toString();
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setItems(String itemsVar) {
		this.itemsExpression = itemsVar;
	}
}
