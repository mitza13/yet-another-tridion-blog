
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CategoriesFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoriesFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}CategoryRelatedFilterData">
 *       &lt;sequence>
 *         &lt;element name="IsRoot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoriesFilterData", propOrder = {
    "isRoot"
})
public class CategoriesFilterData
    extends CategoryRelatedFilterData
{

    @XmlElement(name = "IsRoot", nillable = true)
    protected Boolean isRoot;

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

}
