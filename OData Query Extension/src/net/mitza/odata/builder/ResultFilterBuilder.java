package net.mitza.odata.builder;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.broker.querying.filter.LimitFilter;
import com.tridion.broker.querying.filter.PagingFilter;
import com.tridion.broker.querying.filter.ResultFilter;

/**
 * @author Mihai Cadariu
 */
public class ResultFilterBuilder {

	public static final String $TOP = "$top";
	public static final String $SKIP = "$skip";

	private final Logger log = LoggerFactory.getLogger(ResultFilterBuilder.class);

	private final int top;
	private final int skip;
	private ResultFilter resultFilter;

	public ResultFilterBuilder(Map<String, String> requestParametersMap) {
		top = readMapKey(requestParametersMap, $TOP);
		skip = readMapKey(requestParametersMap, $SKIP);

		if (isSkipSet()) {
			log.debug("Create PagingFilter(" + skip + ", " + top + ")");
			resultFilter = new PagingFilter(skip, top);
		} else {
			if (isTopSet()) {
				log.debug("Create LimitFilter(" + top + ")");
				resultFilter = new LimitFilter(top);
			}
		}
	}

	public boolean isTopSet() {
		return top != -1;
	}

	public int getTop() {
		return top;
	}

	public boolean isSkipSet() {
		return skip != -1;
	}

	public int getSkip() {
		return skip;
	}

	public ResultFilter getResultFilter() {
		return resultFilter;
	}

	private int readMapKey(Map<String, String> requestParametersMap, String key) {
		if (requestParametersMap.containsKey(key)) {
			int result = Integer.parseInt(requestParametersMap.get(key));
			if (result <= 0) {
				return -1;
			}
			return result;
		}
		return -1;
	}
}
