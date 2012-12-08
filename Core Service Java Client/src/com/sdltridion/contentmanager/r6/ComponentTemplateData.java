
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComponentTemplateData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComponentTemplateData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}TemplateData">
 *       &lt;sequence>
 *         &lt;element name="AllowOnPage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ApprovalStatus" type="{http://www.sdltridion.com/ContentManager/R6}LinkToApprovalStatusData" minOccurs="0"/>
 *         &lt;element name="DynamicTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsRepositoryPublishable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RelatedSchemas" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="TrackingCategories" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToCategoryData" minOccurs="0"/>
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
@XmlType(name = "ComponentTemplateData", propOrder = {
    "allowOnPage",
    "approvalStatus",
    "dynamicTemplate",
    "isRepositoryPublishable",
    "outputFormat",
    "priority",
    "relatedSchemas",
    "trackingCategories",
    "workflowInfo"
})
public class ComponentTemplateData
    extends TemplateData
{

    @XmlElement(name = "AllowOnPage", nillable = true)
    protected Boolean allowOnPage;
    @XmlElement(name = "ApprovalStatus", nillable = true)
    protected LinkToApprovalStatusData approvalStatus;
    @XmlElement(name = "DynamicTemplate", nillable = true)
    protected String dynamicTemplate;
    @XmlElement(name = "IsRepositoryPublishable", nillable = true)
    protected Boolean isRepositoryPublishable;
    @XmlElement(name = "OutputFormat", nillable = true)
    protected String outputFormat;
    @XmlElement(name = "Priority", nillable = true)
    protected Integer priority;
    @XmlElement(name = "RelatedSchemas", nillable = true)
    protected ArrayOfLinkToSchemaData relatedSchemas;
    @XmlElement(name = "TrackingCategories", nillable = true)
    protected ArrayOfLinkToCategoryData trackingCategories;
    @XmlElement(name = "WorkflowInfo", nillable = true)
    protected WorkflowInfo workflowInfo;

    /**
     * Gets the value of the allowOnPage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowOnPage() {
        return allowOnPage;
    }

    /**
     * Sets the value of the allowOnPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowOnPage(Boolean value) {
        this.allowOnPage = value;
    }

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
     * Gets the value of the dynamicTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDynamicTemplate() {
        return dynamicTemplate;
    }

    /**
     * Sets the value of the dynamicTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDynamicTemplate(String value) {
        this.dynamicTemplate = value;
    }

    /**
     * Gets the value of the isRepositoryPublishable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRepositoryPublishable() {
        return isRepositoryPublishable;
    }

    /**
     * Sets the value of the isRepositoryPublishable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRepositoryPublishable(Boolean value) {
        this.isRepositoryPublishable = value;
    }

    /**
     * Gets the value of the outputFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Sets the value of the outputFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputFormat(String value) {
        this.outputFormat = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriority(Integer value) {
        this.priority = value;
    }

    /**
     * Gets the value of the relatedSchemas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToSchemaData }
     *     
     */
    public ArrayOfLinkToSchemaData getRelatedSchemas() {
        return relatedSchemas;
    }

    /**
     * Sets the value of the relatedSchemas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToSchemaData }
     *     
     */
    public void setRelatedSchemas(ArrayOfLinkToSchemaData value) {
        this.relatedSchemas = value;
    }

    /**
     * Gets the value of the trackingCategories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToCategoryData }
     *     
     */
    public ArrayOfLinkToCategoryData getTrackingCategories() {
        return trackingCategories;
    }

    /**
     * Sets the value of the trackingCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToCategoryData }
     *     
     */
    public void setTrackingCategories(ArrayOfLinkToCategoryData value) {
        this.trackingCategories = value;
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
