
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrusteeData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrusteeData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideObjectData">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupMemberships" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfGroupMembershipData" minOccurs="0"/>
 *         &lt;element name="IsPredefined" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrusteeData", propOrder = {
    "description",
    "groupMemberships",
    "isPredefined"
})
@XmlSeeAlso({
    UserData.class,
    GroupData.class
})
public class TrusteeData
    extends SystemWideObjectData
{

    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "GroupMemberships", nillable = true)
    protected ArrayOfGroupMembershipData groupMemberships;
    @XmlElement(name = "IsPredefined", nillable = true)
    protected Boolean isPredefined;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the groupMemberships property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGroupMembershipData }
     *     
     */
    public ArrayOfGroupMembershipData getGroupMemberships() {
        return groupMemberships;
    }

    /**
     * Sets the value of the groupMemberships property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGroupMembershipData }
     *     
     */
    public void setGroupMemberships(ArrayOfGroupMembershipData value) {
        this.groupMemberships = value;
    }

    /**
     * Gets the value of the isPredefined property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPredefined() {
        return isPredefined;
    }

    /**
     * Sets the value of the isPredefined property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPredefined(Boolean value) {
        this.isPredefined = value;
    }

}
