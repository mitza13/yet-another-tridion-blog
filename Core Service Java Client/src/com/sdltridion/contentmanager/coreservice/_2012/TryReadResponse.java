
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.IdentifiableObjectData;


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
 *         &lt;element name="TryReadResult" type="{http://www.sdltridion.com/ContentManager/R6}IdentifiableObjectData" minOccurs="0"/>
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
    "tryReadResult"
})
@XmlRootElement(name = "TryReadResponse")
public class TryReadResponse {

    @XmlElement(name = "TryReadResult", nillable = true)
    protected IdentifiableObjectData tryReadResult;

    /**
     * Gets the value of the tryReadResult property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifiableObjectData }
     *     
     */
    public IdentifiableObjectData getTryReadResult() {
        return tryReadResult;
    }

    /**
     * Sets the value of the tryReadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifiableObjectData }
     *     
     */
    public void setTryReadResult(IdentifiableObjectData value) {
        this.tryReadResult = value;
    }

}
