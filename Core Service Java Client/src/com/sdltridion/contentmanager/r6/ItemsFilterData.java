
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SubjectRelatedListFilterData">
 *       &lt;sequence>
 *         &lt;element name="ComponentTypes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfComponentType" minOccurs="0"/>
 *         &lt;element name="IncludeRelativeWebDavUrlColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ItemTypes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfItemType" minOccurs="0"/>
 *         &lt;element name="LockFilter" type="{http://www.sdltridion.com/ContentManager/R6}LockType" minOccurs="0"/>
 *         &lt;element name="LockResult" type="{http://www.sdltridion.com/ContentManager/R6}LockType" minOccurs="0"/>
 *         &lt;element name="Recursive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SchemaPurposes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfSchemaPurpose" minOccurs="0"/>
 *         &lt;element name="IncludeDescriptionColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemsFilterData", propOrder = {
    "componentTypes",
    "includeRelativeWebDavUrlColumn",
    "itemTypes",
    "lockFilter",
    "lockResult",
    "recursive",
    "schemaPurposes",
    "includeDescriptionColumn"
})
@XmlSeeAlso({
    RepositoryItemsFilterData.class,
    OrganizationalItemItemsFilterData.class
})
public class ItemsFilterData
    extends SubjectRelatedListFilterData
{

    @XmlElement(name = "ComponentTypes", nillable = true)
    protected ArrayOfComponentType componentTypes;
    @XmlElement(name = "IncludeRelativeWebDavUrlColumn", nillable = true)
    protected Boolean includeRelativeWebDavUrlColumn;
    @XmlElement(name = "ItemTypes", nillable = true)
    protected ArrayOfItemType itemTypes;
    @XmlList
    @XmlElement(name = "LockFilter", nillable = true)
    protected List<String> lockFilter;
    @XmlList
    @XmlElement(name = "LockResult", nillable = true)
    protected List<String> lockResult;
    @XmlElement(name = "Recursive", nillable = true)
    protected Boolean recursive;
    @XmlElement(name = "SchemaPurposes", nillable = true)
    protected ArrayOfSchemaPurpose schemaPurposes;
    @XmlElement(name = "IncludeDescriptionColumn")
    protected Boolean includeDescriptionColumn;

    /**
     * Gets the value of the componentTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfComponentType }
     *     
     */
    public ArrayOfComponentType getComponentTypes() {
        return componentTypes;
    }

    /**
     * Sets the value of the componentTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfComponentType }
     *     
     */
    public void setComponentTypes(ArrayOfComponentType value) {
        this.componentTypes = value;
    }

    /**
     * Gets the value of the includeRelativeWebDavUrlColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeRelativeWebDavUrlColumn() {
        return includeRelativeWebDavUrlColumn;
    }

    /**
     * Sets the value of the includeRelativeWebDavUrlColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeRelativeWebDavUrlColumn(Boolean value) {
        this.includeRelativeWebDavUrlColumn = value;
    }

    /**
     * Gets the value of the itemTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItemType }
     *     
     */
    public ArrayOfItemType getItemTypes() {
        return itemTypes;
    }

    /**
     * Sets the value of the itemTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItemType }
     *     
     */
    public void setItemTypes(ArrayOfItemType value) {
        this.itemTypes = value;
    }

    /**
     * Gets the value of the lockFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lockFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLockFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLockFilter() {
        if (lockFilter == null) {
            lockFilter = new ArrayList<String>();
        }
        return this.lockFilter;
    }

    /**
     * Gets the value of the lockResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lockResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLockResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLockResult() {
        if (lockResult == null) {
            lockResult = new ArrayList<String>();
        }
        return this.lockResult;
    }

    /**
     * Gets the value of the recursive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecursive() {
        return recursive;
    }

    /**
     * Sets the value of the recursive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecursive(Boolean value) {
        this.recursive = value;
    }

    /**
     * Gets the value of the schemaPurposes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSchemaPurpose }
     *     
     */
    public ArrayOfSchemaPurpose getSchemaPurposes() {
        return schemaPurposes;
    }

    /**
     * Sets the value of the schemaPurposes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSchemaPurpose }
     *     
     */
    public void setSchemaPurposes(ArrayOfSchemaPurpose value) {
        this.schemaPurposes = value;
    }

    /**
     * Gets the value of the includeDescriptionColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeDescriptionColumn() {
        return includeDescriptionColumn;
    }

    /**
     * Sets the value of the includeDescriptionColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeDescriptionColumn(Boolean value) {
        this.includeDescriptionColumn = value;
    }

}
