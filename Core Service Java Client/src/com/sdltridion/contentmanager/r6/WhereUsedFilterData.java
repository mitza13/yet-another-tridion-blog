
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WhereUsedFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WhereUsedFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SubjectRelatedListFilterData">
 *       &lt;sequence>
 *         &lt;element name="InRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
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
@XmlType(name = "WhereUsedFilterData", propOrder = {
    "inRepository",
    "itemTypes"
})
@XmlSeeAlso({
    UsedItemsFilterData.class,
    UsingItemsFilterData.class
})
public class WhereUsedFilterData
    extends SubjectRelatedListFilterData
{

    @XmlElement(name = "InRepository", nillable = true)
    protected LinkToRepositoryData inRepository;
    @XmlElement(name = "ItemTypes", nillable = true)
    protected ArrayOfItemType itemTypes;

    /**
     * Gets the value of the inRepository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getInRepository() {
        return inRepository;
    }

    /**
     * Sets the value of the inRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setInRepository(LinkToRepositoryData value) {
        this.inRepository = value;
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
