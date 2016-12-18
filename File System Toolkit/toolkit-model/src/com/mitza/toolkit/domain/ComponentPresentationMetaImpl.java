package com.mitza.toolkit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object representation of a Tridion component presentation metadata
 *
 * @author Mihai Cadariu
 * @since 05.11.2015
 */
public class ComponentPresentationMetaImpl implements ComponentPresentationMeta {

    @JsonProperty("c")
    private int component;
    @JsonProperty("cnt")
    private String content;
    @JsonProperty("pr")
    private int priority;
    @JsonProperty("p")
    private int publication;
    @JsonProperty("t")
    private int template;

    public ComponentPresentationMetaImpl() {
    }

    /**
     * Create new instance and initializes it to the given parameters
     *
     * @param publication int the context Publication id
     * @param component   int the Component item id
     * @param template    int the Component Template item id
     * @param priority    int the Component Template priority
     */
    public ComponentPresentationMetaImpl(int publication, int component, int template, int priority) {
        this.publication = publication;
        this.component = component;
        this.template = template;
        this.priority = priority;
    }

    /**
     * Return the Component item id inside this Component Presentation
     *
     * @return int the Component item id inside this Component Presentation
     */
    @Override
    @JsonIgnore()
    public int getComponentId() {
        return component;
    }

    public void setComponent(int component) {
        this.component = component;
    }

    /**
     * Return the content of this Dynamic Component Presentation
     *
     * @return String representing the content of this Component Presentation; or null, otherwise
     */
    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Return the link priority of this Component Presentation
     *
     * @return int the link priority of this Component Presentation
     */
    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Return the Publication id of this Component Presentation
     *
     * @return int the Publication id of this Component Presentation
     */
    @Override
    @JsonIgnore()
    public int getPublicationId() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    /**
     * Return the Component Template item id of this Component Presentation
     *
     * @return int the Component Template item id of this Component Presentation
     */
    @Override
    @JsonIgnore()
    public int getTemplateId() {
        return template;
    }

    public void setTemplate(int template) {
        this.template = template;
    }

    /**
     * Implements equality check between two ComponentPresentationMetas by checking the equality of all their properties
     *
     * @param object Object the other object to check
     * @return boolean true, if all properties are equal
     */
    @Override
    public boolean equals(Object object) {
        boolean result = false;

        if (object != null && object instanceof ComponentPresentationMeta) {
            ComponentPresentationMeta other = (ComponentPresentationMeta) object;
            result = component == other.getComponentId() &&
                    publication == other.getPublicationId() &&
                    template == other.getTemplateId();
        }

        return result;
    }

    /**
     * Return a human readable String representation of this ComponentPresentationMeta
     *
     * @return String representation of this ComponentPresentationMeta
     */
    @Override
    public String toString() {
        return String.format("ComponentPresentationMeta[%d-%d-%d]", publication, component, template);
    }
}
