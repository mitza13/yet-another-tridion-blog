
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DecisionActivityFinishData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecisionActivityFinishData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ActivityFinishData">
 *       &lt;sequence>
 *         &lt;element name="NextActivity" type="{http://www.sdltridion.com/ContentManager/R6}LinkToActivityDefinitionData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecisionActivityFinishData", propOrder = {
    "nextActivity"
})
public class DecisionActivityFinishData
    extends ActivityFinishData
{

    @XmlElement(name = "NextActivity", nillable = true)
    protected LinkToActivityDefinitionData nextActivity;

    /**
     * Gets the value of the nextActivity property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToActivityDefinitionData }
     *     
     */
    public LinkToActivityDefinitionData getNextActivity() {
        return nextActivity;
    }

    /**
     * Sets the value of the nextActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToActivityDefinitionData }
     *     
     */
    public void setNextActivity(LinkToActivityDefinitionData value) {
        this.nextActivity = value;
    }

}
