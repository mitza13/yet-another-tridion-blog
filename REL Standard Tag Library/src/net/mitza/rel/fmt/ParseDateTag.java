package net.mitza.rel.fmt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.mitza.rel.base.AdapterTag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * Parses the string representation of a date and/or time and sets it in context
 * 
 * <fmt:parseDate value="expr" pattern="stringPattern" var="varName" />
 */
public class ParseDateTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(ParseDateTag.class);

	private String value; // expression evaluating to a String representing a date or ${}
	private String pattern; // pattern or ${}
	private String var; // var name or ${}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldSkipEvaluation(context)) {
			return buildOriginalTag(tag, tagBody, context, target);
		}

		try {
			pattern = evaluateAttribute(pattern, context).toString();
			var = evaluateAttribute(var, context).toString();
			String dateAsString = evaluateExpression(value, context).toString();

			DateFormat format = new SimpleDateFormat(pattern);
			Date date = format.parse(dateAsString);

			log.debug("Setting context variable '{}' with value '{}'", var, date);
			context.set(var, date);
		} catch (ParseException pe) {
			log.error(pe.getMessage(), pe);
			throw new TCDLTransformerException(pe.getMessage(), pe);
		}

		return "";
	}

	public void setRequiredValue(String value) {
		this.value = value;
	}

	public void setRequiredPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setRequiredVar(String var) {
		this.var = var;
	}
}
