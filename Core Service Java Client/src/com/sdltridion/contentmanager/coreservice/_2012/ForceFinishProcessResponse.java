
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ProcessHistoryData;


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
 *         &lt;element name="ForceFinishProcessResult" type="{http://www.sdltridion.com/ContentManager/R6}ProcessHistoryData" minOccurs="0"/>
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
    "forceFinishProcessResult"
})
@XmlRootElement(name = "ForceFinishProcessResponse")
public class ForceFinishProcessResponse {

    @XmlElement(name = "ForceFinishProcessResult", nillable = true)
    protected ProcessHistoryData forceFinishProcessResult;

    /**
     * Gets the value of the forceFinishProcessResult property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessHistoryData }
     *     
     */
    public ProcessHistoryData getForceFinishProcessResult() {
        return forceFinishProcessResult;
    }

    /**
     * Sets the value of the forceFinishProcessResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessHistoryData }
     *     
     */
    public void setForceFinishProcessResult(ProcessHistoryData value) {
        this.forceFinishProcessResult = value;
    }

}
