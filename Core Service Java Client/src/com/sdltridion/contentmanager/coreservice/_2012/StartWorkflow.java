
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ReadOptions;
import com.sdltridion.contentmanager.r6.StartWorkflowInstructionData;


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
 *         &lt;element name="repositoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="instruction" type="{http://www.sdltridion.com/ContentManager/R6}StartWorkflowInstructionData" minOccurs="0"/>
 *         &lt;element name="readBackOptions" type="{http://www.sdltridion.com/ContentManager/R6}ReadOptions" minOccurs="0"/>
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
    "repositoryId",
    "instruction",
    "readBackOptions"
})
@XmlRootElement(name = "StartWorkflow")
public class StartWorkflow {

    @XmlElement(nillable = true)
    protected String repositoryId;
    @XmlElement(nillable = true)
    protected StartWorkflowInstructionData instruction;
    @XmlElement(nillable = true)
    protected ReadOptions readBackOptions;

    /**
     * Gets the value of the repositoryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepositoryId() {
        return repositoryId;
    }

    /**
     * Sets the value of the repositoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepositoryId(String value) {
        this.repositoryId = value;
    }

    /**
     * Gets the value of the instruction property.
     * 
     * @return
     *     possible object is
     *     {@link StartWorkflowInstructionData }
     *     
     */
    public StartWorkflowInstructionData getInstruction() {
        return instruction;
    }

    /**
     * Sets the value of the instruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartWorkflowInstructionData }
     *     
     */
    public void setInstruction(StartWorkflowInstructionData value) {
        this.instruction = value;
    }

    /**
     * Gets the value of the readBackOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ReadOptions }
     *     
     */
    public ReadOptions getReadBackOptions() {
        return readBackOptions;
    }

    /**
     * Sets the value of the readBackOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadOptions }
     *     
     */
    public void setReadBackOptions(ReadOptions value) {
        this.readBackOptions = value;
    }

}
