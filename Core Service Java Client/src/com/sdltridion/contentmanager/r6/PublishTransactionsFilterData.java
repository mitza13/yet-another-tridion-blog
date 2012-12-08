
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
 * <p>Java class for PublishTransactionsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublishTransactionsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}PublishingListFilterData">
 *       &lt;sequence>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ForRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://www.sdltridion.com/ContentManager/R6}PublishPriority" minOccurs="0"/>
 *         &lt;element name="PublicationTarget" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPublicationTargetData" minOccurs="0"/>
 *         &lt;element name="PublishTransactionState" type="{http://www.sdltridion.com/ContentManager/R6}PublishTransactionState" minOccurs="0"/>
 *         &lt;element name="PublishedBy" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublishTransactionsFilterData", propOrder = {
    "endDate",
    "forRepository",
    "priority",
    "publicationTarget",
    "publishTransactionState",
    "publishedBy",
    "startDate"
})
public class PublishTransactionsFilterData
    extends PublishingListFilterData
{

    @XmlElement(name = "EndDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date endDate;
    @XmlElement(name = "ForRepository", nillable = true)
    protected LinkToRepositoryData forRepository;
    @XmlElement(name = "Priority", nillable = true)
    protected PublishPriority priority;
    @XmlElement(name = "PublicationTarget", nillable = true)
    protected LinkToPublicationTargetData publicationTarget;
    @XmlElement(name = "PublishTransactionState", nillable = true)
    protected PublishTransactionState publishTransactionState;
    @XmlElement(name = "PublishedBy", nillable = true)
    protected LinkToUserData publishedBy;
    @XmlElement(name = "StartDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date startDate;

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(Date value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the forRepository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getForRepository() {
        return forRepository;
    }

    /**
     * Sets the value of the forRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setForRepository(LinkToRepositoryData value) {
        this.forRepository = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link PublishPriority }
     *     
     */
    public PublishPriority getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublishPriority }
     *     
     */
    public void setPriority(PublishPriority value) {
        this.priority = value;
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
     * Gets the value of the publishTransactionState property.
     * 
     * @return
     *     possible object is
     *     {@link PublishTransactionState }
     *     
     */
    public PublishTransactionState getPublishTransactionState() {
        return publishTransactionState;
    }

    /**
     * Sets the value of the publishTransactionState property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublishTransactionState }
     *     
     */
    public void setPublishTransactionState(PublishTransactionState value) {
        this.publishTransactionState = value;
    }

    /**
     * Gets the value of the publishedBy property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getPublishedBy() {
        return publishedBy;
    }

    /**
     * Sets the value of the publishedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setPublishedBy(LinkToUserData value) {
        this.publishedBy = value;
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

}
