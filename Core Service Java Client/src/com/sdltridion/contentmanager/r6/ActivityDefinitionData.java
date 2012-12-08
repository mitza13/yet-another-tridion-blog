
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActivityDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WorkflowObjectData">
 *       &lt;sequence>
 *         &lt;element name="Assignee" type="{http://www.sdltridion.com/ContentManager/R6}LinkToTrusteeData" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessDefinition" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityDefinitionData", propOrder = {
    "assignee",
    "description",
    "processDefinition"
})
@XmlSeeAlso({
    TridionActivityDefinitionData.class
})
public class ActivityDefinitionData
    extends WorkflowObjectData
{

    @XmlElement(name = "Assignee", nillable = true)
    protected LinkToTrusteeData assignee;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "ProcessDefinition", nillable = true)
    protected LinkToProcessDefinitionData processDefinition;

    /**
     * Gets the value of the assignee property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToTrusteeData }
     *     
     */
    public LinkToTrusteeData getAssignee() {
        return assignee;
    }

    /**
     * Sets the value of the assignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToTrusteeData }
     *     
     */
    public void setAssignee(LinkToTrusteeData value) {
        this.assignee = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the processDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public LinkToProcessDefinitionData getProcessDefinition() {
        return processDefinition;
    }

    /**
     * Sets the value of the processDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public void setProcessDefinition(LinkToProcessDefinitionData value) {
        this.processDefinition = value;
    }

}
