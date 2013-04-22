
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for ItemFieldDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemFieldDefinitionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MaxOccurs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MinOccurs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ExtensionXml" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax' minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemFieldDefinitionData", propOrder = {
    "customUrl",
    "description",
    "maxOccurs",
    "minOccurs",
    "name",
    "extensionXml"
})
@XmlSeeAlso({
    MultiLineTextFieldDefinitionData.class,
    ExternalLinkFieldDefinitionData.class,
    XhtmlFieldDefinitionData.class,
    EmbeddedSchemaFieldDefinitionData.class,
    NumberFieldDefinitionData.class,
    DateFieldDefinitionData.class,
    SingleLineTextFieldDefinitionData.class,
    MultimediaLinkFieldDefinitionData.class,
    KeywordFieldDefinitionData.class,
    ComponentLinkFieldDefinitionData.class
})
public class ItemFieldDefinitionData {

    @XmlElement(name = "CustomUrl", nillable = true)
    protected String customUrl;
    @XmlElement(name = "Description", required = true, nillable = true)
    protected String description;
    @XmlElement(name = "MaxOccurs")
    protected int maxOccurs;
    @XmlElement(name = "MinOccurs")
    protected int minOccurs;
    @XmlElement(name = "Name", required = true, nillable = true)
    protected String name;
    @XmlElement(name = "ExtensionXml", nillable = true)
    protected ItemFieldDefinitionData.ExtensionXml extensionXml;

    /**
     * Gets the value of the customUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomUrl() {
        return customUrl;
    }

    /**
     * Sets the value of the customUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomUrl(String value) {
        this.customUrl = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the maxOccurs property.
     * 
     */
    public int getMaxOccurs() {
        return maxOccurs;
    }

    /**
     * Sets the value of the maxOccurs property.
     * 
     */
    public void setMaxOccurs(int value) {
        this.maxOccurs = value;
    }

    /**
     * Gets the value of the minOccurs property.
     * 
     */
    public int getMinOccurs() {
        return minOccurs;
    }

    /**
     * Sets the value of the minOccurs property.
     * 
     */
    public void setMinOccurs(int value) {
        this.minOccurs = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the extensionXml property.
     * 
     * @return
     *     possible object is
     *     {@link ItemFieldDefinitionData.ExtensionXml }
     *     
     */
    public ItemFieldDefinitionData.ExtensionXml getExtensionXml() {
        return extensionXml;
    }

    /**
     * Sets the value of the extensionXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemFieldDefinitionData.ExtensionXml }
     *     
     */
    public void setExtensionXml(ItemFieldDefinitionData.ExtensionXml value) {
        this.extensionXml = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any processContents='lax' minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class ExtensionXml {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         * 
         * @return
         *     possible object is
         *     {@link Element }
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * 
         * @param value
         *     allowed object is
         *     {@link Element }
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
