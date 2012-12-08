
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
 * <p>Java class for QueueMessageData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueueMessageData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Action" type="{http://www.sdltridion.com/ContentManager/R6}QueueMessageAction" minOccurs="0"/>
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CreationHostName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Item" type="{http://www.sdltridion.com/ContentManager/R6}LinkToIdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://www.sdltridion.com/ContentManager/R6}QueueMessagePriority" minOccurs="0"/>
 *         &lt;element name="ProcessingConsumerId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PublicationTarget" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPublicationTargetData" minOccurs="0"/>
 *         &lt;element name="QueueId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ScheduleDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueueMessageData", propOrder = {
    "action",
    "creationDate",
    "creationHostName",
    "id",
    "item",
    "priority",
    "processingConsumerId",
    "publicationTarget",
    "queueId",
    "scheduleDateTime"
})
public class QueueMessageData {

    @XmlElement(name = "Action", nillable = true)
    protected QueueMessageAction action;
    @XmlElement(name = "CreationDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date creationDate;
    @XmlElement(name = "CreationHostName", nillable = true)
    protected String creationHostName;
    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Item", nillable = true)
    protected LinkToIdentifiableObjectData item;
    @XmlElement(name = "Priority", nillable = true)
    protected QueueMessagePriority priority;
    @XmlElement(name = "ProcessingConsumerId", nillable = true)
    protected Integer processingConsumerId;
    @XmlElement(name = "PublicationTarget", nillable = true)
    protected LinkToPublicationTargetData publicationTarget;
    @XmlElement(name = "QueueId", nillable = true)
    protected Integer queueId;
    @XmlElement(name = "ScheduleDateTime", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date scheduleDateTime;

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link QueueMessageAction }
     *     
     */
    public QueueMessageAction getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueueMessageAction }
     *     
     */
    public void setAction(QueueMessageAction value) {
        this.action = value;
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
     * Gets the value of the creationHostName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationHostName() {
        return creationHostName;
    }

    /**
     * Sets the value of the creationHostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationHostName(String value) {
        this.creationHostName = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public LinkToIdentifiableObjectData getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public void setItem(LinkToIdentifiableObjectData value) {
        this.item = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link QueueMessagePriority }
     *     
     */
    public QueueMessagePriority getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueueMessagePriority }
     *     
     */
    public void setPriority(QueueMessagePriority value) {
        this.priority = value;
    }

    /**
     * Gets the value of the processingConsumerId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProcessingConsumerId() {
        return processingConsumerId;
    }

    /**
     * Sets the value of the processingConsumerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProcessingConsumerId(Integer value) {
        this.processingConsumerId = value;
    }

    /**
     * Gets the value of the publicationTarget property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToPublicationTargetData }
     *     
     */
    public LinkToPublicationTargetData getPublicationTarget() {
        return publicationTarget;
    }

    /**
     * Sets the value of the publicationTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToPublicationTargetData }
     *     
     */
    public void setPublicationTarget(LinkToPublicationTargetData value) {
        this.publicationTarget = value;
    }

    /**
     * Gets the value of the queueId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQueueId() {
        return queueId;
    }

    /**
     * Sets the value of the queueId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQueueId(Integer value) {
        this.queueId = value;
    }

    /**
     * Gets the value of the scheduleDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getScheduleDateTime() {
        return scheduleDateTime;
    }

    /**
     * Sets the value of the scheduleDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduleDateTime(Date value) {
        this.scheduleDateTime = value;
    }

}
