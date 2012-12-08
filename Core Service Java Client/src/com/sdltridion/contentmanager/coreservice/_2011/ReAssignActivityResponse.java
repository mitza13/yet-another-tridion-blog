
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ActivityInstanceData;


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
 *         &lt;element name="ReAssignActivityResult" type="{http://www.sdltridion.com/ContentManager/R6}ActivityInstanceData" minOccurs="0"/>
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
    "reAssignActivityResult"
})
@XmlRootElement(name = "ReAssignActivityResponse")
public class ReAssignActivityResponse {

    @XmlElement(name = "ReAssignActivityResult", nillable = true)
    protected ActivityInstanceData reAssignActivityResult;

    /**
     * Gets the value of the reAssignActivityResult property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityInstanceData }
     *     
     */
    public ActivityInstanceData getReAssignActivityResult() {
        return reAssignActivityResult;
    }

    /**
     * Sets the value of the reAssignActivityResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityInstanceData }
     *     
     */
    public void setReAssignActivityResult(ActivityInstanceData value) {
        this.reAssignActivityResult = value;
    }

}
