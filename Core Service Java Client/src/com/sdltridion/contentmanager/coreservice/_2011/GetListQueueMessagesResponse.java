
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfQueueMessageData;


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
 *         &lt;element name="GetListQueueMessagesResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfQueueMessageData" minOccurs="0"/>
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
    "getListQueueMessagesResult"
})
@XmlRootElement(name = "GetListQueueMessagesResponse")
public class GetListQueueMessagesResponse {

    @XmlElement(name = "GetListQueueMessagesResult", nillable = true)
    protected ArrayOfQueueMessageData getListQueueMessagesResult;

    /**
     * Gets the value of the getListQueueMessagesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfQueueMessageData }
     *     
     */
    public ArrayOfQueueMessageData getGetListQueueMessagesResult() {
        return getListQueueMessagesResult;
    }

    /**
     * Sets the value of the getListQueueMessagesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfQueueMessageData }
     *     
     */
    public void setGetListQueueMessagesResult(ArrayOfQueueMessageData value) {
        this.getListQueueMessagesResult = value;
    }

}
