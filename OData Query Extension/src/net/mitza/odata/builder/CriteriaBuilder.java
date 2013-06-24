package net.mitza.odata.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.mitza.odata.parser.Expression;
import net.mitza.odata.parser.Parser;
import net.mitza.odata.parser.ParserException;

import com.tridion.broker.querying.criteria.Criteria;
import com.tridion.broker.querying.criteria.CriteriaException;
import com.tridion.broker.querying.criteria.FieldOperator;
import com.tridion.broker.querying.criteria.content.BinaryTypeCriteria;
import com.tridion.broker.querying.criteria.content.ItemCreationDateCriteria;
import com.tridion.broker.querying.criteria.content.ItemInitialPublishDateCriteria;
import com.tridion.broker.querying.criteria.content.ItemLastPublishedDateCriteria;
import com.tridion.broker.querying.criteria.content.ItemModificationDateCriteria;
import com.tridion.broker.querying.criteria.content.ItemReferenceCriteria;
import com.tridion.broker.querying.criteria.content.ItemSchemaCriteria;
import com.tridion.broker.querying.criteria.content.ItemTitleCriteria;
import com.tridion.broker.querying.criteria.content.MultimediaCriteria;
import com.tridion.broker.querying.criteria.content.PageTemplateCriteria;
import com.tridion.broker.querying.criteria.content.PageURLCriteria;
import com.tridion.broker.querying.criteria.content.PublicationCriteria;
import com.tridion.broker.querying.criteria.content.SchemaTitleCriteria;
import com.tridion.broker.querying.criteria.metadata.CustomMetaKeyCriteria;
import com.tridion.broker.querying.criteria.metadata.CustomMetaValueCriteria;
import com.tridion.broker.querying.criteria.operators.AndCriteria;
import com.tridion.broker.querying.criteria.publication.PublicationKeyCriteria;
import com.tridion.broker.querying.criteria.publication.PublicationMultimediaPathCriteria;
import com.tridion.broker.querying.criteria.publication.PublicationMultimediaURLCriteria;
import com.tridion.broker.querying.criteria.publication.PublicationPathCriteria;
import com.tridion.broker.querying.criteria.publication.PublicationTitleCriteria;
import com.tridion.broker.querying.criteria.publication.PublicationURLCriteria;
import com.tridion.broker.querying.criteria.structuregroups.StructureGroupCriteria;
import com.tridion.broker.querying.criteria.structuregroups.StructureGroupDirectoryCriteria;
import com.tridion.broker.querying.criteria.structuregroups.StructureGroupTitleCriteria;
import com.tridion.broker.querying.criteria.taxonomy.TaxonomyCriteria;
import com.tridion.webservices.odata.input.ODataInputElement;

/**
 * @author Mihai Cadariu
 */
public class CriteriaBuilder {

	private static final String $FILTER = "$filter";
	private static final String BYNARY_TYPE = "BinaryType";
	private static final String ITEM_CREATION_DATE = "ItemCreationDate";
	private static final String ITEM_INITIAL_PUBLISH_DATE = "ItemInitialPublishDate";
	private static final String ITEM_LAST_PUBLISHED_DATE = "ItemLastPublishedDate";
	private static final String ITEM_MODIFICATION_DATE = "ItemModificationDate";
	private static final String ITEM_REFERENCE = "ItemReference";
	private static final String ITEM_SCHEMA = "ItemSchema";
	private static final String ITEM_TITLE = "ItemTitle";
	private static final String MULTIMEDIA = "Multimedia";
	private static final String PAGE_TEMPLATE = "PageTemplate";
	private static final String PAGE_URL = "PageURL";
	private static final String PUBLICATION = "Publication";
	private static final String SCHEMA_TITLE = "SchemaTitle";

	private static final String PUBLICATION_KEY = "PublicationKey";
	private static final String PUBLICATION_MULTIMEDIA_PATH = "PublicationMultimediaPath";
	private static final String PUBLICATION_MULTIMEDIA_URL = "PublicationMultimediaURL";
	private static final String PUBLICATION_PATH = "PublicationPath";
	private static final String PUBLICATION_TITLE = "PublicationTitle";
	private static final String PUBLICATION_URL = "PublicationURL";

	private static final String STRUCTURE_GROUP = "StructureGroup";
	private static final String STRUCTURE_GROUP_DIRECTORY = "StructureGroupDirectory";
	private static final String STRUCTURE_GROUP_TITLE = "StructureGroupTitle";
	private static final String TAXONOMY = "Taxonomy";

	private static final String CUSTOM_META_KEY = "CustomMetaKey";
	private static final String CUSTOM_META_VALUE = "CustomMetaValue";

	private final ODataInputElement oDataInputElement;
	private final Map<String, String> requestParametersMap;
	private String filter;
	private Criteria criteria;

	public CriteriaBuilder(ODataInputElement oDataInputElement, Map<String, String> requestParametersMap) {
		this.oDataInputElement = oDataInputElement;
		this.requestParametersMap = requestParametersMap;
		buildCriteria();
	}

	public CriteriaBuilder(String filter) {
		this.oDataInputElement = null;
		this.requestParametersMap = null;
		this.filter = filter;
		buildCriteria();
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public static Criteria parseCriteria(String criteria, String value, FieldOperator fieldOperator) {
		try {
			if (BYNARY_TYPE.equals(criteria)) {
				if (fieldOperator != FieldOperator.EQUAL) {
					throw new ParserException("Illegal FieldOperator " + fieldOperator + " for criteria " + criteria);
				}
				return new BinaryTypeCriteria(value);
			} else if (ITEM_CREATION_DATE.equals(criteria)) {
				return new ItemCreationDateCriteria(value, fieldOperator);
			} else if (ITEM_INITIAL_PUBLISH_DATE.equals(criteria)) {
				return new ItemInitialPublishDateCriteria(value, fieldOperator);
			} else if (ITEM_LAST_PUBLISHED_DATE.equals(criteria)) {
				return new ItemLastPublishedDateCriteria(value, fieldOperator);
			} else if (ITEM_MODIFICATION_DATE.equals(criteria)) {
				return new ItemModificationDateCriteria(value, fieldOperator);
			} else if (ITEM_REFERENCE.equals(criteria)) {
				if (fieldOperator != FieldOperator.EQUAL) {
					throw new ParserException("Illegal FieldOperator " + fieldOperator + " for criteria " + criteria);
				}
				return new ItemReferenceCriteria(Integer.parseInt(value));
			} else if (ITEM_SCHEMA.equals(criteria)) {
				if (fieldOperator != FieldOperator.EQUAL) {
					throw new ParserException("Illegal FieldOperator " + fieldOperator + " for criteria " + criteria);
				}
				return new ItemSchemaCriteria(Integer.parseInt(value));
			} else if (ITEM_TITLE.equals(criteria)) {
				if (fieldOperator != FieldOperator.EQUAL) {
					throw new ParserException("Illegal FieldOperator " + fieldOperator + " for criteria " + criteria);
				}
				return new ItemTitleCriteria(value);
			} else if (MULTIMEDIA.equals(criteria)) {
				if (fieldOperator != FieldOperator.EQUAL) {
					throw new ParserException("Illegal FieldOperator " + fieldOperator + " for criteria " + criteria);
				}
				return new MultimediaCriteria(Boolean.parseBoolean(value));
			} else if (PAGE_TEMPLATE.equals(criteria)) {
				if (fieldOperator != FieldOperator.EQUAL) {
					throw new ParserException("Illegal FieldOperator " + fieldOperator + " for criteria " + criteria);
				}
				return new PageTemplateCriteria(Integer.parseInt(value));
			} else if (PAGE_URL.equals(criteria)) {
				if (fieldOperator != FieldOperator.EQUAL) {
					throw new ParserException("Illegal FieldOperator " + fieldOperator + " for criteria " + criteria);
				}
				return new PageURLCriteria(value);
			} else if (PUBLICATION.equals(criteria)) {
				if (fieldOperator != FieldOperator.EQUAL) {
					throw new ParserException("Illegal FieldOperator " + fieldOperator + " for criteria " + criteria);
				}
				return new PublicationCriteria(Integer.parseInt(value));
			} else if (SCHEMA_TITLE.equals(criteria)) {
				return new SchemaTitleCriteria(value, fieldOperator);

				// Publication stuff
			} else if (PUBLICATION_KEY.equals(criteria)) {
				return new PublicationKeyCriteria(value, fieldOperator);
			} else if (PUBLICATION_MULTIMEDIA_PATH.equals(criteria)) {
				return new PublicationMultimediaPathCriteria(value, fieldOperator);
			} else if (PUBLICATION_MULTIMEDIA_URL.equals(criteria)) {
				return new PublicationMultimediaURLCriteria(value, fieldOperator);
			} else if (PUBLICATION_PATH.equals(criteria)) {
				return new PublicationPathCriteria(value, fieldOperator);
			} else if (PUBLICATION_TITLE.equals(criteria)) {
				return new PublicationTitleCriteria(value, fieldOperator);
			} else if (PUBLICATION_URL.equals(criteria)) {
				return new PublicationURLCriteria(value, fieldOperator);

				// Structure Group stuff
			} else if (STRUCTURE_GROUP.equals(criteria)) {
				return new StructureGroupCriteria(value); // TODO: other param
			} else if (STRUCTURE_GROUP_DIRECTORY.equals(criteria)) {
				return new StructureGroupDirectoryCriteria(value, fieldOperator);
			} else if (STRUCTURE_GROUP_TITLE.equals(criteria)) {
				return new StructureGroupTitleCriteria(value, fieldOperator);

				// Taxonomy stuff
			} else if (TAXONOMY.equals(criteria)) {
				if (fieldOperator != FieldOperator.EQUAL) {
					throw new ParserException("Illegal FieldOperator " + fieldOperator + " for criteria " + criteria);
				}
				return new TaxonomyCriteria(value);

				// Custom meta stuff
			} else if (CUSTOM_META_KEY.equals(criteria)) {
				return new CustomMetaKeyCriteria(value, fieldOperator);
			} else if (CUSTOM_META_VALUE.equals(criteria)) {
				return new CustomMetaValueCriteria(value, fieldOperator);
			}
		} catch (NumberFormatException nfe) {
			throw new ParserException("NumberFormatException occurred: " + nfe.getMessage(), nfe);
		} catch (CriteriaException ce) {
			throw new ParserException("CriteriaException occurred: " + ce.getMessage(), ce);
		}
		throw new ParserException("Unknown criteria " + criteria);
	}

	private void buildCriteria() {
		if (filter == null) {
			criteria = buildFromODataElement();
		} else {
			criteria = buildFromFilter();
		}
	}

	private Criteria buildFromODataElement() {
		List<Criteria> criterias = new ArrayList<Criteria>();

		for (String key : oDataInputElement.getIdentifierKeys()) {
			String value = oDataInputElement.getIdentifier(key);
			Criteria criteria = parseCriteria(key, value, FieldOperator.EQUAL);
			criterias.add(criteria);
		}

		if (requestParametersMap.containsKey($FILTER)) {
			filter = requestParametersMap.get($FILTER);
			criterias.add(buildFromFilter());
		}

		Criteria result = new AndCriteria(criterias.toArray(new Criteria[0]));
		return result;
	}

	private Criteria buildFromFilter() {
		Parser criteriaParser = new Parser();
		Expression expression = criteriaParser.parse(filter);
		return expression.getCritera();
	}
}
