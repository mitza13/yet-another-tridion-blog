
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CategoryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoryData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}OrganizationalItemData">
 *       &lt;sequence>
 *         &lt;element name="AllowedParentCategories" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToCategoryData" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsTaxonomyRoot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="KeywordMetadataSchema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="UseForIdentification" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UseForNavigation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="XmlName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoryData", propOrder = {
    "allowedParentCategories",
    "description",
    "isTaxonomyRoot",
    "keywordMetadataSchema",
    "useForIdentification",
    "useForNavigation",
    "xmlName"
})
public class CategoryData
    extends OrganizationalItemData
{

    @XmlElement(name = "AllowedParentCategories", nillable = true)
    protected ArrayOfLinkToCategoryData allowedParentCategories;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "IsTaxonomyRoot", nillable = true)
    protected Boolean isTaxonomyRoot;
    @XmlElement(name = "KeywordMetadataSchema", nillable = true)
    protected LinkToSchemaData keywordMetadataSchema;
    @XmlElement(name = "UseForIdentification", nillable = true)
    protected Boolean useForIdentification;
    @XmlElement(name = "UseForNavigation", nillable = true)
    protected Boolean useForNavigation;
    @XmlElement(name = "XmlName", nillable = true)
    protected String xmlName;

    /**
     * Gets the value of the allowedParentCategories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToCategoryData }
     *     
     */
    public ArrayOfLinkToCategoryData getAllowedParentCategories() {
        return allowedParentCategories;
    }

    /**
     * Sets the value of the allowedParentCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToCategoryData }
     *     
     */
    public void setAllowedParentCategories(ArrayOfLinkToCategoryData value) {
        this.allowedParentCategories = value;
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
     * Gets the value of the isTaxonomyRoot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsTaxonomyRoot() {
        return isTaxonomyRoot;
    }

    /**
     * Sets the value of the isTaxonomyRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsTaxonomyRoot(Boolean value) {
        this.isTaxonomyRoot = value;
    }

    /**
     * Gets the value of the keywordMetadataSchema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getKeywordMetadataSchema() {
        return keywordMetadataSchema;
    }

    /**
     * Sets the value of the keywordMetadataSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setKeywordMetadataSchema(LinkToSchemaData value) {
        this.keywordMetadataSchema = value;
    }

    /**
     * Gets the value of the useForIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseForIdentification() {
        return useForIdentification;
    }

    /**
     * Sets the value of the useForIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseForIdentification(Boolean value) {
        this.useForIdentification = value;
    }

    /**
     * Gets the value of the useForNavigation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseForNavigation() {
        return useForNavigation;
    }

    /**
     * Sets the value of the useForNavigation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseForNavigation(Boolean value) {
        this.useForNavigation = value;
    }

    /**
     * Gets the value of the xmlName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlName() {
        return xmlName;
    }

    /**
     * Sets the value of the xmlName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlName(String value) {
        this.xmlName = value;
    }

}
