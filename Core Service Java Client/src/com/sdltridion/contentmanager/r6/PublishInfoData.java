
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
 * <p>Java class for PublishInfoData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublishInfoData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}Info">
 *       &lt;sequence>
 *         &lt;element name="PublicationTarget" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPublicationTargetData" minOccurs="0"/>
 *         &lt;element name="PublishedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="RenderedWith" type="{http://www.sdltridion.com/ContentManager/R6}LinkToVersionedItemData" minOccurs="0"/>
 *         &lt;element name="Repository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="User" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublishInfoData", propOrder = {
    "publicationTarget",
    "publishedAt",
    "renderedWith",
    "repository",
    "user"
})
public class PublishInfoData
    extends Info
{

    @XmlElement(name = "PublicationTarget", nillable = true)
    protected LinkToPublicationTargetData publicationTarget;
    @XmlElement(name = "PublishedAt", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date publishedAt;
    @XmlElement(name = "RenderedWith", nillable = true)
    protected LinkToVersionedItemData renderedWith;
    @XmlElement(name = "Repository", nillable = true)
    protected LinkToRepositoryData repository;
    @XmlElement(name = "User", nillable = true)
    protected LinkToUserData user;

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
     * Gets the value of the publishedAt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getPublishedAt() {
        return publishedAt;
    }

    /**
     * Sets the value of the publishedAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishedAt(Date value) {
        this.publishedAt = value;
    }

    /**
     * Gets the value of the renderedWith property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToVersionedItemData }
     *     
     */
    public LinkToVersionedItemData getRenderedWith() {
        return renderedWith;
    }

    /**
     * Sets the value of the renderedWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToVersionedItemData }
     *     
     */
    public void setRenderedWith(LinkToVersionedItemData value) {
        this.renderedWith = value;
    }

    /**
     * Gets the value of the repository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getRepository() {
        return repository;
    }

    /**
     * Sets the value of the repository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setRepository(LinkToRepositoryData value) {
        this.repository = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setUser(LinkToUserData value) {
        this.user = value;
    }

}
