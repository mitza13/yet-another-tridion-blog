package net.mitza.rel.renderer;

import java.util.HashMap;
import java.util.Map;

import net.mitza.odata.builder.CriteriaBuilder;
import net.mitza.odata.builder.ResultFilterBuilder;
import net.mitza.odata.builder.SortParameterBuilder;
import net.mitza.rel.DynamicContent;

import com.tridion.dcp.ComponentPresentation;
import com.tridion.dynamiccontent.ComponentPresentationAssembler;
import com.tridion.tcdl.OutputDocument;
import com.tridion.tcdl.TCDLTransformerException;
import com.tridion.tcdl.Tag;
import com.tridion.tcdl.TagRenderer;
import com.tridion.tcdl.TransformContext;

/**
 * @author Mihai Cadariu
 */
public class DynamicContentTagRenderer implements TagRenderer {

	private String var;
	private ComponentPresentation[] dcps;
	private Map<String, String> parametersMap;

	public DynamicContentTagRenderer() {
		parametersMap = new HashMap<String, String>();
	}

	@Override
	public int doStartTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		DynamicContent dynamicContent = new DynamicContent(parametersMap);
		dcps = dynamicContent.queryComponentPresentations();

		return dcps.length > 0 ? Tag.CONTINUE_TAG_EVALUATION : Tag.SKIP_TAG;
	}

	@Override
	public String doEndTag(Tag tag, StringBuffer tagBody, TransformContext context, OutputDocument target)
			throws TCDLTransformerException {
		if (var == null) {
			int publicationId = dcps[0].getPublicationId();
			ComponentPresentationAssembler assembler = new ComponentPresentationAssembler(publicationId);
			for (ComponentPresentation dcp : dcps) {
				tagBody.append(assembler.getContent(dcp.getComponentId(), dcp.getComponentTemplateId()));
			}
		} else {
			context.set(var, dcps);
		}

		return tagBody.toString();
	}

	@Override
	public boolean requiresCodeBlock(TransformContext context, OutputDocument output, Tag tag) {
		return false;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setFilter(String filter) {
		parametersMap.put(CriteriaBuilder.$FILTER, filter);
	}

	public void setOrderby(String orderby) {
		parametersMap.put(SortParameterBuilder.$ORDERBY, orderby);
	}

	public void setTop(String top) {
		parametersMap.put(ResultFilterBuilder.$TOP, top);
	}

	public void setSkip(String skip) {
		parametersMap.put(ResultFilterBuilder.$SKIP, skip);
	}

	public void setComponentTemplate(String componentTemplate) {
		parametersMap.put(DynamicContent.COMPONENT_TEMPLATE, componentTemplate);
	}
}
