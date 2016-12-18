package com.mitza.toolkit.domain;

/**
 * Object representing a Tridion item that has a location
 *
 * @author Mihai Cadariu
 * @since 20.10.2015
 */
public interface LocatableObject {

    /**
     * Return the filename of this locatable object
     *
     * @return String the filename of this locatable object
     */
    String getFilename();

    /**
     * Return the URL of this locatable object
     *
     * @return String URL of this locatable object
     */
    String getUrl();
}
