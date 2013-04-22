
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="GetSessionTransactionTimeoutResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "getSessionTransactionTimeoutResult"
})
@XmlRootElement(name = "GetSessionTransactionTimeoutResponse")
public class GetSessionTransactionTimeoutResponse {

    @XmlElement(name = "GetSessionTransactionTimeoutResult")
    protected Integer getSessionTransactionTimeoutResult;

    /**
     * Gets the value of the getSessionTransactionTimeoutResult property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGetSessionTransactionTimeoutResult() {
        return getSessionTransactionTimeoutResult;
    }

    /**
     * Sets the value of the getSessionTransactionTimeoutResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGetSessionTransactionTimeoutResult(Integer value) {
        this.getSessionTransactionTimeoutResult = value;
    }

}
