
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.PublishInstructionData;
import com.sdltridion.contentmanager.r6.RepositoryLocalObjectData;
import com.sdltridion.contentmanager.r6.TemplateData;


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
 *         &lt;element name="itemData" type="{http://www.sdltridion.com/ContentManager/R6}RepositoryLocalObjectData" minOccurs="0"/>
 *         &lt;element name="templateData" type="{http://www.sdltridion.com/ContentManager/R6}TemplateData" minOccurs="0"/>
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
    "itemData",
    "templateData",
    "publishInstruction",
    "publicationTargetId"
})
@XmlRootElement(name = "PreviewItem")
public class PreviewItem {

    @XmlElement(nillable = true)
    protected RepositoryLocalObjectData itemData;
    @XmlElement(nillable = true)
    protected TemplateData templateData;
    @XmlElement(nillable = true)
    protected PublishInstructionData publishInstruction;
    @XmlElement(nillable = true)
    protected String publicationTargetId;

    /**
     * Gets the value of the itemData property.
     * 
     * @return
     *     possible object is
     *     {@link RepositoryLocalObjectData }
     *     
     */
    public RepositoryLocalObjectData getItemData() {
        return itemData;
    }

    /**
     * Sets the value of the itemData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepositoryLocalObjectData }
     *     
     */
    public void setItemData(RepositoryLocalObjectData value) {
        this.itemData = value;
    }

    /**
     * Gets the value of the templateData property.
     * 
     * @return
     *     possible object is
     *     {@link TemplateData }
     *     
     */
    public TemplateData getTemplateData() {
        return templateData;
    }

    /**
     * Sets the value of the templateData property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateData }
     *     
     */
    public void setTemplateData(TemplateData value) {
        this.templateData = value;
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
