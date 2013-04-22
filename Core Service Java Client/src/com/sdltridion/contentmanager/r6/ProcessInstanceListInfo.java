
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessInstanceListInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessInstanceListInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ListInfo">
 *       &lt;sequence>
 *         &lt;element name="ActivityDefinitionType" type="{http://www.sdltridion.com/ContentManager/R6}ActivityType" minOccurs="0"/>
 *         &lt;element name="ApprovalStatus" type="{http://www.sdltridion.com/ContentManager/R6}LinkToApprovalStatusData" minOccurs="0"/>
 *         &lt;element name="CurrentActivity" type="{http://www.sdltridion.com/ContentManager/R6}ActivityInstanceData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessInstanceListInfo", propOrder = {
    "activityDefinitionType",
    "approvalStatus",
    "currentActivity"
})
public class ProcessInstanceListInfo
    extends ListInfo
{

    @XmlElement(name = "ActivityDefinitionType", nillable = true)
    protected ActivityType activityDefinitionType;
    @XmlElement(name = "ApprovalStatus", nillable = true)
    protected LinkToApprovalStatusData approvalStatus;
    @XmlElement(name = "CurrentActivity", nillable = true)
    protected ActivityInstanceData currentActivity;

    /**
     * Gets the value of the activityDefinitionType property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityType }
     *     
     */
    public ActivityType getActivityDefinitionType() {
        return activityDefinitionType;
    }

    /**
     * Sets the value of the activityDefinitionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityType }
     *     
     */
    public void setActivityDefinitionType(ActivityType value) {
        this.activityDefinitionType = value;
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
     * Gets the value of the currentActivity property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityInstanceData }
     *     
     */
    public ActivityInstanceData getCurrentActivity() {
        return currentActivity;
    }

    /**
     * Sets the value of the currentActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityInstanceData }
     *     
     */
    public void setCurrentActivity(ActivityInstanceData value) {
        this.currentActivity = value;
    }

}
