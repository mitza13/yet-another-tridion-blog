
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganizationalItemsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationalItemsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SubjectRelatedListFilterData">
 *       &lt;sequence>
 *         &lt;element name="ExcludeTrustees" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToTrusteeData" minOccurs="0"/>
 *         &lt;element name="IncludePathColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeRelativeWebDavUrlColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeTrustees" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToTrusteeData" minOccurs="0"/>
 *         &lt;element name="ItemTypes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfItemType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationalItemsFilterData", propOrder = {
    "excludeTrustees",
    "includePathColumn",
    "includeRelativeWebDavUrlColumn",
    "includeTrustees",
    "itemTypes"
})
public class OrganizationalItemsFilterData
    extends SubjectRelatedListFilterData
{

    @XmlElement(name = "ExcludeTrustees", nillable = true)
    protected ArrayOfLinkToTrusteeData excludeTrustees;
    @XmlElement(name = "IncludePathColumn", nillable = true)
    protected Boolean includePathColumn;
    @XmlElement(name = "IncludeRelativeWebDavUrlColumn", nillable = true)
    protected Boolean includeRelativeWebDavUrlColumn;
    @XmlElement(name = "IncludeTrustees", nillable = true)
    protected ArrayOfLinkToTrusteeData includeTrustees;
    @XmlElement(name = "ItemTypes", nillable = true)
    protected ArrayOfItemType itemTypes;

    /**
     * Gets the value of the excludeTrustees property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToTrusteeData }
     *     
     */
    public ArrayOfLinkToTrusteeData getExcludeTrustees() {
        return excludeTrustees;
    }

    /**
     * Sets the value of the excludeTrustees property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToTrusteeData }
     *     
     */
    public void setExcludeTrustees(ArrayOfLinkToTrusteeData value) {
        this.excludeTrustees = value;
    }

    /**
     * Gets the value of the includePathColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludePathColumn() {
        return includePathColumn;
    }

    /**
     * Sets the value of the includePathColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludePathColumn(Boolean value) {
        this.includePathColumn = value;
    }

    /**
     * Gets the value of the includeRelativeWebDavUrlColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeRelativeWebDavUrlColumn() {
        return includeRelativeWebDavUrlColumn;
    }

    /**
     * Sets the value of the includeRelativeWebDavUrlColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeRelativeWebDavUrlColumn(Boolean value) {
        this.includeRelativeWebDavUrlColumn = value;
    }

    /**
     * Gets the value of the includeTrustees property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToTrusteeData }
     *     
     */
    public ArrayOfLinkToTrusteeData getIncludeTrustees() {
        return includeTrustees;
    }

    /**
     * Sets the value of the includeTrustees property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToTrusteeData }
     *     
     */
    public void setIncludeTrustees(ArrayOfLinkToTrusteeData value) {
        this.includeTrustees = value;
    }

    /**
     * Gets the value of the itemTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItemType }
     *     
     */
    public ArrayOfItemType getItemTypes() {
        return itemTypes;
    }

    /**
     * Sets the value of the itemTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItemType }
     *     
     */
    public void setItemTypes(ArrayOfItemType value) {
        this.itemTypes = value;
    }

}
