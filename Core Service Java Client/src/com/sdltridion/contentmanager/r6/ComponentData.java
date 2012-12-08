
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComponentData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComponentData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}VersionedItemData">
 *       &lt;sequence>
 *         &lt;element name="ApprovalStatus" type="{http://www.sdltridion.com/ContentManager/R6}LinkToApprovalStatusData" minOccurs="0"/>
 *         &lt;element name="BinaryContent" type="{http://www.sdltridion.com/ContentManager/R6}BinaryContentData" minOccurs="0"/>
 *         &lt;element name="ComponentType" type="{http://www.sdltridion.com/ContentManager/R6}ComponentType" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="IsBasedOnMandatorySchema" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsBasedOnTridionWebSchema" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Schema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
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
@XmlType(name = "ComponentData", propOrder = {
    "approvalStatus",
    "binaryContent",
    "componentType",
    "content",
    "isBasedOnMandatorySchema",
    "isBasedOnTridionWebSchema",
    "schema",
    "workflowInfo"
})
public class ComponentData
    extends VersionedItemData
{

    @XmlElement(name = "ApprovalStatus", nillable = true)
    protected LinkToApprovalStatusData approvalStatus;
    @XmlElement(name = "BinaryContent", nillable = true)
    protected BinaryContentData binaryContent;
    @XmlElement(name = "ComponentType", nillable = true)
    protected ComponentType componentType;
    @XmlElement(name = "Content", nillable = true)
    protected String content;
    @XmlElement(name = "IsBasedOnMandatorySchema", nillable = true)
    protected Boolean isBasedOnMandatorySchema;
    @XmlElement(name = "IsBasedOnTridionWebSchema", nillable = true)
    protected Boolean isBasedOnTridionWebSchema;
    @XmlElement(name = "Schema", nillable = true)
    protected LinkToSchemaData schema;
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
     * Gets the value of the binaryContent property.
     * 
     * @return
     *     possible object is
     *     {@link BinaryContentData }
     *     
     */
    public BinaryContentData getBinaryContent() {
        return binaryContent;
    }

    /**
     * Sets the value of the binaryContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BinaryContentData }
     *     
     */
    public void setBinaryContent(BinaryContentData value) {
        this.binaryContent = value;
    }

    /**
     * Gets the value of the componentType property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentType }
     *     
     */
    public ComponentType getComponentType() {
        return componentType;
    }

    /**
     * Sets the value of the componentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentType }
     *     
     */
    public void setComponentType(ComponentType value) {
        this.componentType = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the isBasedOnMandatorySchema property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsBasedOnMandatorySchema() {
        return isBasedOnMandatorySchema;
    }

    /**
     * Sets the value of the isBasedOnMandatorySchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsBasedOnMandatorySchema(Boolean value) {
        this.isBasedOnMandatorySchema = value;
    }

    /**
     * Gets the value of the isBasedOnTridionWebSchema property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsBasedOnTridionWebSchema() {
        return isBasedOnTridionWebSchema;
    }

    /**
     * Sets the value of the isBasedOnTridionWebSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsBasedOnTridionWebSchema(Boolean value) {
        this.isBasedOnTridionWebSchema = value;
    }

    /**
     * Gets the value of the schema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getSchema() {
        return schema;
    }

    /**
     * Sets the value of the schema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setSchema(LinkToSchemaData value) {
        this.schema = value;
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
