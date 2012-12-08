
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClassificationDetailData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassificationDetailData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Category" type="{http://www.sdltridion.com/ContentManager/R6}LinkToCategoryData" minOccurs="0"/>
 *         &lt;element name="FieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsMetadataField" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Keywords" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToKeywordData" minOccurs="0"/>
 *         &lt;element name="XPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassificationDetailData", propOrder = {
    "category",
    "fieldName",
    "isMetadataField",
    "keywords",
    "xPath"
})
public class ClassificationDetailData {

    @XmlElement(name = "Category", nillable = true)
    protected LinkToCategoryData category;
    @XmlElement(name = "FieldName", nillable = true)
    protected String fieldName;
    @XmlElement(name = "IsMetadataField")
    protected Boolean isMetadataField;
    @XmlElement(name = "Keywords", nillable = true)
    protected ArrayOfLinkToKeywordData keywords;
    @XmlElement(name = "XPath", nillable = true)
    protected String xPath;

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToCategoryData }
     *     
     */
    public LinkToCategoryData getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToCategoryData }
     *     
     */
    public void setCategory(LinkToCategoryData value) {
        this.category = value;
    }

    /**
     * Gets the value of the fieldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets the value of the fieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldName(String value) {
        this.fieldName = value;
    }

    /**
     * Gets the value of the isMetadataField property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsMetadataField() {
        return isMetadataField;
    }

    /**
     * Sets the value of the isMetadataField property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsMetadataField(Boolean value) {
        this.isMetadataField = value;
    }

    /**
     * Gets the value of the keywords property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToKeywordData }
     *     
     */
    public ArrayOfLinkToKeywordData getKeywords() {
        return keywords;
    }

    /**
     * Sets the value of the keywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToKeywordData }
     *     
     */
    public void setKeywords(ArrayOfLinkToKeywordData value) {
        this.keywords = value;
    }

    /**
     * Gets the value of the xPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXPath() {
        return xPath;
    }

    /**
     * Sets the value of the xPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXPath(String value) {
        this.xPath = value;
    }

}
