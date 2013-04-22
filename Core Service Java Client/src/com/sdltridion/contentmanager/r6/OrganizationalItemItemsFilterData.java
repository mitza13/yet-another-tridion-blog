
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;


/**
 * <p>Java class for OrganizationalItemItemsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationalItemItemsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ItemsFilterData">
 *       &lt;sequence>
 *         &lt;element name="BasedOnSchemas" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="NotBasedOnSchema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="ShowNewItems" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TemplateTypeIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *         &lt;element name="FailIfNoAccessToItems" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludePathColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationalItemItemsFilterData", propOrder = {
    "basedOnSchemas",
    "notBasedOnSchema",
    "showNewItems",
    "templateTypeIds",
    "failIfNoAccessToItems",
    "includePathColumn"
})
public class OrganizationalItemItemsFilterData
    extends ItemsFilterData
{

    @XmlElement(name = "BasedOnSchemas", nillable = true)
    protected ArrayOfLinkToSchemaData basedOnSchemas;
    @XmlElement(name = "NotBasedOnSchema", nillable = true)
    protected LinkToSchemaData notBasedOnSchema;
    @XmlElement(name = "ShowNewItems", nillable = true)
    protected Boolean showNewItems;
    @XmlElement(name = "TemplateTypeIds", nillable = true)
    protected ArrayOfint templateTypeIds;
    @XmlElement(name = "FailIfNoAccessToItems")
    protected Boolean failIfNoAccessToItems;
    @XmlElement(name = "IncludePathColumn")
    protected Boolean includePathColumn;

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
     * Gets the value of the notBasedOnSchema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getNotBasedOnSchema() {
        return notBasedOnSchema;
    }

    /**
     * Sets the value of the notBasedOnSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setNotBasedOnSchema(LinkToSchemaData value) {
        this.notBasedOnSchema = value;
    }

    /**
     * Gets the value of the showNewItems property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowNewItems() {
        return showNewItems;
    }

    /**
     * Sets the value of the showNewItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowNewItems(Boolean value) {
        this.showNewItems = value;
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
     * Gets the value of the failIfNoAccessToItems property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFailIfNoAccessToItems() {
        return failIfNoAccessToItems;
    }

    /**
     * Sets the value of the failIfNoAccessToItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFailIfNoAccessToItems(Boolean value) {
        this.failIfNoAccessToItems = value;
    }

    /**
     * Gets the value of the includePathColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludePathColumn() {
        return includePathColumn;
    }

    /**
     * Sets the value of the includePathColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludePathColumn(Boolean value) {
        this.includePathColumn = value;
    }

}
