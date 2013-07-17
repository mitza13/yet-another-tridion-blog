package net.mitza.rel.core;

import java.text.ParseException;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import net.mitza.rel.base.TagWithParameterBase;
import net.mitza.rel.util.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.dcp.ComponentPresentation;
import com.tridion.dcp.ComponentPresentationFactory;
import com.tridion.dynamiccontent.ComponentPresentationAssembler;
import com.tridion.dynamiccontent.PageContentAssembler;
import com.tridion.meta.PageMeta;
import com.tridion.meta.PageMetaFactory;
import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;
import com.tridion.util.TCMURI;

/*
 * Retrieves a URL or TcmUri and either outputs its contents or sets it in context
 * 
 * <c:import var="varName" url="expr" componentTemplate="tcmUri" />
 * 
 * or
 * 
 * <c:import var="varName" url="expr" componentTemplate="tcmUri">
 *     <c:param name="varName1" value="expr1"/>
 *     <c:param name="varName2" value="expr2"/>
 * </c:import>
 */
public class ImportTag extends TagWithParameterBase<ParamTag> {

	private static Logger log = LoggerFactory.getLogger(ImportTag.class);

	private String var; // var name or ${}
	private String url; // tcmuri or string or ${}
	private Object componentTemplate; // tcmuri or CT itemId or ${} representing tcmuri or TCMURI or CT itemId

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldBuildOriginalTag) { // if current tag is nested
			return buildOriginalTag(tag, tagBody, context, target);
		}

		removeSkipEvaluation(context);
		var = evaluateAttribute(var, context).toString();
		url = evaluateAttribute(url, context).toString();
		componentTemplate = evaluateAttribute((String) componentTemplate, context);

		String value = doImport(context);

		if (var.length() == 0) {
			tagBody.append(value);
			log.debug("Appending to tag body '{}'", value);
		} else {
			context.set(var, value);
			log.debug("Setting context variable '{}' with value '{}'", var, value);
		}

		return tagBody.toString();
	}

	public void setRequiredUrl(String url) {
		this.url = url;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setComponentTemplate(String componentTemplate) {
		this.componentTemplate = componentTemplate;
	}

	public void addParam(ParamTag param) {
		parameterList.add(param);
	}

	private String doImport(TransformContext context) {
		try {
			TCMURI tcmUri = new TCMURI(url);
			return doImport(tcmUri, context);
		} catch (ParseException e) {
			return doImport(url, context);
		}
	}

	private String doImport(String url, TransformContext context) {
		if (url.startsWith("/")) {
			PageMetaFactory factory = new PageMetaFactory(0);
			Collection<PageMeta> metas = factory.getMetaByURL(url);
			if (metas.size() > 0) {
				PageMeta pageMeta = metas.iterator().next();
				TCMURI pageUri = new TCMURI(pageMeta.getPublicationId(), pageMeta.getId(), 64, 0);
				return doImport(pageUri, context);
			}
		}

		if (!url.contains("?")) {
			url += "?";
		}

		for (Map.Entry<String, String> entry : getParameterMap(context).entrySet()) {
			url += String.format("&%s=%s", entry.getKey(), entry.getValue());
		}

		log.debug("Accessing page " + url);
		return new Scanner(url).useDelimiter("\\A").next();
	}

	private String doImport(TCMURI tcmUri, TransformContext context) {
		if (tcmUri.getItemType() == 16) {
			ComponentPresentationAssembler assembler = new ComponentPresentationAssembler(tcmUri.getPublicationId());
			int ctId = Utils.getItemId(componentTemplate);
			if (ctId < 0) {
				ctId = getComponentTemplateId(tcmUri);
			}
			return ctId > 0 ? assembler.getContent(tcmUri.getItemId(), ctId) : "";
		} else if (tcmUri.getItemType() == 64) {
			PageContentAssembler assembler = new PageContentAssembler();
			return assembler.getContent(tcmUri.toString(), getParameterMap(context));
		}

		log.error("Only Component or Page TCMURI URLs accepted, but found " + tcmUri);
		return "";
	}

	private Map<String, String> getParameterMap(TransformContext context) {
		Map<String, String> result = new TreeMap<String, String>();
		for (ParamTag param : parameterList) {
			String name = param.getName();
			name = evaluateAttribute(name, context).toString();
			String value = param.getValue();
			value = evaluateAttribute(value, context).toString();
			result.put(name, value);
		}

		return result;
	}

	private int getComponentTemplateId(TCMURI tcmUri) {
		ComponentPresentationFactory factory = new ComponentPresentationFactory(tcmUri.getPublicationId());
		ComponentPresentation dcp = factory.getComponentPresentationWithHighestPriority(tcmUri.getItemId());

		return dcp == null ? -1 : dcp.getComponentTemplateId();
	}
}
