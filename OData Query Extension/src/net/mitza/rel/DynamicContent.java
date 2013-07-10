package net.mitza.rel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.mitza.odata.builder.QueryBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.ItemTypes;
import com.tridion.broker.StorageException;
import com.tridion.broker.querying.Query;
import com.tridion.dcp.ComponentPresentation;
import com.tridion.dcp.ComponentPresentationFactory;
import com.tridion.util.TCMURI;

/**
 * @author Mihai Cadariu
 */
public class DynamicContent {

	public static final String COMPONENT_TEMPLATE = "ComponentTemplate";

	private Query query;
	private int componentTemplateId;

	private static final Logger log = LoggerFactory.getLogger(DynamicContent.class);

	public DynamicContent(Map<String, String> attributes) {
		setComponentTemplate(attributes.get(COMPONENT_TEMPLATE));
		QueryBuilder builder = new QueryBuilder(attributes);
		query = builder.getQuery();
	}

	public ComponentPresentation[] queryComponentPresentations() {
		List<ComponentPresentation> result = new ArrayList<ComponentPresentation>();

		try {
			String componentTcmUris[] = query.executeQuery();
			log.debug("Query found " + componentTcmUris.length + " Components");
			if (componentTcmUris.length == 0) {
				return new ComponentPresentation[0];
			}

			TCMURI tcmUri = new TCMURI(componentTcmUris[0]);
			int publicationId = tcmUri.getPublicationId();
			String templateTcmUri = getTemplateTcmUri(publicationId);

			ComponentPresentationFactory factory = new ComponentPresentationFactory(publicationId);
			ComponentPresentation componentPresentation;

			for (String componentTcmUri : componentTcmUris) {
				if (templateTcmUri == null) {
					componentPresentation = factory.getComponentPresentationWithHighestPriority(componentTcmUri);
				} else {
					componentPresentation = factory.getComponentPresentation(componentTcmUri, templateTcmUri);
				}
				if (componentPresentation != null) {
					result.add(componentPresentation);
				}
			}
		} catch (StorageException se) {
			log.error("StorageException occurred", se);
		} catch (ParseException pe) {
			log.error("ParseException occurred", pe);
		}

		return result.toArray(new ComponentPresentation[0]);
	}

	private String getTemplateTcmUri(int publicationId) {
		if (componentTemplateId > 0) {
			return new TCMURI(publicationId, componentTemplateId, ItemTypes.COMPONENT_TEMPLATE, 0).toString();
		} else {
			return null;
		}
	}

	public int getComponentTemplate() {
		return componentTemplateId;
	}

	public void setComponentTemplate(String componentTemplate) {
		try {
			TCMURI tcmUri = new TCMURI(componentTemplate);
			componentTemplateId = tcmUri.getItemId();
		} catch (ParseException pe) {
			try {
				componentTemplateId = Integer.parseInt(componentTemplate);
			} catch (NumberFormatException nfe) {
				componentTemplateId = -1;
			}
		}
	}
}
