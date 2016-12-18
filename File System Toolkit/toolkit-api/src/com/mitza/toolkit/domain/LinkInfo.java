package com.mitza.toolkit.domain;

/**
 * Object representing a Tridion link information
 *
 * @author Mihai Cadariu
 * @since 20.10.2015
 */
public interface LinkInfo {

    /**
     * Return the Component item id in this link info
     *
     * @return int representing the Component item id in this link info
     */
    int getComponent();

    /**
     * Return the Publication id in this link info
     *
     * @return int representing the Publication id in this link info
     */
    int getPublication();

    /**
     * Return the Page item id in this link info
     *
     * @return int representing the Page item id in this link info
     */
    int getPage();

    /**
     * Return the link priority in this link info
     *
     * @return int representing the link priority in this link info
     */
    int getPriority();

    /**
     * Return the target URL in this link info
     *
     * @return int representing the target URL in this link info
     */
    String getUrl();

    /**
     * Return the variant id in this link info
     *
     * @return int representing the variant id in this link info
     */
    String getVariant();
}
