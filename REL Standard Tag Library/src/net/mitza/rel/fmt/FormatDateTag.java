package net.mitza.rel.fmt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.mitza.rel.base.AdapterTag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * Formats a date and/or time using the supplied pattern
 * 
 * <fmt:formatDate value="expr" pattern="stringPattern" var="varName" />
 */
public class FormatDateTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(FormatDateTag.class);

	private String value; // expression evaluating to a date
	private String pattern; // pattern or ${}
	private String var; // var name or ${}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldSkipEvaluation(context)) {
			return buildOriginalTag(tag, tagBody, context, target);
		}

		pattern = evaluateAttribute(pattern, context).toString();
		var = evaluateAttribute(var, context).toString();
		Object evaluatedValue = evaluateExpression(value, context);

		DateFormat format = new SimpleDateFormat(pattern);
		String date = format.format(evaluatedValue);

		if (var.length() == 0) {
			log.debug("Appending to output '{}'", date);
			tagBody.append(date);
		} else {
			log.debug("Setting context variable '{}' with value '{}'", var, date);
			context.set(var, date);
		}

		return tagBody.toString();
	}

	public void setRequiredValue(String value) {
		this.value = value;
	}

	public void setRequiredPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setVar(String var) {
		this.var = var;
	}
}
