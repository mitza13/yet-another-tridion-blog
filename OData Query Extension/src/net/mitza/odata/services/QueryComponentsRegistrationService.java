package net.mitza.odata.services;

import java.util.Collections;
import java.util.List;

import net.mitza.odata.resolver.QueryComponentResolver;

import com.tridion.webservices.extension.ODataEntryRegistrationService;
import com.tridion.webservices.odata.input.resolver.ResolverBase;
import com.tridion.webservices.odata.model.metadata.schema.Entity;
import com.tridion.webservices.odata.model.metadata.schema.entities.ComponentEntity;
import com.tridion.webservices.odata.model.wrappers.ComponentPropertyWrapper;
import com.tridion.webservices.odata.model.wrappers.PropertyWrapper;

/**
 * @author Mihai Cadariu
 */
public class QueryComponentsRegistrationService implements ODataEntryRegistrationService {

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
		return new ComponentEntity();
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
		return ComponentPropertyWrapper.class;
	}

	@Override
	public Class<? extends ResolverBase> getResolverClass() {
		return QueryComponentResolver.class;
	}

	@Override
	public String getResolverName() {
		return "QueryComponents";
	}

	@Override
	public boolean isResolverForCollection() {
		return true;
	}

}
