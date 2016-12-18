package com.mitza.toolkit.query;

import com.mitza.toolkit.domain.ItemTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Query filter class used to identify which items shuold be returned by a content query.
 *
 * @author Mihai Cadariu
 * @since 03.12.2015
 */
public class FilterImpl implements Filter {

    public static final Filter EMPTY_FILTER = new FilterImpl();

    private final Set<Integer> publicationIds;
    private final ItemTypes itemType;
    private final boolean includeRangeBoundaries;
    private final Logger log = LoggerFactory.getLogger(FilterImpl.class);

    /**
     * Create new filter that doesn't filter any results
     */
    public FilterImpl() {
        this(Collections.<Integer>emptySet(), null, false);
    }

    /**
     * Create new filter that only allows the specified ItemTypes enumeration
     *
     * @param itemType ItemTypes the allowed enumeration value
     */
    public FilterImpl(ItemTypes itemType) {
        this(Collections.<Integer>emptySet(), itemType, false);
    }

    /**
     * Create new filter that specifies whether to include range boundaries or not
     *
     * @param includeRangeBoundaries boolean whether to include range boundaries or not
     */
    public FilterImpl(boolean includeRangeBoundaries) {
        this(Collections.<Integer>emptySet(), null, includeRangeBoundaries);
    }

    /**
     * Create new filter that allows certain Publication ids and given ItemTypes value
     *
     * @param publicationIds Set of Publication ids to allow
     * @param itemType       ItemTypes the allowed enumeration value
     */
    public FilterImpl(Set<Integer> publicationIds, ItemTypes itemType) {
        this(publicationIds, itemType, false);
    }

    /**
     * Create new filter that allows Publication ids, ItemTypes value and whether to include range boundaries
     *
     * @param publicationIds         Set of Publication ids to allow
     * @param itemType               ItemTypes the allowed enumeration value
     * @param includeRangeBoundaries boolean whether to include range boundaries or not
     */
    public FilterImpl(Set<Integer> publicationIds, ItemTypes itemType, boolean includeRangeBoundaries) {
        this.publicationIds = new TreeSet<>(publicationIds);
        this.itemType = itemType;
        this.includeRangeBoundaries = includeRangeBoundaries;
        log.debug("Create {}", this);
    }

    /**
     * Set of Publication id integers that are allowed by this filter
     *
     * @return Set of integers representing the Publication ids allowed by this filter
     */
    @Override
    public Set<Integer> getPublicationIds() {
        return publicationIds;
    }

    /**
     * Return the ItemTypes allowed by this filter
     *
     * @return ItemTypes type allowed by this filter
     */
    @Override
    public ItemTypes getItemType() {
        return itemType;
    }

    /**
     * Return whether this filter includes the range boundaries or not
     *
     * @return boolean representing whether this filter includes the range boundaries or not
     */
    @Override
    public boolean isIncludeRangeBoundaries() {
        return includeRangeBoundaries;
    }

    /**
     * Return a human readable String representation of this Filter
     *
     * @return String representation of this Filter
     */
    @Override
    public String toString() {
        return String.format("Filter[publication=%s itemType=%s includeRangeBoundaries=%s]",
                publicationIds, itemType, includeRangeBoundaries);
    }
}
