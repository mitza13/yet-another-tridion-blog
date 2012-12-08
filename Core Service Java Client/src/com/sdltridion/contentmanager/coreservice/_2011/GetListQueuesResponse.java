
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfQueueData;


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
 *         &lt;element name="GetListQueuesResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfQueueData" minOccurs="0"/>
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
    "getListQueuesResult"
})
@XmlRootElement(name = "GetListQueuesResponse")
public class GetListQueuesResponse {

    @XmlElement(name = "GetListQueuesResult", nillable = true)
    protected ArrayOfQueueData getListQueuesResult;

    /**
     * Gets the value of the getListQueuesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfQueueData }
     *     
     */
    public ArrayOfQueueData getGetListQueuesResult() {
        return getListQueuesResult;
    }

    /**
     * Sets the value of the getListQueuesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfQueueData }
     *     
     */
    public void setGetListQueuesResult(ArrayOfQueueData value) {
        this.getListQueuesResult = value;
    }

}
