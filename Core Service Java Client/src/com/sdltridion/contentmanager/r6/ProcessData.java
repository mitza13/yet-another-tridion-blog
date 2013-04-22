
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WorkflowObjectData">
 *       &lt;sequence>
 *         &lt;element name="Activities" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfActivityData" minOccurs="0"/>
 *         &lt;element name="HasSnapshots" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Subjects" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToIdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="Creator" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="WorkflowType" type="{http://www.sdltridion.com/ContentManager/R6}LinkToWorkflowTypeData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessData", propOrder = {
    "activities",
    "hasSnapshots",
    "subjects",
    "creator",
    "workflowType"
})
@XmlSeeAlso({
    ProcessHistoryData.class,
    ProcessInstanceData.class
})
public class ProcessData
    extends WorkflowObjectData
{

    @XmlElement(name = "Activities", nillable = true)
    protected ArrayOfActivityData activities;
    @XmlElement(name = "HasSnapshots", nillable = true)
    protected Boolean hasSnapshots;
    @XmlElement(name = "Subjects", nillable = true)
    protected ArrayOfLinkToIdentifiableObjectData subjects;
    @XmlElement(name = "Creator", nillable = true)
    protected LinkToUserData creator;
    @XmlElement(name = "WorkflowType", nillable = true)
    protected LinkToWorkflowTypeData workflowType;

    /**
     * Gets the value of the activities property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfActivityData }
     *     
     */
    public ArrayOfActivityData getActivities() {
        return activities;
    }

    /**
     * Sets the value of the activities property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfActivityData }
     *     
     */
    public void setActivities(ArrayOfActivityData value) {
        this.activities = value;
    }

    /**
     * Gets the value of the hasSnapshots property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasSnapshots() {
        return hasSnapshots;
    }

    /**
     * Sets the value of the hasSnapshots property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasSnapshots(Boolean value) {
        this.hasSnapshots = value;
    }

    /**
     * Gets the value of the subjects property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToIdentifiableObjectData }
     *     
     */
    public ArrayOfLinkToIdentifiableObjectData getSubjects() {
        return subjects;
    }

    /**
     * Sets the value of the subjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToIdentifiableObjectData }
     *     
     */
    public void setSubjects(ArrayOfLinkToIdentifiableObjectData value) {
        this.subjects = value;
    }

    /**
     * Gets the value of the creator property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setCreator(LinkToUserData value) {
        this.creator = value;
    }

    /**
     * Gets the value of the workflowType property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToWorkflowTypeData }
     *     
     */
    public LinkToWorkflowTypeData getWorkflowType() {
        return workflowType;
    }

    /**
     * Sets the value of the workflowType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToWorkflowTypeData }
     *     
     */
    public void setWorkflowType(LinkToWorkflowTypeData value) {
        this.workflowType = value;
    }

}
