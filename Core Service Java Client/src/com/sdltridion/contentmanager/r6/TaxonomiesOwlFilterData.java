
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxonomiesOwlFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxonomiesOwlFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}TaxonomiesFilterData">
 *       &lt;sequence>
 *         &lt;element name="RootCategories" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToCategoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxonomiesOwlFilterData", propOrder = {
    "rootCategories"
})
public class TaxonomiesOwlFilterData
    extends TaxonomiesFilterData
{

    @XmlElement(name = "RootCategories", nillable = true)
    protected ArrayOfLinkToCategoryData rootCategories;

    /**
     * Gets the value of the rootCategories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToCategoryData }
     *     
     */
    public ArrayOfLinkToCategoryData getRootCategories() {
        return rootCategories;
    }

    /**
     * Sets the value of the rootCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToCategoryData }
     *     
     */
    public void setRootCategories(ArrayOfLinkToCategoryData value) {
        this.rootCategories = value;
    }

}
