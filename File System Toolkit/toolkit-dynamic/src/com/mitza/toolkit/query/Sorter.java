package com.mitza.toolkit.query;

import com.mitza.toolkit.domain.CustomMeta;
import com.mitza.toolkit.domain.CustomMetaItem;
import com.mitza.toolkit.domain.CustomMetaType;
import com.mitza.toolkit.domain.ItemMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Custom comparator used to provide a sort order between two ItemMeta objects.
 *
 * @author Mihai Cadariu
 * @since 04.12.2015
 */
public class Sorter implements Comparator<ItemMeta> {

    private static final Date MIN_DATE = new Date(Long.MIN_VALUE);
    private final Logger log = LoggerFactory.getLogger(Sorter.class);
    private List<SortTerm> sortTerms;

    /**
     * Create new instance using the given sort property and direction
     *
     * @param column    SortColumn enumeration indicating the property to sort on
     * @param direction SortDirection enumeration indicating the sort direction
     */
    public Sorter(SortColumn column, SortDirection direction) {
        sortTerms = new ArrayList<>(1);
        addSort(column, direction);
        log.debug("Create new instance {}", this);
    }

    /**
     * Create new instance using the given custom meta name and direction
     *
     * @param customMeta String the name of the cutom meta to sort on
     * @param direction  SortDirection enumeration indicating the sort direction
     */
    public Sorter(String customMeta, SortDirection direction) {
        sortTerms = new ArrayList<>(1);
        addSort(customMeta, direction);
        log.debug("Create new instance {}", this);
    }

    /**
     * Add sorting parameter on the given sort property and direction
     *
     * @param column    SortColumn enumeration indicating the property to sort on
     * @param direction SortDirection enumeration indicating the sort direction
     */
    public void addSort(SortColumn column, SortDirection direction) {
        SortTerm sortTerm = new SortTerm(column, direction);
        log.debug("Add {}", sortTerm);
        sortTerms.add(sortTerm);
    }

    /**
     * Add sorting parameter on the given custom meta name and direction
     *
     * @param customMeta String the name of the cutom meta to sort on
     * @param direction  SortDirection enumeration indicating the sort direction
     */
    public void addSort(String customMeta, SortDirection direction) {
        SortTerm sortTerm = new SortTerm(customMeta, direction);
        log.debug("Add {}", sortTerm);
        sortTerms.add(sortTerm);
    }

    /**
     * Performs actual comparison between two ItemMeta instances. It compares all SortTerms provided to this Sorter
     * in the same order they were provided.
     *
     * @param i1 ItemMeta to sort
     * @param i2 ItemMeta to sort
     * @return int indicating the sort order of the two ItemMeta (negative if i1 &lt; i2; zero if i1 == i2; positive if i1 &gt; i2)
     */
    @Override
    public int compare(ItemMeta i1, ItemMeta i2) {
        for (SortTerm sortTerm : sortTerms) {
            int compare = compare(i1, i2, sortTerm);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }

    /**
     * Return a human readable String representation of this Sorter
     *
     * @return String representation of this Sorter
     */
    @Override
    public String toString() {
        return String.format("Sorter%s", sortTerms);
    }

    private int compare(ItemMeta i1, ItemMeta i2, SortTerm sortTerm) {
        SortColumn column = sortTerm.getColumn();
        SortDirection direction = sortTerm.getDirection();

        switch (column) {
            case CUSTOM_META:
                String customMeta = sortTerm.getCustomMeta();
                CustomMetaItem customMetaItem1 = getCustomMetaItem(i1, customMeta);
                CustomMetaItem customMetaItem2 = getCustomMetaItem(i2, customMeta);
                return compare(customMetaItem1, customMetaItem2, direction);

            case LAST_MODIFIED:
                Date date1 = getLastModified(i1);
                Date date2 = getLastModified(i2);
                return direction == SortDirection.ASCENDING ? date1.compareTo(date2) : date2.compareTo(date1);

            case LAST_PUBLISH:
                date1 = getLastPublished(i1);
                date2 = getLastPublished(i2);
                return direction == SortDirection.ASCENDING ? date1.compareTo(date2) : date2.compareTo(date1);

            case TITLE:
                String title1 = getTitle(i1);
                String title2 = getTitle(i2);
                return direction == SortDirection.ASCENDING ? title1.compareTo(title2) : title2.compareTo(title1);

            default:
                log.error("Unknown sort column {}", column);
        }

        return 0;
    }

    private CustomMetaItem getCustomMetaItem(ItemMeta itemMeta, String key) {
        if (itemMeta == null) {
            return null;
        }

        CustomMeta customMeta = itemMeta.getCustomMeta();
        if (customMeta == null) {
            return null;
        }

        CustomMetaItem customMetaItem = customMeta.getByName(key);
        if (customMetaItem == null) {
            return null;
        }

        return customMetaItem;
    }

    private int compare(CustomMetaItem meta1, CustomMetaItem meta2, SortDirection direction) {
        if (meta1 == null && meta2 == null) {
            return 0;
        } else if (meta1 == null) {
            return direction == SortDirection.ASCENDING ? -1 : 1;
        } else if (meta2 == null) {
            return direction == SortDirection.ASCENDING ? 1 : -1;
        }

        CustomMetaType type1 = meta1.getType();
        CustomMetaType type2 = meta2.getType();
        if (type1 != type2) {
            log.warn("Cannot compare custom meta {} with {}", type1, type2);
            return 1;
        }

        switch (type1) {
            case DATE:
                Date date1 = meta1.getDateValue();
                date1 = date1 == null ? MIN_DATE : date1;
                Date date2 = meta2.getDateValue();
                date2 = date2 == null ? MIN_DATE : date2;
                return direction == SortDirection.ASCENDING ? date1.compareTo(date2) : date2.compareTo(date1);

            case NUMERIC:
                float float1 = meta1.getNumericValue();
                float float2 = meta2.getNumericValue();
                if (float1 == float2) {
                    return 0;
                } else if (float1 < float2) {
                    return direction == SortDirection.ASCENDING ? -1 : 1;
                } else {
                    return direction == SortDirection.ASCENDING ? 1 : -1;
                }

            case STRING:
                String string1 = join(meta1.getStringValues());
                String string2 = join(meta2.getStringValues());
                return direction == SortDirection.ASCENDING ? string1.compareTo(string2) : string2.compareTo(string1);
        }

        return 0;
    }

    private Date getLastModified(ItemMeta itemMeta) {
        Date date = itemMeta == null ? MIN_DATE : itemMeta.getLastModified();
        date = date == null ? MIN_DATE : date;

        return date;
    }

    private Date getLastPublished(ItemMeta itemMeta) {
        Date date = itemMeta == null ? MIN_DATE : itemMeta.getLastPublished();
        date = date == null ? MIN_DATE : date;

        return date;
    }

    private String getTitle(ItemMeta itemMeta) {
        String result = itemMeta == null ? "" : itemMeta.getTitle();
        result = result == null ? "" : result;

        return result;
    }

    private String join(Collection<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }

        Iterator<String> iter = strings.iterator();
        StringBuilder builder = new StringBuilder(iter.next());
        while (iter.hasNext()) {
            builder.append(iter.next());
        }

        return builder.toString();
    }
}
