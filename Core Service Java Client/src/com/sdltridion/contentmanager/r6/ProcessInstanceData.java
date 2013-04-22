
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessInstanceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessInstanceData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ProcessData">
 *       &lt;sequence>
 *         &lt;element name="ProcessDefinition" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *         &lt;element name="Variables" type="{http://www.sdltridion.com/ContentManager/R6}VariablesDictionary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessInstanceData", propOrder = {
    "processDefinition",
    "variables"
})
public class ProcessInstanceData
    extends ProcessData
{

    @XmlElement(name = "ProcessDefinition", nillable = true)
    protected LinkToProcessDefinitionData processDefinition;
    @XmlElement(name = "Variables", nillable = true)
    protected VariablesDictionary variables;

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
     * Gets the value of the variables property.
     * 
     * @return
     *     possible object is
     *     {@link VariablesDictionary }
     *     
     */
    public VariablesDictionary getVariables() {
        return variables;
    }

    /**
     * Sets the value of the variables property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariablesDictionary }
     *     
     */
    public void setVariables(VariablesDictionary value) {
        this.variables = value;
    }

}
