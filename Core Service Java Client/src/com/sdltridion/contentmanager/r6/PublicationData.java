
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublicationData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublicationData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}RepositoryData">
 *       &lt;sequence>
 *         &lt;element name="ComponentSnapshotTemplate" type="{http://www.sdltridion.com/ContentManager/R6}LinkToComponentTemplateData" minOccurs="0"/>
 *         &lt;element name="ComponentTemplateProcess" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *         &lt;element name="DefaultComponentTemplate" type="{http://www.sdltridion.com/ContentManager/R6}LinkToComponentTemplateData" minOccurs="0"/>
 *         &lt;element name="DefaultPageTemplate" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPageTemplateData" minOccurs="0"/>
 *         &lt;element name="DefaultTemplateBuildingBlock" type="{http://www.sdltridion.com/ContentManager/R6}LinkToTemplateBuildingBlockData" minOccurs="0"/>
 *         &lt;element name="MultimediaPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MultimediaUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PageSnapshotTemplate" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPageTemplateData" minOccurs="0"/>
 *         &lt;element name="PageTemplateProcess" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *         &lt;element name="PublicationPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicationUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RootStructureGroup" type="{http://www.sdltridion.com/ContentManager/R6}LinkToStructureGroupData" minOccurs="0"/>
 *         &lt;element name="ShareProcessAssociations" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicationData", propOrder = {
    "componentSnapshotTemplate",
    "componentTemplateProcess",
    "defaultComponentTemplate",
    "defaultPageTemplate",
    "defaultTemplateBuildingBlock",
    "multimediaPath",
    "multimediaUrl",
    "pageSnapshotTemplate",
    "pageTemplateProcess",
    "publicationPath",
    "publicationType",
    "publicationUrl",
    "rootStructureGroup",
    "shareProcessAssociations"
})
@XmlSeeAlso({
    BluePrintNodeData.class
})
public class PublicationData
    extends RepositoryData
{

    @XmlElement(name = "ComponentSnapshotTemplate", nillable = true)
    protected LinkToComponentTemplateData componentSnapshotTemplate;
    @XmlElement(name = "ComponentTemplateProcess", nillable = true)
    protected LinkToProcessDefinitionData componentTemplateProcess;
    @XmlElement(name = "DefaultComponentTemplate", nillable = true)
    protected LinkToComponentTemplateData defaultComponentTemplate;
    @XmlElement(name = "DefaultPageTemplate", nillable = true)
    protected LinkToPageTemplateData defaultPageTemplate;
    @XmlElement(name = "DefaultTemplateBuildingBlock", nillable = true)
    protected LinkToTemplateBuildingBlockData defaultTemplateBuildingBlock;
    @XmlElement(name = "MultimediaPath", nillable = true)
    protected String multimediaPath;
    @XmlElement(name = "MultimediaUrl", nillable = true)
    protected String multimediaUrl;
    @XmlElement(name = "PageSnapshotTemplate", nillable = true)
    protected LinkToPageTemplateData pageSnapshotTemplate;
    @XmlElement(name = "PageTemplateProcess", nillable = true)
    protected LinkToProcessDefinitionData pageTemplateProcess;
    @XmlElement(name = "PublicationPath", nillable = true)
    protected String publicationPath;
    @XmlElement(name = "PublicationType", nillable = true)
    protected String publicationType;
    @XmlElement(name = "PublicationUrl", nillable = true)
    protected String publicationUrl;
    @XmlElement(name = "RootStructureGroup", nillable = true)
    protected LinkToStructureGroupData rootStructureGroup;
    @XmlElement(name = "ShareProcessAssociations", nillable = true)
    protected Boolean shareProcessAssociations;

    /**
     * Gets the value of the componentSnapshotTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToComponentTemplateData }
     *     
     */
    public LinkToComponentTemplateData getComponentSnapshotTemplate() {
        return componentSnapshotTemplate;
    }

    /**
     * Sets the value of the componentSnapshotTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToComponentTemplateData }
     *     
     */
    public void setComponentSnapshotTemplate(LinkToComponentTemplateData value) {
        this.componentSnapshotTemplate = value;
    }

    /**
     * Gets the value of the componentTemplateProcess property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public LinkToProcessDefinitionData getComponentTemplateProcess() {
        return componentTemplateProcess;
    }

    /**
     * Sets the value of the componentTemplateProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public void setComponentTemplateProcess(LinkToProcessDefinitionData value) {
        this.componentTemplateProcess = value;
    }

    /**
     * Gets the value of the defaultComponentTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToComponentTemplateData }
     *     
     */
    public LinkToComponentTemplateData getDefaultComponentTemplate() {
        return defaultComponentTemplate;
    }

    /**
     * Sets the value of the defaultComponentTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToComponentTemplateData }
     *     
     */
    public void setDefaultComponentTemplate(LinkToComponentTemplateData value) {
        this.defaultComponentTemplate = value;
    }

    /**
     * Gets the value of the defaultPageTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToPageTemplateData }
     *     
     */
    public LinkToPageTemplateData getDefaultPageTemplate() {
        return defaultPageTemplate;
    }

    /**
     * Sets the value of the defaultPageTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToPageTemplateData }
     *     
     */
    public void setDefaultPageTemplate(LinkToPageTemplateData value) {
        this.defaultPageTemplate = value;
    }

    /**
     * Gets the value of the defaultTemplateBuildingBlock property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToTemplateBuildingBlockData }
     *     
     */
    public LinkToTemplateBuildingBlockData getDefaultTemplateBuildingBlock() {
        return defaultTemplateBuildingBlock;
    }

    /**
     * Sets the value of the defaultTemplateBuildingBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToTemplateBuildingBlockData }
     *     
     */
    public void setDefaultTemplateBuildingBlock(LinkToTemplateBuildingBlockData value) {
        this.defaultTemplateBuildingBlock = value;
    }

    /**
     * Gets the value of the multimediaPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMultimediaPath() {
        return multimediaPath;
    }

    /**
     * Sets the value of the multimediaPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMultimediaPath(String value) {
        this.multimediaPath = value;
    }

    /**
     * Gets the value of the multimediaUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMultimediaUrl() {
        return multimediaUrl;
    }

    /**
     * Sets the value of the multimediaUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMultimediaUrl(String value) {
        this.multimediaUrl = value;
    }

    /**
     * Gets the value of the pageSnapshotTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToPageTemplateData }
     *     
     */
    public LinkToPageTemplateData getPageSnapshotTemplate() {
        return pageSnapshotTemplate;
    }

    /**
     * Sets the value of the pageSnapshotTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToPageTemplateData }
     *     
     */
    public void setPageSnapshotTemplate(LinkToPageTemplateData value) {
        this.pageSnapshotTemplate = value;
    }

    /**
     * Gets the value of the pageTemplateProcess property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public LinkToProcessDefinitionData getPageTemplateProcess() {
        return pageTemplateProcess;
    }

    /**
     * Sets the value of the pageTemplateProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public void setPageTemplateProcess(LinkToProcessDefinitionData value) {
        this.pageTemplateProcess = value;
    }

    /**
     * Gets the value of the publicationPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationPath() {
        return publicationPath;
    }

    /**
     * Sets the value of the publicationPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationPath(String value) {
        this.publicationPath = value;
    }

    /**
     * Gets the value of the publicationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationType() {
        return publicationType;
    }

    /**
     * Sets the value of the publicationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationType(String value) {
        this.publicationType = value;
    }

    /**
     * Gets the value of the publicationUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationUrl() {
        return publicationUrl;
    }

    /**
     * Sets the value of the publicationUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationUrl(String value) {
        this.publicationUrl = value;
    }

    /**
     * Gets the value of the rootStructureGroup property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToStructureGroupData }
     *     
     */
    public LinkToStructureGroupData getRootStructureGroup() {
        return rootStructureGroup;
    }

    /**
     * Sets the value of the rootStructureGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToStructureGroupData }
     *     
     */
    public void setRootStructureGroup(LinkToStructureGroupData value) {
        this.rootStructureGroup = value;
    }

    /**
     * Gets the value of the shareProcessAssociations property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShareProcessAssociations() {
        return shareProcessAssociations;
    }

    /**
     * Sets the value of the shareProcessAssociations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShareProcessAssociations(Boolean value) {
        this.shareProcessAssociations = value;
    }

}
