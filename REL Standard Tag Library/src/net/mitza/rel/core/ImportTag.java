package net.mitza.rel.core;

import java.text.ParseException;
import java.util.Scanner;

import net.mitza.rel.base.AdapterTag;
import net.mitza.rel.util.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.dcp.ComponentPresentation;
import com.tridion.dcp.ComponentPresentationFactory;
import com.tridion.dynamiccontent.ComponentPresentationAssembler;
import com.tridion.dynamiccontent.PageContentAssembler;
import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TransformContext;
import com.tridion.util.TCMURI;

/*
 * Retrieves a URL or TcmUri and exposes its contents to either the tag body or a String in 'var' (placed in TransformCntext).
 * 
 * <c:import var="varName" url="expr" componentTemplate="tcmUri" />
 */
public class ImportTag extends AdapterTag {

	private static Logger log = LoggerFactory.getLogger(ImportTag.class);

	private String var;
	private String url;
	private String componentTemplate;

	@Override
	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		super.doStartTag(tag, tagBody, context, target);
		if (shouldSkipEvaluation(context)) { // if current tag is nested
			shouldBuildOriginalTag = true;
			return Tag.CONTINUE_TAG_EVALUATION;
		}

		return Tag.CONTINUE_TAG_EVALUATION;
	}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (shouldBuildOriginalTag) { // if current tag is nested
			return buildOriginalTag(tag, tagBody);
		}
		removeSkipEvaluation(context);

		String value = doImport();
		if (var == null) {
			tagBody.append(value);
			log.debug("Appending {} to tag body", value);
		} else {
			context.set(var, value);
			log.debug("Setting context variable {} with value {}", var, value);
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

	private String doImport() {
		try {
			TCMURI tcmUri = new TCMURI(url);
			return doImport(tcmUri);
		} catch (ParseException e) {
			// continue
		}

		return new Scanner(url).useDelimiter("\\A").next();
	}

	private String doImport(TCMURI tcmUri) {
		if (tcmUri.getItemType() == 16) {
			ComponentPresentationAssembler assembler = new ComponentPresentationAssembler(tcmUri.getPublicationId());
			int ctId = Utils.getItemId(componentTemplate);
			if (ctId < 0) {
				ctId = getComponentTemplateId(tcmUri);
			}
			return ctId > 0 ? assembler.getContent(tcmUri.getItemId(), ctId) : "";
		} else if (tcmUri.getItemType() == 64) {
			PageContentAssembler assembler = new PageContentAssembler();
			return assembler.getContent(tcmUri.toString());
		}

		log.error("Only Component or Page TCMURI URLs accepted, but found " + tcmUri);
		return "";
	}

	private int getComponentTemplateId(TCMURI tcmUri) {
		ComponentPresentationFactory factory = new ComponentPresentationFactory(tcmUri.getPublicationId());
		ComponentPresentation dcp = factory.getComponentPresentationWithHighestPriority(tcmUri.getItemId());

		return dcp == null ? -1 : dcp.getComponentTemplateId();
	}
}
