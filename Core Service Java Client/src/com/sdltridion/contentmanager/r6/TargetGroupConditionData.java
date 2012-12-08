
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetGroupConditionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetGroupConditionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ConditionData">
 *       &lt;sequence>
 *         &lt;element name="TargetGroup" type="{http://www.sdltridion.com/ContentManager/R6}LinkToTargetGroupData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetGroupConditionData", propOrder = {
    "targetGroup"
})
public class TargetGroupConditionData
    extends ConditionData
{

    @XmlElement(name = "TargetGroup", nillable = true)
    protected LinkToTargetGroupData targetGroup;

    /**
     * Gets the value of the targetGroup property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToTargetGroupData }
     *     
     */
    public LinkToTargetGroupData getTargetGroup() {
        return targetGroup;
    }

    /**
     * Sets the value of the targetGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToTargetGroupData }
     *     
     */
    public void setTargetGroup(LinkToTargetGroupData value) {
        this.targetGroup = value;
    }

}
