package net.mitza.odata.builder;

import java.util.Map;

import com.tridion.broker.querying.Query;
import com.tridion.broker.querying.criteria.Criteria;
import com.tridion.broker.querying.filter.ResultFilter;
import com.tridion.broker.querying.sorting.SortParameter;
import com.tridion.webservices.odata.input.ODataInputElement;

/**
 * @author Mihai Cadariu
 */
public class QueryBuilder {

	private Criteria criteria;
	private ResultFilter resultFilter;
	private SortParameter[] sortParameters;
	private Query query;

	public QueryBuilder(ODataInputElement oDataInputElement, Map<String, String> requestParametersMap,
			Criteria intialCriteria) {
		CriteriaBuilder criteriaBuilder = new CriteriaBuilder(oDataInputElement, requestParametersMap);
		criteria = criteriaBuilder.getCriteria(intialCriteria);
		query = new Query(criteria);

		buildResultAndSort(requestParametersMap);
	}

	public QueryBuilder(Map<String, String> requestParametersMap) {
		if (requestParametersMap.containsKey(CriteriaBuilder.$FILTER)) {
			String filter = requestParametersMap.get(CriteriaBuilder.$FILTER);
			CriteriaBuilder criteriaBuilder = new CriteriaBuilder(filter);
			criteria = criteriaBuilder.getCriteria();
			query = new Query(criteria);
		} else {
			query = new Query();
		}

		buildResultAndSort(requestParametersMap);
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public Query getQuery() {
		return query;
	}

	public ResultFilter getResultFilter() {
		return resultFilter;
	}

	public SortParameter[] getSortParameters() {
		return sortParameters;
	}

	private void buildResultAndSort(Map<String, String> requestParametersMap) {
		ResultFilterBuilder resultFilterBuilder = new ResultFilterBuilder(requestParametersMap);
		resultFilter = resultFilterBuilder.getResultFilter();
		if (resultFilter != null) {
			query.setResultFilter(resultFilter);
		}

		SortParameterBuilder sortParameterBuilder = new SortParameterBuilder(requestParametersMap);
		sortParameters = sortParameterBuilder.getSortParameters();
		for (SortParameter sortParameter : getSortParameters()) {
			query.addSorting(sortParameter);
		}
	}
}
