package net.mitza.rel.core;

import java.util.HashMap;
import java.util.Map;

import com.tridion.tcdl.TransformContext;

/*
 * Subtag of <c:choose> that follows <c:when> tags and runs only if 
 * all of the prior conditions evaluated to 'false'
 * 
 * <c:choose>
 *   <c:when test="expr1"> Do something </c:when>
 *   <c:when test="expr2"> Do something </c:when>
 *   <c:otherwsie> Do something </c:otherwise>
 * </c:choose>
 */
public class OtherwiseTag extends WhenTag {

	private static final String TAG_NAME = "otherwise";

	@Override
	protected boolean condition(TransformContext context) {
		return true;
	}

	@Override
	protected String getTagName() {
		return TAG_NAME;
	}

	@Override
	protected Map<String, String> getTagAttributes() {
		return new HashMap<String, String>();
	}
}
