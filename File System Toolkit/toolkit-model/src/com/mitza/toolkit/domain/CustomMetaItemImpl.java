package com.mitza.toolkit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Object representation of a Tridion custom metadata entry
 *
 * @author Mihai Cadariu
 * @since 04.11.2015
 */
public class CustomMetaItemImpl implements CustomMetaItem {

    @JsonProperty("k")
    private String name;
    @JsonProperty("d")
    private List<Date> dateValues;
    @JsonProperty("n")
    private List<Float> numericValues;
    @JsonProperty("s")
    private List<String> stringValues;
    @JsonProperty("t")
    private CustomMetaType type;

    public CustomMetaItemImpl() {
    }

    /**
     * Create new instance for the given name and Date value
     *
     * @param name      String the custom meta name
     * @param dateValue Date the custom meta value
     */
    public CustomMetaItemImpl(String name, Date dateValue) {
        setName(name);
        addDateValue(dateValue);
    }

    /**
     * Create new instance for the given name and numeric value
     *
     * @param name         String the custom meta name
     * @param numericValue float the custom meta value
     */
    public CustomMetaItemImpl(String name, float numericValue) {
        setName(name);
        addNumericValue(numericValue);
    }

    /**
     * Create new instance for the given name and String value
     *
     * @param name        String the custom meta name
     * @param stringValue String the custom meta value
     */
    public CustomMetaItemImpl(String name, String stringValue) {
        setName(name);
        addStringValue(stringValue);
    }

    /**
     * Add new Date value to this custm meta item
     *
     * @param dateValue Date the value to add
     */
    public void addDateValue(Date dateValue) {
        if (dateValues == null) {
            dateValues = new ArrayList<>();
        }
        type = CustomMetaType.DATE;
        dateValues.add(dateValue);
    }

    /**
     * Add new numeric value to this custm meta item
     *
     * @param numericValue float the value to add
     */
    public void addNumericValue(float numericValue) {
        if (numericValues == null) {
            numericValues = new ArrayList<>();
        }
        type = CustomMetaType.NUMERIC;
        numericValues.add(numericValue);
    }

    /**
     * Add new String value to this custm meta item
     *
     * @param stringValue String the value to add
     */
    public void addStringValue(String stringValue) {
        if (stringValues == null) {
            stringValues = new ArrayList<>();
        }
        type = CustomMetaType.STRING;
        stringValues.add(stringValue);
    }

    /**
     * Return the name of this custom meta item
     *
     * @return String the name of this custom meta item
     */
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the Date value of this custom meta item, if there is one
     *
     * @return Date the Date value of this custom meta item, or null
     */
    @Override
    @JsonIgnore
    public Date getDateValue() {
        return dateValues == null ? null : dateValues.get(0);
    }

    /**
     * Return all Date values of this custom meta item, if there is one
     *
     * @return List the list of Date values of this custom meta item, or null
     */
    @Override
    public List<Date> getDateValues() {
        return dateValues;
    }

    /**
     * Return the numeric value of this custom meta item, if there is one
     *
     * @return float the numeric value of this custom meta item, or null
     */
    @Override
    @JsonIgnore
    public float getNumericValue() {
        return numericValues == null ? 0 : numericValues.get(0);
    }

    /**
     * Return all numeric values of this custom meta item, if there is one
     *
     * @return List the list of numeric values of this custom meta item, or null
     */
    @Override
    public List<Float> getNumericValues() {
        return numericValues;
    }

    /**
     * Return the String value of this custom meta item, if there is one
     *
     * @return the String value of this custom meta item, or null
     */
    @Override
    @JsonIgnore
    public String getStringValue() {
        return stringValues == null ? null : stringValues.get(0);
    }

    /**
     * Return all String values of this custom meta item, if there is one
     *
     * @return List the list of String values of this custom meta item, or null
     */
    @Override
    public List<String> getStringValues() {
        return stringValues;
    }

    /**
     * Return the type of this custo meta item
     *
     * @return CustomMetaType enumeration representing the type of this custom meta item
     */
    @Override
    public CustomMetaType getType() {
        return type;
    }

    /**
     * Return a human readable String representation of this CustomMetaItem
     *
     * @return String representation of this CustomMetaItem
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("CustomMetaItem[name=").append(name);

        if (type != null) {
            switch (type) {
                case DATE:
                    builder.append(" dates=").append(dateValues);
                    break;

                case NUMERIC:
                    builder.append(" numerics=").append(numericValues);
                    break;

                case STRING:
                    builder.append(" strings=").append(stringValues);
                    break;
            }
        }

        return builder.append("]").toString();
    }
}
