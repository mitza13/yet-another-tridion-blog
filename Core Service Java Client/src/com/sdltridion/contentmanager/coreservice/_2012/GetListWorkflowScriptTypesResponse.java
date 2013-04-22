
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfWorkflowScriptType;


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
 *         &lt;element name="GetListWorkflowScriptTypesResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfWorkflowScriptType" minOccurs="0"/>
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
    "getListWorkflowScriptTypesResult"
})
@XmlRootElement(name = "GetListWorkflowScriptTypesResponse")
public class GetListWorkflowScriptTypesResponse {

    @XmlElement(name = "GetListWorkflowScriptTypesResult", nillable = true)
    protected ArrayOfWorkflowScriptType getListWorkflowScriptTypesResult;

    /**
     * Gets the value of the getListWorkflowScriptTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWorkflowScriptType }
     *     
     */
    public ArrayOfWorkflowScriptType getGetListWorkflowScriptTypesResult() {
        return getListWorkflowScriptTypesResult;
    }

    /**
     * Sets the value of the getListWorkflowScriptTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWorkflowScriptType }
     *     
     */
    public void setGetListWorkflowScriptTypesResult(ArrayOfWorkflowScriptType value) {
        this.getListWorkflowScriptTypesResult = value;
    }

}
