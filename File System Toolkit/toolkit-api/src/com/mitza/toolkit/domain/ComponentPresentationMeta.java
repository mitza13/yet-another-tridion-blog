package com.mitza.toolkit.domain;

/**
 * Object representation of a Tridion component presentation metadata
 *
 * @author Mihai Cadariu
 * @since 20.10.2015
 */
public interface ComponentPresentationMeta {

    /**
     * Return the Component item id inside this Component Presentation
     *
     * @return int the Component item id inside this Component Presentation
     */
    int getComponentId();

    /**
     * Return the link priority of this Component Presentation
     *
     * @return int the link priority of this Component Presentation
     */
    int getPriority();

    /**
     * Return the Publication id of this Component Presentation
     *
     * @return int the Publication id of this Component Presentation
     */
    int getPublicationId();

    /**
     * Return the Component Template item id of this Component Presentation
     *
     * @return int the Component Template item id of this Component Presentation
     */
    int getTemplateId();

    /**
     * Return the content of this Dynamic Component Presentation
     *
     * @return String representing the content of this Component Presentation; or null, otherwise
     */
    String getContent();
}
