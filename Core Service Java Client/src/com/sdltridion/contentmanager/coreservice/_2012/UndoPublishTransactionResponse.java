
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.PublishTransactionData;


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
 *         &lt;element name="UndoPublishTransactionResult" type="{http://www.sdltridion.com/ContentManager/R6}PublishTransactionData" minOccurs="0"/>
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
    "undoPublishTransactionResult"
})
@XmlRootElement(name = "UndoPublishTransactionResponse")
public class UndoPublishTransactionResponse {

    @XmlElement(name = "UndoPublishTransactionResult", nillable = true)
    protected PublishTransactionData undoPublishTransactionResult;

    /**
     * Gets the value of the undoPublishTransactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link PublishTransactionData }
     *     
     */
    public PublishTransactionData getUndoPublishTransactionResult() {
        return undoPublishTransactionResult;
    }

    /**
     * Sets the value of the undoPublishTransactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublishTransactionData }
     *     
     */
    public void setUndoPublishTransactionResult(PublishTransactionData value) {
        this.undoPublishTransactionResult = value;
    }

}
