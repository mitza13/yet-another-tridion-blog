
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublishContextData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublishContextData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessedItems" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfProcessedItemData" minOccurs="0"/>
 *         &lt;element name="Publication" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPublicationData" minOccurs="0"/>
 *         &lt;element name="PublicationTarget" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPublicationTargetData" minOccurs="0"/>
 *         &lt;element name="ResolvedItems" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfResolvedItemData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublishContextData", propOrder = {
    "processedItems",
    "publication",
    "publicationTarget",
    "resolvedItems"
})
public class PublishContextData {

    @XmlElement(name = "ProcessedItems", nillable = true)
    protected ArrayOfProcessedItemData processedItems;
    @XmlElement(name = "Publication", nillable = true)
    protected LinkToPublicationData publication;
    @XmlElement(name = "PublicationTarget", nillable = true)
    protected LinkToPublicationTargetData publicationTarget;
    @XmlElement(name = "ResolvedItems", nillable = true)
    protected ArrayOfResolvedItemData resolvedItems;

    /**
     * Gets the value of the processedItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProcessedItemData }
     *     
     */
    public ArrayOfProcessedItemData getProcessedItems() {
        return processedItems;
    }

    /**
     * Sets the value of the processedItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProcessedItemData }
     *     
     */
    public void setProcessedItems(ArrayOfProcessedItemData value) {
        this.processedItems = value;
    }

    /**
     * Gets the value of the publication property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToPublicationData }
     *     
     */
    public LinkToPublicationData getPublication() {
        return publication;
    }

    /**
     * Sets the value of the publication property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToPublicationData }
     *     
     */
    public void setPublication(LinkToPublicationData value) {
        this.publication = value;
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
     * Gets the value of the resolvedItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfResolvedItemData }
     *     
     */
    public ArrayOfResolvedItemData getResolvedItems() {
        return resolvedItems;
    }

    /**
     * Sets the value of the resolvedItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfResolvedItemData }
     *     
     */
    public void setResolvedItems(ArrayOfResolvedItemData value) {
        this.resolvedItems = value;
    }

}
