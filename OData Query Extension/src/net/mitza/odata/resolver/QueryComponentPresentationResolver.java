package net.mitza.odata.resolver;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.mitza.odata.builder.QueryBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.ItemTypes;
import com.tridion.broker.StorageException;
import com.tridion.broker.querying.Query;
import com.tridion.broker.querying.criteria.Criteria;
import com.tridion.broker.querying.criteria.content.ItemTypeCriteria;
import com.tridion.dcp.ComponentPresentationFactory;
import com.tridion.storage.ComponentPresentation;
import com.tridion.storage.mapper.MapperFactory;
import com.tridion.util.TCMURI;
import com.tridion.webservices.odata.builders.ComponentPresentationEntryBuilder;
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
public class QueryComponentPresentationResolver extends ResolverBase {

	private final Logger log = LoggerFactory.getLogger(QueryComponentPresentationResolver.class);

	public QueryComponentPresentationResolver(ODataInputElement oDataInputElement) {
		super(oDataInputElement, new ComponentPresentationEntryBuilder());
	}

	protected ODataBase resolveEntry() {
		return resolveCollection();
	}

	@Override
	protected ODataBase resolveCollection() {
		try {
			return buildQueryEntries(getComponentPresentations());
		} catch (Exception e) {
			log.error("Error occurred while querying for content", e);
			return new ODataErrorResponse("Unable to build query entries", e.getMessage());
		}
	}

	@Override
	protected ODataBase resolveRelation(ODataEntry previouslyResolvedEntry) {
		return new ODataErrorResponse("", "Relation is not supported");
	}

	private ODataFeed buildQueryEntries(List<ComponentPresentation> items) throws FeedBuildingException,
			JPQLExecutionException {
		ODataFeed feed = new ODataFeed(ODataFeed.COMPONENT_PRESENTATION_FEED_TITLE, getRequestUrl(), getBaseUrl());
		feed.setUpdated(new Date());
		feed.setId(getRequestUrl());
		for (ComponentPresentation item : items) {
			feed.addEntry(buildEntry(item, false));
		}

		return feed;
	}

	List<ComponentPresentation> getComponentPresentations() throws StorageException, ParseException {
		List<ComponentPresentation> result = new ArrayList<ComponentPresentation>();
		Criteria componentTypeCriteria = new ItemTypeCriteria(ItemTypes.COMPONENT);
		QueryBuilder queryBuilder = new QueryBuilder(oDataInputElement, getRequestParametersMap(),
				componentTypeCriteria);

		Query query = queryBuilder.getQuery();
		String[] items = query.executeQuery();
		if (items.length == 0) {
			return result;
		}

		int publicationId = new TCMURI(items[0]).getPublicationId();
		ComponentPresentationFactory factory = new ComponentPresentationFactory(publicationId);

		for (String tcmUri : items) {
			com.tridion.dcp.ComponentPresentation oldCP = factory.getComponentPresentationWithHighestPriority(tcmUri);
			if (oldCP != null) {
				ComponentPresentation componentPresentation = MapperFactory.mapComponentPresentation(oldCP);
				result.add(componentPresentation);
			}
		}

		return result;
	}
}
