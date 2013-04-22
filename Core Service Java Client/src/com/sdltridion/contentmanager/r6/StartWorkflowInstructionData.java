
package com.sdltridion.contentmanager.r6;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for StartWorkflowInstructionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StartWorkflowInstructionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActivityTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Assignee" type="{http://www.sdltridion.com/ContentManager/R6}LinkToTrusteeData" minOccurs="0"/>
 *         &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ProcessDefinition" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *         &lt;element name="ProcessInstanceTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Subjects" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToIdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="WorkflowType" type="{http://www.sdltridion.com/ContentManager/R6}LinkToWorkflowTypeData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StartWorkflowInstructionData", propOrder = {
    "activityTitle",
    "assignee",
    "dueDate",
    "processDefinition",
    "processInstanceTitle",
    "subjects",
    "workflowType"
})
public class StartWorkflowInstructionData {

    @XmlElement(name = "ActivityTitle", nillable = true)
    protected String activityTitle;
    @XmlElement(name = "Assignee", nillable = true)
    protected LinkToTrusteeData assignee;
    @XmlElement(name = "DueDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date dueDate;
    @XmlElement(name = "ProcessDefinition", nillable = true)
    protected LinkToProcessDefinitionData processDefinition;
    @XmlElement(name = "ProcessInstanceTitle", nillable = true)
    protected String processInstanceTitle;
    @XmlElement(name = "Subjects", nillable = true)
    protected ArrayOfLinkToIdentifiableObjectData subjects;
    @XmlElement(name = "WorkflowType", nillable = true)
    protected LinkToWorkflowTypeData workflowType;

    /**
     * Gets the value of the activityTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityTitle() {
        return activityTitle;
    }

    /**
     * Sets the value of the activityTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityTitle(String value) {
        this.activityTitle = value;
    }

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
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDueDate(Date value) {
        this.dueDate = value;
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

    /**
     * Gets the value of the processInstanceTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessInstanceTitle() {
        return processInstanceTitle;
    }

    /**
     * Sets the value of the processInstanceTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessInstanceTitle(String value) {
        this.processInstanceTitle = value;
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
