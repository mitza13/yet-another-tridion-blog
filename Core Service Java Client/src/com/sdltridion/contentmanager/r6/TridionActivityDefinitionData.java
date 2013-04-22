
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TridionActivityDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TridionActivityDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ActivityDefinitionData">
 *       &lt;sequence>
 *         &lt;element name="ActivityType" type="{http://www.sdltridion.com/ContentManager/R6}ActivityType" minOccurs="0"/>
 *         &lt;element name="FinishApprovalStatus" type="{http://www.sdltridion.com/ContentManager/R6}LinkToApprovalStatusData" minOccurs="0"/>
 *         &lt;element name="NextActivityDefinitions" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToTridionActivityDefinitionData" minOccurs="0"/>
 *         &lt;element name="Script" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ScriptType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AllowOverrideDueDate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PerformingTimeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TridionActivityDefinitionData", propOrder = {
    "activityType",
    "finishApprovalStatus",
    "nextActivityDefinitions",
    "script",
    "scriptType",
    "allowOverrideDueDate",
    "performingTimeout"
})
public class TridionActivityDefinitionData
    extends ActivityDefinitionData
{

    @XmlElement(name = "ActivityType", nillable = true)
    protected ActivityType activityType;
    @XmlElement(name = "FinishApprovalStatus", nillable = true)
    protected LinkToApprovalStatusData finishApprovalStatus;
    @XmlElement(name = "NextActivityDefinitions", nillable = true)
    protected ArrayOfLinkToTridionActivityDefinitionData nextActivityDefinitions;
    @XmlElement(name = "Script", nillable = true)
    protected String script;
    @XmlElement(name = "ScriptType", nillable = true)
    protected String scriptType;
    @XmlElement(name = "AllowOverrideDueDate", nillable = true)
    protected Boolean allowOverrideDueDate;
    @XmlElement(name = "PerformingTimeout", nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long performingTimeout;

    /**
     * Gets the value of the activityType property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityType }
     *     
     */
    public ActivityType getActivityType() {
        return activityType;
    }

    /**
     * Sets the value of the activityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityType }
     *     
     */
    public void setActivityType(ActivityType value) {
        this.activityType = value;
    }

    /**
     * Gets the value of the finishApprovalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToApprovalStatusData }
     *     
     */
    public LinkToApprovalStatusData getFinishApprovalStatus() {
        return finishApprovalStatus;
    }

    /**
     * Sets the value of the finishApprovalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToApprovalStatusData }
     *     
     */
    public void setFinishApprovalStatus(LinkToApprovalStatusData value) {
        this.finishApprovalStatus = value;
    }

    /**
     * Gets the value of the nextActivityDefinitions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToTridionActivityDefinitionData }
     *     
     */
    public ArrayOfLinkToTridionActivityDefinitionData getNextActivityDefinitions() {
        return nextActivityDefinitions;
    }

    /**
     * Sets the value of the nextActivityDefinitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToTridionActivityDefinitionData }
     *     
     */
    public void setNextActivityDefinitions(ArrayOfLinkToTridionActivityDefinitionData value) {
        this.nextActivityDefinitions = value;
    }

    /**
     * Gets the value of the script property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScript() {
        return script;
    }

    /**
     * Sets the value of the script property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScript(String value) {
        this.script = value;
    }

    /**
     * Gets the value of the scriptType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScriptType() {
        return scriptType;
    }

    /**
     * Sets the value of the scriptType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScriptType(String value) {
        this.scriptType = value;
    }

    /**
     * Gets the value of the allowOverrideDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowOverrideDueDate() {
        return allowOverrideDueDate;
    }

    /**
     * Sets the value of the allowOverrideDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowOverrideDueDate(Boolean value) {
        this.allowOverrideDueDate = value;
    }

    /**
     * Gets the value of the performingTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPerformingTimeout() {
        return performingTimeout;
    }

    /**
     * Sets the value of the performingTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPerformingTimeout(Long value) {
        this.performingTimeout = value;
    }

}
