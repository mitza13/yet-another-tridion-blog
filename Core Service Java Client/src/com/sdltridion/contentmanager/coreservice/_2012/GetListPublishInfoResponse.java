
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfPublishInfoData;


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
 *         &lt;element name="GetListPublishInfoResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfPublishInfoData" minOccurs="0"/>
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
    "getListPublishInfoResult"
})
@XmlRootElement(name = "GetListPublishInfoResponse")
public class GetListPublishInfoResponse {

    @XmlElement(name = "GetListPublishInfoResult", nillable = true)
    protected ArrayOfPublishInfoData getListPublishInfoResult;

    /**
     * Gets the value of the getListPublishInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPublishInfoData }
     *     
     */
    public ArrayOfPublishInfoData getGetListPublishInfoResult() {
        return getListPublishInfoResult;
    }

    /**
     * Sets the value of the getListPublishInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPublishInfoData }
     *     
     */
    public void setGetListPublishInfoResult(ArrayOfPublishInfoData value) {
        this.getListPublishInfoResult = value;
    }

}
