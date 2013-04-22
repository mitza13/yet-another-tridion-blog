
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for WorkflowInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkflowInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}Info">
 *       &lt;sequence>
 *         &lt;element name="ActivityDefinitionDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActivityInstance" type="{http://www.sdltridion.com/ContentManager/R6}LinkToActivityInstanceData" minOccurs="0"/>
 *         &lt;element name="Assignee" type="{http://www.sdltridion.com/ContentManager/R6}LinkToTrusteeData" minOccurs="0"/>
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FinishDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Performer" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="PreviousMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessInstance" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessInstanceData" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ActivityState" type="{http://www.sdltridion.com/ContentManager/R6}ActivityState" minOccurs="0"/>
 *         &lt;element name="ActivityConstraints" type="{http://www.sdltridion.com/ContentManager/R6}ActivityConstraints" minOccurs="0"/>
 *         &lt;element name="AssignmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowInfo", propOrder = {
    "activityDefinitionDescription",
    "activityInstance",
    "assignee",
    "creationDate",
    "finishDate",
    "performer",
    "previousMessage",
    "processInstance",
    "startDate",
    "activityState",
    "activityConstraints",
    "assignmentDate",
    "dueDate"
})
public class WorkflowInfo
    extends Info
{

    @XmlElement(name = "ActivityDefinitionDescription", nillable = true)
    protected String activityDefinitionDescription;
    @XmlElement(name = "ActivityInstance", nillable = true)
    protected LinkToActivityInstanceData activityInstance;
    @XmlElement(name = "Assignee", nillable = true)
    protected LinkToTrusteeData assignee;
    @XmlElement(name = "CreationDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date creationDate;
    @XmlElement(name = "FinishDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date finishDate;
    @XmlElement(name = "Performer", nillable = true)
    protected LinkToUserData performer;
    @XmlElement(name = "PreviousMessage", nillable = true)
    protected String previousMessage;
    @XmlElement(name = "ProcessInstance", nillable = true)
    protected LinkToProcessInstanceData processInstance;
    @XmlElement(name = "StartDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date startDate;
    @XmlList
    @XmlElement(name = "ActivityState", nillable = true)
    protected List<String> activityState;
    @XmlList
    @XmlElement(name = "ActivityConstraints", nillable = true)
    protected List<String> activityConstraints;
    @XmlElement(name = "AssignmentDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date assignmentDate;
    @XmlElement(name = "DueDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date dueDate;

    /**
     * Gets the value of the activityDefinitionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityDefinitionDescription() {
        return activityDefinitionDescription;
    }

    /**
     * Sets the value of the activityDefinitionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityDefinitionDescription(String value) {
        this.activityDefinitionDescription = value;
    }

    /**
     * Gets the value of the activityInstance property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToActivityInstanceData }
     *     
     */
    public LinkToActivityInstanceData getActivityInstance() {
        return activityInstance;
    }

    /**
     * Sets the value of the activityInstance property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToActivityInstanceData }
     *     
     */
    public void setActivityInstance(LinkToActivityInstanceData value) {
        this.activityInstance = value;
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
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(Date value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the finishDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * Sets the value of the finishDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinishDate(Date value) {
        this.finishDate = value;
    }

    /**
     * Gets the value of the performer property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getPerformer() {
        return performer;
    }

    /**
     * Sets the value of the performer property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setPerformer(LinkToUserData value) {
        this.performer = value;
    }

    /**
     * Gets the value of the previousMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousMessage() {
        return previousMessage;
    }

    /**
     * Sets the value of the previousMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousMessage(String value) {
        this.previousMessage = value;
    }

    /**
     * Gets the value of the processInstance property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessInstanceData }
     *     
     */
    public LinkToProcessInstanceData getProcessInstance() {
        return processInstance;
    }

    /**
     * Sets the value of the processInstance property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessInstanceData }
     *     
     */
    public void setProcessInstance(LinkToProcessInstanceData value) {
        this.processInstance = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(Date value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the activityState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activityState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActivityState() {
        if (activityState == null) {
            activityState = new ArrayList<String>();
        }
        return this.activityState;
    }

    /**
     * Gets the value of the activityConstraints property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activityConstraints property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityConstraints().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActivityConstraints() {
        if (activityConstraints == null) {
            activityConstraints = new ArrayList<String>();
        }
        return this.activityConstraints;
    }

    /**
     * Gets the value of the assignmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getAssignmentDate() {
        return assignmentDate;
    }

    /**
     * Sets the value of the assignmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignmentDate(Date value) {
        this.assignmentDate = value;
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

}
