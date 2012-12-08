
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComponentLinkFieldDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComponentLinkFieldDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ItemFieldDefinitionData">
 *       &lt;sequence>
 *         &lt;element name="AllowMultimediaLinks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AllowedTargetSchemas" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToSchemaData"/>
 *         &lt;element name="DefaultValue" type="{http://www.sdltridion.com/ContentManager/R6}LinkToComponentData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComponentLinkFieldDefinitionData", propOrder = {
    "allowMultimediaLinks",
    "allowedTargetSchemas",
    "defaultValue"
})
public class ComponentLinkFieldDefinitionData
    extends ItemFieldDefinitionData
{

    @XmlElement(name = "AllowMultimediaLinks")
    protected Boolean allowMultimediaLinks;
    @XmlElement(name = "AllowedTargetSchemas", required = true, nillable = true)
    protected ArrayOfLinkToSchemaData allowedTargetSchemas;
    @XmlElement(name = "DefaultValue", nillable = true)
    protected LinkToComponentData defaultValue;

    /**
     * Gets the value of the allowMultimediaLinks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowMultimediaLinks() {
        return allowMultimediaLinks;
    }

    /**
     * Sets the value of the allowMultimediaLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowMultimediaLinks(Boolean value) {
        this.allowMultimediaLinks = value;
    }

    /**
     * Gets the value of the allowedTargetSchemas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToSchemaData }
     *     
     */
    public ArrayOfLinkToSchemaData getAllowedTargetSchemas() {
        return allowedTargetSchemas;
    }

    /**
     * Sets the value of the allowedTargetSchemas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToSchemaData }
     *     
     */
    public void setAllowedTargetSchemas(ArrayOfLinkToSchemaData value) {
        this.allowedTargetSchemas = value;
    }

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToComponentData }
     *     
     */
    public LinkToComponentData getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToComponentData }
     *     
     */
    public void setDefaultValue(LinkToComponentData value) {
        this.defaultValue = value;
    }

}
