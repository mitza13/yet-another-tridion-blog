
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.OrganizationalItemData;


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
 *         &lt;element name="UnlockResult" type="{http://www.sdltridion.com/ContentManager/R6}OrganizationalItemData" minOccurs="0"/>
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
    "unlockResult"
})
@XmlRootElement(name = "UnlockResponse")
public class UnlockResponse {

    @XmlElement(name = "UnlockResult", nillable = true)
    protected OrganizationalItemData unlockResult;

    /**
     * Gets the value of the unlockResult property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationalItemData }
     *     
     */
    public OrganizationalItemData getUnlockResult() {
        return unlockResult;
    }

    /**
     * Sets the value of the unlockResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationalItemData }
     *     
     */
    public void setUnlockResult(OrganizationalItemData value) {
        this.unlockResult = value;
    }

}
