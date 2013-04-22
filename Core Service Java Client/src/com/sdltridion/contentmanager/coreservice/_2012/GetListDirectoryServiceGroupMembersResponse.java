
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.security.ArrayOfDirectoryServiceUser;


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
 *         &lt;element name="GetListDirectoryServiceGroupMembersResult" type="{http://www.sdltridion.com/Security}ArrayOfDirectoryServiceUser" minOccurs="0"/>
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
    "getListDirectoryServiceGroupMembersResult"
})
@XmlRootElement(name = "GetListDirectoryServiceGroupMembersResponse")
public class GetListDirectoryServiceGroupMembersResponse {

    @XmlElement(name = "GetListDirectoryServiceGroupMembersResult", nillable = true)
    protected ArrayOfDirectoryServiceUser getListDirectoryServiceGroupMembersResult;

    /**
     * Gets the value of the getListDirectoryServiceGroupMembersResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDirectoryServiceUser }
     *     
     */
    public ArrayOfDirectoryServiceUser getGetListDirectoryServiceGroupMembersResult() {
        return getListDirectoryServiceGroupMembersResult;
    }

    /**
     * Sets the value of the getListDirectoryServiceGroupMembersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDirectoryServiceUser }
     *     
     */
    public void setGetListDirectoryServiceGroupMembersResult(ArrayOfDirectoryServiceUser value) {
        this.getListDirectoryServiceGroupMembersResult = value;
    }

}
