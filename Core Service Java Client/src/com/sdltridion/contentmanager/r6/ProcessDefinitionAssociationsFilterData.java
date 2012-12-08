
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessDefinitionAssociationsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessDefinitionAssociationsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WorkflowManagerFilterData">
 *       &lt;sequence>
 *         &lt;element name="ContextRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="ProcessDefinition" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessDefinitionAssociationsFilterData", propOrder = {
    "contextRepository",
    "processDefinition"
})
public class ProcessDefinitionAssociationsFilterData
    extends WorkflowManagerFilterData
{

    @XmlElement(name = "ContextRepository", nillable = true)
    protected LinkToRepositoryData contextRepository;
    @XmlElement(name = "ProcessDefinition", nillable = true)
    protected LinkToProcessDefinitionData processDefinition;

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

}
