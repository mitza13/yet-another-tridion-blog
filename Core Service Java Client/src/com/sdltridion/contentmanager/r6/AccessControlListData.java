
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccessControlListData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccessControlListData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccessControlEntries" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfAccessControlEntryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccessControlListData", propOrder = {
    "accessControlEntries"
})
public class AccessControlListData {

    @XmlElement(name = "AccessControlEntries", nillable = true)
    protected ArrayOfAccessControlEntryData accessControlEntries;

    /**
     * Gets the value of the accessControlEntries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAccessControlEntryData }
     *     
     */
    public ArrayOfAccessControlEntryData getAccessControlEntries() {
        return accessControlEntries;
    }

    /**
     * Sets the value of the accessControlEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAccessControlEntryData }
     *     
     */
    public void setAccessControlEntries(ArrayOfAccessControlEntryData value) {
        this.accessControlEntries = value;
    }

}
