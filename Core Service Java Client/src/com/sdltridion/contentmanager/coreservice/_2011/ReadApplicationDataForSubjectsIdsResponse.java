
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ApplicationDataDictionary;


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
 *         &lt;element name="ReadApplicationDataForSubjectsIdsResult" type="{http://www.sdltridion.com/ContentManager/R6}ApplicationDataDictionary" minOccurs="0"/>
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
    "readApplicationDataForSubjectsIdsResult"
})
@XmlRootElement(name = "ReadApplicationDataForSubjectsIdsResponse")
public class ReadApplicationDataForSubjectsIdsResponse {

    @XmlElement(name = "ReadApplicationDataForSubjectsIdsResult", nillable = true)
    protected ApplicationDataDictionary readApplicationDataForSubjectsIdsResult;

    /**
     * Gets the value of the readApplicationDataForSubjectsIdsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationDataDictionary }
     *     
     */
    public ApplicationDataDictionary getReadApplicationDataForSubjectsIdsResult() {
        return readApplicationDataForSubjectsIdsResult;
    }

    /**
     * Sets the value of the readApplicationDataForSubjectsIdsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationDataDictionary }
     *     
     */
    public void setReadApplicationDataForSubjectsIdsResult(ApplicationDataDictionary value) {
        this.readApplicationDataForSubjectsIdsResult = value;
    }

}
