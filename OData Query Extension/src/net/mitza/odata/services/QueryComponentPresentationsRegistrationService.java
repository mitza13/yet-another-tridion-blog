package net.mitza.odata.services;

import java.util.Collections;
import java.util.List;

import net.mitza.odata.resolver.QueryComponentPresentationResolver;

import com.tridion.webservices.extension.ODataEntryRegistrationService;
import com.tridion.webservices.odata.input.resolver.ResolverBase;
import com.tridion.webservices.odata.model.metadata.schema.Entity;
import com.tridion.webservices.odata.model.wrappers.ComponentPresentationPropertyWrapper;
import com.tridion.webservices.odata.model.wrappers.PropertyWrapper;

/**
 * @author Mihai Cadariu
 */
public class QueryComponentPresentationsRegistrationService implements ODataEntryRegistrationService {

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public String getFunctionalName() {
		return "QUERY_FUNCTIONAL_NAME";
	}

	@Override
	public List<String> getManyToManyRelationships() {
		return Collections.emptyList();
	}

	@Override
	public Entity getMetadataEntity() {
		return null;
	}

	@Override
	public List<String> getOneToManyRelationships() {
		return Collections.emptyList();
	}

	@Override
	public List<String> getOneToOneRelationships() {
		return Collections.emptyList();
	}

	@Override
	public Class<? extends PropertyWrapper> getPropertyWrapper() {
		return ComponentPresentationPropertyWrapper.class;
	}

	@Override
	public Class<? extends ResolverBase> getResolverClass() {
		return QueryComponentPresentationResolver.class;
	}

	@Override
	public String getResolverName() {
		return "QueryComponentPresentations";
	}

	@Override
	public boolean isResolverForCollection() {
		return true;
	}
}
