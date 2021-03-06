
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfWeakLink;


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
 *         &lt;element name="activityInstanceLinks" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfWeakLink" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "activityInstanceLinks",
    "reason"
})
@XmlRootElement(name = "BatchSuspendActivity")
public class BatchSuspendActivity {

    @XmlElement(nillable = true)
    protected ArrayOfWeakLink activityInstanceLinks;
    @XmlElement(nillable = true)
    protected String reason;

    /**
     * Gets the value of the activityInstanceLinks property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWeakLink }
     *     
     */
    public ArrayOfWeakLink getActivityInstanceLinks() {
        return activityInstanceLinks;
    }

    /**
     * Sets the value of the activityInstanceLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWeakLink }
     *     
     */
    public void setActivityInstanceLinks(ArrayOfWeakLink value) {
        this.activityInstanceLinks = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

}
