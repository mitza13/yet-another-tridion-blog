package com.mitza.toolkit.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Class that identifies items based on their Publication id.
 *
 * @author Mihai Cadariu
 * @since 30.11.2015
 */
public class PublicationCriterion extends Criterion {

    private final int publicationId;

    private final Logger log = LoggerFactory.getLogger(PublicationCriterion.class);

    /**
     * Create new instance using the given Publication id
     *
     * @param publicationId int the Publication id to restrict query results to
     */
    public PublicationCriterion(int publicationId) {
        log.debug("Create new instance publicationId={}", publicationId);
        this.publicationId = publicationId;
    }

    /**
     * Method to be used internally only. DO NOT call explicitely!
     */
    @Override
    public Set<String> executeQuery(Filter filter) {
        String message = "Do not directly call PublicationCriterion.executeQuery()";
        log.error(message);
        throw new QueryException(message);
    }

    /**
     * Return the current Publication id
     *
     * @return int the current Publication id
     */
    public int getPublicationId() {
        return publicationId;
    }

    /**
     * Return a human readable String representation of this criteria
     *
     * @return String representation of this criteria
     */
    @Override
    public String toString() {
        return String.format("PublicationCriterion[%d]", publicationId);
    }
}
