
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Link complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Link">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdRef" type="{http://www.sdltridion.com/ContentManager/R6}TcmUri" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WebDavUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Link", propOrder = {
    "idRef",
    "title",
    "webDavUrl"
})
@XmlSeeAlso({
    LinkToComponentTemplateData.class,
    LinkToOrganizationalItemData.class,
    LinkToRepositoryLocalObjectData.class,
    LinkToVersionedItemData.class,
    LinkToStructureGroupData.class,
    LinkToTemplateData.class,
    LinkToPublicationTargetData.class,
    LinkToActivityInstanceData.class,
    LinkToUserData.class,
    LinkToGroupData.class,
    LinkToIdentifiableObjectData.class,
    LinkToMultimediaTypeData.class,
    LinkToCategoryData.class,
    LinkToTemplateBuildingBlockData.class,
    LinkToProcessInstanceData.class,
    LinkToProcessDefinitionData.class,
    LinkToApprovalStatusData.class,
    LinkToProcessData.class,
    LinkToActivityDefinitionData.class,
    LinkToFolderData.class,
    LinkToActivityData.class,
    LinkToSchemaData.class,
    LinkToKeywordData.class,
    LinkToTargetGroupData.class,
    LinkToComponentData.class,
    LinkToTridionActivityDefinitionData.class,
    LinkToTargetTypeData.class,
    LinkToPageTemplateData.class,
    LinkToTrusteeData.class,
    LinkToPublicationData.class,
    LinkToRepositoryData.class
})
public class Link {

    @XmlElement(name = "IdRef", nillable = true)
    protected String idRef;
    @XmlElement(name = "Title", nillable = true)
    protected String title;
    @XmlElement(name = "WebDavUrl", nillable = true)
    protected String webDavUrl;

    /**
     * Gets the value of the idRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdRef() {
        return idRef;
    }

    /**
     * Sets the value of the idRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdRef(String value) {
        this.idRef = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the webDavUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebDavUrl() {
        return webDavUrl;
    }

    /**
     * Sets the value of the webDavUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebDavUrl(String value) {
        this.webDavUrl = value;
    }

}
