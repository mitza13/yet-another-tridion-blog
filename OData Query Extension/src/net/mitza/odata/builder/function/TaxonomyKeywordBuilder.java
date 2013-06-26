package net.mitza.odata.builder.function;

import java.util.List;

import net.mitza.odata.parser.FieldOperatorNode;
import net.mitza.odata.parser.ParametersExpression;

import com.tridion.broker.querying.criteria.taxonomy.TaxonomyKeywordCriteria;

/**
 * @author Mihai Cadariu
 */
public class TaxonomyKeywordBuilder extends FunctionBuilder {

	public TaxonomyKeywordBuilder(ParametersExpression parametersExpression) {
		build(parametersExpression);
	}

	@Override
	public void build(ParametersExpression parametersExpression) {
		List<FieldOperatorNode> fieldOperatorNodes = parametersExpression.getFieldOperatorNodes();

		if (fieldOperatorNodes.size() == 3) {
			String taxonomyUri = fieldOperatorNodes.get(0).getValue();
			String keywordUri = fieldOperatorNodes.get(1).getValue();
			boolean includeKeywordBranches = Boolean.parseBoolean(fieldOperatorNodes.get(2).getValue());
			criteria = new TaxonomyKeywordCriteria(taxonomyUri, keywordUri, includeKeywordBranches);
		} else {
			int publicationId = Integer.parseInt(fieldOperatorNodes.get(0).getValue());
			int taxonomyId = Integer.parseInt(fieldOperatorNodes.get(1).getValue());
			int keywordId = Integer.parseInt(fieldOperatorNodes.get(2).getValue());
			boolean includeKeywordBranches = Boolean.parseBoolean(fieldOperatorNodes.get(3).getValue());
			criteria = new TaxonomyKeywordCriteria(publicationId, taxonomyId, keywordId, includeKeywordBranches);
		}
	}
}