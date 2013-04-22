
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RepositoryLocalObjectData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RepositoryLocalObjectData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}IdentifiableObjectData">
 *       &lt;sequence>
 *         &lt;element name="BluePrintInfo" type="{http://www.sdltridion.com/ContentManager/R6}BluePrintInfo" minOccurs="0"/>
 *         &lt;element name="IsPublishedInContext" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LocationInfo" type="{http://www.sdltridion.com/ContentManager/R6}LocationInfo" minOccurs="0"/>
 *         &lt;element name="Metadata" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="MetadataSchema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="LockInfo" type="{http://www.sdltridion.com/ContentManager/R6}LockInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepositoryLocalObjectData", propOrder = {
    "bluePrintInfo",
    "isPublishedInContext",
    "locationInfo",
    "metadata",
    "metadataSchema",
    "lockInfo"
})
@XmlSeeAlso({
    KeywordData.class,
    ProcessDefinitionData.class,
    TargetGroupData.class,
    VersionedItemData.class,
    OrganizationalItemData.class
})
public class RepositoryLocalObjectData
    extends IdentifiableObjectData
{

    @XmlElement(name = "BluePrintInfo", nillable = true)
    protected BluePrintInfo bluePrintInfo;
    @XmlElement(name = "IsPublishedInContext", nillable = true)
    protected Boolean isPublishedInContext;
    @XmlElement(name = "LocationInfo", nillable = true)
    protected LocationInfo locationInfo;
    @XmlElement(name = "Metadata", nillable = true)
    protected String metadata;
    @XmlElement(name = "MetadataSchema", nillable = true)
    protected LinkToSchemaData metadataSchema;
    @XmlElement(name = "LockInfo", nillable = true)
    protected LockInfo lockInfo;

    /**
     * Gets the value of the bluePrintInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BluePrintInfo }
     *     
     */
    public BluePrintInfo getBluePrintInfo() {
        return bluePrintInfo;
    }

    /**
     * Sets the value of the bluePrintInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BluePrintInfo }
     *     
     */
    public void setBluePrintInfo(BluePrintInfo value) {
        this.bluePrintInfo = value;
    }

    /**
     * Gets the value of the isPublishedInContext property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPublishedInContext() {
        return isPublishedInContext;
    }

    /**
     * Sets the value of the isPublishedInContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPublishedInContext(Boolean value) {
        this.isPublishedInContext = value;
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
     * Gets the value of the lockInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LockInfo }
     *     
     */
    public LockInfo getLockInfo() {
        return lockInfo;
    }

    /**
     * Sets the value of the lockInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LockInfo }
     *     
     */
    public void setLockInfo(LockInfo value) {
        this.lockInfo = value;
    }

}
