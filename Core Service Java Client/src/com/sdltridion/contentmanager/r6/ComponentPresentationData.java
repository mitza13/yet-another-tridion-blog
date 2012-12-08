
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComponentPresentationData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComponentPresentationData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Component" type="{http://www.sdltridion.com/ContentManager/R6}LinkToComponentData" minOccurs="0"/>
 *         &lt;element name="ComponentTemplate" type="{http://www.sdltridion.com/ContentManager/R6}LinkToComponentTemplateData" minOccurs="0"/>
 *         &lt;element name="Conditions" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfTargetGroupConditionData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComponentPresentationData", propOrder = {
    "component",
    "componentTemplate",
    "conditions"
})
public class ComponentPresentationData {

    @XmlElement(name = "Component", nillable = true)
    protected LinkToComponentData component;
    @XmlElement(name = "ComponentTemplate", nillable = true)
    protected LinkToComponentTemplateData componentTemplate;
    @XmlElement(name = "Conditions", nillable = true)
    protected ArrayOfTargetGroupConditionData conditions;

    /**
     * Gets the value of the component property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToComponentData }
     *     
     */
    public LinkToComponentData getComponent() {
        return component;
    }

    /**
     * Sets the value of the component property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToComponentData }
     *     
     */
    public void setComponent(LinkToComponentData value) {
        this.component = value;
    }

    /**
     * Gets the value of the componentTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToComponentTemplateData }
     *     
     */
    public LinkToComponentTemplateData getComponentTemplate() {
        return componentTemplate;
    }

    /**
     * Sets the value of the componentTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToComponentTemplateData }
     *     
     */
    public void setComponentTemplate(LinkToComponentTemplateData value) {
        this.componentTemplate = value;
    }

    /**
     * Gets the value of the conditions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTargetGroupConditionData }
     *     
     */
    public ArrayOfTargetGroupConditionData getConditions() {
        return conditions;
    }

    /**
     * Sets the value of the conditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTargetGroupConditionData }
     *     
     */
    public void setConditions(ArrayOfTargetGroupConditionData value) {
        this.conditions = value;
    }

}
