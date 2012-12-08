
package com.sdltridion.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirectoryUsersFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirectoryUsersFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubtreeDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserNameSearchMode" type="{http://www.sdltridion.com/Security}UserNameSearchMode" minOccurs="0"/>
 *         &lt;element name="UserNameStartsWith" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectoryUsersFilter", propOrder = {
    "subtreeDN",
    "userNameSearchMode",
    "userNameStartsWith"
})
public class DirectoryUsersFilter {

    @XmlElement(name = "SubtreeDN", nillable = true)
    protected String subtreeDN;
    @XmlElement(name = "UserNameSearchMode", nillable = true)
    protected UserNameSearchMode userNameSearchMode;
    @XmlElement(name = "UserNameStartsWith", nillable = true)
    protected String userNameStartsWith;

    /**
     * Gets the value of the subtreeDN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtreeDN() {
        return subtreeDN;
    }

    /**
     * Sets the value of the subtreeDN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtreeDN(String value) {
        this.subtreeDN = value;
    }

    /**
     * Gets the value of the userNameSearchMode property.
     * 
     * @return
     *     possible object is
     *     {@link UserNameSearchMode }
     *     
     */
    public UserNameSearchMode getUserNameSearchMode() {
        return userNameSearchMode;
    }

    /**
     * Sets the value of the userNameSearchMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserNameSearchMode }
     *     
     */
    public void setUserNameSearchMode(UserNameSearchMode value) {
        this.userNameSearchMode = value;
    }

    /**
     * Gets the value of the userNameStartsWith property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserNameStartsWith() {
        return userNameStartsWith;
    }

    /**
     * Sets the value of the userNameStartsWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserNameStartsWith(String value) {
        this.userNameStartsWith = value;
    }

}
