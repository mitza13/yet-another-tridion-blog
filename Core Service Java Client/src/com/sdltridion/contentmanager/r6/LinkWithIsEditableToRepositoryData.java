
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LinkWithIsEditableToRepositoryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LinkWithIsEditableToRepositoryData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData">
 *       &lt;sequence>
 *         &lt;element name="IsEditable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkWithIsEditableToRepositoryData", propOrder = {
    "isEditable"
})
public class LinkWithIsEditableToRepositoryData
    extends LinkToRepositoryData
{

    @XmlElement(name = "IsEditable", nillable = true)
    protected Boolean isEditable;

    /**
     * Gets the value of the isEditable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEditable() {
        return isEditable;
    }

    /**
     * Sets the value of the isEditable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEditable(Boolean value) {
        this.isEditable = value;
    }

}
