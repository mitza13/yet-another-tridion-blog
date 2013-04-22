
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
 *         &lt;element name="TryGetTcmUriResult" type="{http://www.sdltridion.com/ContentManager/R6}TcmUri" minOccurs="0"/>
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
    "tryGetTcmUriResult"
})
@XmlRootElement(name = "TryGetTcmUriResponse")
public class TryGetTcmUriResponse {

    @XmlElement(name = "TryGetTcmUriResult", nillable = true)
    protected String tryGetTcmUriResult;

    /**
     * Gets the value of the tryGetTcmUriResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTryGetTcmUriResult() {
        return tryGetTcmUriResult;
    }

    /**
     * Sets the value of the tryGetTcmUriResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTryGetTcmUriResult(String value) {
        this.tryGetTcmUriResult = value;
    }

}
