
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
 *         &lt;element name="GetSearchResultsPagedResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfIdentifiableObjectData" minOccurs="0"/>
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
    "getSearchResultsPagedResult"
})
@XmlRootElement(name = "GetSearchResultsPagedResponse")
public class GetSearchResultsPagedResponse {

    @XmlElement(name = "GetSearchResultsPagedResult", nillable = true)
    protected ArrayOfIdentifiableObjectData getSearchResultsPagedResult;

    /**
     * Gets the value of the getSearchResultsPagedResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIdentifiableObjectData }
     *     
     */
    public ArrayOfIdentifiableObjectData getGetSearchResultsPagedResult() {
        return getSearchResultsPagedResult;
    }

    /**
     * Sets the value of the getSearchResultsPagedResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIdentifiableObjectData }
     *     
     */
    public void setGetSearchResultsPagedResult(ArrayOfIdentifiableObjectData value) {
        this.getSearchResultsPagedResult = value;
    }

}
