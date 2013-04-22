
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.InstanceData;


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
 *         &lt;element name="GetInstanceDataResult" type="{http://www.sdltridion.com/ContentManager/R6}InstanceData" minOccurs="0"/>
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
    "getInstanceDataResult"
})
@XmlRootElement(name = "GetInstanceDataResponse")
public class GetInstanceDataResponse {

    @XmlElement(name = "GetInstanceDataResult", nillable = true)
    protected InstanceData getInstanceDataResult;

    /**
     * Gets the value of the getInstanceDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link InstanceData }
     *     
     */
    public InstanceData getGetInstanceDataResult() {
        return getInstanceDataResult;
    }

    /**
     * Sets the value of the getInstanceDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstanceData }
     *     
     */
    public void setGetInstanceDataResult(InstanceData value) {
        this.getInstanceDataResult = value;
    }

}
