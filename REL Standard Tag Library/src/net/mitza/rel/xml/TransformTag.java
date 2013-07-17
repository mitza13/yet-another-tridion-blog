package net.mitza.rel.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.mitza.rel.base.TagWithParameterBase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;

/*
 * Conducts a transformation given a source XML document and an XSLT stylesheet.
 * 
 * <x:transform var="varName" doc="xmlVar" xslt="xsltVar">
 *   <x:param var="varName1" select="expr1" />
 *   <x:param var="varName2" select="expr2" />
 * </x:transform>
 */
public class TransformTag extends TagWithParameterBase<ParamTag> {

	private static Logger log = LoggerFactory.getLogger(TransformTag.class);

	private String doc; // expression evaluating to String representing XML or Document object or DOMSource object
	private String xslt; // expression evaluating to String representing XSLT or Templates object
	private String var; // var name or ${}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldBuildOriginalTag) { // if current tag is nested
			return buildOriginalTag(tag, tagBody, context, target);
		}
		removeSkipEvaluation(context);

		try {
			DOMSource domSource = getDOMSource(context);
			Templates templates = getTemplates(context);
			Transformer transformer = templates.newTransformer();
			setParams(transformer, context);

			StringWriter writer = new StringWriter();
			transformer.transform(domSource, new StreamResult(writer));
			String result = writer.toString();
			var = evaluateAttribute(var, context).toString();

			if (var.length() == 0) {
				tagBody.append(result);
				log.debug("Appending result to tag body '{}'", result);
			} else {
				context.set(var, result);
				log.debug("Setting context variable '{}' with value '{}'", var, result);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new TCDLTransformerException(e.getMessage(), e);
		}

		return tagBody.toString();
	}

	public void setRequiredDoc(String doc) {
		this.doc = doc;
	}

	public void setRequiredXslt(String xslt) {
		this.xslt = xslt;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void addParam(ParamTag param) {
		parameterList.add(param);
	}

	private DOMSource getDOMSource(TransformContext context) throws Exception {
		Object docValue = evaluateExpression(doc, context);
		DOMSource domSource = null;

		if (docValue instanceof String) {
			Document document = parseXml((String) docValue);
			domSource = new DOMSource(document);
		} else if (docValue instanceof Document) {
			domSource = new DOMSource((Document) docValue);
		} else if (docValue instanceof DOMSource) {
			domSource = (DOMSource) docValue;
		}
		return domSource;
	}

	private Templates getTemplates(TransformContext context) throws Exception {
		Object xsltValue = evaluateExpression(xslt, context);
		Templates templates = null;

		if (xsltValue instanceof String) {
			templates = parseXslt((String) xsltValue);
		} else if (xsltValue instanceof Templates) {
			templates = (Templates) xsltValue;
		}

		return templates;
	}

	private Document parseXml(String docValue) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource source = new InputSource(new StringReader(docValue));
		return builder.parse(source);
	}

	private Templates parseXslt(String xsltValue) throws Exception {
		Source source = new StreamSource(new StringReader(xsltValue));
		TransformerFactory factory = TransformerFactory.newInstance();
		return factory.newTemplates(source);
	}

	private void setParams(Transformer transformer, TransformContext context) {
		for (ParamTag param : parameterList) {
			String paramName = param.getVar();
			paramName = evaluateAttribute(paramName, context).toString();
			Object paramValue = param.getSelect();
			paramValue = evaluateAttribute(paramValue.toString(), context);
			transformer.setParameter(paramName, paramValue);
		}
	}
}
