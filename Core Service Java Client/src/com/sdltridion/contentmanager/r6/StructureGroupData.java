
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StructureGroupData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StructureGroupData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}OrganizationalItemData">
 *       &lt;sequence>
 *         &lt;element name="DefaultPageTemplate" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPageTemplateData" minOccurs="0"/>
 *         &lt;element name="Directory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsActive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsActiveResolvedValue" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsDefaultPageTemplateInherited" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PageProcess" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructureGroupData", propOrder = {
    "defaultPageTemplate",
    "directory",
    "isActive",
    "isActiveResolvedValue",
    "isDefaultPageTemplateInherited",
    "pageProcess"
})
public class StructureGroupData
    extends OrganizationalItemData
{

    @XmlElement(name = "DefaultPageTemplate", nillable = true)
    protected LinkToPageTemplateData defaultPageTemplate;
    @XmlElement(name = "Directory", nillable = true)
    protected String directory;
    @XmlElement(name = "IsActive", nillable = true)
    protected Boolean isActive;
    @XmlElement(name = "IsActiveResolvedValue", nillable = true)
    protected Boolean isActiveResolvedValue;
    @XmlElement(name = "IsDefaultPageTemplateInherited", nillable = true)
    protected Boolean isDefaultPageTemplateInherited;
    @XmlElement(name = "PageProcess", nillable = true)
    protected LinkToProcessDefinitionData pageProcess;

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
     * Gets the value of the directory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * Sets the value of the directory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectory(String value) {
        this.directory = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsActive(Boolean value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the isActiveResolvedValue property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsActiveResolvedValue() {
        return isActiveResolvedValue;
    }

    /**
     * Sets the value of the isActiveResolvedValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsActiveResolvedValue(Boolean value) {
        this.isActiveResolvedValue = value;
    }

    /**
     * Gets the value of the isDefaultPageTemplateInherited property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDefaultPageTemplateInherited() {
        return isDefaultPageTemplateInherited;
    }

    /**
     * Sets the value of the isDefaultPageTemplateInherited property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDefaultPageTemplateInherited(Boolean value) {
        this.isDefaultPageTemplateInherited = value;
    }

    /**
     * Gets the value of the pageProcess property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public LinkToProcessDefinitionData getPageProcess() {
        return pageProcess;
    }

    /**
     * Sets the value of the pageProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public void setPageProcess(LinkToProcessDefinitionData value) {
        this.pageProcess = value;
    }

}
