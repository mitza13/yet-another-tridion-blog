
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxonomiesFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxonomiesFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SubjectRelatedListFilterData">
 *       &lt;sequence>
 *         &lt;element name="ForItems" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToRepositoryLocalObjectData" minOccurs="0"/>
 *         &lt;element name="UseForNavigation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxonomiesFilterData", propOrder = {
    "forItems",
    "useForNavigation"
})
@XmlSeeAlso({
    TaxonomiesOwlFilterData.class
})
public class TaxonomiesFilterData
    extends SubjectRelatedListFilterData
{

    @XmlElement(name = "ForItems", nillable = true)
    protected ArrayOfLinkToRepositoryLocalObjectData forItems;
    @XmlElement(name = "UseForNavigation", nillable = true)
    protected Boolean useForNavigation;

    /**
     * Gets the value of the forItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToRepositoryLocalObjectData }
     *     
     */
    public ArrayOfLinkToRepositoryLocalObjectData getForItems() {
        return forItems;
    }

    /**
     * Sets the value of the forItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToRepositoryLocalObjectData }
     *     
     */
    public void setForItems(ArrayOfLinkToRepositoryLocalObjectData value) {
        this.forItems = value;
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

}
