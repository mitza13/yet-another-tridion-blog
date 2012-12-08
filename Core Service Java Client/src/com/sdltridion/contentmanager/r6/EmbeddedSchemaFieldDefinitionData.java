
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EmbeddedSchemaFieldDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EmbeddedSchemaFieldDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ItemFieldDefinitionData">
 *       &lt;sequence>
 *         &lt;element name="EmbeddedFields" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfItemFieldDefinitionData" minOccurs="0"/>
 *         &lt;element name="EmbeddedSchema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmbeddedSchemaFieldDefinitionData", propOrder = {
    "embeddedFields",
    "embeddedSchema"
})
public class EmbeddedSchemaFieldDefinitionData
    extends ItemFieldDefinitionData
{

    @XmlElement(name = "EmbeddedFields", nillable = true)
    protected ArrayOfItemFieldDefinitionData embeddedFields;
    @XmlElement(name = "EmbeddedSchema", required = true, nillable = true)
    protected LinkToSchemaData embeddedSchema;

    /**
     * Gets the value of the embeddedFields property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItemFieldDefinitionData }
     *     
     */
    public ArrayOfItemFieldDefinitionData getEmbeddedFields() {
        return embeddedFields;
    }

    /**
     * Sets the value of the embeddedFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItemFieldDefinitionData }
     *     
     */
    public void setEmbeddedFields(ArrayOfItemFieldDefinitionData value) {
        this.embeddedFields = value;
    }

    /**
     * Gets the value of the embeddedSchema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getEmbeddedSchema() {
        return embeddedSchema;
    }

    /**
     * Sets the value of the embeddedSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setEmbeddedSchema(LinkToSchemaData value) {
        this.embeddedSchema = value;
    }

}
