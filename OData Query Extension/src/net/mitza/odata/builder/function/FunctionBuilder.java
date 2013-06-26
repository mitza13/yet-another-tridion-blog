package net.mitza.odata.builder.function;

import net.mitza.odata.parser.FunctionExpression;
import net.mitza.odata.parser.ParametersExpression;
import net.mitza.odata.parser.ParserException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.broker.querying.criteria.Criteria;
import com.tridion.broker.querying.criteria.CriteriaException;

/**
 * @author Mihai Cadariu
 */
public abstract class FunctionBuilder {

	public static final String CUSTOM_META_DATE_RANGE = "CustomMetaDateRange";
	public static final String CUSTOM_META_KEY = "CustomMetaKey";
	public static final String CUSTOM_META_NUMERICAL_RANGE = "NumericalRange";
	public static final String CUSTOM_META_STRING_RANGE = "CustomMetaStringRange";
	public static final String CUSTOM_META_VALUE = "CustomMetaValue";

	public static final String STRUCTURE_GROUP = "StructureGroup";
	public static final String STRUCTURE_GROUP_DIRECTORY = "StructureGroupDirectory";
	public static final String STRUCTURE_GROUP_TITLE = "StructureGroupTitle";

	public static final String TAXONOMY_KEYWORD = "TaxonomyKeyword";
	public static final String TAXONOMY_KEYWORD_DESCRIPTION = "TaxonomyKeywordDescription";
	public static final String TAXONOMY_KEYWORD_KEY = "TaxonomyKeywordKey";
	public static final String TAXONOMY_KEYWORD_NAME = "TaxonomyKeywordName";

	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

	private static final Logger log = LoggerFactory.getLogger(FunctionBuilder.class);

	protected Criteria criteria;

	public abstract void build(ParametersExpression parametersExpression) throws CriteriaException;

	public Criteria getCriteria() {
		return criteria;
	}

	public static Criteria parseCriteria(FunctionExpression functionExpression) {
		String function = functionExpression.getFunctionName();
		ParametersExpression parametersExpression = functionExpression.getParameters();
		FunctionBuilder builder = null;

		try {
			// Custom Meta functions
			if (CUSTOM_META_KEY.equals(function)) {
				builder = new CustomMetaKeyBuilder(parametersExpression);
			} else if (CUSTOM_META_VALUE.equals(function)) {
				builder = new CustomMetaValueBuilder(parametersExpression);
			} else if (CUSTOM_META_DATE_RANGE.equals(function)) {
				builder = new CustomMetaDateRangeBuilder(parametersExpression);
			} else if (CUSTOM_META_STRING_RANGE.equals(function)) {
				builder = new CustomMetaStringRangeBuilder(parametersExpression);
			} else if (CUSTOM_META_NUMERICAL_RANGE.equals(function)) {
				builder = new CustomMetaNumericalRangeBuilder(parametersExpression);

				// Structure Group functions
			} else if (STRUCTURE_GROUP.equals(function)) {
				builder = new StructureGroupBuilder(parametersExpression);
			} else if (STRUCTURE_GROUP_DIRECTORY.equals(function)) {
				builder = new StructureGroupDirectoryBuilder(parametersExpression);
			} else if (STRUCTURE_GROUP_TITLE.equals(function)) {
				builder = new StructureGroupTitleBuilder(parametersExpression);

				// Taxonomy functions
			} else if (TAXONOMY_KEYWORD.equals(function)) {
				builder = new TaxonomyKeywordBuilder(parametersExpression);
			} else if (TAXONOMY_KEYWORD_DESCRIPTION.equals(function)) {
				builder = new TaxonomyKeywordDescriptionBuilder(parametersExpression);
			} else if (TAXONOMY_KEYWORD_KEY.equals(function)) {
				builder = new TaxonomyKeywordKeyBuilder(parametersExpression);
			} else if (TAXONOMY_KEYWORD_NAME.equals(function)) {
				builder = new TaxonomyKeywordNameBuilder(parametersExpression);
			}
		} catch (IndexOutOfBoundsException ioobe) {
			String messsage = "Wrong number of parameters for function " + function +
					". IndexOutOfBoundsException occurred: " + ioobe.getMessage();
			log.error(messsage, ioobe);
			throw new ParserException(messsage, ioobe);
		} catch (CriteriaException ce) {
			String messsage = "Exception occurred while creating Criteria for function " + function + ". " +
					ce.getMessage();
			log.error(messsage, ce);
			throw new ParserException(messsage, ce);
		}

		if (builder == null) {
			throw new ParserException("Unknown function " + function);
		} else {
			return builder.getCriteria();
		}
	}
}
