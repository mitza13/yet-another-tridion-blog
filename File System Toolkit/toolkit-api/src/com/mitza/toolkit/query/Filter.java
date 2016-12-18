package com.mitza.toolkit.query;

import com.mitza.toolkit.domain.ItemTypes;

import java.util.Set;

/**
 * Query filter class used to identify which items shuold be returned by a content query.
 *
 * @author Mihai Cadariu
 * @since 03.12.2015
 */
public interface Filter {

    /**
     * Set of Publication id integers that are allowed by this filter
     *
     * @return Set of integers representing the Publication ids allowed by this filter
     */
    Set<Integer> getPublicationIds();

    /**
     * Return the ItemTypes allowed by this filter
     *
     * @return ItemTypes type allowed by this filter
     */
    ItemTypes getItemType();

    /**
     * Return whether this filter includes the range boundaries or not
     *
     * @return boolean representing whether this filter includes the range boundaries or not
     */
    boolean isIncludeRangeBoundaries();
}
