
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
    "activityState"
})
public class ActivityInstanceData
    extends ActivityData
{

    @XmlElement(name = "ActivityDefinition", nillable = true)
    protected LinkToActivityDefinitionData activityDefinition;
    @XmlList
    @XmlElement(name = "ActivityState", nillable = true)
    protected List<String> activityState;

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

}
