
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}VersionedItemData">
 *       &lt;sequence>
 *         &lt;element name="ApprovalStatus" type="{http://www.sdltridion.com/ContentManager/R6}LinkToApprovalStatusData" minOccurs="0"/>
 *         &lt;element name="ComponentPresentations" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfComponentPresentationData" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsPageTemplateInherited" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PageTemplate" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPageTemplateData" minOccurs="0"/>
 *         &lt;element name="WorkflowInfo" type="{http://www.sdltridion.com/ContentManager/R6}WorkflowInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageData", propOrder = {
    "approvalStatus",
    "componentPresentations",
    "fileName",
    "isPageTemplateInherited",
    "pageTemplate",
    "workflowInfo"
})
public class PageData
    extends VersionedItemData
{

    @XmlElement(name = "ApprovalStatus", nillable = true)
    protected LinkToApprovalStatusData approvalStatus;
    @XmlElement(name = "ComponentPresentations", nillable = true)
    protected ArrayOfComponentPresentationData componentPresentations;
    @XmlElement(name = "FileName", nillable = true)
    protected String fileName;
    @XmlElement(name = "IsPageTemplateInherited", nillable = true)
    protected Boolean isPageTemplateInherited;
    @XmlElement(name = "PageTemplate", nillable = true)
    protected LinkToPageTemplateData pageTemplate;
    @XmlElement(name = "WorkflowInfo", nillable = true)
    protected WorkflowInfo workflowInfo;

    /**
     * Gets the value of the approvalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToApprovalStatusData }
     *     
     */
    public LinkToApprovalStatusData getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * Sets the value of the approvalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToApprovalStatusData }
     *     
     */
    public void setApprovalStatus(LinkToApprovalStatusData value) {
        this.approvalStatus = value;
    }

    /**
     * Gets the value of the componentPresentations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfComponentPresentationData }
     *     
     */
    public ArrayOfComponentPresentationData getComponentPresentations() {
        return componentPresentations;
    }

    /**
     * Sets the value of the componentPresentations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfComponentPresentationData }
     *     
     */
    public void setComponentPresentations(ArrayOfComponentPresentationData value) {
        this.componentPresentations = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the isPageTemplateInherited property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPageTemplateInherited() {
        return isPageTemplateInherited;
    }

    /**
     * Sets the value of the isPageTemplateInherited property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPageTemplateInherited(Boolean value) {
        this.isPageTemplateInherited = value;
    }

    /**
     * Gets the value of the pageTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToPageTemplateData }
     *     
     */
    public LinkToPageTemplateData getPageTemplate() {
        return pageTemplate;
    }

    /**
     * Sets the value of the pageTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToPageTemplateData }
     *     
     */
    public void setPageTemplate(LinkToPageTemplateData value) {
        this.pageTemplate = value;
    }

    /**
     * Gets the value of the workflowInfo property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowInfo }
     *     
     */
    public WorkflowInfo getWorkflowInfo() {
        return workflowInfo;
    }

    /**
     * Sets the value of the workflowInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowInfo }
     *     
     */
    public void setWorkflowInfo(WorkflowInfo value) {
        this.workflowInfo = value;
    }

}
