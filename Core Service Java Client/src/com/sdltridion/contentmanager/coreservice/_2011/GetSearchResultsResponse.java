
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
 *         &lt;element name="GetSearchResultsResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfIdentifiableObjectData" minOccurs="0"/>
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
    "getSearchResultsResult"
})
@XmlRootElement(name = "GetSearchResultsResponse")
public class GetSearchResultsResponse {

    @XmlElement(name = "GetSearchResultsResult", nillable = true)
    protected ArrayOfIdentifiableObjectData getSearchResultsResult;

    /**
     * Gets the value of the getSearchResultsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIdentifiableObjectData }
     *     
     */
    public ArrayOfIdentifiableObjectData getGetSearchResultsResult() {
        return getSearchResultsResult;
    }

    /**
     * Sets the value of the getSearchResultsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIdentifiableObjectData }
     *     
     */
    public void setGetSearchResultsResult(ArrayOfIdentifiableObjectData value) {
        this.getSearchResultsResult = value;
    }

}
