
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfPublishTransactionData;


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
 *         &lt;element name="UnPublishResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfPublishTransactionData" minOccurs="0"/>
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
    "unPublishResult"
})
@XmlRootElement(name = "UnPublishResponse")
public class UnPublishResponse {

    @XmlElement(name = "UnPublishResult", nillable = true)
    protected ArrayOfPublishTransactionData unPublishResult;

    /**
     * Gets the value of the unPublishResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPublishTransactionData }
     *     
     */
    public ArrayOfPublishTransactionData getUnPublishResult() {
        return unPublishResult;
    }

    /**
     * Sets the value of the unPublishResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPublishTransactionData }
     *     
     */
    public void setUnPublishResult(ArrayOfPublishTransactionData value) {
        this.unPublishResult = value;
    }

}
