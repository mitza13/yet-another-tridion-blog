package com.mitza.toolkit.query;

/**
 * Class representing an association between a property (or custom meta name) and a direction.
 * Multiple SortTerms define the order of the items returned in a Query.
 *
 * @author Mihai Cadariu
 * @since 04.12.2015
 */
public class SortTerm {

    private final SortColumn column;
    private final String customMeta;
    private final SortDirection direction;

    /**
     * Create new instance for the given sort property and direction
     *
     * @param column    SortColumn enumeration indicating the property to sort on
     * @param direction SortDirection enumeration indicating the sort direction
     */
    public SortTerm(SortColumn column, SortDirection direction) {
        this.column = column;
        this.direction = direction;
        customMeta = null;
    }

    /**
     * Create new instance for the given custom meta name and direction
     *
     * @param customMeta String the name of the cutom meta to sort on
     * @param direction  SortDirection enumeration indicating the sort direction
     */
    public SortTerm(String customMeta, SortDirection direction) {
        this.column = SortColumn.CUSTOM_META;
        this.customMeta = customMeta;
        this.direction = direction;
    }

    /**
     * Return enumeration indicating the property to sort on
     *
     * @return SortColumn enumeration indicating the property to sort on
     */
    public SortColumn getColumn() {
        return column;
    }

    /**
     * Return the custom meta name to sort on
     *
     * @return String the name of the cutom meta to sort on
     */
    public String getCustomMeta() {
        return customMeta;
    }

    /**
     * Return enumeration indicating the sort direction
     *
     * @return SortDirection enumeration indicating the sort direction
     */
    public SortDirection getDirection() {
        return direction;
    }

    /**
     * Return a human readable String representation of this SortTerm
     *
     * @return String representation of this SortTerm
     */
    @Override
    public String toString() {
        return String.format("SortTerm[%s, %s]",
                customMeta == null ? column : customMeta,
                direction);
    }
}
