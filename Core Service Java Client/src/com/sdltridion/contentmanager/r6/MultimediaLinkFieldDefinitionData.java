
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultimediaLinkFieldDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultimediaLinkFieldDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ItemFieldDefinitionData">
 *       &lt;sequence>
 *         &lt;element name="AllowedTargetSchemas" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToSchemaData"/>
 *         &lt;element name="DefaultValue" type="{http://www.sdltridion.com/ContentManager/R6}LinkToComponentData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultimediaLinkFieldDefinitionData", propOrder = {
    "allowedTargetSchemas",
    "defaultValue"
})
public class MultimediaLinkFieldDefinitionData
    extends ItemFieldDefinitionData
{

    @XmlElement(name = "AllowedTargetSchemas", required = true, nillable = true)
    protected ArrayOfLinkToSchemaData allowedTargetSchemas;
    @XmlElement(name = "DefaultValue", nillable = true)
    protected LinkToComponentData defaultValue;

    /**
     * Gets the value of the allowedTargetSchemas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToSchemaData }
     *     
     */
    public ArrayOfLinkToSchemaData getAllowedTargetSchemas() {
        return allowedTargetSchemas;
    }

    /**
     * Sets the value of the allowedTargetSchemas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToSchemaData }
     *     
     */
    public void setAllowedTargetSchemas(ArrayOfLinkToSchemaData value) {
        this.allowedTargetSchemas = value;
    }

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToComponentData }
     *     
     */
    public LinkToComponentData getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToComponentData }
     *     
     */
    public void setDefaultValue(LinkToComponentData value) {
        this.defaultValue = value;
    }

}
