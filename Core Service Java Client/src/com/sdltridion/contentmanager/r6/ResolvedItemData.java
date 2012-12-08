
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResolvedItemData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResolvedItemData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Item" type="{http://www.sdltridion.com/ContentManager/R6}LinkToIdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="ItemPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicationTarget" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPublicationTargetData" minOccurs="0"/>
 *         &lt;element name="Template" type="{http://www.sdltridion.com/ContentManager/R6}LinkToTemplateData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResolvedItemData", propOrder = {
    "item",
    "itemPath",
    "publicationTarget",
    "template"
})
public class ResolvedItemData {

    @XmlElement(name = "Item", nillable = true)
    protected LinkToIdentifiableObjectData item;
    @XmlElement(name = "ItemPath", nillable = true)
    protected String itemPath;
    @XmlElement(name = "PublicationTarget", nillable = true)
    protected LinkToPublicationTargetData publicationTarget;
    @XmlElement(name = "Template", nillable = true)
    protected LinkToTemplateData template;

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public LinkToIdentifiableObjectData getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public void setItem(LinkToIdentifiableObjectData value) {
        this.item = value;
    }

    /**
     * Gets the value of the itemPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemPath() {
        return itemPath;
    }

    /**
     * Sets the value of the itemPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemPath(String value) {
        this.itemPath = value;
    }

    /**
     * Gets the value of the publicationTarget property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToPublicationTargetData }
     *     
     */
    public LinkToPublicationTargetData getPublicationTarget() {
        return publicationTarget;
    }

    /**
     * Sets the value of the publicationTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToPublicationTargetData }
     *     
     */
    public void setPublicationTarget(LinkToPublicationTargetData value) {
        this.publicationTarget = value;
    }

    /**
     * Gets the value of the template property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToTemplateData }
     *     
     */
    public LinkToTemplateData getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToTemplateData }
     *     
     */
    public void setTemplate(LinkToTemplateData value) {
        this.template = value;
    }

}
