
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfTridionEnumValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetEnumValuesResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfTridionEnumValue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getEnumValuesResult"
})
@XmlRootElement(name = "GetEnumValuesResponse")
public class GetEnumValuesResponse {

    @XmlElement(name = "GetEnumValuesResult", nillable = true)
    protected ArrayOfTridionEnumValue getEnumValuesResult;

    /**
     * Gets the value of the getEnumValuesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTridionEnumValue }
     *     
     */
    public ArrayOfTridionEnumValue getGetEnumValuesResult() {
        return getEnumValuesResult;
    }

    /**
     * Sets the value of the getEnumValuesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTridionEnumValue }
     *     
     */
    public void setGetEnumValuesResult(ArrayOfTridionEnumValue value) {
        this.getEnumValuesResult = value;
    }

}
