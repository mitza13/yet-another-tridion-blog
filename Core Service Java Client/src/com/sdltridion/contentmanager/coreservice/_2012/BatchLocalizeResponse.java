
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
 *         &lt;element name="BatchLocalizeResult" type="{http://www.sdltridion.com/ContentManager/R6}TcmUri" minOccurs="0"/>
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
    "batchLocalizeResult"
})
@XmlRootElement(name = "BatchLocalizeResponse")
public class BatchLocalizeResponse {

    @XmlElement(name = "BatchLocalizeResult", nillable = true)
    protected String batchLocalizeResult;

    /**
     * Gets the value of the batchLocalizeResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchLocalizeResult() {
        return batchLocalizeResult;
    }

    /**
     * Sets the value of the batchLocalizeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchLocalizeResult(String value) {
        this.batchLocalizeResult = value;
    }

}
