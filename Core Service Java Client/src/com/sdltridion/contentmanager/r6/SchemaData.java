
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SchemaData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SchemaData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}VersionedItemData">
 *       &lt;sequence>
 *         &lt;element name="AllowedMultimediaTypes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToMultimediaTypeData" minOccurs="0"/>
 *         &lt;element name="ComponentProcess" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsTridionWebSchema" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NamespaceUri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Purpose" type="{http://www.sdltridion.com/ContentManager/R6}SchemaPurpose" minOccurs="0"/>
 *         &lt;element name="RootElementName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Xsd" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="BundleProcess" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *         &lt;element name="DeleteBundleOnProcessFinished" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaData", propOrder = {
    "allowedMultimediaTypes",
    "componentProcess",
    "description",
    "isTridionWebSchema",
    "namespaceUri",
    "purpose",
    "rootElementName",
    "xsd",
    "bundleProcess",
    "deleteBundleOnProcessFinished"
})
@XmlSeeAlso({
    BundleTypeData.class
})
public class SchemaData
    extends VersionedItemData
{

    @XmlElement(name = "AllowedMultimediaTypes", nillable = true)
    protected ArrayOfLinkToMultimediaTypeData allowedMultimediaTypes;
    @XmlElement(name = "ComponentProcess", nillable = true)
    protected LinkToProcessDefinitionData componentProcess;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "IsTridionWebSchema", nillable = true)
    protected Boolean isTridionWebSchema;
    @XmlElement(name = "NamespaceUri", nillable = true)
    protected String namespaceUri;
    @XmlElement(name = "Purpose", nillable = true)
    protected SchemaPurpose purpose;
    @XmlElement(name = "RootElementName", nillable = true)
    protected String rootElementName;
    @XmlElement(name = "Xsd", nillable = true)
    protected String xsd;
    @XmlElement(name = "BundleProcess", nillable = true)
    protected LinkToProcessDefinitionData bundleProcess;
    @XmlElement(name = "DeleteBundleOnProcessFinished", nillable = true)
    protected Boolean deleteBundleOnProcessFinished;

    /**
     * Gets the value of the allowedMultimediaTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToMultimediaTypeData }
     *     
     */
    public ArrayOfLinkToMultimediaTypeData getAllowedMultimediaTypes() {
        return allowedMultimediaTypes;
    }

    /**
     * Sets the value of the allowedMultimediaTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToMultimediaTypeData }
     *     
     */
    public void setAllowedMultimediaTypes(ArrayOfLinkToMultimediaTypeData value) {
        this.allowedMultimediaTypes = value;
    }

    /**
     * Gets the value of the componentProcess property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public LinkToProcessDefinitionData getComponentProcess() {
        return componentProcess;
    }

    /**
     * Sets the value of the componentProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public void setComponentProcess(LinkToProcessDefinitionData value) {
        this.componentProcess = value;
    }

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
     * Gets the value of the isTridionWebSchema property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsTridionWebSchema() {
        return isTridionWebSchema;
    }

    /**
     * Sets the value of the isTridionWebSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsTridionWebSchema(Boolean value) {
        this.isTridionWebSchema = value;
    }

    /**
     * Gets the value of the namespaceUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespaceUri() {
        return namespaceUri;
    }

    /**
     * Sets the value of the namespaceUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespaceUri(String value) {
        this.namespaceUri = value;
    }

    /**
     * Gets the value of the purpose property.
     * 
     * @return
     *     possible object is
     *     {@link SchemaPurpose }
     *     
     */
    public SchemaPurpose getPurpose() {
        return purpose;
    }

    /**
     * Sets the value of the purpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemaPurpose }
     *     
     */
    public void setPurpose(SchemaPurpose value) {
        this.purpose = value;
    }

    /**
     * Gets the value of the rootElementName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootElementName() {
        return rootElementName;
    }

    /**
     * Sets the value of the rootElementName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootElementName(String value) {
        this.rootElementName = value;
    }

    /**
     * Gets the value of the xsd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXsd() {
        return xsd;
    }

    /**
     * Sets the value of the xsd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXsd(String value) {
        this.xsd = value;
    }

    /**
     * Gets the value of the bundleProcess property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public LinkToProcessDefinitionData getBundleProcess() {
        return bundleProcess;
    }

    /**
     * Sets the value of the bundleProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public void setBundleProcess(LinkToProcessDefinitionData value) {
        this.bundleProcess = value;
    }

    /**
     * Gets the value of the deleteBundleOnProcessFinished property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeleteBundleOnProcessFinished() {
        return deleteBundleOnProcessFinished;
    }

    /**
     * Sets the value of the deleteBundleOnProcessFinished property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleteBundleOnProcessFinished(Boolean value) {
        this.deleteBundleOnProcessFinished = value;
    }

}
