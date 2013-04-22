
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWorkflowScriptType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWorkflowScriptType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkflowScriptType" type="{http://www.sdltridion.com/ContentManager/R6}WorkflowScriptType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWorkflowScriptType", propOrder = {
    "workflowScriptType"
})
public class ArrayOfWorkflowScriptType {

    @XmlElement(name = "WorkflowScriptType", nillable = true)
    protected List<WorkflowScriptType> workflowScriptType;

    /**
     * Gets the value of the workflowScriptType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflowScriptType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkflowScriptType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkflowScriptType }
     * 
     * 
     */
    public List<WorkflowScriptType> getWorkflowScriptType() {
        if (workflowScriptType == null) {
            workflowScriptType = new ArrayList<WorkflowScriptType>();
        }
        return this.workflowScriptType;
    }

}
