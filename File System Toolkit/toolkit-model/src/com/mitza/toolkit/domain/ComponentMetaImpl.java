package com.mitza.toolkit.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mitza.util.TcmUri;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Object representation of a Tridion component metadata
 *
 * @author Mihai Cadariu
 * @since 03.11.2015
 */
public class ComponentMetaImpl implements ComponentMeta {

    @JsonDeserialize(contentAs = ComponentPresentationMetaImpl.class)
    @JsonProperty("cp")
    private List<ComponentPresentationMeta> dynamicComponentPresentationMetas;
    @JsonDeserialize(as = CustomMetaImpl.class)
    @JsonProperty("cstm")
    private CustomMeta customMeta;
    @JsonProperty("m")
    private Date lastModified;
    @JsonProperty("p")
    private Date lastPublished;
    @JsonDeserialize(contentAs = LinkInfoImpl.class)
    @JsonProperty("lnk")
    private List<LinkInfo> linkInfos;
    @JsonProperty("sch")
    private int schemaId;
    @JsonProperty("tcm")
    private TcmUri tcmUri;
    @JsonProperty("t")
    private String title;
    @JsonProperty("mm")
    private boolean multimedia;

    public ComponentMetaImpl() {
    }

    /**
     * Return all dynamic Component Presentation metas this Component belongs to
     *
     * @return List of all dynamic ComponentPresentationMeta objects this ComponentMeta appears in
     */
    @Override
    public List<ComponentPresentationMeta> getDynamicComponentPresentationMetas() {
        return dynamicComponentPresentationMetas;
    }

    /**
     * Set dynamic Component Presentation metas this Component belongs to
     *
     * @param dynamicComponentPresentationMetas List of dcps to set
     */
    public void setDynamicComponentPresentationMetas(List<ComponentPresentationMeta> dynamicComponentPresentationMetas) {
        this.dynamicComponentPresentationMetas = dynamicComponentPresentationMetas;
    }

    /**
     * Add Component Presentation meta to the list of DCPs in this Component
     *
     * @param componentPresentationMeta ComponentPresentationMeta to add
     */
    public synchronized void addComponentPresentationMeta(ComponentPresentationMeta componentPresentationMeta) {
        if (dynamicComponentPresentationMetas == null) {
            dynamicComponentPresentationMetas = new ArrayList<>();
        }

        int idx = dynamicComponentPresentationMetas.indexOf(componentPresentationMeta);
        if (idx < 0) {
            dynamicComponentPresentationMetas.add(componentPresentationMeta);
        } else {
            dynamicComponentPresentationMetas.set(idx, componentPresentationMeta);
        }
    }

    /**
     * Return all LinkInfo objects this Component belongs to
     *
     * @return List of all LinkInfo obejcts this Component belongs to
     */
    @Override
    public List<LinkInfo> getLinkInfos() {
        return linkInfos;
    }

    /**
     * Set link infos
     *
     * @param linkInfos List of LinkInfo objects to set
     */
    public void setLinkInfos(List<LinkInfo> linkInfos) {
        this.linkInfos = linkInfos;
    }

    /**
     * Add LinkInfo to the list of LinkInfos in this Component
     *
     * @param linkInfo LinkInfo to add
     */
    public synchronized void addLinkInfo(LinkInfo linkInfo) {
        if (linkInfos == null) {
            linkInfos = new ArrayList<>();
        }
        linkInfos.add(linkInfo);
    }

    /**
     * Return the item id of the Schema associated with this Component
     *
     * @return int representing the item id of the Schema associated with this Component
     */
    @Override
    public int getSchemaId() {
        return schemaId;
    }

    /**
     * Set the Schema item id
     *
     * @param schemaId int the Schema item id to set
     */
    public void setSchemaId(int schemaId) {
        this.schemaId = schemaId;
    }

    /**
     * Return the CustomMeta object of this item, if exists
     *
     * @return CustomMeta object of this item; or null, otherwise
     */
    @Override
    public CustomMeta getCustomMeta() {
        return customMeta;
    }

    /**
     * Set custom meta
     *
     * @param customMeta CustomMeta to set
     */
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

    /**
     * Set last modified date
     *
     * @param lastModified Date the last modified date to set
     */
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

    /**
     * Set last published date
     *
     * @param lastPublished Date the last published date to set
     */
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

    /**
     * Set the TcmUri
     *
     * @param tcmUri Tcmri to set
     */
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

    /**
     * Set the title
     *
     * @param title String the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return whether this is a Multimedia Component
     *
     * @return boolean true, if this is a Multimedia Component
     */
    @Override
    public boolean isMultimedia() {
        return multimedia;
    }

    /**
     * Set whether this Component is a multimedia
     *
     * @param multimedia boolean the multimedia status to set
     */
    public void setMultimedia(boolean multimedia) {
        this.multimedia = multimedia;
    }

    /**
     * Return a human readable String representation of this ComponentMeta
     *
     * @return String representation of this ComponentMeta
     */
    @Override
    public String toString() {
        return String.format("%s[%s]", super.toString(), tcmUri);
    }
}
