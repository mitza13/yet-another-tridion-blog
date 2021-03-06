
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfIdentifiableObjectData;


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
 *         &lt;element name="GetSystemWideListResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfIdentifiableObjectData" minOccurs="0"/>
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
    "getSystemWideListResult"
})
@XmlRootElement(name = "GetSystemWideListResponse")
public class GetSystemWideListResponse {

    @XmlElement(name = "GetSystemWideListResult", nillable = true)
    protected ArrayOfIdentifiableObjectData getSystemWideListResult;

    /**
     * Gets the value of the getSystemWideListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIdentifiableObjectData }
     *     
     */
    public ArrayOfIdentifiableObjectData getGetSystemWideListResult() {
        return getSystemWideListResult;
    }

    /**
     * Sets the value of the getSystemWideListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIdentifiableObjectData }
     *     
     */
    public void setGetSystemWideListResult(ArrayOfIdentifiableObjectData value) {
        this.getSystemWideListResult = value;
    }

}
