
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
 *         &lt;element name="GetListDirectoryServiceUsersResult" type="{http://www.sdltridion.com/Security}ArrayOfDirectoryServiceUser" minOccurs="0"/>
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
    "getListDirectoryServiceUsersResult"
})
@XmlRootElement(name = "GetListDirectoryServiceUsersResponse")
public class GetListDirectoryServiceUsersResponse {

    @XmlElement(name = "GetListDirectoryServiceUsersResult", nillable = true)
    protected ArrayOfDirectoryServiceUser getListDirectoryServiceUsersResult;

    /**
     * Gets the value of the getListDirectoryServiceUsersResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDirectoryServiceUser }
     *     
     */
    public ArrayOfDirectoryServiceUser getGetListDirectoryServiceUsersResult() {
        return getListDirectoryServiceUsersResult;
    }

    /**
     * Sets the value of the getListDirectoryServiceUsersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDirectoryServiceUser }
     *     
     */
    public void setGetListDirectoryServiceUsersResult(ArrayOfDirectoryServiceUser value) {
        this.getListDirectoryServiceUsersResult = value;
    }

}
