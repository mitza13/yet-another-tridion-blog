
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.UserData;


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
 *         &lt;element name="GetCurrentUserResult" type="{http://www.sdltridion.com/ContentManager/R6}UserData" minOccurs="0"/>
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
    "getCurrentUserResult"
})
@XmlRootElement(name = "GetCurrentUserResponse")
public class GetCurrentUserResponse {

    @XmlElement(name = "GetCurrentUserResult", nillable = true)
    protected UserData getCurrentUserResult;

    /**
     * Gets the value of the getCurrentUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link UserData }
     *     
     */
    public UserData getGetCurrentUserResult() {
        return getCurrentUserResult;
    }

    /**
     * Sets the value of the getCurrentUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserData }
     *     
     */
    public void setGetCurrentUserResult(UserData value) {
        this.getCurrentUserResult = value;
    }

}
