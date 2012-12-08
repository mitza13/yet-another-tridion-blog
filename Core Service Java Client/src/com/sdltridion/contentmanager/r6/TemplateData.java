
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TemplateData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TemplateData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}VersionedItemData">
 *       &lt;sequence>
 *         &lt;element name="BinaryContent" type="{http://www.sdltridion.com/ContentManager/R6}BinaryContentData" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParameterSchema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="TemplateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemplateData", propOrder = {
    "binaryContent",
    "content",
    "parameterSchema",
    "templateType"
})
@XmlSeeAlso({
    PageTemplateData.class,
    TemplateBuildingBlockData.class,
    ComponentTemplateData.class
})
public class TemplateData
    extends VersionedItemData
{

    @XmlElement(name = "BinaryContent", nillable = true)
    protected BinaryContentData binaryContent;
    @XmlElement(name = "Content", nillable = true)
    protected String content;
    @XmlElement(name = "ParameterSchema", nillable = true)
    protected LinkToSchemaData parameterSchema;
    @XmlElement(name = "TemplateType", nillable = true)
    protected String templateType;

    /**
     * Gets the value of the binaryContent property.
     * 
     * @return
     *     possible object is
     *     {@link BinaryContentData }
     *     
     */
    public BinaryContentData getBinaryContent() {
        return binaryContent;
    }

    /**
     * Sets the value of the binaryContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BinaryContentData }
     *     
     */
    public void setBinaryContent(BinaryContentData value) {
        this.binaryContent = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the parameterSchema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getParameterSchema() {
        return parameterSchema;
    }

    /**
     * Sets the value of the parameterSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setParameterSchema(LinkToSchemaData value) {
        this.parameterSchema = value;
    }

    /**
     * Gets the value of the templateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateType() {
        return templateType;
    }

    /**
     * Sets the value of the templateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateType(String value) {
        this.templateType = value;
    }

}
