
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.PurgeOldVersionsInstructionData;


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
 *         &lt;element name="instruction" type="{http://www.sdltridion.com/ContentManager/R6}PurgeOldVersionsInstructionData" minOccurs="0"/>
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
    "instruction"
})
@XmlRootElement(name = "PurgeOldVersions")
public class PurgeOldVersions {

    @XmlElement(nillable = true)
    protected PurgeOldVersionsInstructionData instruction;

    /**
     * Gets the value of the instruction property.
     * 
     * @return
     *     possible object is
     *     {@link PurgeOldVersionsInstructionData }
     *     
     */
    public PurgeOldVersionsInstructionData getInstruction() {
        return instruction;
    }

    /**
     * Sets the value of the instruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurgeOldVersionsInstructionData }
     *     
     */
    public void setInstruction(PurgeOldVersionsInstructionData value) {
        this.instruction = value;
    }

}
