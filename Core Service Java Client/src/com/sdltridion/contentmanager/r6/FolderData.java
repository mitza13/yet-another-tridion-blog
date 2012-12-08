
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FolderData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FolderData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}OrganizationalItemData">
 *       &lt;sequence>
 *         &lt;element name="IsLinkedSchemaMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LinkedSchema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FolderData", propOrder = {
    "isLinkedSchemaMandatory",
    "linkedSchema"
})
public class FolderData
    extends OrganizationalItemData
{

    @XmlElement(name = "IsLinkedSchemaMandatory", nillable = true)
    protected Boolean isLinkedSchemaMandatory;
    @XmlElement(name = "LinkedSchema", nillable = true)
    protected LinkToSchemaData linkedSchema;

    /**
     * Gets the value of the isLinkedSchemaMandatory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsLinkedSchemaMandatory() {
        return isLinkedSchemaMandatory;
    }

    /**
     * Sets the value of the isLinkedSchemaMandatory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsLinkedSchemaMandatory(Boolean value) {
        this.isLinkedSchemaMandatory = value;
    }

    /**
     * Gets the value of the linkedSchema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getLinkedSchema() {
        return linkedSchema;
    }

    /**
     * Sets the value of the linkedSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setLinkedSchema(LinkToSchemaData value) {
        this.linkedSchema = value;
    }

}
