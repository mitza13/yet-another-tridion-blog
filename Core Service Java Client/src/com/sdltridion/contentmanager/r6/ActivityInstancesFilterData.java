
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActivityInstancesFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityInstancesFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WorkflowManagerFilterData">
 *       &lt;sequence>
 *         &lt;element name="ActivityState" type="{http://www.sdltridion.com/ContentManager/R6}ActivityState" minOccurs="0"/>
 *         &lt;element name="ContextRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="ForAllUsers" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeAdditionalDateColumns" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeWorkItems" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ProcessDefinition" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
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
@XmlType(name = "ActivityInstancesFilterData", propOrder = {
    "activityState",
    "contextRepository",
    "forAllUsers",
    "includeAdditionalDateColumns",
    "includeWorkItems",
    "processDefinition",
    "workflowType"
})
public class ActivityInstancesFilterData
    extends WorkflowManagerFilterData
{

    @XmlList
    @XmlElement(name = "ActivityState", nillable = true)
    protected List<String> activityState;
    @XmlElement(name = "ContextRepository", nillable = true)
    protected LinkToRepositoryData contextRepository;
    @XmlElement(name = "ForAllUsers", nillable = true)
    protected Boolean forAllUsers;
    @XmlElement(name = "IncludeAdditionalDateColumns")
    protected Boolean includeAdditionalDateColumns;
    @XmlElement(name = "IncludeWorkItems")
    protected Boolean includeWorkItems;
    @XmlElement(name = "ProcessDefinition", nillable = true)
    protected LinkToProcessDefinitionData processDefinition;
    @XmlElement(name = "WorkflowType", nillable = true)
    protected LinkToWorkflowTypeData workflowType;

    /**
     * Gets the value of the activityState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activityState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActivityState() {
        if (activityState == null) {
            activityState = new ArrayList<String>();
        }
        return this.activityState;
    }

    /**
     * Gets the value of the contextRepository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getContextRepository() {
        return contextRepository;
    }

    /**
     * Sets the value of the contextRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setContextRepository(LinkToRepositoryData value) {
        this.contextRepository = value;
    }

    /**
     * Gets the value of the forAllUsers property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForAllUsers() {
        return forAllUsers;
    }

    /**
     * Sets the value of the forAllUsers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForAllUsers(Boolean value) {
        this.forAllUsers = value;
    }

    /**
     * Gets the value of the includeAdditionalDateColumns property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeAdditionalDateColumns() {
        return includeAdditionalDateColumns;
    }

    /**
     * Sets the value of the includeAdditionalDateColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAdditionalDateColumns(Boolean value) {
        this.includeAdditionalDateColumns = value;
    }

    /**
     * Gets the value of the includeWorkItems property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeWorkItems() {
        return includeWorkItems;
    }

    /**
     * Sets the value of the includeWorkItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeWorkItems(Boolean value) {
        this.includeWorkItems = value;
    }

    /**
     * Gets the value of the processDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public LinkToProcessDefinitionData getProcessDefinition() {
        return processDefinition;
    }

    /**
     * Sets the value of the processDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public void setProcessDefinition(LinkToProcessDefinitionData value) {
        this.processDefinition = value;
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
