package net.mitza.odata.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.mitza.odata.parser.Expression;
import net.mitza.odata.parser.Parser;
import net.mitza.odata.parser.ParserException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.tridion.broker.querying.criteria.taxonomy.TaxonomyUsedForIdentificationCriteria;
import com.tridion.webservices.odata.input.ODataInputElement;

/**
 * @author Mihai Cadariu
 */
public class CriteriaBuilder {

	public static final String BYNARY_TYPE = "BinaryType";
	public static final String ITEM_CREATION_DATE = "ItemCreationDate";
	public static final String ITEM_INITIAL_PUBLISH_DATE = "ItemInitialPublishDate";
	public static final String ITEM_LAST_PUBLISHED_DATE = "ItemLastPublishedDate";
	public static final String ITEM_MODIFICATION_DATE = "ItemModificationDate";
	public static final String ITEM_REFERENCE = "ItemReference";
	public static final String ITEM_SCHEMA = "ItemSchema";
	public static final String ITEM_TITLE = "ItemTitle";
	public static final String MULTIMEDIA = "Multimedia";
	public static final String PAGE_TEMPLATE = "PageTemplate";
	public static final String PAGE_URL = "PageURL";
	public static final String PUBLICATION = "Publication";
	public static final String SCHEMA_TITLE = "SchemaTitle";

	public static final String PUBLICATION_KEY = "PublicationKey";
	public static final String PUBLICATION_MULTIMEDIA_PATH = "PublicationMultimediaPath";
	public static final String PUBLICATION_MULTIMEDIA_URL = "PublicationMultimediaURL";
	public static final String PUBLICATION_PATH = "PublicationPath";
	public static final String PUBLICATION_TITLE = "PublicationTitle";
	public static final String PUBLICATION_URL = "PublicationURL";

	public static final String STRUCTURE_GROUP = "StructureGroup";
	public static final String STRUCTURE_GROUP_DIRECTORY = "StructureGroupDirectory";
	public static final String STRUCTURE_GROUP_TITLE = "StructureGroupTitle";

	public static final String TAXONOMY = "Taxonomy";
	public static final String TAXONOMY_USED_FOR_IDENTIFICATION = "TaxonomyUsedForIdentification";

	public static final String CUSTOM_META_KEY = "CustomMetaKey";
	public static final String CUSTOM_META_VALUE = "CustomMetaValue";

	public static final String $FILTER = "$filter";

	private static final Logger log = LoggerFactory.getLogger(CriteriaBuilder.class);

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

	public Criteria getCriteria(Criteria initialCriteria) {
		if (criteria == null) {
			return initialCriteria;
		} else {
			log.debug("Add initial " + initialCriteria);
			criteria.addCriteria(initialCriteria);
			return getCriteria();
		}
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
				return new StructureGroupCriteria(value);
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
			} else if (TAXONOMY_USED_FOR_IDENTIFICATION.equals(criteria)) {
				if (fieldOperator != FieldOperator.EQUAL) {
					throw new ParserException("Illegal FieldOperator " + fieldOperator + " for criteria " + criteria);
				}
				return new TaxonomyUsedForIdentificationCriteria(Boolean.parseBoolean(value));

				// Custom meta stuff
			} else if (CUSTOM_META_KEY.equals(criteria)) {
				return new CustomMetaKeyCriteria(value, fieldOperator);
			} else if (CUSTOM_META_VALUE.equals(criteria)) {
				return new CustomMetaValueCriteria(value, fieldOperator);
			}
		} catch (NumberFormatException nfe) {
			String messsage = "NumberFormatException occurred: " + nfe.getMessage();
			log.error(messsage, nfe);
			throw new ParserException(messsage, nfe);
		} catch (CriteriaException ce) {
			String messsage = "CriteriaException occurred: " + ce.getMessage();
			log.error(messsage, ce);
			throw new ParserException(messsage, ce);
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
			log.debug("Add Criteria from identifiers " + criteria);
			criterias.add(criteria);
		}

		if (requestParametersMap.containsKey($FILTER)) {
			filter = requestParametersMap.get($FILTER);
			Criteria criteria = buildFromFilter();
			log.debug("Add Criteria from $filter " + criteria);
			criterias.add(criteria);
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
