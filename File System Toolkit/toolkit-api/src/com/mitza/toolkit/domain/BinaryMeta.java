package com.mitza.toolkit.domain;

/**
 * Object representation of a Tridion binary metadata
 *
 * @author Mihai Cadariu
 * @since 20.10.2015
 */
public interface BinaryMeta extends ItemMeta, LocatableObject {

    /**
     * Return the binary's mime type
     *
     * @return String this binary's mime type
     */
    String getMimeType();

    /**
     * Return the binary's Multimedia Schema title
     *
     * @return String representing this binary's Multimedia Schema title
     */
    String getSchema();
}
