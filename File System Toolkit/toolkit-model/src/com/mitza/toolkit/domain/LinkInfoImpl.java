package com.mitza.toolkit.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object representing a Tridion link information
 *
 * @author Mihai Cadariu
 * @since 05.11.2015
 */
public class LinkInfoImpl implements LinkInfo {

    @JsonProperty("c")
    private int component;
    @JsonProperty("pg")
    private int page;
    @JsonProperty("pr")
    private int priority;
    @JsonProperty("p")
    private int publication;
    @JsonProperty("u")
    private String url;
    @JsonProperty("v")
    private String variant;

    public LinkInfoImpl() {
    }

    /**
     * Return the Component item id in this link info
     *
     * @return int representing the Component item id in this link info
     */
    @Override
    public int getComponent() {
        return component;
    }

    public void setComponent(int component) {
        this.component = component;
    }

    /**
     * Return the Publication id in this link info
     *
     * @return int representing the Publication id in this link info
     */
    @Override
    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    /**
     * Return the Page item id in this link info
     *
     * @return int representing the Page item id in this link info
     */
    @Override
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Return the link priority in this link info
     *
     * @return int representing the link priority in this link info
     */
    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Return the target URL in this link info
     *
     * @return int representing the target URL in this link info
     */
    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Return the variant id in this link info
     *
     * @return int representing the variant id in this link info
     */
    @Override
    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    /**
     * Return a human readable String representation of this LinkInfoImpl
     *
     * @return String representation of this LinkInfoImpl
     */
    @Override
    public String toString() {
        return String.format("LinkInfo[publication=%d page=%d component=%d priority=%d variant=%s url=%s]",
                publication, page, component, priority, variant, url);
    }
}
