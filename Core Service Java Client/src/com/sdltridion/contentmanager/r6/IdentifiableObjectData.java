
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentifiableObjectData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentifiableObjectData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AllowedActions" type="{http://www.sdltridion.com/ContentManager/R6}AllowedActions" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.sdltridion.com/ContentManager/R6}TcmUri"/>
 *         &lt;element name="IsEditable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VersionInfo" type="{http://www.sdltridion.com/ContentManager/R6}BasicVersionInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentifiableObjectData", propOrder = {
    "allowedActions",
    "id",
    "isEditable",
    "title",
    "versionInfo"
})
@XmlSeeAlso({
    ProcessDefinitionAssociationData.class,
    RepositoryLocalObjectData.class,
    SystemWideObjectData.class,
    WorkflowObjectData.class
})
public class IdentifiableObjectData {

    @XmlElement(name = "AllowedActions", nillable = true)
    protected AllowedActions allowedActions;
    @XmlElement(name = "Id", required = true, nillable = true)
    protected String id;
    @XmlElement(name = "IsEditable", nillable = true)
    protected Boolean isEditable;
    @XmlElement(name = "Title", nillable = true)
    protected String title;
    @XmlElement(name = "VersionInfo", nillable = true)
    protected BasicVersionInfo versionInfo;

    /**
     * Gets the value of the allowedActions property.
     * 
     * @return
     *     possible object is
     *     {@link AllowedActions }
     *     
     */
    public AllowedActions getAllowedActions() {
        return allowedActions;
    }

    /**
     * Sets the value of the allowedActions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowedActions }
     *     
     */
    public void setAllowedActions(AllowedActions value) {
        this.allowedActions = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the isEditable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEditable() {
        return isEditable;
    }

    /**
     * Sets the value of the isEditable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEditable(Boolean value) {
        this.isEditable = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the versionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BasicVersionInfo }
     *     
     */
    public BasicVersionInfo getVersionInfo() {
        return versionInfo;
    }

    /**
     * Sets the value of the versionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicVersionInfo }
     *     
     */
    public void setVersionInfo(BasicVersionInfo value) {
        this.versionInfo = value;
    }

}
