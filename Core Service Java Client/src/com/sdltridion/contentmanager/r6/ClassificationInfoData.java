
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClassificationInfoData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassificationInfoData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfClassificationDetailData" minOccurs="0"/>
 *         &lt;element name="Item" type="{http://www.sdltridion.com/ContentManager/R6}RepositoryLocalObjectData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassificationInfoData", propOrder = {
    "details",
    "item"
})
public class ClassificationInfoData {

    @XmlElement(name = "Details", nillable = true)
    protected ArrayOfClassificationDetailData details;
    @XmlElement(name = "Item", nillable = true)
    protected RepositoryLocalObjectData item;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClassificationDetailData }
     *     
     */
    public ArrayOfClassificationDetailData getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClassificationDetailData }
     *     
     */
    public void setDetails(ArrayOfClassificationDetailData value) {
        this.details = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link RepositoryLocalObjectData }
     *     
     */
    public RepositoryLocalObjectData getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepositoryLocalObjectData }
     *     
     */
    public void setItem(RepositoryLocalObjectData value) {
        this.item = value;
    }

}
