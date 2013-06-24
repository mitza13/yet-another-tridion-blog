package net.mitza.odata.resolver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.mitza.odata.builder.CriteriaBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.ItemTypes;
import com.tridion.broker.StorageException;
import com.tridion.broker.querying.Query;
import com.tridion.broker.querying.criteria.Criteria;
import com.tridion.broker.querying.criteria.content.ItemTypeCriteria;
import com.tridion.meta.Item;
import com.tridion.storage.PageMeta;
import com.tridion.webservices.odata.builders.PageEntryBuilder;
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
public class QueryPageResolver extends ResolverBase {

	private final Logger log = LoggerFactory.getLogger(QueryPageResolver.class);

	public QueryPageResolver(ODataInputElement oDataInputElement) {
		super(oDataInputElement, new PageEntryBuilder());
	}

	protected ODataBase resolveEntry() {
		return resolveCollection();
	}

	@Override
	protected ODataBase resolveCollection() {
		try {
			CriteriaBuilder builder = new CriteriaBuilder(oDataInputElement, getRequestParametersMap());
			Criteria criteria = builder.getCriteria();
			return buildQueryEntries(getQueries(criteria));
		} catch (Exception e) {
			log.error("Error occurred while querying for pages", e);
			return new ODataErrorResponse("Unable to build query entries", e.getMessage());
		}
	}

	@Override
	protected ODataBase resolveRelation(ODataEntry previouslyResolvedEntry) {
		return new ODataErrorResponse("", "Relation is not supported");
	}

	private ODataFeed buildQueryEntries(List<PageMeta> items) throws FeedBuildingException, JPQLExecutionException {
		ODataFeed feed = new ODataFeed(ODataFeed.PAGE_TITLE, getRequestUrl(), getBaseUrl());
		feed.setUpdated(new Date());
		feed.setId(getRequestUrl());
		for (PageMeta pageMeta : items) {
			feed.addEntry(buildEntry(pageMeta, false));
		}

		return feed;
	}

	List<PageMeta> getQueries(Criteria criteria) throws StorageException {
		List<PageMeta> result = new ArrayList<PageMeta>();
		Criteria pageTypeCriteria = new ItemTypeCriteria(ItemTypes.PAGE);
		if (criteria == null) {
			criteria = pageTypeCriteria;
		} else {
			criteria.addCriteria(pageTypeCriteria);
		}

		Query query = new Query(criteria);
		Item[] items = query.executeEntityQuery();
		for (Item item : items) {
			PageMeta pageMeta = new PageMeta((com.tridion.meta.PageMeta) item);
			result.add(pageMeta);
		}

		return result;
	}
}
