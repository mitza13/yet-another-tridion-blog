
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccessControlEntryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccessControlEntryData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AllowedPermissions" type="{http://www.sdltridion.com/ContentManager/R6}Permissions" minOccurs="0"/>
 *         &lt;element name="AllowedRights" type="{http://www.sdltridion.com/ContentManager/R6}Rights" minOccurs="0"/>
 *         &lt;element name="DeniedPermissions" type="{http://www.sdltridion.com/ContentManager/R6}Permissions" minOccurs="0"/>
 *         &lt;element name="DeniedRights" type="{http://www.sdltridion.com/ContentManager/R6}Rights" minOccurs="0"/>
 *         &lt;element name="Trustee" type="{http://www.sdltridion.com/ContentManager/R6}LinkToTrusteeData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccessControlEntryData", propOrder = {
    "allowedPermissions",
    "allowedRights",
    "deniedPermissions",
    "deniedRights",
    "trustee"
})
public class AccessControlEntryData {

    @XmlList
    @XmlElement(name = "AllowedPermissions")
    protected List<String> allowedPermissions;
    @XmlList
    @XmlElement(name = "AllowedRights")
    protected List<String> allowedRights;
    @XmlList
    @XmlElement(name = "DeniedPermissions")
    protected List<String> deniedPermissions;
    @XmlList
    @XmlElement(name = "DeniedRights")
    protected List<String> deniedRights;
    @XmlElement(name = "Trustee", required = true, nillable = true)
    protected LinkToTrusteeData trustee;

    /**
     * Gets the value of the allowedPermissions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedPermissions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedPermissions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAllowedPermissions() {
        if (allowedPermissions == null) {
            allowedPermissions = new ArrayList<String>();
        }
        return this.allowedPermissions;
    }

    /**
     * Gets the value of the allowedRights property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedRights property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedRights().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAllowedRights() {
        if (allowedRights == null) {
            allowedRights = new ArrayList<String>();
        }
        return this.allowedRights;
    }

    /**
     * Gets the value of the deniedPermissions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deniedPermissions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeniedPermissions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDeniedPermissions() {
        if (deniedPermissions == null) {
            deniedPermissions = new ArrayList<String>();
        }
        return this.deniedPermissions;
    }

    /**
     * Gets the value of the deniedRights property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deniedRights property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeniedRights().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDeniedRights() {
        if (deniedRights == null) {
            deniedRights = new ArrayList<String>();
        }
        return this.deniedRights;
    }

    /**
     * Gets the value of the trustee property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToTrusteeData }
     *     
     */
    public LinkToTrusteeData getTrustee() {
        return trustee;
    }

    /**
     * Sets the value of the trustee property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToTrusteeData }
     *     
     */
    public void setTrustee(LinkToTrusteeData value) {
        this.trustee = value;
    }

}
