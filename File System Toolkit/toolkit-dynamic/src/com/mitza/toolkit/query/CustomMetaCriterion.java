package com.mitza.toolkit.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class that identifies items based on their custom meta names and values.
 *
 * @author Mihai Cadariu
 * @since 30.11.2015
 */
public class CustomMetaCriterion extends Criterion {

    private final IndexAbstract dateIndex;
    private final IndexAbstract numericIndex;
    private final IndexAbstract stringIndex;
    private final Logger log = LoggerFactory.getLogger(CustomMetaCriterion.class);

    private String key;
    private Date valueDate;
    private Date maxValueDate;
    private Float valueNumeric;
    private String valueString;
    private boolean includeRangeBoundaries;

    CustomMetaCriterion(String key) {
        this.key = key;

        IndexFactory factory = IndexFactory.INSTANCE;
        dateIndex = factory.getCustomMetaDateIndex();
        numericIndex = factory.getCustomMetaNumericIndex();
        stringIndex = factory.getCustomMetaStringIndex();
    }

    /**
     * Create new instance on given key and String value
     *
     * @param key   String the custom meta name
     * @param value String the custom meta value
     */
    public CustomMetaCriterion(String key, String value) {
        this(key);
        valueString = value;
        log.debug("Create string {}", this);
    }

    /**
     * Create new instance on given key and Date value
     *
     * @param key   String the custom meta name
     * @param value Date the custom meta value
     */
    public CustomMetaCriterion(String key, Date value) {
        this(key);
        valueDate = value;
        log.debug("Create date {}", this);
    }

    /**
     * Create new instance on given key and Date range
     *
     * @param key                    String the custom meta name
     * @param minValue               Date the custom meta range min value
     * @param maxValue               Date the custom meta range max value
     * @param includeRangeBoundaries boolean whether to include the range boundaries while querying
     */
    public CustomMetaCriterion(String key, Date minValue, Date maxValue, boolean includeRangeBoundaries) {
        this(key);
        valueDate = minValue;
        maxValueDate = maxValue;
        this.includeRangeBoundaries = includeRangeBoundaries;

        log.debug("Create date {}", this);
    }

    /**
     * Create new instance on given key and float value
     *
     * @param key   String the custom meta name
     * @param value floar the custom meta value
     */
    public CustomMetaCriterion(String key, Float value) {
        this(key);
        valueNumeric = value;
        log.debug("Create numeric {}", this);
    }

    /**
     * Triggers the execution of this custom meta criteria
     *
     * @param filter Filter only return items that match the properties in the given Filter
     * @return Set a set of unique TcmUri items that matched the current custom meta criteria and Filter
     */
    @Override
    public Set<String> executeQuery(Filter filter) {
        long duration = System.currentTimeMillis();
        log.debug("Execute criterion {}", this);

        Set<String> result;
        if (valueDate != null) {
            if (maxValueDate == null) {
                String indexKey = dateIndex.buildKey(key, valueDate.getTime());
                result = new TreeSet<>(dateIndex.get(indexKey, filter));
            } else {
                String startKey = dateIndex.buildKey(key, valueDate.getTime());
                String endKey = dateIndex.buildKey(key, maxValueDate.getTime());
                Filter newFilter = new FilterImpl(filter.getPublicationIds(), filter.getItemType(), includeRangeBoundaries);
                result = new TreeSet<>(dateIndex.get(startKey, endKey, newFilter));
            }
        } else if (valueNumeric != null) {
            String indexKey = numericIndex.buildKey(key, valueNumeric);
            result = new TreeSet<>(numericIndex.get(indexKey, filter));
        } else if (valueString != null) {
            String indexKey = stringIndex.buildKey(key, valueString);
            result = new TreeSet<>(stringIndex.get(indexKey, filter));
        } else {
            result = Collections.emptySet();
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("Execute query return {} in {} millis", result, duration);
        return result;
    }

    /**
     * Return a human readable String representation of this custom meta criteria
     *
     * @return String representation of this custom meta criteria
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("CustomMetaCriterion[key=").append(key).append(" value=");

        if (valueDate != null) {
            builder.append(valueDate);
        } else if (valueNumeric != null) {
            builder.append(valueNumeric);
        } else if (valueString != null) {
            builder.append(valueString);
        } else {
            builder.append("_UNKNOWN_");
        }

        return builder.append("]").toString();
    }
}
