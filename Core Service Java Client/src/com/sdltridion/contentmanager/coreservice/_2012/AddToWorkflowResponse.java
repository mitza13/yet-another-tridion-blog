
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfWorkItemData;


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
 *         &lt;element name="AddToWorkflowResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfWorkItemData" minOccurs="0"/>
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
    "addToWorkflowResult"
})
@XmlRootElement(name = "AddToWorkflowResponse")
public class AddToWorkflowResponse {

    @XmlElement(name = "AddToWorkflowResult", nillable = true)
    protected ArrayOfWorkItemData addToWorkflowResult;

    /**
     * Gets the value of the addToWorkflowResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWorkItemData }
     *     
     */
    public ArrayOfWorkItemData getAddToWorkflowResult() {
        return addToWorkflowResult;
    }

    /**
     * Sets the value of the addToWorkflowResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWorkItemData }
     *     
     */
    public void setAddToWorkflowResult(ArrayOfWorkItemData value) {
        this.addToWorkflowResult = value;
    }

}
