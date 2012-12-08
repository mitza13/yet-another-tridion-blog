
package com.sdltridion.contentmanager.coreservice._2011;

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
 *         &lt;element name="GetListResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfIdentifiableObjectData" minOccurs="0"/>
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
    "getListResult"
})
@XmlRootElement(name = "GetListResponse")
public class GetListResponse {

    @XmlElement(name = "GetListResult", nillable = true)
    protected ArrayOfIdentifiableObjectData getListResult;

    /**
     * Gets the value of the getListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIdentifiableObjectData }
     *     
     */
    public ArrayOfIdentifiableObjectData getGetListResult() {
        return getListResult;
    }

    /**
     * Sets the value of the getListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIdentifiableObjectData }
     *     
     */
    public void setGetListResult(ArrayOfIdentifiableObjectData value) {
        this.getListResult = value;
    }

}
