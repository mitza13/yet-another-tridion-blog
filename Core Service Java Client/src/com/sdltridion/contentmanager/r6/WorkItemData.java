
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkItemData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkItemData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WorkflowObjectData">
 *       &lt;sequence>
 *         &lt;element name="Activity" type="{http://www.sdltridion.com/ContentManager/R6}LinkToActivityData" minOccurs="0"/>
 *         &lt;element name="Owner" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="Process" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessData" minOccurs="0"/>
 *         &lt;element name="Subject" type="{http://www.sdltridion.com/ContentManager/R6}LinkToIdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubjectOwningRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkItemData", propOrder = {
    "activity",
    "owner",
    "process",
    "subject",
    "comment",
    "subjectOwningRepository"
})
public class WorkItemData
    extends WorkflowObjectData
{

    @XmlElement(name = "Activity", nillable = true)
    protected LinkToActivityData activity;
    @XmlElement(name = "Owner", nillable = true)
    protected LinkToUserData owner;
    @XmlElement(name = "Process", nillable = true)
    protected LinkToProcessData process;
    @XmlElement(name = "Subject", nillable = true)
    protected LinkToIdentifiableObjectData subject;
    @XmlElement(name = "Comment", nillable = true)
    protected String comment;
    @XmlElement(name = "SubjectOwningRepository", nillable = true)
    protected LinkToRepositoryData subjectOwningRepository;

    /**
     * Gets the value of the activity property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToActivityData }
     *     
     */
    public LinkToActivityData getActivity() {
        return activity;
    }

    /**
     * Sets the value of the activity property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToActivityData }
     *     
     */
    public void setActivity(LinkToActivityData value) {
        this.activity = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setOwner(LinkToUserData value) {
        this.owner = value;
    }

    /**
     * Gets the value of the process property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessData }
     *     
     */
    public LinkToProcessData getProcess() {
        return process;
    }

    /**
     * Sets the value of the process property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessData }
     *     
     */
    public void setProcess(LinkToProcessData value) {
        this.process = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public LinkToIdentifiableObjectData getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public void setSubject(LinkToIdentifiableObjectData value) {
        this.subject = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the subjectOwningRepository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getSubjectOwningRepository() {
        return subjectOwningRepository;
    }

    /**
     * Sets the value of the subjectOwningRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setSubjectOwningRepository(LinkToRepositoryData value) {
        this.subjectOwningRepository = value;
    }

}
