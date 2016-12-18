package com.mitza.toolkit.query;

import java.util.Set;

/**
 * Defines a base class for all criteria
 *
 * @author Mihai Cadariu
 * @since 30.11.2015
 */
public abstract class Criterion {

    /**
     * Triggers the execution of this criterion
     *
     * @return Set a set of all unique TcmUri items that matched the current criterion
     */
    public Set<String> executeQuery() {
        return executeQuery(FilterImpl.EMPTY_FILTER);
    }

    /**
     * Triggers the execution of this criterion
     *
     * @param filter Filter only return items that match the properties in the given Filter
     * @return Set a set of unique TcmUri items that matched the current criterion and Filter
     */
    public abstract Set<String> executeQuery(Filter filter);
}
