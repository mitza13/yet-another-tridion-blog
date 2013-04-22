
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ProcessInstanceData;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StartWorkflowResult" type="{http://www.sdltridion.com/ContentManager/R6}ProcessInstanceData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "startWorkflowResult"
})
@XmlRootElement(name = "StartWorkflowResponse")
public class StartWorkflowResponse {

    @XmlElement(name = "StartWorkflowResult", nillable = true)
    protected ProcessInstanceData startWorkflowResult;

    /**
     * Gets the value of the startWorkflowResult property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessInstanceData }
     *     
     */
    public ProcessInstanceData getStartWorkflowResult() {
        return startWorkflowResult;
    }

    /**
     * Sets the value of the startWorkflowResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessInstanceData }
     *     
     */
    public void setStartWorkflowResult(ProcessInstanceData value) {
        this.startWorkflowResult = value;
    }

}
