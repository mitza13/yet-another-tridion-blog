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
 * <c:ForEach var="varName" items="varCollection" > Do Something </c:ForEach>
 */
public class ForEachTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(ForEachTag.class);

	private String var;
	private String itemsVar;
	@SuppressWarnings("rawtypes")
	private List items;

	@SuppressWarnings("rawtypes")
	@Override
	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		super.doStartTag(tag, tagBody, context, target);
		if (shouldSkipEvaluation(context)) {
			shouldBuildOriginalTag = true;
			return Tag.CONTINUE_TAG_EVALUATION;
		}

		Object contextItems = evaluateVariable(itemsVar, context);
		if (contextItems == null) {
			return Tag.SKIP_TAG;
		} else if (contextItems instanceof Object[]) {
			items = Arrays.asList((Object[]) contextItems);
		} else if (contextItems instanceof List) {
			items = (List) contextItems;
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
		if (shouldBuildOriginalTag) {
			return buildOriginalTag(tag, tagBody);
		}

		removeSkipEvaluation(context);
		StringBuffer result = new StringBuffer();

		for (Object item : items) {
			context.set(var, item);
			log.debug("Set transform context attribute '{}' to '{}'", var, item);
			String body = evaluateBody(tagBody.toString(), context);
			result.append(body);
		}

		log.debug("Removing attribute '{}' from page context", var);
		context.remove(var);

		return result.toString();
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setItems(String itemsVar) {
		this.itemsVar = itemsVar;
	}
}
