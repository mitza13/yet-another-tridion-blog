
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActivityInstanceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityInstanceData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ActivityData">
 *       &lt;sequence>
 *         &lt;element name="ActivityDefinition" type="{http://www.sdltridion.com/ContentManager/R6}LinkToActivityDefinitionData" minOccurs="0"/>
 *         &lt;element name="ActivityState" type="{http://www.sdltridion.com/ContentManager/R6}ActivityState" minOccurs="0"/>
 *         &lt;element name="ActivityConstraints" type="{http://www.sdltridion.com/ContentManager/R6}ActivityConstraints" minOccurs="0"/>
 *         &lt;element name="ResumeBookmark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SuspendOrFailReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityInstanceData", propOrder = {
    "activityDefinition",
    "activityState",
    "activityConstraints",
    "resumeBookmark",
    "suspendOrFailReason"
})
public class ActivityInstanceData
    extends ActivityData
{

    @XmlElement(name = "ActivityDefinition", nillable = true)
    protected LinkToActivityDefinitionData activityDefinition;
    @XmlList
    @XmlElement(name = "ActivityState", nillable = true)
    protected List<String> activityState;
    @XmlList
    @XmlElement(name = "ActivityConstraints", nillable = true)
    protected List<String> activityConstraints;
    @XmlElement(name = "ResumeBookmark", nillable = true)
    protected String resumeBookmark;
    @XmlElement(name = "SuspendOrFailReason", nillable = true)
    protected String suspendOrFailReason;

    /**
     * Gets the value of the activityDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToActivityDefinitionData }
     *     
     */
    public LinkToActivityDefinitionData getActivityDefinition() {
        return activityDefinition;
    }

    /**
     * Sets the value of the activityDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToActivityDefinitionData }
     *     
     */
    public void setActivityDefinition(LinkToActivityDefinitionData value) {
        this.activityDefinition = value;
    }

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
     * Gets the value of the activityConstraints property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activityConstraints property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityConstraints().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActivityConstraints() {
        if (activityConstraints == null) {
            activityConstraints = new ArrayList<String>();
        }
        return this.activityConstraints;
    }

    /**
     * Gets the value of the resumeBookmark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResumeBookmark() {
        return resumeBookmark;
    }

    /**
     * Sets the value of the resumeBookmark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResumeBookmark(String value) {
        this.resumeBookmark = value;
    }

    /**
     * Gets the value of the suspendOrFailReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuspendOrFailReason() {
        return suspendOrFailReason;
    }

    /**
     * Sets the value of the suspendOrFailReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuspendOrFailReason(String value) {
        this.suspendOrFailReason = value;
    }

}
