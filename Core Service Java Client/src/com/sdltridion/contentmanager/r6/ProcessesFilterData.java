
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessesFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessesFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WorkflowManagerFilterData">
 *       &lt;sequence>
 *         &lt;element name="ForPerformer" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="ForProcessDefinition" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *         &lt;element name="ForRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="ProcessType" type="{http://www.sdltridion.com/ContentManager/R6}ProcessType" minOccurs="0"/>
 *         &lt;element name="ForSubject" type="{http://www.sdltridion.com/ContentManager/R6}LinkToIdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="IncludeWorkflowTypeColumns" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LegacyMode" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="WorkflowType" type="{http://www.sdltridion.com/ContentManager/R6}LinkToWorkflowTypeData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessesFilterData", propOrder = {
    "forPerformer",
    "forProcessDefinition",
    "forRepository",
    "processType",
    "forSubject",
    "includeWorkflowTypeColumns",
    "legacyMode",
    "workflowType"
})
public class ProcessesFilterData
    extends WorkflowManagerFilterData
{

    @XmlElement(name = "ForPerformer", nillable = true)
    protected LinkToUserData forPerformer;
    @XmlElement(name = "ForProcessDefinition", nillable = true)
    protected LinkToProcessDefinitionData forProcessDefinition;
    @XmlElement(name = "ForRepository", nillable = true)
    protected LinkToRepositoryData forRepository;
    @XmlElement(name = "ProcessType", nillable = true)
    protected ProcessType processType;
    @XmlElement(name = "ForSubject", nillable = true)
    protected LinkToIdentifiableObjectData forSubject;
    @XmlElement(name = "IncludeWorkflowTypeColumns")
    protected Boolean includeWorkflowTypeColumns;
    @XmlElement(name = "LegacyMode", nillable = true)
    protected Boolean legacyMode;
    @XmlElement(name = "WorkflowType", nillable = true)
    protected LinkToWorkflowTypeData workflowType;

    /**
     * Gets the value of the forPerformer property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getForPerformer() {
        return forPerformer;
    }

    /**
     * Sets the value of the forPerformer property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setForPerformer(LinkToUserData value) {
        this.forPerformer = value;
    }

    /**
     * Gets the value of the forProcessDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public LinkToProcessDefinitionData getForProcessDefinition() {
        return forProcessDefinition;
    }

    /**
     * Sets the value of the forProcessDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public void setForProcessDefinition(LinkToProcessDefinitionData value) {
        this.forProcessDefinition = value;
    }

    /**
     * Gets the value of the forRepository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getForRepository() {
        return forRepository;
    }

    /**
     * Sets the value of the forRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setForRepository(LinkToRepositoryData value) {
        this.forRepository = value;
    }

    /**
     * Gets the value of the processType property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessType }
     *     
     */
    public ProcessType getProcessType() {
        return processType;
    }

    /**
     * Sets the value of the processType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessType }
     *     
     */
    public void setProcessType(ProcessType value) {
        this.processType = value;
    }

    /**
     * Gets the value of the forSubject property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public LinkToIdentifiableObjectData getForSubject() {
        return forSubject;
    }

    /**
     * Sets the value of the forSubject property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public void setForSubject(LinkToIdentifiableObjectData value) {
        this.forSubject = value;
    }

    /**
     * Gets the value of the includeWorkflowTypeColumns property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeWorkflowTypeColumns() {
        return includeWorkflowTypeColumns;
    }

    /**
     * Sets the value of the includeWorkflowTypeColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeWorkflowTypeColumns(Boolean value) {
        this.includeWorkflowTypeColumns = value;
    }

    /**
     * Gets the value of the legacyMode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLegacyMode() {
        return legacyMode;
    }

    /**
     * Sets the value of the legacyMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLegacyMode(Boolean value) {
        this.legacyMode = value;
    }

    /**
     * Gets the value of the workflowType property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToWorkflowTypeData }
     *     
     */
    public LinkToWorkflowTypeData getWorkflowType() {
        return workflowType;
    }

    /**
     * Sets the value of the workflowType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToWorkflowTypeData }
     *     
     */
    public void setWorkflowType(LinkToWorkflowTypeData value) {
        this.workflowType = value;
    }

}
