
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublicationTargetData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublicationTargetData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}PublishingTargetData">
 *       &lt;sequence>
 *         &lt;element name="DefaultCodePage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Destinations" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfTargetDestinationData" minOccurs="0"/>
 *         &lt;element name="MinApprovalStatus" type="{http://www.sdltridion.com/ContentManager/R6}LinkToApprovalStatusData" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://www.sdltridion.com/ContentManager/R6}PublishPriority" minOccurs="0"/>
 *         &lt;element name="Publications" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToPublicationData" minOccurs="0"/>
 *         &lt;element name="TargetLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetTypes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToTargetTypeData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicationTargetData", propOrder = {
    "defaultCodePage",
    "destinations",
    "minApprovalStatus",
    "priority",
    "publications",
    "targetLanguage",
    "targetTypes"
})
public class PublicationTargetData
    extends PublishingTargetData
{

    @XmlElement(name = "DefaultCodePage", nillable = true)
    protected Integer defaultCodePage;
    @XmlElement(name = "Destinations", nillable = true)
    protected ArrayOfTargetDestinationData destinations;
    @XmlElement(name = "MinApprovalStatus", nillable = true)
    protected LinkToApprovalStatusData minApprovalStatus;
    @XmlElement(name = "Priority", nillable = true)
    protected PublishPriority priority;
    @XmlElement(name = "Publications", nillable = true)
    protected ArrayOfLinkToPublicationData publications;
    @XmlElement(name = "TargetLanguage", nillable = true)
    protected String targetLanguage;
    @XmlElement(name = "TargetTypes", nillable = true)
    protected ArrayOfLinkToTargetTypeData targetTypes;

    /**
     * Gets the value of the defaultCodePage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultCodePage() {
        return defaultCodePage;
    }

    /**
     * Sets the value of the defaultCodePage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultCodePage(Integer value) {
        this.defaultCodePage = value;
    }

    /**
     * Gets the value of the destinations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTargetDestinationData }
     *     
     */
    public ArrayOfTargetDestinationData getDestinations() {
        return destinations;
    }

    /**
     * Sets the value of the destinations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTargetDestinationData }
     *     
     */
    public void setDestinations(ArrayOfTargetDestinationData value) {
        this.destinations = value;
    }

    /**
     * Gets the value of the minApprovalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToApprovalStatusData }
     *     
     */
    public LinkToApprovalStatusData getMinApprovalStatus() {
        return minApprovalStatus;
    }

    /**
     * Sets the value of the minApprovalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToApprovalStatusData }
     *     
     */
    public void setMinApprovalStatus(LinkToApprovalStatusData value) {
        this.minApprovalStatus = value;
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
     * Gets the value of the publications property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToPublicationData }
     *     
     */
    public ArrayOfLinkToPublicationData getPublications() {
        return publications;
    }

    /**
     * Sets the value of the publications property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToPublicationData }
     *     
     */
    public void setPublications(ArrayOfLinkToPublicationData value) {
        this.publications = value;
    }

    /**
     * Gets the value of the targetLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetLanguage() {
        return targetLanguage;
    }

    /**
     * Sets the value of the targetLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetLanguage(String value) {
        this.targetLanguage = value;
    }

    /**
     * Gets the value of the targetTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToTargetTypeData }
     *     
     */
    public ArrayOfLinkToTargetTypeData getTargetTypes() {
        return targetTypes;
    }

    /**
     * Sets the value of the targetTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToTargetTypeData }
     *     
     */
    public void setTargetTypes(ArrayOfLinkToTargetTypeData value) {
        this.targetTypes = value;
    }

}
