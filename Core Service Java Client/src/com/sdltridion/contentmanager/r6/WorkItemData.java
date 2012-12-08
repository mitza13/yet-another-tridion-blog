
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
 *         &lt;element name="Subject" type="{http://www.sdltridion.com/ContentManager/R6}LinkToVersionedItemData" minOccurs="0"/>
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
    "subject"
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
    protected LinkToVersionedItemData subject;

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
     *     {@link LinkToVersionedItemData }
     *     
     */
    public LinkToVersionedItemData getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToVersionedItemData }
     *     
     */
    public void setSubject(LinkToVersionedItemData value) {
        this.subject = value;
    }

}
