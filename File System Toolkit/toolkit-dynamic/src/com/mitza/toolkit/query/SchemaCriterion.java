package com.mitza.toolkit.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.TreeSet;

/**
 * Class that identifies Components based on their associated Schema id.
 *
 * @author Mihai Cadariu
 * @since 01.12.2015
 */
public class SchemaCriterion extends Criterion {

    private final IndexAbstract index;
    private final int schema;

    private final Logger log = LoggerFactory.getLogger(SchemaCriterion.class);

    /**
     * Create new instance for the given Schema id
     *
     * @param schema int the Schema id to use while querying for Components
     */
    public SchemaCriterion(int schema) {
        index = IndexFactory.INSTANCE.getSchemaIndex();
        this.schema = schema;
        log.debug("Create {}", this);
    }

    /**
     * Triggers the execution of this criteria
     *
     * @param filter Filter only return items that match the properties in the given Filter
     * @return Set a set of unique TcmUri items that matched the current criteria and Filter
     */
    @Override
    public Set<String> executeQuery(Filter filter) {
        long duration = System.currentTimeMillis();
        log.debug("Execute criterion {}", this);

        Set<String> result = new TreeSet<>(index.get(Integer.toString(schema)));

        duration = System.currentTimeMillis() - duration;
        log.debug("Execute query return {} in {} millis", result, duration);
        return result;
    }

    /**
     * Return a human readable String representation of this criteria
     *
     * @return String representation of this criteria
     */
    @Override
    public String toString() {
        return "SchemaCriterion[schema=" + schema + "]";
    }
}
