
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ProcessDefinitionAssociationDictionary;


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
 *         &lt;element name="GetProcessDefinitionsForItemsResult" type="{http://www.sdltridion.com/ContentManager/R6}ProcessDefinitionAssociationDictionary" minOccurs="0"/>
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
    "getProcessDefinitionsForItemsResult"
})
@XmlRootElement(name = "GetProcessDefinitionsForItemsResponse")
public class GetProcessDefinitionsForItemsResponse {

    @XmlElement(name = "GetProcessDefinitionsForItemsResult", nillable = true)
    protected ProcessDefinitionAssociationDictionary getProcessDefinitionsForItemsResult;

    /**
     * Gets the value of the getProcessDefinitionsForItemsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessDefinitionAssociationDictionary }
     *     
     */
    public ProcessDefinitionAssociationDictionary getGetProcessDefinitionsForItemsResult() {
        return getProcessDefinitionsForItemsResult;
    }

    /**
     * Sets the value of the getProcessDefinitionsForItemsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessDefinitionAssociationDictionary }
     *     
     */
    public void setGetProcessDefinitionsForItemsResult(ProcessDefinitionAssociationDictionary value) {
        this.getProcessDefinitionsForItemsResult = value;
    }

}
