
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.IdentifiableObjectData;


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
 *         &lt;element name="SaveResult" type="{http://www.sdltridion.com/ContentManager/R6}IdentifiableObjectData" minOccurs="0"/>
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
    "saveResult"
})
@XmlRootElement(name = "SaveResponse")
public class SaveResponse {

    @XmlElement(name = "SaveResult", nillable = true)
    protected IdentifiableObjectData saveResult;

    /**
     * Gets the value of the saveResult property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifiableObjectData }
     *     
     */
    public IdentifiableObjectData getSaveResult() {
        return saveResult;
    }

    /**
     * Sets the value of the saveResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifiableObjectData }
     *     
     */
    public void setSaveResult(IdentifiableObjectData value) {
        this.saveResult = value;
    }

}
