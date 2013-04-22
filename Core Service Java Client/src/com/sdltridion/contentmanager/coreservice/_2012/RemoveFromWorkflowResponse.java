
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
 *         &lt;element name="RemoveFromWorkflowResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfWorkItemData" minOccurs="0"/>
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
    "removeFromWorkflowResult"
})
@XmlRootElement(name = "RemoveFromWorkflowResponse")
public class RemoveFromWorkflowResponse {

    @XmlElement(name = "RemoveFromWorkflowResult", nillable = true)
    protected ArrayOfWorkItemData removeFromWorkflowResult;

    /**
     * Gets the value of the removeFromWorkflowResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWorkItemData }
     *     
     */
    public ArrayOfWorkItemData getRemoveFromWorkflowResult() {
        return removeFromWorkflowResult;
    }

    /**
     * Sets the value of the removeFromWorkflowResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWorkItemData }
     *     
     */
    public void setRemoveFromWorkflowResult(ArrayOfWorkItemData value) {
        this.removeFromWorkflowResult = value;
    }

}
