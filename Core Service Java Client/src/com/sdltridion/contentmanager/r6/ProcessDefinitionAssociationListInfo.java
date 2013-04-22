
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessDefinitionAssociationListInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessDefinitionAssociationListInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ListInfo">
 *       &lt;sequence>
 *         &lt;element name="ControlledItemType" type="{http://www.sdltridion.com/ContentManager/R6}ItemType" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsPublished" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ItemLock" type="{http://www.sdltridion.com/ContentManager/R6}LockType" minOccurs="0"/>
 *         &lt;element name="PublicationTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessDefinitionAssociationListInfo", propOrder = {
    "controlledItemType",
    "fileName",
    "isPublished",
    "itemLock",
    "publicationTitle",
    "subType"
})
public class ProcessDefinitionAssociationListInfo
    extends ListInfo
{

    @XmlElement(name = "ControlledItemType", nillable = true)
    protected ItemType controlledItemType;
    @XmlElement(name = "FileName", nillable = true)
    protected String fileName;
    @XmlElement(name = "IsPublished", nillable = true)
    protected Boolean isPublished;
    @XmlList
    @XmlElement(name = "ItemLock", nillable = true)
    protected List<String> itemLock;
    @XmlElement(name = "PublicationTitle", nillable = true)
    protected String publicationTitle;
    @XmlElement(name = "SubType", nillable = true)
    protected Integer subType;

    /**
     * Gets the value of the controlledItemType property.
     * 
     * @return
     *     possible object is
     *     {@link ItemType }
     *     
     */
    public ItemType getControlledItemType() {
        return controlledItemType;
    }

    /**
     * Sets the value of the controlledItemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemType }
     *     
     */
    public void setControlledItemType(ItemType value) {
        this.controlledItemType = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the isPublished property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPublished() {
        return isPublished;
    }

    /**
     * Sets the value of the isPublished property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPublished(Boolean value) {
        this.isPublished = value;
    }

    /**
     * Gets the value of the itemLock property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemLock property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemLock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getItemLock() {
        if (itemLock == null) {
            itemLock = new ArrayList<String>();
        }
        return this.itemLock;
    }

    /**
     * Gets the value of the publicationTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationTitle() {
        return publicationTitle;
    }

    /**
     * Sets the value of the publicationTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationTitle(String value) {
        this.publicationTitle = value;
    }

    /**
     * Gets the value of the subType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubType(Integer value) {
        this.subType = value;
    }

}
