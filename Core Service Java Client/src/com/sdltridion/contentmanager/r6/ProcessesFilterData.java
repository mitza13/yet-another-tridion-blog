
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessesFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessesFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WorkflowManagerFilterData">
 *       &lt;sequence>
 *         &lt;element name="ForPerformer" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="ProcessType" type="{http://www.sdltridion.com/ContentManager/R6}ProcessType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessesFilterData", propOrder = {
    "forPerformer",
    "processType"
})
public class ProcessesFilterData
    extends WorkflowManagerFilterData
{

    @XmlElement(name = "ForPerformer", nillable = true)
    protected LinkToUserData forPerformer;
    @XmlElement(name = "ProcessType", nillable = true)
    protected ProcessType processType;

    /**
     * Gets the value of the forPerformer property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getForPerformer() {
        return forPerformer;
    }

    /**
     * Sets the value of the forPerformer property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setForPerformer(LinkToUserData value) {
        this.forPerformer = value;
    }

    /**
     * Gets the value of the processType property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessType }
     *     
     */
    public ProcessType getProcessType() {
        return processType;
    }

    /**
     * Sets the value of the processType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessType }
     *     
     */
    public void setProcessType(ProcessType value) {
        this.processType = value;
    }

}
