
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualFolderData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualFolderData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}OrganizationalItemData">
 *       &lt;sequence>
 *         &lt;element name="Configuration" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="TypeSchema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualFolderData", propOrder = {
    "configuration",
    "typeSchema"
})
public class VirtualFolderData
    extends OrganizationalItemData
{

    @XmlElement(name = "Configuration", nillable = true)
    protected String configuration;
    @XmlElement(name = "TypeSchema", nillable = true)
    protected LinkToSchemaData typeSchema;

    /**
     * Gets the value of the configuration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfiguration(String value) {
        this.configuration = value;
    }

    /**
     * Gets the value of the typeSchema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getTypeSchema() {
        return typeSchema;
    }

    /**
     * Sets the value of the typeSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setTypeSchema(LinkToSchemaData value) {
        this.typeSchema = value;
    }

}
