
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * <p>Java class for RepositoryLocalObjectsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RepositoryLocalObjectsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideListFilterData">
 *       &lt;sequence>
 *         &lt;element name="ComponentTypes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfComponentType" minOccurs="0"/>
 *         &lt;element name="IncludeLockUserColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeRelativeWebDavUrlColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ItemTypes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfItemType" minOccurs="0"/>
 *         &lt;element name="LockFilter" type="{http://www.sdltridion.com/ContentManager/R6}LockType" minOccurs="0"/>
 *         &lt;element name="LockResult" type="{http://www.sdltridion.com/ContentManager/R6}LockType" minOccurs="0"/>
 *         &lt;element name="LockUser" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="SchemaPurposes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfSchemaPurpose" minOccurs="0"/>
 *         &lt;element name="TemplateTypeIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *         &lt;element name="BasedOnSchemas" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="IncludeLocationInfoColumns" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ItemIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="UseDynamicVersion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeDescriptionColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeDynamicVersionInfoColumns" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepositoryLocalObjectsFilterData", propOrder = {
    "componentTypes",
    "includeLockUserColumn",
    "includeRelativeWebDavUrlColumn",
    "itemTypes",
    "lockFilter",
    "lockResult",
    "lockUser",
    "schemaPurposes",
    "templateTypeIds",
    "basedOnSchemas",
    "includeLocationInfoColumns",
    "itemIds",
    "useDynamicVersion",
    "includeDescriptionColumn",
    "includeDynamicVersionInfoColumns"
})
public class RepositoryLocalObjectsFilterData
    extends SystemWideListFilterData
{

    @XmlElement(name = "ComponentTypes", nillable = true)
    protected ArrayOfComponentType componentTypes;
    @XmlElement(name = "IncludeLockUserColumn", nillable = true)
    protected Boolean includeLockUserColumn;
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
    @XmlElement(name = "LockUser", nillable = true)
    protected LinkToUserData lockUser;
    @XmlElement(name = "SchemaPurposes", nillable = true)
    protected ArrayOfSchemaPurpose schemaPurposes;
    @XmlElement(name = "TemplateTypeIds", nillable = true)
    protected ArrayOfint templateTypeIds;
    @XmlElement(name = "BasedOnSchemas", nillable = true)
    protected ArrayOfLinkToSchemaData basedOnSchemas;
    @XmlElement(name = "IncludeLocationInfoColumns", nillable = true)
    protected Boolean includeLocationInfoColumns;
    @XmlElement(name = "ItemIds", nillable = true)
    protected ArrayOfstring itemIds;
    @XmlElement(name = "UseDynamicVersion", nillable = true)
    protected Boolean useDynamicVersion;
    @XmlElement(name = "IncludeDescriptionColumn")
    protected Boolean includeDescriptionColumn;
    @XmlElement(name = "IncludeDynamicVersionInfoColumns")
    protected Boolean includeDynamicVersionInfoColumns;

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
     * Gets the value of the includeLockUserColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeLockUserColumn() {
        return includeLockUserColumn;
    }

    /**
     * Sets the value of the includeLockUserColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeLockUserColumn(Boolean value) {
        this.includeLockUserColumn = value;
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
     * Gets the value of the lockUser property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getLockUser() {
        return lockUser;
    }

    /**
     * Sets the value of the lockUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setLockUser(LinkToUserData value) {
        this.lockUser = value;
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
     * Gets the value of the templateTypeIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfint }
     *     
     */
    public ArrayOfint getTemplateTypeIds() {
        return templateTypeIds;
    }

    /**
     * Sets the value of the templateTypeIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfint }
     *     
     */
    public void setTemplateTypeIds(ArrayOfint value) {
        this.templateTypeIds = value;
    }

    /**
     * Gets the value of the basedOnSchemas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToSchemaData }
     *     
     */
    public ArrayOfLinkToSchemaData getBasedOnSchemas() {
        return basedOnSchemas;
    }

    /**
     * Sets the value of the basedOnSchemas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToSchemaData }
     *     
     */
    public void setBasedOnSchemas(ArrayOfLinkToSchemaData value) {
        this.basedOnSchemas = value;
    }

    /**
     * Gets the value of the includeLocationInfoColumns property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeLocationInfoColumns() {
        return includeLocationInfoColumns;
    }

    /**
     * Sets the value of the includeLocationInfoColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeLocationInfoColumns(Boolean value) {
        this.includeLocationInfoColumns = value;
    }

    /**
     * Gets the value of the itemIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getItemIds() {
        return itemIds;
    }

    /**
     * Sets the value of the itemIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setItemIds(ArrayOfstring value) {
        this.itemIds = value;
    }

    /**
     * Gets the value of the useDynamicVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseDynamicVersion() {
        return useDynamicVersion;
    }

    /**
     * Sets the value of the useDynamicVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseDynamicVersion(Boolean value) {
        this.useDynamicVersion = value;
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

    /**
     * Gets the value of the includeDynamicVersionInfoColumns property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeDynamicVersionInfoColumns() {
        return includeDynamicVersionInfoColumns;
    }

    /**
     * Sets the value of the includeDynamicVersionInfoColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeDynamicVersionInfoColumns(Boolean value) {
        this.includeDynamicVersionInfoColumns = value;
    }

}
