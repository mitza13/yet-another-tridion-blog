
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeywordFieldDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeywordFieldDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ItemFieldDefinitionData">
 *       &lt;sequence>
 *         &lt;element name="Category" type="{http://www.sdltridion.com/ContentManager/R6}LinkToCategoryData"/>
 *         &lt;element name="DefaultValue" type="{http://www.sdltridion.com/ContentManager/R6}LinkToKeywordData" minOccurs="0"/>
 *         &lt;element name="List" type="{http://www.sdltridion.com/ContentManager/R6}ListDefinitionData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeywordFieldDefinitionData", propOrder = {
    "category",
    "defaultValue",
    "list"
})
public class KeywordFieldDefinitionData
    extends ItemFieldDefinitionData
{

    @XmlElement(name = "Category", required = true, nillable = true)
    protected LinkToCategoryData category;
    @XmlElement(name = "DefaultValue", nillable = true)
    protected LinkToKeywordData defaultValue;
    @XmlElement(name = "List", nillable = true)
    protected ListDefinitionData list;

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
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToKeywordData }
     *     
     */
    public LinkToKeywordData getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToKeywordData }
     *     
     */
    public void setDefaultValue(LinkToKeywordData value) {
        this.defaultValue = value;
    }

    /**
     * Gets the value of the list property.
     * 
     * @return
     *     possible object is
     *     {@link ListDefinitionData }
     *     
     */
    public ListDefinitionData getList() {
        return list;
    }

    /**
     * Sets the value of the list property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListDefinitionData }
     *     
     */
    public void setList(ListDefinitionData value) {
        this.list = value;
    }

}
