
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApplicationData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplicationData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ApplicationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Data" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="ManagedLinks" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLink" minOccurs="0"/>
 *         &lt;element name="TypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsInherited" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OwningRepositoryId" type="{http://www.sdltridion.com/ContentManager/R6}TcmUri" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationData", propOrder = {
    "applicationId",
    "data",
    "managedLinks",
    "typeId",
    "isInherited",
    "owningRepositoryId"
})
public class ApplicationData {

    @XmlElement(name = "ApplicationId", required = true, nillable = true)
    protected String applicationId;
    @XmlElement(name = "Data", nillable = true)
    protected byte[] data;
    @XmlElement(name = "ManagedLinks", nillable = true)
    protected ArrayOfLink managedLinks;
    @XmlElement(name = "TypeId", nillable = true)
    protected String typeId;
    @XmlElement(name = "IsInherited", nillable = true)
    protected Boolean isInherited;
    @XmlElement(name = "OwningRepositoryId", nillable = true)
    protected String owningRepositoryId;

    /**
     * Gets the value of the applicationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the value of the applicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationId(String value) {
        this.applicationId = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setData(byte[] value) {
        this.data = ((byte[]) value);
    }

    /**
     * Gets the value of the managedLinks property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLink }
     *     
     */
    public ArrayOfLink getManagedLinks() {
        return managedLinks;
    }

    /**
     * Sets the value of the managedLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLink }
     *     
     */
    public void setManagedLinks(ArrayOfLink value) {
        this.managedLinks = value;
    }

    /**
     * Gets the value of the typeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * Sets the value of the typeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeId(String value) {
        this.typeId = value;
    }

    /**
     * Gets the value of the isInherited property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsInherited() {
        return isInherited;
    }

    /**
     * Sets the value of the isInherited property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsInherited(Boolean value) {
        this.isInherited = value;
    }

    /**
     * Gets the value of the owningRepositoryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwningRepositoryId() {
        return owningRepositoryId;
    }

    /**
     * Sets the value of the owningRepositoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwningRepositoryId(String value) {
        this.owningRepositoryId = value;
    }

}
