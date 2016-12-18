package com.mitza.toolkit.domain;

import java.util.List;

/**
 * Object representation of a Tridion component metadata
 *
 * @author Mihai Cadariu
 * @since 20.10.2015
 */
public interface ComponentMeta extends ItemMeta {

    /**
     * Return all dynamic Component Presentation metas this Component belongs to
     *
     * @return List of all dynamic ComponentPresentationMeta objects this ComponentMeta appears in
     */
    List<ComponentPresentationMeta> getDynamicComponentPresentationMetas();

    /**
     * Return all LinkInfo objects this Component belongs to
     *
     * @return List of all LinkInfo obejcts this Component belongs to
     */
    List<LinkInfo> getLinkInfos();

    /**
     * Return whether this is a Multimedia Component
     *
     * @return boolean true, if this is a Multimedia Component
     */
    boolean isMultimedia();

    /**
     * Return the item id of the Schema associated with this Component
     *
     * @return int representing the item id of the Schema associated with this Component
     */
    int getSchemaId();
}
