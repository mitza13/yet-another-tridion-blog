package com.mitza.toolkit.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class defining a logical OR between several Criterion objects.
 *
 * @author Mihai Cadariu
 * @since 30.11.2015
 */
public class OrCriteria extends Criterion {

    private final Logger log = LoggerFactory.getLogger(OrCriteria.class);
    private Collection<Criterion> criteria;
    private Set<Integer> publicationIds;

    /**
     * Create a new OrCriteria for the two given Criterion objects
     *
     * @param first  Criterion the first criterion
     * @param second Criterion the secod criterion
     */
    public OrCriteria(Criterion first, Criterion second) {
        criteria = new ArrayList<>(2);
        criteria.add(first);
        criteria.add(second);

        publicationIds = new TreeSet<>();
        identifyPublicationIds();

        log.debug("Create new {}", this);
    }

    /**
     * Create a new OrCriteria between all the given Crtierion objects
     *
     * @param criteria Collection the Criterion objects to make an OR from
     */
    public OrCriteria(Collection<Criterion> criteria) {
        this.criteria = new ArrayList<>(criteria);

        publicationIds = new TreeSet<>();
        identifyPublicationIds();

        log.debug("Create new {}", this);
    }

    /**
     * Add a new Criterion to the current OrCriteria
     *
     * @param criterion the criterion to add
     */
    public void add(Criterion criterion) {
        log.debug("Add {}", criterion);

        criteria.add(criterion);
        identifyPublicationIds();
    }

    /**
     * Triggers the execution of this OrCriteria
     *
     * @param filter Filter only return items that match the properties in the given Filter
     * @return Set a set of unique TcmUri items that matched the current OrCriteria and Filter
     */
    @Override
    public Set<String> executeQuery(Filter filter) {
        long duration = System.currentTimeMillis();
        log.debug("Execute criterion {}", this);

        Set<String> result = null;
        boolean first = true;

        for (Criterion criterion : criteria) {
            Set<String> criterionResult = criterion.executeQuery(filter);
            if (first) {
                first = false;
                result = new TreeSet<>(criterionResult);
            } else {
                result.addAll(criterionResult);
            }
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("Execute query return {} in {} millis", result, duration);
        return result;
    }

    /**
     * Return the indentified Publication ids for this OrCriteria
     *
     * @return Set of allowed Publication ids
     */
    public Set<Integer> getPublicationIds() {
        return publicationIds;
    }

    /**
     * Return a human readable String representation of this AndCriteria
     *
     * @return String representation of this AndCriteria
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("OrCriteria[");

        boolean first = true;
        if (publicationIds.size() > 0) {
            builder.append("PublicationCriterion").append(publicationIds);
            first = false;
        }

        for (Criterion criterion : criteria) {
            if (first) {
                first = false;
            } else {
                builder.append(" | ");
            }
            builder.append(criterion.toString());
        }

        return builder.append("]").toString();
    }

    private void identifyPublicationIds() {
        for (Iterator<Criterion> iterator = criteria.iterator(); iterator.hasNext(); ) {
            Criterion criterion = iterator.next();
            if (criterion instanceof PublicationCriterion) {
                int publicationId = ((PublicationCriterion) criterion).getPublicationId();
                publicationIds.add(publicationId);
                iterator.remove();
            }
        }
    }
}
