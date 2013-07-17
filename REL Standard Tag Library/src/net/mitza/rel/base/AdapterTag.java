package net.mitza.rel.base;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.DefaultDocumentBuilder;
import com.tridion.tcdl.DocumentBuilder;
import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLEngine;
import com.tridion.tcdl.TCDLMode;
import com.tridion.tcdl.TCDLParser;
import com.tridion.tcdl.TCDLProcessor;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TagDispatcher;
import com.tridion.tcdl.TagHandlerRegistry;
import com.tridion.tcdl.TagRenderer;
import com.tridion.tcdl.TransformContext;
import com.tridion.util.StringUtils;

public class AdapterTag implements TagRenderer {

	public static final String SKIP_TAG_EVALUATION = "SkipTagEvaluation";

	protected String originalTag;
	protected boolean shouldBuildOriginalTag;

	private static TagHandlerRegistry USED_HANDLER_REGISTRY;
	private static DocumentBuilder USED_DOCUMENT_BUILDER;
	private static final Logger log = LoggerFactory.getLogger(AdapterTag.class);

	@Override
	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		originalTag = buildOriginalTag(tag, tagBody, context, target);
		return Tag.CONTINUE_TAG_EVALUATION;
	}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldSkipEvaluation(context)) {
			return buildOriginalTag(tag, tagBody, context, target);
		}

		return evaluateBody(tagBody.toString(), context);
	}

	@Override
	public boolean requiresCodeBlock(TransformContext transformContext, OutputDocument document, Tag tag) {
		return false;
	}

	public boolean shouldSkipEvaluation(TransformContext context) {
		return context.getBoolean(SKIP_TAG_EVALUATION, false);
	}

	public void setSkipEvaluation(TransformContext context) {
		context.setBoolean(SKIP_TAG_EVALUATION, true);
	}

	public void removeSkipEvaluation(TransformContext context) {
		context.setBoolean(SKIP_TAG_EVALUATION, false);
	}

	public String buildOriginalTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target) {
		return buildOriginalTag(tag, tagBody.toString(), context, target);
	}

	public String buildOriginalTag(Tag tag, String tagBody, TransformContext context, OutputDocument target) {
		StringBuffer wholeTagWithBody = new StringBuffer();
		String tagName = tag.getQualifiedName();
		wholeTagWithBody.append("<").append(tagName);

		for (Entry<String, String> entry : tag.getAttributes().entrySet()) {
			String attribute = String.format(" %s=\"%s\"", entry.getKey(), entry.getValue());
			wholeTagWithBody.append(attribute);
		}

		if (StringUtils.isEmpty(tagBody)) {
			wholeTagWithBody.append("/>");
		} else {
			wholeTagWithBody.append(">");
			wholeTagWithBody.append(tagBody);
			wholeTagWithBody.append("</").append(tagName).append(">");
		}

		return wholeTagWithBody.toString();
	}

	public String evaluateBody(String originalBody, TransformContext context) throws TCDLTransformerException {
		StringWriter writer = new StringWriter();
		TagHandlerRegistry registry = getHandlerRegistry();
		DocumentBuilder documentBuilder = getDocumentBuilder();
		OutputDocument output = new OutputDocument();
		TagDispatcher dispatcher = new TagDispatcher(context, output, registry);
		TCDLParser parser = new TCDLParser(registry.getNamespaceList(), null);
		parser.parse(dispatcher, originalBody);
		documentBuilder.buildDocument(context, output, writer);
		return writer.toString();
	}

	/**
	 * Evaluate an expresison if it's in a ${expression} notation. Otherwiese, return the original expression.
	 */
	public Object evaluateAttribute(String expression, TransformContext context) {
		if (expression == null) {
			return "";
		}

		if (expression.startsWith("${") && expression.endsWith("}")) {
			return evaluateExpression(expression.substring(2, expression.length() - 1), context);
		} else {
			return expression;
		}
	}

	public Object evaluateExpression(String expression, TransformContext context) {
		ExpressionEvaluator evaluator = new ExpressionEvaluator(context);
		return evaluator.evaluate(expression);
	}

	public boolean evaluateCondition(String condition, TransformContext context) {
		ExpressionComparator comparator = new ExpressionComparator(context);
		return comparator.evaluate(condition);
	}

	@Override
	public String toString() {
		return originalTag;
	}

	private TagHandlerRegistry getHandlerRegistry() throws TCDLTransformerException {
		if (USED_HANDLER_REGISTRY == null) {
			USED_HANDLER_REGISTRY = loadHandlerRegistry();
		}
		return USED_HANDLER_REGISTRY;
	}

	private DocumentBuilder getDocumentBuilder() throws TCDLTransformerException {
		if (USED_DOCUMENT_BUILDER == null) {
			USED_DOCUMENT_BUILDER = loadDocumentBuilder();
		}
		return USED_DOCUMENT_BUILDER;
	}

	private TagHandlerRegistry loadHandlerRegistry() throws TCDLTransformerException {
		log.debug("Loading HandlerRegistry");
		TCDLProcessor processor = TCDLProcessor.getInstance();
		Object renderProcessor = forceGetField(processor, "renderProcessor");
		TagHandlerRegistry registry;
		if (renderProcessor != null && (renderProcessor instanceof TCDLEngine)) {
			TCDLEngine renderer = (TCDLEngine) renderProcessor;
			Object registryObject = forceGetField(renderer, "registry");
			if (registryObject != null && (registryObject instanceof TagHandlerRegistry)) {
				registry = (TagHandlerRegistry) registryObject;
				log.debug("Loaded handlerRegistry={}", registry);
			} else {
				registry = new TagHandlerRegistry(true, TCDLMode.RENDER);
				log.debug("Registry member of renderProcessor was null. Loaded default handlerRegistry={}", registry);
			}
		} else {
			registry = new TagHandlerRegistry(true, TCDLMode.RENDER);
			log.debug("RenderProcessor was null. Loaded default handlerRegistry={}", registry);
		}
		return registry;
	}

	private DocumentBuilder loadDocumentBuilder() throws TCDLTransformerException {
		log.debug("Loading documentBuilder.");
		TCDLProcessor processor = TCDLProcessor.getInstance();
		Object renderProcessor = forceGetField(processor, "renderProcessor");
		DocumentBuilder documentBuilder;
		if (renderProcessor != null && (renderProcessor instanceof TCDLEngine)) {
			TCDLEngine renderer = (TCDLEngine) renderProcessor;
			Object documentBuilderObject = forceGetField(renderer, "documentBuilder");
			if (documentBuilderObject != null && (documentBuilderObject instanceof DocumentBuilder)) {
				documentBuilder = (DocumentBuilder) documentBuilderObject;
				log.debug("Loaded documentBuilder={}.", documentBuilder);
			} else {
				documentBuilder = new DefaultDocumentBuilder();
				log.debug("DocumentBuilder member of renderProcessor was null. Loaded default documentBuilder={}",
						documentBuilder);
			}
		} else {
			documentBuilder = new DefaultDocumentBuilder();
			log.debug("RenderProcessor was null. Loaded default documentBuilder={}", documentBuilder);
		}
		return documentBuilder;
	}

	@SuppressWarnings("rawtypes")
	private Object forceGetField(Object objectWithField, String fieldName) {
		Object value = null;
		Class beanClass = objectWithField.getClass();
		try {
			Field objectField = null;
			Iterator i$ = getAllDeclaredFields(beanClass).iterator();
			do {
				if (!i$.hasNext()) {
					break;
				}
				Field declaredField = (Field) i$.next();
				if (fieldName.equals(declaredField.getName())) {
					objectField = declaredField;
					break;
				}
			} while (true);
			if (objectField != null) {
				objectField.setAccessible(true);
				value = objectField.get(objectWithField);
				log.debug("Found value={} for field={}", value, fieldName);
			}
		} catch (SecurityException e) {
			log.warn((new StringBuilder()).append("Could not get field value for object ").append(objectWithField)
					.append(" and field ").append(fieldName).toString(), e);
		} catch (IllegalArgumentException e) {
			log.warn((new StringBuilder()).append("Could not get field value for object ").append(objectWithField)
					.append(" and method ").append(fieldName).toString(), e);
		} catch (IllegalAccessException e) {
			log.warn((new StringBuilder()).append("Could not get field value for object ").append(objectWithField)
					.append(" and method ").append(fieldName).toString(), e);
		}
		return value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List getAllDeclaredFields(Class clazz) {
		List allDeclaredFields = new ArrayList();
		Field arr$[] = clazz.getDeclaredFields();
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++) {
			Field field = arr$[i$];
			allDeclaredFields.add(field);
		}

		Class superClass = clazz.getSuperclass();
		if (superClass != null) {
			allDeclaredFields.addAll(getAllDeclaredFields(clazz.getSuperclass()));
		}
		return allDeclaredFields;
	}
}
