package net.mitza.odata.builder.function;

import java.util.List;

import net.mitza.odata.parser.FieldOperatorNode;
import net.mitza.odata.parser.ParametersExpression;

import com.tridion.broker.querying.criteria.FieldOperator;
import com.tridion.broker.querying.criteria.taxonomy.TaxonomyKeywordNameCriteria;

/**
 * @author Mihai Cadariu
 */
public class TaxonomyKeywordNameBuilder extends FunctionBuilder {

	public TaxonomyKeywordNameBuilder(ParametersExpression parametersExpression) {
		build(parametersExpression);
	}

	@Override
	public void build(ParametersExpression parametersExpression) {
		List<FieldOperatorNode> fieldOperatorNodes = parametersExpression.getFieldOperatorNodes();

		int publicationId = Integer.parseInt(fieldOperatorNodes.get(0).getValue());
		int taxonomyId = Integer.parseInt(fieldOperatorNodes.get(1).getValue());
		String keywordName = fieldOperatorNodes.get(2).getValue();
		FieldOperator operator = fieldOperatorNodes.get(2).getFieldOperator();
		boolean includeKeywordBranches = Boolean.parseBoolean(fieldOperatorNodes.get(3).getValue());

		if (operator == FieldOperator.EQUAL) {
			criteria = new TaxonomyKeywordNameCriteria(publicationId, taxonomyId, keywordName, includeKeywordBranches);
		} else {
			criteria = new TaxonomyKeywordNameCriteria(publicationId, taxonomyId, keywordName, includeKeywordBranches,
					operator);
		}
	}
}