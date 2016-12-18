package com.mitza.toolkit.domain;

import java.util.List;

/**
 * Object representing a Tridion page metadata
 *
 * @author Mihai Cadariu
 * @since 20.10.2015
 */
public interface PageMeta extends ItemMeta, LocatableObject {

    /**
     * Return the Component Presentations on this page
     *
     * @return List of Component Presentations on this page
     */
    List<ComponentPresentationMeta> getComponentPresentationMetas();

    /**
     * Return the Page Template item id associated with this page
     *
     * @return int the Page Template item id associated with this page
     */
    int getPageTemplateId();
}
