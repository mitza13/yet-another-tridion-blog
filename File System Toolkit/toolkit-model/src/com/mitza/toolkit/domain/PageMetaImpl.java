package com.mitza.toolkit.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mitza.util.TcmUri;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Object representing a Tridion page metadata
 *
 * @author Mihai Cadariu
 * @since 03.11.2015
 */
public class PageMetaImpl implements PageMeta {

    @JsonDeserialize(contentAs = ComponentPresentationMetaImpl.class)
    @JsonProperty("cp")
    private List<ComponentPresentationMeta> componentPresentationMetas;
    @JsonDeserialize(as = CustomMetaImpl.class)
    @JsonProperty("cstm")
    private CustomMeta customMeta;
    @JsonProperty("f")
    private String filename;
    @JsonProperty("m")
    private Date lastModified;
    @JsonProperty("p")
    private Date lastPublished;
    @JsonProperty("pt")
    private int pageTemplateId;
    @JsonProperty("tcm")
    private TcmUri tcmUri;
    @JsonProperty("t")
    private String title;
    @JsonProperty("u")
    private String url;

    public PageMetaImpl() {
    }

    /**
     * Return the Component Presentations on this page
     *
     * @return List of Component Presentations on this page
     */
    @Override
    public List<ComponentPresentationMeta> getComponentPresentationMetas() {
        return componentPresentationMetas;
    }

    public void setComponentPresentationMetas(List<ComponentPresentationMeta> componentPresentationMetas) {
        this.componentPresentationMetas = componentPresentationMetas;
    }

    /**
     * Add Component Presentation meta to the list of DCPs in this Page
     *
     * @param componentPresentationMeta ComponentPresentationMeta to add
     */
    public void addComponentPresentationMeta(ComponentPresentationMeta componentPresentationMeta) {
        if (componentPresentationMetas == null) {
            componentPresentationMetas = new ArrayList<>();
        }
        componentPresentationMetas.add(componentPresentationMeta);
    }

    /**
     * Return the Page Template item id associated with this page
     *
     * @return int the Page Template item id associated with this page
     */
    @Override
    public int getPageTemplateId() {
        return pageTemplateId;
    }

    public void setPageTemplateId(int pageTemplateId) {
        this.pageTemplateId = pageTemplateId;
    }

    /**
     * Return the Page Template item id associated with this page
     *
     * @return int the Page Template item id associated with this page
     */
    @Override
    public CustomMeta getCustomMeta() {
        return customMeta;
    }

    public void setCustomMeta(CustomMeta customMeta) {
        this.customMeta = customMeta;
    }

    /**
     * Return the last modification date for this item
     *
     * @return Date the last modification date for this item
     */
    @Override
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Return the last publish date for this item
     *
     * @return Date the last publish date for this item
     */
    @Override
    public Date getLastPublished() {
        return lastPublished;
    }

    public void setLastPublished(Date lastPublished) {
        this.lastPublished = lastPublished;
    }

    /**
     * Return the TcmUri of this item
     *
     * @return TcmUri the unique URI of this item
     */
    @Override
    public TcmUri getTcmUri() {
        return tcmUri;
    }

    public void setTcmUri(TcmUri tcmUri) {
        this.tcmUri = tcmUri;
    }

    /**
     * Return the title of this item
     *
     * @return String the title of this item
     */
    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return the filename of this locatable object
     *
     * @return String the filename of this locatable object
     */
    @Override
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Return the URL of this locatable object
     *
     * @return String URL of this locatable object
     */
    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Return a human readable String representation of this PageMetaImpl
     *
     * @return String representation of this PageMetaImpl
     */
    @Override
    public String toString() {
        return String.format("%s[%s]", super.toString(), tcmUri);
    }
}
