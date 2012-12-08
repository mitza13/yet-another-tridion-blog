
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstanceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InstanceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContainerItem" type="{http://www.sdltridion.com/ContentManager/R6}LinkToIdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="Metadata" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="Schema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstanceData", propOrder = {
    "containerItem",
    "content",
    "metadata",
    "schema"
})
public class InstanceData {

    @XmlElement(name = "ContainerItem", nillable = true)
    protected LinkToIdentifiableObjectData containerItem;
    @XmlElement(name = "Content", nillable = true)
    protected String content;
    @XmlElement(name = "Metadata", nillable = true)
    protected String metadata;
    @XmlElement(name = "Schema", nillable = true)
    protected LinkToSchemaData schema;

    /**
     * Gets the value of the containerItem property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public LinkToIdentifiableObjectData getContainerItem() {
        return containerItem;
    }

    /**
     * Sets the value of the containerItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public void setContainerItem(LinkToIdentifiableObjectData value) {
        this.containerItem = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetadata(String value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the schema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getSchema() {
        return schema;
    }

    /**
     * Sets the value of the schema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setSchema(LinkToSchemaData value) {
        this.schema = value;
    }

}
