
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeywordData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeywordData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}RepositoryLocalObjectData">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsAbstract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsRoot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParentKeywords" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToKeywordData" minOccurs="0"/>
 *         &lt;element name="RelatedKeywords" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToKeywordData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeywordData", propOrder = {
    "description",
    "isAbstract",
    "isRoot",
    "key",
    "parentKeywords",
    "relatedKeywords"
})
public class KeywordData
    extends RepositoryLocalObjectData
{

    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "IsAbstract", nillable = true)
    protected Boolean isAbstract;
    @XmlElement(name = "IsRoot", nillable = true)
    protected Boolean isRoot;
    @XmlElement(name = "Key", nillable = true)
    protected String key;
    @XmlElement(name = "ParentKeywords", nillable = true)
    protected ArrayOfLinkToKeywordData parentKeywords;
    @XmlElement(name = "RelatedKeywords", nillable = true)
    protected ArrayOfLinkToKeywordData relatedKeywords;

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
     * Gets the value of the isAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAbstract() {
        return isAbstract;
    }

    /**
     * Sets the value of the isAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAbstract(Boolean value) {
        this.isAbstract = value;
    }

    /**
     * Gets the value of the isRoot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRoot() {
        return isRoot;
    }

    /**
     * Sets the value of the isRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRoot(Boolean value) {
        this.isRoot = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the parentKeywords property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToKeywordData }
     *     
     */
    public ArrayOfLinkToKeywordData getParentKeywords() {
        return parentKeywords;
    }

    /**
     * Sets the value of the parentKeywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToKeywordData }
     *     
     */
    public void setParentKeywords(ArrayOfLinkToKeywordData value) {
        this.parentKeywords = value;
    }

    /**
     * Gets the value of the relatedKeywords property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToKeywordData }
     *     
     */
    public ArrayOfLinkToKeywordData getRelatedKeywords() {
        return relatedKeywords;
    }

    /**
     * Sets the value of the relatedKeywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToKeywordData }
     *     
     */
    public void setRelatedKeywords(ArrayOfLinkToKeywordData value) {
        this.relatedKeywords = value;
    }

}
