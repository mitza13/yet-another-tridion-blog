package com.mitza.toolkit.domain;

import java.util.Map;

/**
 * Object representation of Tridion custom metadata
 *
 * @author Mihai Cadariu
 * @since 01.11.2015
 */
public interface CustomMeta {

    /**
     * Return all custom meta items in a map
     *
     * @return Map containing custom meta name as keys and CustomMetaItem as values
     */
    Map<String, CustomMetaItem> getAll();

    /**
     * Return the CustomMetaItem for the given custom meta name, or null if not found
     *
     * @param name String representing the custom meta name to lookup
     * @return CustomMetaItem the custom meta item; or null, if given custom meta name is not in map
     */
    CustomMetaItem getByName(String name);
}
