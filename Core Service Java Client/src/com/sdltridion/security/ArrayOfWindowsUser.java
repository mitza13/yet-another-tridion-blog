
package com.sdltridion.security;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWindowsUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWindowsUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WindowsUser" type="{http://www.sdltridion.com/Security}WindowsUser" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWindowsUser", propOrder = {
    "windowsUser"
})
public class ArrayOfWindowsUser {

    @XmlElement(name = "WindowsUser", nillable = true)
    protected List<WindowsUser> windowsUser;

    /**
     * Gets the value of the windowsUser property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the windowsUser property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWindowsUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WindowsUser }
     * 
     * 
     */
    public List<WindowsUser> getWindowsUser() {
        if (windowsUser == null) {
            windowsUser = new ArrayList<WindowsUser>();
        }
        return this.windowsUser;
    }

}
