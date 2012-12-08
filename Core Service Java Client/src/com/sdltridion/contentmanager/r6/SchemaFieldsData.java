
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SchemaFieldsData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SchemaFieldsData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fields" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfItemFieldDefinitionData" minOccurs="0"/>
 *         &lt;element name="MetadataFields" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfItemFieldDefinitionData" minOccurs="0"/>
 *         &lt;element name="NamespaceUri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RootElementName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaFieldsData", propOrder = {
    "fields",
    "metadataFields",
    "namespaceUri",
    "rootElementName"
})
public class SchemaFieldsData {

    @XmlElement(name = "Fields", nillable = true)
    protected ArrayOfItemFieldDefinitionData fields;
    @XmlElement(name = "MetadataFields", nillable = true)
    protected ArrayOfItemFieldDefinitionData metadataFields;
    @XmlElement(name = "NamespaceUri", nillable = true)
    protected String namespaceUri;
    @XmlElement(name = "RootElementName", nillable = true)
    protected String rootElementName;

    /**
     * Gets the value of the fields property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItemFieldDefinitionData }
     *     
     */
    public ArrayOfItemFieldDefinitionData getFields() {
        return fields;
    }

    /**
     * Sets the value of the fields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItemFieldDefinitionData }
     *     
     */
    public void setFields(ArrayOfItemFieldDefinitionData value) {
        this.fields = value;
    }

    /**
     * Gets the value of the metadataFields property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItemFieldDefinitionData }
     *     
     */
    public ArrayOfItemFieldDefinitionData getMetadataFields() {
        return metadataFields;
    }

    /**
     * Sets the value of the metadataFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItemFieldDefinitionData }
     *     
     */
    public void setMetadataFields(ArrayOfItemFieldDefinitionData value) {
        this.metadataFields = value;
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

}
