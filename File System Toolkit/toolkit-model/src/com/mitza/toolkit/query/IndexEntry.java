package com.mitza.toolkit.query;

import java.util.Set;
import java.util.TreeSet;

/**
 * Class representing an index entry, which is composed of a key, a set of values and the start/end positions in the
 * index file corresponding to this entry.
 *
 * @author Mihai Cadariu
 * @since 27.11.2015
 */
public class IndexEntry {

    private String key;
    private Set<String> values;
    private long startPosition;
    private long endPosition;

    /**
     * Create new empty entry for a given key and at a starting position in the index file
     *
     * @param key           String the index key to use
     * @param startPosition long the start position in the index file for this entry
     */
    public IndexEntry(String key, long startPosition) {
        this(key, new TreeSet<String>(), startPosition, 0);
    }

    /**
     * Create new entry for a given key, a set of values and at a start/end interval in the index file
     *
     * @param key           String the index key to use
     * @param values        Set of String values associated with this key
     * @param startPosition long the start position in the index file
     * @param endPosition   long the end position in the index file
     */
    public IndexEntry(String key, Set<String> values, long startPosition, long endPosition) {
        this.key = key;
        this.values = values;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    /**
     * Return the indexed values
     *
     * @return Set of String indexed values
     */
    public Set<String> getValues() {
        return values;
    }

    /**
     * Add String value to this entry
     *
     * @param value String the value to add
     */
    public void addValue(String value) {
        values.add(value);
    }

    /**
     * Checks whether this entry contains the specified value
     *
     * @param value String the value to check
     * @return boolean true, if the specified values is present in this entry
     */
    public boolean containsValue(String value) {
        return values.contains(value);
    }

    /**
     * Remove specified value from this entry
     *
     * @param value String the value to remove
     * @return boolean true, if the value was removed
     */
    public boolean removeValue(String value) {
        return values.remove(value);
    }

    /**
     * Checks whether this entry contains any values
     *
     * @return boolean true, if this entry does not contain any value
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * Return an index file entry representation of this entry's key and values separated by VALUE_SEPARATOR
     *
     * @return String the index file entry
     */
    public String encodeLine() {
        StringBuilder builder = new StringBuilder(key);

        for (String value : values) {
            builder.append((char) IndexAbstract.VALUE_SEPARATOR);
            builder.append(value);
        }

        return builder.toString();
    }

    /**
     * Return the key of this entry
     *
     * @return String the key of this entry
     */
    public String getKey() {
        return key;
    }

    /**
     * Set the key to the given value
     *
     * @param key String the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Return this entry's start position in the index file
     *
     * @return long the start offset of this entry in the index file
     */
    public long getStartPosition() {
        return startPosition;
    }

    /**
     * Return this entry's end position in the index file
     *
     * @return long the end offset of this entry in the index file
     */
    public long getEndPosition() {
        return endPosition;
    }

    /**
     * Return a human readable String representation of this entry
     *
     * @return String representation of this entry
     */
    public String toString() {
        return String.format("IndexEntry[key=%s values=%s startPosition=%d endPosition=%d]",
                key, values, startPosition, endPosition);
    }
}
