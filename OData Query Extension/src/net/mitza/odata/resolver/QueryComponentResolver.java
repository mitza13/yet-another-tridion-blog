package net.mitza.odata.resolver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.mitza.odata.builder.QueryBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.ItemTypes;
import com.tridion.broker.StorageException;
import com.tridion.broker.querying.Query;
import com.tridion.broker.querying.criteria.content.ItemTypeCriteria;
import com.tridion.meta.Item;
import com.tridion.storage.ComponentMeta;
import com.tridion.storage.mapper.MapperFactory;
import com.tridion.webservices.odata.builders.ComponentEntryBuilder;
import com.tridion.webservices.odata.exceptions.FeedBuildingException;
import com.tridion.webservices.odata.input.ODataInputElement;
import com.tridion.webservices.odata.input.jpql.JPQLExecutionException;
import com.tridion.webservices.odata.input.resolver.ResolverBase;
import com.tridion.webservices.odata.model.ODataBase;
import com.tridion.webservices.odata.model.ODataEntry;
import com.tridion.webservices.odata.model.ODataErrorResponse;
import com.tridion.webservices.odata.model.ODataFeed;

/**
 * @author Mihai Cadariu
 */
public class QueryComponentResolver extends ResolverBase {

	private final Logger log = LoggerFactory.getLogger(QueryComponentResolver.class);

	public QueryComponentResolver(ODataInputElement oDataInputElement) {
		super(oDataInputElement, new ComponentEntryBuilder());
	}

	@Override
	protected ODataBase resolveEntry() {
		return resolveCollection();
	}

	@Override
	protected ODataBase resolveCollection() {
		try {
			return buildQueryEntries(getComponents());
		} catch (Exception e) {
			log.error("Error occurred while querying for content", e);
			return new ODataErrorResponse("Unable to build query entries", e.getMessage());
		}
	}

	@Override
	protected ODataBase resolveRelation(ODataEntry previouslyResolvedEntry) {
		return new ODataErrorResponse("", "Relation is not supported");
	}

	private ODataFeed buildQueryEntries(List<ComponentMeta> items) throws FeedBuildingException, JPQLExecutionException {
		ODataFeed feed = new ODataFeed(ODataFeed.COMPONENT_TITLE, getRequestUrl(), getBaseUrl());
		feed.setUpdated(new Date());
		feed.setId(getRequestUrl());
		for (ComponentMeta componentMeta : items) {
			feed.addEntry(buildEntry(componentMeta, false));
		}

		return feed;
	}

	private List<ComponentMeta> getComponents() throws StorageException {
		List<ComponentMeta> result = new ArrayList<ComponentMeta>();
		ItemTypeCriteria componentTypeCriteria = new ItemTypeCriteria(ItemTypes.COMPONENT);
		QueryBuilder queryBuilder = new QueryBuilder(oDataInputElement, getRequestParametersMap(),
				componentTypeCriteria);

		Query query = queryBuilder.getQuery();
		Item[] items = query.executeEntityQuery();

		for (Item item : items) {
			ComponentMeta componentMeta = MapperFactory.mapComponentMeta((com.tridion.meta.ComponentMeta) item);
			result.add(componentMeta);
		}

		return result;
	}
}
