
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}TrusteeData">
 *       &lt;sequence>
 *         &lt;element name="IsEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsEnabledEditable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsPrivilegesEditable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LanguageId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LocaleId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Privileges" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserData", propOrder = {
    "isEnabled",
    "isEnabledEditable",
    "isPrivilegesEditable",
    "languageId",
    "localeId",
    "privileges"
})
public class UserData
    extends TrusteeData
{

    @XmlElement(name = "IsEnabled", nillable = true)
    protected Boolean isEnabled;
    @XmlElement(name = "IsEnabledEditable", nillable = true)
    protected Boolean isEnabledEditable;
    @XmlElement(name = "IsPrivilegesEditable", nillable = true)
    protected Boolean isPrivilegesEditable;
    @XmlElement(name = "LanguageId", nillable = true)
    protected Integer languageId;
    @XmlElement(name = "LocaleId", nillable = true)
    protected Integer localeId;
    @XmlElement(name = "Privileges", nillable = true)
    protected Integer privileges;

    /**
     * Gets the value of the isEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEnabled() {
        return isEnabled;
    }

    /**
     * Sets the value of the isEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEnabled(Boolean value) {
        this.isEnabled = value;
    }

    /**
     * Gets the value of the isEnabledEditable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEnabledEditable() {
        return isEnabledEditable;
    }

    /**
     * Sets the value of the isEnabledEditable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEnabledEditable(Boolean value) {
        this.isEnabledEditable = value;
    }

    /**
     * Gets the value of the isPrivilegesEditable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPrivilegesEditable() {
        return isPrivilegesEditable;
    }

    /**
     * Sets the value of the isPrivilegesEditable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPrivilegesEditable(Boolean value) {
        this.isPrivilegesEditable = value;
    }

    /**
     * Gets the value of the languageId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLanguageId() {
        return languageId;
    }

    /**
     * Sets the value of the languageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLanguageId(Integer value) {
        this.languageId = value;
    }

    /**
     * Gets the value of the localeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLocaleId() {
        return localeId;
    }

    /**
     * Sets the value of the localeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLocaleId(Integer value) {
        this.localeId = value;
    }

    /**
     * Gets the value of the privileges property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPrivileges() {
        return privileges;
    }

    /**
     * Sets the value of the privileges property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPrivileges(Integer value) {
        this.privileges = value;
    }

}
