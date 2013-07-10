package net.mitza.odata.services;

import java.util.Collections;
import java.util.List;

import net.mitza.odata.resolver.QueryPageResolver;

import com.tridion.webservices.extension.ODataEntryRegistrationService;
import com.tridion.webservices.odata.input.resolver.ResolverBase;
import com.tridion.webservices.odata.model.metadata.schema.Entity;
import com.tridion.webservices.odata.model.wrappers.PagePropertyWrapper;
import com.tridion.webservices.odata.model.wrappers.PropertyWrapper;

/**
 * @author Mihai Cadariu
 */
public class QueryPagesRegistrationService implements ODataEntryRegistrationService {

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
		return PagePropertyWrapper.class;
	}

	@Override
	public Class<? extends ResolverBase> getResolverClass() {
		return QueryPageResolver.class;
	}

	@Override
	public String getResolverName() {
		return "QueryPages";
	}

	@Override
	public boolean isResolverForCollection() {
		return true;
	}

}
