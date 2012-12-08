
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RepositoryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RepositoryData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideObjectData">
 *       &lt;sequence>
 *         &lt;element name="AccessControlList" type="{http://www.sdltridion.com/ContentManager/R6}AccessControlListData" minOccurs="0"/>
 *         &lt;element name="CategoriesXsd" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="DefaultMultimediaSchema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="HasChildren" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocationInfo" type="{http://www.sdltridion.com/ContentManager/R6}LocationInfo" minOccurs="0"/>
 *         &lt;element name="Metadata" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="MetadataSchema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="Parents" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="RootFolder" type="{http://www.sdltridion.com/ContentManager/R6}LinkToFolderData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepositoryData", propOrder = {
    "accessControlList",
    "categoriesXsd",
    "defaultMultimediaSchema",
    "hasChildren",
    "key",
    "locationInfo",
    "metadata",
    "metadataSchema",
    "parents",
    "rootFolder"
})
@XmlSeeAlso({
    PublicationData.class
})
public class RepositoryData
    extends SystemWideObjectData
{

    @XmlElement(name = "AccessControlList", nillable = true)
    protected AccessControlListData accessControlList;
    @XmlElement(name = "CategoriesXsd", nillable = true)
    protected String categoriesXsd;
    @XmlElement(name = "DefaultMultimediaSchema", nillable = true)
    protected LinkToSchemaData defaultMultimediaSchema;
    @XmlElement(name = "HasChildren", nillable = true)
    protected Boolean hasChildren;
    @XmlElement(name = "Key", nillable = true)
    protected String key;
    @XmlElement(name = "LocationInfo", nillable = true)
    protected LocationInfo locationInfo;
    @XmlElement(name = "Metadata", nillable = true)
    protected String metadata;
    @XmlElement(name = "MetadataSchema", nillable = true)
    protected LinkToSchemaData metadataSchema;
    @XmlElement(name = "Parents", nillable = true)
    protected ArrayOfLinkToRepositoryData parents;
    @XmlElement(name = "RootFolder", nillable = true)
    protected LinkToFolderData rootFolder;

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
     * Gets the value of the categoriesXsd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoriesXsd() {
        return categoriesXsd;
    }

    /**
     * Sets the value of the categoriesXsd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoriesXsd(String value) {
        this.categoriesXsd = value;
    }

    /**
     * Gets the value of the defaultMultimediaSchema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getDefaultMultimediaSchema() {
        return defaultMultimediaSchema;
    }

    /**
     * Sets the value of the defaultMultimediaSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setDefaultMultimediaSchema(LinkToSchemaData value) {
        this.defaultMultimediaSchema = value;
    }

    /**
     * Gets the value of the hasChildren property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasChildren() {
        return hasChildren;
    }

    /**
     * Sets the value of the hasChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasChildren(Boolean value) {
        this.hasChildren = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the locationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LocationInfo }
     *     
     */
    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    /**
     * Sets the value of the locationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationInfo }
     *     
     */
    public void setLocationInfo(LocationInfo value) {
        this.locationInfo = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetadata(String value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the metadataSchema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getMetadataSchema() {
        return metadataSchema;
    }

    /**
     * Sets the value of the metadataSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setMetadataSchema(LinkToSchemaData value) {
        this.metadataSchema = value;
    }

    /**
     * Gets the value of the parents property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToRepositoryData }
     *     
     */
    public ArrayOfLinkToRepositoryData getParents() {
        return parents;
    }

    /**
     * Sets the value of the parents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToRepositoryData }
     *     
     */
    public void setParents(ArrayOfLinkToRepositoryData value) {
        this.parents = value;
    }

    /**
     * Gets the value of the rootFolder property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToFolderData }
     *     
     */
    public LinkToFolderData getRootFolder() {
        return rootFolder;
    }

    /**
     * Sets the value of the rootFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToFolderData }
     *     
     */
    public void setRootFolder(LinkToFolderData value) {
        this.rootFolder = value;
    }

}
