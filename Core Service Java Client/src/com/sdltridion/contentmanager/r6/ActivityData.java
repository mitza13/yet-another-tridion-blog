
package com.sdltridion.contentmanager.r6;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for ActivityData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WorkflowObjectData">
 *       &lt;sequence>
 *         &lt;element name="Assignee" type="{http://www.sdltridion.com/ContentManager/R6}LinkToTrusteeData" minOccurs="0"/>
 *         &lt;element name="FinishDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FinishMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Owner" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="Performers" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToUserData" minOccurs="0"/>
 *         &lt;element name="Position" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Process" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessData" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="SuspendDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="WorkItems" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfWorkItemData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityData", propOrder = {
    "assignee",
    "finishDate",
    "finishMessage",
    "owner",
    "performers",
    "position",
    "process",
    "startDate",
    "suspendDate",
    "workItems"
})
@XmlSeeAlso({
    ActivityInstanceData.class,
    ActivityHistoryData.class
})
public class ActivityData
    extends WorkflowObjectData
{

    @XmlElement(name = "Assignee", nillable = true)
    protected LinkToTrusteeData assignee;
    @XmlElement(name = "FinishDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date finishDate;
    @XmlElement(name = "FinishMessage", nillable = true)
    protected String finishMessage;
    @XmlElement(name = "Owner", nillable = true)
    protected LinkToUserData owner;
    @XmlElement(name = "Performers", nillable = true)
    protected ArrayOfLinkToUserData performers;
    @XmlElement(name = "Position", nillable = true)
    protected Integer position;
    @XmlElement(name = "Process", nillable = true)
    protected LinkToProcessData process;
    @XmlElement(name = "StartDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date startDate;
    @XmlElement(name = "SuspendDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date suspendDate;
    @XmlElement(name = "WorkItems", nillable = true)
    protected ArrayOfWorkItemData workItems;

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
     * Gets the value of the finishMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinishMessage() {
        return finishMessage;
    }

    /**
     * Sets the value of the finishMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinishMessage(String value) {
        this.finishMessage = value;
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
     * Gets the value of the performers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToUserData }
     *     
     */
    public ArrayOfLinkToUserData getPerformers() {
        return performers;
    }

    /**
     * Sets the value of the performers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToUserData }
     *     
     */
    public void setPerformers(ArrayOfLinkToUserData value) {
        this.performers = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPosition(Integer value) {
        this.position = value;
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
     * Gets the value of the suspendDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getSuspendDate() {
        return suspendDate;
    }

    /**
     * Sets the value of the suspendDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuspendDate(Date value) {
        this.suspendDate = value;
    }

    /**
     * Gets the value of the workItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWorkItemData }
     *     
     */
    public ArrayOfWorkItemData getWorkItems() {
        return workItems;
    }

    /**
     * Sets the value of the workItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWorkItemData }
     *     
     */
    public void setWorkItems(ArrayOfWorkItemData value) {
        this.workItems = value;
    }

}
