package com.mitza.toolkit.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class defining a logical AND between several Criterion objects.
 *
 * @author Mihai Cadariu
 * @since 30.11.2015
 */
public class AndCriteria extends Criterion {

    private final Logger log = LoggerFactory.getLogger(AndCriteria.class);
    private Collection<Criterion> criteria;
    private Set<Integer> publicationIds;

    /**
     * Create a new AndCriteria for the two given Criterion objects
     *
     * @param first  Criterion the first criterion
     * @param second Criterion the secod criterion
     */
    public AndCriteria(Criterion first, Criterion second) {
        criteria = new ArrayList<>(2);
        criteria.add(first);
        criteria.add(second);

        publicationIds = new TreeSet<>();
        identifyPublicationIds();

        log.debug("Create new {}", this);
    }

    /**
     * Create a new AndCriteria between all the given Crtierion objects
     *
     * @param criteria Collection the Criterion objects to make an AND from
     */
    public AndCriteria(Collection<Criterion> criteria) {
        this.criteria = new ArrayList<>(criteria);

        publicationIds = new TreeSet<>();
        identifyPublicationIds();

        log.debug("Create new {}", this);
    }

    /**
     * Add a new Criterion to the current AndCriteria
     *
     * @param criterion the criterion to add
     */
    public void add(Criterion criterion) {
        log.debug("Add {}", criterion);
        criteria.add(criterion);

        identifyPublicationIds();
    }

    /**
     * Triggers the execution of this AndCriteria
     *
     * @param filter Filter only return items that match the properties in the given Filter
     * @return Set a set of unique TcmUri items that matched the current AndCriteria and Filter
     */
    @Override
    public Set<String> executeQuery(Filter filter) {
        long duration = System.currentTimeMillis();
        log.debug("Execute criterion {}", this);

        Set<Integer> queryPublicationIds = new TreeSet<>(publicationIds);
        queryPublicationIds.addAll(filter.getPublicationIds());
        FilterImpl queryFilter = new FilterImpl(queryPublicationIds, filter.getItemType());

        Set<String> result = null;
        boolean first = true;

        for (Criterion criterion : criteria) {
            Set<String> criterionResult = criterion.executeQuery(queryFilter);

            if (first) {
                first = false;
                result = new TreeSet<>(criterionResult);
            } else {
                result.retainAll(criterionResult);
            }
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("Execute query return {} in {} millis", result, duration);
        return result;
    }

    /**
     * Return a human readable String representation of this AndCriteria
     *
     * @return String representation of this AndCriteria
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("AndCriteria[");

        boolean first = true;
        if (publicationIds.size() > 0) {
            builder.append("PublicationCriterion").append(publicationIds);
            first = false;
        }

        for (Criterion criterion : criteria) {
            if (first) {
                first = false;
            } else {
                builder.append(" & ");
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
            } else if (criterion instanceof OrCriteria) {
                Set<Integer> orPublicationIds = ((OrCriteria) criterion).getPublicationIds();
                if (!orPublicationIds.isEmpty()) {
                    publicationIds.addAll(orPublicationIds);
                    iterator.remove();
                }
            }
        }
    }
}
