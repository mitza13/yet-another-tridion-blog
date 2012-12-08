
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganizationalItemData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationalItemData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}RepositoryLocalObjectData">
 *       &lt;sequence>
 *         &lt;element name="AccessControlList" type="{http://www.sdltridion.com/ContentManager/R6}AccessControlListData" minOccurs="0"/>
 *         &lt;element name="IsPermissionsInheritanceRoot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsRootOrganizationalItem" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationalItemData", propOrder = {
    "accessControlList",
    "isPermissionsInheritanceRoot",
    "isRootOrganizationalItem"
})
@XmlSeeAlso({
    VirtualFolderData.class,
    StructureGroupData.class,
    FolderData.class,
    CategoryData.class
})
public class OrganizationalItemData
    extends RepositoryLocalObjectData
{

    @XmlElement(name = "AccessControlList", nillable = true)
    protected AccessControlListData accessControlList;
    @XmlElement(name = "IsPermissionsInheritanceRoot", nillable = true)
    protected Boolean isPermissionsInheritanceRoot;
    @XmlElement(name = "IsRootOrganizationalItem", nillable = true)
    protected Boolean isRootOrganizationalItem;

    /**
     * Gets the value of the accessControlList property.
     * 
     * @return
     *     possible object is
     *     {@link AccessControlListData }
     *     
     */
    public AccessControlListData getAccessControlList() {
        return accessControlList;
    }

    /**
     * Sets the value of the accessControlList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessControlListData }
     *     
     */
    public void setAccessControlList(AccessControlListData value) {
        this.accessControlList = value;
    }

    /**
     * Gets the value of the isPermissionsInheritanceRoot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPermissionsInheritanceRoot() {
        return isPermissionsInheritanceRoot;
    }

    /**
     * Sets the value of the isPermissionsInheritanceRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPermissionsInheritanceRoot(Boolean value) {
        this.isPermissionsInheritanceRoot = value;
    }

    /**
     * Gets the value of the isRootOrganizationalItem property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRootOrganizationalItem() {
        return isRootOrganizationalItem;
    }

    /**
     * Sets the value of the isRootOrganizationalItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRootOrganizationalItem(Boolean value) {
        this.isRootOrganizationalItem = value;
    }

}
