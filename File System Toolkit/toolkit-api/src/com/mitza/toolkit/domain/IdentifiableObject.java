package com.mitza.toolkit.domain;

import com.mitza.util.TcmUri;

/**
 * Simplest object representation of a Tridion item
 *
 * @author Mihai Cadariu
 * @since 20.10.2015
 */
public interface IdentifiableObject {

    /**
     * Return the TcmUri of this item
     *
     * @return TcmUri the unique URI of this item
     */
    TcmUri getTcmUri();

    /**
     * Return the title of this item
     *
     * @return String the title of this item
     */
    String getTitle();
}
