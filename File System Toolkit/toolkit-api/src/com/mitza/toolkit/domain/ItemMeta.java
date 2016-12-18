package com.mitza.toolkit.domain;

import java.util.Date;

/**
 * Object representation of a Tridion item metadata
 *
 * @author Mihai Cadariu
 * @since 20.10.2015
 */
public interface ItemMeta extends IdentifiableObject {

    /**
     * Return the CustomMeta object of this item, if exists
     *
     * @return CustomMeta object of this item; or null, otherwise
     */
    CustomMeta getCustomMeta();

    /**
     * Return the last modification date for this item
     *
     * @return Date the last modification date for this item
     */
    Date getLastModified();

    /**
     * Return the last publish date for this item
     *
     * @return Date the last publish date for this item
     */
    Date getLastPublished();
}
