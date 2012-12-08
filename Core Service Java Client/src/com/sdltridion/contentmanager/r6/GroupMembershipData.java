
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupMembershipData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupMembershipData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Group" type="{http://www.sdltridion.com/ContentManager/R6}LinkToGroupData" minOccurs="0"/>
 *         &lt;element name="Scope" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkWithIsEditableToRepositoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupMembershipData", propOrder = {
    "group",
    "scope"
})
public class GroupMembershipData {

    @XmlElement(name = "Group", nillable = true)
    protected LinkToGroupData group;
    @XmlElement(name = "Scope", nillable = true)
    protected ArrayOfLinkWithIsEditableToRepositoryData scope;

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToGroupData }
     *     
     */
    public LinkToGroupData getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToGroupData }
     *     
     */
    public void setGroup(LinkToGroupData value) {
        this.group = value;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkWithIsEditableToRepositoryData }
     *     
     */
    public ArrayOfLinkWithIsEditableToRepositoryData getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkWithIsEditableToRepositoryData }
     *     
     */
    public void setScope(ArrayOfLinkWithIsEditableToRepositoryData value) {
        this.scope = value;
    }

}
