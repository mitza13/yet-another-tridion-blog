
package com.sdltridion.security;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDirectoryServiceUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDirectoryServiceUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DirectoryServiceUser" type="{http://www.sdltridion.com/Security}DirectoryServiceUser" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDirectoryServiceUser", propOrder = {
    "directoryServiceUser"
})
public class ArrayOfDirectoryServiceUser {

    @XmlElement(name = "DirectoryServiceUser", nillable = true)
    protected List<DirectoryServiceUser> directoryServiceUser;

    /**
     * Gets the value of the directoryServiceUser property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directoryServiceUser property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectoryServiceUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DirectoryServiceUser }
     * 
     * 
     */
    public List<DirectoryServiceUser> getDirectoryServiceUser() {
        if (directoryServiceUser == null) {
            directoryServiceUser = new ArrayList<DirectoryServiceUser>();
        }
        return this.directoryServiceUser;
    }

}
