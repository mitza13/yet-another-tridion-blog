package net.mitza.odata.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.broker.querying.MetadataType;
import com.tridion.broker.querying.sorting.SortColumn;
import com.tridion.broker.querying.sorting.SortDirection;
import com.tridion.broker.querying.sorting.SortParameter;
import com.tridion.broker.querying.sorting.column.CustomMetaKeyColumn;

/**
 * @author Mihai Cadariu
 */
public class SortParameterBuilder {

	public static final String COMPONENT_SCHEMA = "ComponentSchema";
	public static final String ITEM_CREATION_DATE = "ItemCreationDate";
	public static final String ITEM_ID = "ItemId";
	public static final String ITEM_INITIAL_PUBLICATION = "ItemInitialPublication";
	public static final String ITEM_LAST_PUBLISH = "ItemLastPublish";
	public static final String ITEM_MAJOR_VERSION = "ItemMajorVersion";
	public static final String ITEM_MINOR_VERSION = "ItemMinorVersion";
	public static final String ITEM_MODIFICATION = "ItemModification";
	public static final String ITEM_OWNING_PUBLICATION = "ItemOwningPublication";
	public static final String ITEM_PUBLICATION = "ItemPublication";
	public static final String ITEM_TITLE = "ItemTitle";
	public static final String ITEM_TRUSTEE = "ItemTrustee";
	public static final String ITEM_TYPE = "ItemType";
	public static final String PAGE_FILENAME = "PageFilename";
	public static final String PAGE_TEMPLATE = "PageTemplate";
	public static final String PAGE_URL = "PageURL";

	public static final String $ORDERBY = "$orderby";

	private final Logger log = LoggerFactory.getLogger(SortParameterBuilder.class);

	private final String orderby;
	private List<SortParameter> sortParameters;
	private LinkedList<String> tokens;
	private String curentToken;

	public SortParameterBuilder(Map<String, String> requestParametersMap) {
		sortParameters = new ArrayList<SortParameter>();
		if (requestParametersMap.containsKey($ORDERBY)) {
			orderby = requestParametersMap.get($ORDERBY);
			log.debug($ORDERBY + "=" + orderby);
			buildSortParameters();
		} else {
			orderby = null;
		}
	}

	public SortParameterBuilder(String orderby) {
		sortParameters = new ArrayList<SortParameter>();
		this.orderby = orderby;
		buildSortParameters();
	}

	public boolean isOrderbySet() {
		return orderby != null;
	}

	public String getOrderby() {
		return orderby;
	}

	public SortParameter[] getSortParameters() {
		return sortParameters.toArray(new SortParameter[0]);
	}

	private void nextToken() {
		if (!tokens.isEmpty()) {
			tokens.pop();
		}
		if (tokens.isEmpty()) {
			curentToken = null;
		} else {
			curentToken = tokens.getFirst();
		}
	}

	private void buildSortParameters() {
		if (orderby == null) {
			return;
		}

		tokens = new LinkedList<String>(Arrays.asList(orderby.split("\\s")));
		curentToken = tokens.getFirst();
		while (curentToken != null) {
			SortColumn sortColumn = getSortColumn();
			SortDirection sortDirection = getSortDirection();
			log.debug("Add SortParameter(" + sortColumn + ", " + sortDirection + ")");
			sortParameters.add(new SortParameter(sortColumn, sortDirection));
		}
	}

	private SortColumn getSortColumn() {
		SortColumn sortColumn = null;
		if (COMPONENT_SCHEMA.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_SCHEMA_ID;
		} else if (ITEM_CREATION_DATE.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_CREATION_DATE;
		} else if (ITEM_ID.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_ITEM_REFERENCE_ID;
		} else if (ITEM_INITIAL_PUBLICATION.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_INITIAL_PUBLICATION_DATE;
		} else if (ITEM_LAST_PUBLISH.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_LAST_PUBLISHED_DATE;
		} else if (ITEM_MAJOR_VERSION.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_MAJOR_VERSION;
		} else if (ITEM_MINOR_VERSION.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_MINOR_VERSION;
		} else if (ITEM_MODIFICATION.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_MODIFICATION_DATE;
		} else if (ITEM_OWNING_PUBLICATION.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_OWNING_PUBLICATION_ID;
		} else if (ITEM_PUBLICATION.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_PUBLICATION_ID;
		} else if (ITEM_TITLE.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_TITLE;
		} else if (ITEM_TRUSTEE.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_TRUSTEE;
		} else if (ITEM_TYPE.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_ITEM_TYPE;
		} else if (PAGE_FILENAME.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_FILENAME;
		} else if (PAGE_TEMPLATE.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_PAGE_TEMPLATE_ID;
		} else if (PAGE_URL.equals(curentToken)) {
			sortColumn = SortParameter.ITEMS_URL;
		}

		nextToken();
		if (sortColumn != null) {
			return sortColumn;
		}

		// assume it's custom meta key
		String customMetaKey = curentToken;
		MetadataType metadataType = getMetadataType();

		log.debug("Identified CustomMetaKeyColumn(" + customMetaKey + ", " + metadataType + ")");
		return new CustomMetaKeyColumn(customMetaKey, metadataType);
	}

	private SortDirection getSortDirection() {
		if ("asc".equals(curentToken)) {
			nextToken();
			return SortParameter.ASCENDING;
		} else if ("desc".equals(curentToken)) {
			nextToken();
			return SortParameter.DESCENDING;
		}

		return SortDirection.ASCENDING;
	}

	private MetadataType getMetadataType() {
		if (curentToken == null) {
			return MetadataType.STRING;
		}

		MetadataType metadataType;
		try {
			metadataType = MetadataType.valueOf(curentToken.toUpperCase());
			nextToken();
		} catch (IllegalArgumentException iae) {
			metadataType = MetadataType.STRING;
		}

		return metadataType;
	}
}
