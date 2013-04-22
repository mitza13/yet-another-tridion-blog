
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.SecurityDescriptorDataDictionary;


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
 *         &lt;element name="GetContentSecurityDescriptorsForOrgItemIdsResult" type="{http://www.sdltridion.com/ContentManager/R6}SecurityDescriptorDataDictionary" minOccurs="0"/>
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
    "getContentSecurityDescriptorsForOrgItemIdsResult"
})
@XmlRootElement(name = "GetContentSecurityDescriptorsForOrgItemIdsResponse")
public class GetContentSecurityDescriptorsForOrgItemIdsResponse {

    @XmlElement(name = "GetContentSecurityDescriptorsForOrgItemIdsResult", nillable = true)
    protected SecurityDescriptorDataDictionary getContentSecurityDescriptorsForOrgItemIdsResult;

    /**
     * Gets the value of the getContentSecurityDescriptorsForOrgItemIdsResult property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityDescriptorDataDictionary }
     *     
     */
    public SecurityDescriptorDataDictionary getGetContentSecurityDescriptorsForOrgItemIdsResult() {
        return getContentSecurityDescriptorsForOrgItemIdsResult;
    }

    /**
     * Sets the value of the getContentSecurityDescriptorsForOrgItemIdsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityDescriptorDataDictionary }
     *     
     */
    public void setGetContentSecurityDescriptorsForOrgItemIdsResult(SecurityDescriptorDataDictionary value) {
        this.getContentSecurityDescriptorsForOrgItemIdsResult = value;
    }

}
