
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetGroupData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetGroupData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}RepositoryLocalObjectData">
 *       &lt;sequence>
 *         &lt;element name="Conditions" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfConditionData" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetGroupData", propOrder = {
    "conditions",
    "description"
})
public class TargetGroupData
    extends RepositoryLocalObjectData
{

    @XmlElement(name = "Conditions", nillable = true)
    protected ArrayOfConditionData conditions;
    @XmlElement(name = "Description", nillable = true)
    protected String description;

    /**
     * Gets the value of the conditions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfConditionData }
     *     
     */
    public ArrayOfConditionData getConditions() {
        return conditions;
    }

    /**
     * Sets the value of the conditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfConditionData }
     *     
     */
    public void setConditions(ArrayOfConditionData value) {
        this.conditions = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
