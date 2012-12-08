
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ActionFlags;


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
 *         &lt;element name="CastActionsResult" type="{http://www.sdltridion.com/ContentManager/R6}ActionFlags" minOccurs="0"/>
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
    "castActionsResult"
})
@XmlRootElement(name = "CastActionsResponse")
public class CastActionsResponse {

    @XmlElement(name = "CastActionsResult", nillable = true)
    protected ActionFlags castActionsResult;

    /**
     * Gets the value of the castActionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ActionFlags }
     *     
     */
    public ActionFlags getCastActionsResult() {
        return castActionsResult;
    }

    /**
     * Sets the value of the castActionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionFlags }
     *     
     */
    public void setCastActionsResult(ActionFlags value) {
        this.castActionsResult = value;
    }

}
