
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.security.ArrayOfWindowsUser;


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
 *         &lt;element name="GetListWindowsDomainUsersResult" type="{http://www.sdltridion.com/Security}ArrayOfWindowsUser" minOccurs="0"/>
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
    "getListWindowsDomainUsersResult"
})
@XmlRootElement(name = "GetListWindowsDomainUsersResponse")
public class GetListWindowsDomainUsersResponse {

    @XmlElement(name = "GetListWindowsDomainUsersResult", nillable = true)
    protected ArrayOfWindowsUser getListWindowsDomainUsersResult;

    /**
     * Gets the value of the getListWindowsDomainUsersResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWindowsUser }
     *     
     */
    public ArrayOfWindowsUser getGetListWindowsDomainUsersResult() {
        return getListWindowsDomainUsersResult;
    }

    /**
     * Sets the value of the getListWindowsDomainUsersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWindowsUser }
     *     
     */
    public void setGetListWindowsDomainUsersResult(ArrayOfWindowsUser value) {
        this.getListWindowsDomainUsersResult = value;
    }

}
