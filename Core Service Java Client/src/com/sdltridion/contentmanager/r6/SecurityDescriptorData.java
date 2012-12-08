
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecurityDescriptorData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityDescriptorData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Permissions" type="{http://www.sdltridion.com/ContentManager/R6}Permissions" minOccurs="0"/>
 *         &lt;element name="Rights" type="{http://www.sdltridion.com/ContentManager/R6}Rights" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityDescriptorData", propOrder = {
    "permissions",
    "rights"
})
public class SecurityDescriptorData {

    @XmlList
    @XmlElement(name = "Permissions")
    protected List<String> permissions;
    @XmlList
    @XmlElement(name = "Rights")
    protected List<String> rights;

    /**
     * Gets the value of the permissions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the permissions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPermissions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPermissions() {
        if (permissions == null) {
            permissions = new ArrayList<String>();
        }
        return this.permissions;
    }

    /**
     * Gets the value of the rights property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rights property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRights().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRights() {
        if (rights == null) {
            rights = new ArrayList<String>();
        }
        return this.rights;
    }

}
