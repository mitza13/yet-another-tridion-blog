
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.QueueMessagePriority;
import com.sdltridion.contentmanager.r6.ReadOptions;


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
 *         &lt;element name="publishTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://www.sdltridion.com/ContentManager/R6}QueueMessagePriority" minOccurs="0"/>
 *         &lt;element name="readBackOptions" type="{http://www.sdltridion.com/ContentManager/R6}ReadOptions" minOccurs="0"/>
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
    "publishTransactionId",
    "priority",
    "readBackOptions"
})
@XmlRootElement(name = "UndoPublishTransaction")
public class UndoPublishTransaction {

    @XmlElement(nillable = true)
    protected String publishTransactionId;
    @XmlElement(nillable = true)
    protected QueueMessagePriority priority;
    @XmlElement(nillable = true)
    protected ReadOptions readBackOptions;

    /**
     * Gets the value of the publishTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublishTransactionId() {
        return publishTransactionId;
    }

    /**
     * Sets the value of the publishTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishTransactionId(String value) {
        this.publishTransactionId = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link QueueMessagePriority }
     *     
     */
    public QueueMessagePriority getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueueMessagePriority }
     *     
     */
    public void setPriority(QueueMessagePriority value) {
        this.priority = value;
    }

    /**
     * Gets the value of the readBackOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ReadOptions }
     *     
     */
    public ReadOptions getReadBackOptions() {
        return readBackOptions;
    }

    /**
     * Sets the value of the readBackOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadOptions }
     *     
     */
    public void setReadBackOptions(ReadOptions value) {
        this.readBackOptions = value;
    }

}
