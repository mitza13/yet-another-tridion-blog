package com.mitza.toolkit.query;

import java.util.Set;

/**
 * Defines common functionality for an Index class. This class defines abstract method signatures that handle index operations
 * get, put and remove of values to their specific indexes.
 *
 * @author Mihai Cadariu
 * @since 26.11.2015
 */
public abstract class IndexAbstract {

    public static final int KEY_SEPARATOR = 29;
    public static final int VALUE_SEPARATOR = 31;
    public static final int ENTRY_SEPARATOR = 10;

    /**
     * Build an index key based on a String key and long value
     *
     * @param key   String the key to use
     * @param value long the value to use
     * @return String the built key
     */
    public String buildKey(String key, long value) {
        key = normalizeString(key);
        return String.format("%s%c%d", key, KEY_SEPARATOR, value);
    }

    /**
     * Build an index key based on a String key and float value
     *
     * @param key   String the key to use
     * @param value float the value to use
     * @return String the built key
     */
    public String buildKey(String key, float value) {
        key = normalizeString(key);
        return String.format("%s%c%s", key, KEY_SEPARATOR, value == (long) value ? "" + (long) value : "" + value);
    }

    /**
     * Build an index key based on a String key and String value
     *
     * @param key   String the key to use
     * @param value String the value to use
     * @return String the built key
     */
    public String buildKey(String key, String value) {
        key = normalizeString(key);
        value = normalizeString(value);
        return String.format("%s%c%s", key, KEY_SEPARATOR, value);
    }

    /**
     * Normalize a given key by removing 'carriage return' and 'line feed' characters
     *
     * @param key String the key to normalize
     * @return String the normalized key
     */
    protected String normalizeString(String key) {
        if (key == null) {
            return "";
        }

        key = key.replaceAll("[\\n\\r]", "");

        return key.trim();
    }

    /**
     * Abstract method that should return the indexed values associated with an index key
     *
     * @param key String the key to use
     * @return Set of String values corresponding to the given index key
     */
    public abstract Set<String> get(String key);

    /**
     * Abstract method that should return the indexed values associated with an index key, after they were filtered by
     * the given Filter
     *
     * @param key    String the key to use
     * @param filter Filter the filter to apply
     * @return Set of String values corresponding to the given index key and matching the Filter
     */
    public abstract Set<String> get(String key, Filter filter);

    /**
     * Abstract method that should return the indexed values that fall within a given keys min/max interval,
     * after they were filtered by the given Filter
     *
     * @param startKey String the key specifying the start interval
     * @param endKey   String the key specifying the end interval
     * @param filter   Filter the filter to apply
     * @return Set of String values within to the given index keys interval and matching the Filter
     */
    public abstract Set<String> get(String startKey, String endKey, Filter filter);

    /**
     * Abstract method that should add the given value to the index under the given key
     *
     * @param key   String the key to use
     * @param value String the value to use
     * @return boolean true, if the value was updated or false, if the value was inserted into the index
     */
    public abstract boolean put(String key, String value);

    /**
     * Abstract method that should remove the entire entry under the given key from the index
     *
     * @param key String the key to remove
     * @return boolean true, if the remove was successful
     */
    public abstract boolean remove(String key);

    /**
     * Abstract method that should remove a given value for a given key from the index. If the index entry is left
     * without any values, the entire index entry should be removed.
     *
     * @param key   String the key to use
     * @param value String the value to remove
     * @return boolean true, if the remove was successful
     */
    public abstract boolean remove(String key, String value);
}
