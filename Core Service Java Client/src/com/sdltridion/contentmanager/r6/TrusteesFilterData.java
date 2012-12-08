
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrusteesFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrusteesFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideListFilterData">
 *       &lt;sequence>
 *         &lt;element name="IsPredefined" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ItemType" type="{http://www.sdltridion.com/ContentManager/R6}ItemType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrusteesFilterData", propOrder = {
    "isPredefined",
    "itemType"
})
@XmlSeeAlso({
    UsersFilterData.class,
    GroupsFilterData.class
})
public class TrusteesFilterData
    extends SystemWideListFilterData
{

    @XmlElement(name = "IsPredefined", nillable = true)
    protected Boolean isPredefined;
    @XmlElement(name = "ItemType", nillable = true)
    protected ItemType itemType;

    /**
     * Gets the value of the isPredefined property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPredefined() {
        return isPredefined;
    }

    /**
     * Sets the value of the isPredefined property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPredefined(Boolean value) {
        this.isPredefined = value;
    }

    /**
     * Gets the value of the itemType property.
     * 
     * @return
     *     possible object is
     *     {@link ItemType }
     *     
     */
    public ItemType getItemType() {
        return itemType;
    }

    /**
     * Sets the value of the itemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemType }
     *     
     */
    public void setItemType(ItemType value) {
        this.itemType = value;
    }

}
