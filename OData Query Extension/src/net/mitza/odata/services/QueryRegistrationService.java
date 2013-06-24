package net.mitza.odata.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.mitza.odata.resolver.QueryComponentPresentationResolver;
import net.mitza.odata.resolver.QueryComponentResolver;
import net.mitza.odata.resolver.QueryPageResolver;

import com.tridion.webservices.extension.ODataResourceBundleRegistrationService;
import com.tridion.webservices.extension.WebserviceExtensionType;
import com.tridion.webservices.odata.input.ODataInputElementType;
import com.tridion.webservices.odata.model.wrappers.ComponentPresentationPropertyWrapper;
import com.tridion.webservices.odata.model.wrappers.ComponentPropertyWrapper;
import com.tridion.webservices.odata.model.wrappers.PagePropertyWrapper;

/**
 * @author Mihai Cadariu
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class QueryRegistrationService implements ODataResourceBundleRegistrationService {
	private static String AREA_NAME;
	public static final ODataInputElementType QUERY_COMPONENT;
	public static final ODataInputElementType QUERY_COMPONENTPRESENTATION;
	public static final ODataInputElementType QUERY_PAGE;
	private static List PROPERTY_WRAPPERS;

	static {
		AREA_NAME = "QUERY_AREA";
		QUERY_COMPONENT = new ODataInputElementType("QueryComponents", QueryComponentResolver.class, true, AREA_NAME);
		QUERY_COMPONENTPRESENTATION = new ODataInputElementType("QueryComponentPresentations",
				QueryComponentPresentationResolver.class, true, AREA_NAME);
		QUERY_PAGE = new ODataInputElementType("QueryPages", QueryPageResolver.class, true, AREA_NAME);
		PROPERTY_WRAPPERS = new ArrayList();
		PROPERTY_WRAPPERS.add(ComponentPropertyWrapper.class);
		PROPERTY_WRAPPERS.add(ComponentPresentationPropertyWrapper.class);
		PROPERTY_WRAPPERS.add(PagePropertyWrapper.class);
	}

	public String getContentType() {
		return null;
	}

	public WebserviceExtensionType getExtensionType() {
		return WebserviceExtensionType.ResourceResolver;
	}

	public String getExtensionName() {
		return AREA_NAME;
	}

	public List getRegistrationEntries() {
		List types = new ArrayList();
		types.add(QUERY_COMPONENT);
		types.add(QUERY_COMPONENTPRESENTATION);
		types.add(QUERY_PAGE);

		return types;
	}

	public List getPropertyWrappers() {
		return PROPERTY_WRAPPERS;
	}

	public List getMetadataEntities() {
		return Collections.emptyList();
	}

	public List getOneToOneRelationships() {
		return Collections.emptyList();
	}

	public List getOneToManyRelationships() {
		return Collections.emptyList();
	}

	public List getManyToManyRelationships() {
		return Collections.emptyList();
	}
}
