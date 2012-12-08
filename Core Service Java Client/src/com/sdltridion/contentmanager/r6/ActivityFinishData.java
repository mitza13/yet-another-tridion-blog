
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActivityFinishData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityFinishData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NextAssignee" type="{http://www.sdltridion.com/ContentManager/R6}LinkToTrusteeData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityFinishData", propOrder = {
    "message",
    "nextAssignee"
})
@XmlSeeAlso({
    DecisionActivityFinishData.class
})
public class ActivityFinishData {

    @XmlElement(name = "Message", nillable = true)
    protected String message;
    @XmlElement(name = "NextAssignee", nillable = true)
    protected LinkToTrusteeData nextAssignee;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the nextAssignee property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToTrusteeData }
     *     
     */
    public LinkToTrusteeData getNextAssignee() {
        return nextAssignee;
    }

    /**
     * Sets the value of the nextAssignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToTrusteeData }
     *     
     */
    public void setNextAssignee(LinkToTrusteeData value) {
        this.nextAssignee = value;
    }

}
