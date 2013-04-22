
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BatchOperationData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchOperationData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Parameters" type="{http://www.sdltridion.com/ContentManager/R6}ParametersDictionary" minOccurs="0"/>
 *         &lt;element name="Statuses" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfBatchOperationStatusData" minOccurs="0"/>
 *         &lt;element name="SubjectLinks" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfWeakLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchOperationData", propOrder = {
    "operation",
    "parameters",
    "statuses",
    "subjectLinks"
})
public class BatchOperationData {

    @XmlElement(name = "Operation", nillable = true)
    protected String operation;
    @XmlElement(name = "Parameters", nillable = true)
    protected ParametersDictionary parameters;
    @XmlElement(name = "Statuses", nillable = true)
    protected ArrayOfBatchOperationStatusData statuses;
    @XmlElement(name = "SubjectLinks", nillable = true)
    protected ArrayOfWeakLink subjectLinks;

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link ParametersDictionary }
     *     
     */
    public ParametersDictionary getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametersDictionary }
     *     
     */
    public void setParameters(ParametersDictionary value) {
        this.parameters = value;
    }

    /**
     * Gets the value of the statuses property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBatchOperationStatusData }
     *     
     */
    public ArrayOfBatchOperationStatusData getStatuses() {
        return statuses;
    }

    /**
     * Sets the value of the statuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBatchOperationStatusData }
     *     
     */
    public void setStatuses(ArrayOfBatchOperationStatusData value) {
        this.statuses = value;
    }

    /**
     * Gets the value of the subjectLinks property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWeakLink }
     *     
     */
    public ArrayOfWeakLink getSubjectLinks() {
        return subjectLinks;
    }

    /**
     * Sets the value of the subjectLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWeakLink }
     *     
     */
    public void setSubjectLinks(ArrayOfWeakLink value) {
        this.subjectLinks = value;
    }

}
