package com.mitza.toolkit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Object representation of Tridion custom metadata
 *
 * @author Mihai Cadariu
 * @since 04.11.2015
 */
public class CustomMetaImpl implements CustomMeta {

    @JsonDeserialize(contentAs = CustomMetaItemImpl.class)
    @JsonProperty("meta")
    private final Map<String, CustomMetaItem> items = new HashMap<>();

    /**
     * Checks whether this custom meta contains any entries
     *
     * @return boolean true if this custo meta contains no CustomMetaItem
     */
    @JsonIgnore
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Add new CustomMetaItem of type Date and given name
     *
     * @param name      String the custom meta name to use
     * @param dateValue Date the value to add
     */
    public void add(String name, Date dateValue) {
        CustomMetaItemImpl customMetaItem = (CustomMetaItemImpl) items.get(name);
        if (customMetaItem == null) {
            customMetaItem = new CustomMetaItemImpl(name, dateValue);
            items.put(name, customMetaItem);
        } else {
            customMetaItem.addDateValue(dateValue);
        }
    }

    /**
     * Add new CustomMetaItem of type float and given name
     *
     * @param name         String the custom meta name to use
     * @param numericValue float the value to add
     */
    public void add(String name, float numericValue) {
        CustomMetaItemImpl customMetaItem = (CustomMetaItemImpl) items.get(name);
        if (customMetaItem == null) {
            customMetaItem = new CustomMetaItemImpl(name, numericValue);
            items.put(name, customMetaItem);
        } else {
            customMetaItem.addNumericValue(numericValue);
        }
    }

    /**
     * Add new CustomMetaItem of type String and given name
     *
     * @param name        String the custom meta name to use
     * @param stringValue String the value to add
     */
    public void add(String name, String stringValue) {
        CustomMetaItemImpl customMetaItem = (CustomMetaItemImpl) items.get(name);
        if (customMetaItem == null) {
            customMetaItem = new CustomMetaItemImpl(name, stringValue);
            items.put(name, customMetaItem);
        } else {
            customMetaItem.addStringValue(stringValue);
        }
    }

    /**
     * Return all custom meta items in a map
     *
     * @return Map containing custom meta name as keys and CustomMetaItem as values
     */
    @Override
    @JsonIgnore
    public Map<String, CustomMetaItem> getAll() {
        return items;
    }

    /**
     * Return the CustomMetaItem for the given custom meta name, or null if not found
     *
     * @param name String representing the custom meta name to lookup
     * @return CustomMetaItem the custom meta item; or null, if given custom meta name is not in map
     */
    @Override
    public CustomMetaItem getByName(String name) {
        return items.get(name);
    }
}
