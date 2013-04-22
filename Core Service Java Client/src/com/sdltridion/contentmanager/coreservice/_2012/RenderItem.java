
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.PublishInstructionData;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="templateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publishInstruction" type="{http://www.sdltridion.com/ContentManager/R6}PublishInstructionData" minOccurs="0"/>
 *         &lt;element name="publicationTargetId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itemId",
    "templateId",
    "publishInstruction",
    "publicationTargetId"
})
@XmlRootElement(name = "RenderItem")
public class RenderItem {

    @XmlElement(nillable = true)
    protected String itemId;
    @XmlElement(nillable = true)
    protected String templateId;
    @XmlElement(nillable = true)
    protected PublishInstructionData publishInstruction;
    @XmlElement(nillable = true)
    protected String publicationTargetId;

    /**
     * Gets the value of the itemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemId(String value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the templateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * Sets the value of the templateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateId(String value) {
        this.templateId = value;
    }

    /**
     * Gets the value of the publishInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link PublishInstructionData }
     *     
     */
    public PublishInstructionData getPublishInstruction() {
        return publishInstruction;
    }

    /**
     * Sets the value of the publishInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublishInstructionData }
     *     
     */
    public void setPublishInstruction(PublishInstructionData value) {
        this.publishInstruction = value;
    }

    /**
     * Gets the value of the publicationTargetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationTargetId() {
        return publicationTargetId;
    }

    /**
     * Sets the value of the publicationTargetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationTargetId(String value) {
        this.publicationTargetId = value;
    }

}
