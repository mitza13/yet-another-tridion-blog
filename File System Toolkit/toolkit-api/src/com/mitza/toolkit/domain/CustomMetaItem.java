package com.mitza.toolkit.domain;

import java.util.Date;
import java.util.List;

/**
 * Object representation of a Tridion custom metadata entry
 *
 * @author Mihai Cadariu
 * @since 20.10.2015
 */
public interface CustomMetaItem {

    /**
     * Return the name of this custom meta item
     *
     * @return String the name of this custom meta item
     */
    String getName();

    /**
     * Return the Date value of this custom meta item, if there is one
     *
     * @return Date the Date value of this custom meta item, or null
     */
    Date getDateValue();

    /**
     * Return all Date values of this custom meta item, if there is one
     *
     * @return List the list of Date values of this custom meta item, or null
     */
    List<Date> getDateValues();

    /**
     * Return the numeric value of this custom meta item, if there is one
     *
     * @return float the numeric value of this custom meta item, or null
     */
    float getNumericValue();

    /**
     * Return all numeric values of this custom meta item, if there is one
     *
     * @return List the list of numeric values of this custom meta item, or null
     */
    List<Float> getNumericValues();

    /**
     * Return the String value of this custom meta item, if there is one
     *
     * @return the String value of this custom meta item, or null
     */
    String getStringValue();

    /**
     * Return all String values of this custom meta item, if there is one
     *
     * @return List the list of String values of this custom meta item, or null
     */
    List<String> getStringValues();

    /**
     * Return the type of this custo meta item
     *
     * @return CustomMetaType enumeration representing the type of this custom meta item
     */
    CustomMetaType getType();
}
