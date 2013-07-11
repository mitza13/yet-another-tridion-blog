package net.mitza.rel.xml;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.mitza.rel.base.AdapterTag;

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
 * <x:transform var="varName" doc="xmlName" xslt="xsltName">
 *   <x:param var="varName1" select="expr1" />
 *   <x:param var="varName2" select="expr2" />
 * </x:transform>
 */
public class TransformTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(TransformTag.class);

	private String doc;
	private String xslt;
	private String var;
	private List<ParamTag> params;

	public TransformTag() {
		params = new ArrayList<ParamTag>();
	}

	@Override
	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		super.doStartTag(tag, tagBody, context, target);
		if (shouldSkipEvaluation(context)) { // if current tag is nested
			shouldBuildOriginalTag = true;
			return Tag.CONTINUE_TAG_EVALUATION;
		}

		setSkipEvaluation(context);
		return Tag.CONTINUE_TAG_EVALUATION;
	}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldBuildOriginalTag) { // if current tag is nested
			return buildOriginalTag(tag, tagBody, context, target);
		}
		removeSkipEvaluation(context);

		try {
			String docValue = (String) evaluateVariable(doc, context);
			Document xmlDom = parseXml(docValue);
			DOMSource domSource = new DOMSource(xmlDom);

			String xsltValue = (String) evaluateVariable(xslt, context);
			Templates templates = parseXslt(xsltValue);

			Transformer transformer = templates.newTransformer();
			setParams(transformer);

			StringWriter writer = new StringWriter();
			transformer.transform(domSource, new StreamResult(writer));
			String result = writer.toString();
			if (var == null) {
				tagBody.append(result);
				log.debug("Appending result to tag body {}", result);
			} else {
				context.set(var, result);
				log.debug("Setting context variable {} with value {}", var, result);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new TCDLTransformerException(e.getMessage(), e);
		}

		return tagBody.toString();
	}

	public String buildOriginalTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target) {
		StringBuffer wholeTagWithBody = new StringBuffer();

		String tagName = tag.getQualifiedName();
		wholeTagWithBody.append("<").append(tagName);

		for (Entry<String, String> entry : tag.getAttributes().entrySet()) {
			String attribute = String.format(" %s=\"%s\"", entry.getKey(), entry.getValue());
			wholeTagWithBody.append(attribute);
		}

		if (params.size() == 0) {
			wholeTagWithBody.append("/>");
		} else {
			wholeTagWithBody.append(">");
			for (ParamTag param : params) {
				try {
					param.doStartTag(tag, tagBody, context, target);
					String paramBody = param.doEndTag(tag, tagBody, context, target);
					wholeTagWithBody.append(paramBody);
				} catch (TCDLTransformerException e) {
				}
			}
			wholeTagWithBody.append("</").append(tagName).append(">");
		}

		return wholeTagWithBody.toString();
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
		params.add(param);
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

	private void setParams(Transformer transformer) {
		for (ParamTag param : params) {
			String paramName = param.getVar();
			String paramValue = param.getSelect(); // must evaluate
			transformer.setParameter(paramName, paramValue);
		}
	}
}
