
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.SearchQueryData;


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
 *         &lt;element name="ConvertXmlToSearchQueryResult" type="{http://www.sdltridion.com/ContentManager/R6}SearchQueryData" minOccurs="0"/>
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
    "convertXmlToSearchQueryResult"
})
@XmlRootElement(name = "ConvertXmlToSearchQueryResponse")
public class ConvertXmlToSearchQueryResponse {

    @XmlElement(name = "ConvertXmlToSearchQueryResult", nillable = true)
    protected SearchQueryData convertXmlToSearchQueryResult;

    /**
     * Gets the value of the convertXmlToSearchQueryResult property.
     * 
     * @return
     *     possible object is
     *     {@link SearchQueryData }
     *     
     */
    public SearchQueryData getConvertXmlToSearchQueryResult() {
        return convertXmlToSearchQueryResult;
    }

    /**
     * Sets the value of the convertXmlToSearchQueryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchQueryData }
     *     
     */
    public void setConvertXmlToSearchQueryResult(SearchQueryData value) {
        this.convertXmlToSearchQueryResult = value;
    }

}
