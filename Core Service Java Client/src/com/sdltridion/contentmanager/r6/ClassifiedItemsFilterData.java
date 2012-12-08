
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClassifiedItemsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassifiedItemsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SubjectRelatedListFilterData">
 *       &lt;sequence>
 *         &lt;element name="BasedOnSchemas" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="ItemTypes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfItemType" minOccurs="0"/>
 *         &lt;element name="ResolveDescendantKeywords" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ResultLimit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassifiedItemsFilterData", propOrder = {
    "basedOnSchemas",
    "itemTypes",
    "resolveDescendantKeywords",
    "resultLimit"
})
public class ClassifiedItemsFilterData
    extends SubjectRelatedListFilterData
{

    @XmlElement(name = "BasedOnSchemas", nillable = true)
    protected ArrayOfLinkToSchemaData basedOnSchemas;
    @XmlElement(name = "ItemTypes", nillable = true)
    protected ArrayOfItemType itemTypes;
    @XmlElement(name = "ResolveDescendantKeywords", nillable = true)
    protected Boolean resolveDescendantKeywords;
    @XmlElement(name = "ResultLimit", nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long resultLimit;

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
     * Gets the value of the itemTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItemType }
     *     
     */
    public ArrayOfItemType getItemTypes() {
        return itemTypes;
    }

    /**
     * Sets the value of the itemTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItemType }
     *     
     */
    public void setItemTypes(ArrayOfItemType value) {
        this.itemTypes = value;
    }

    /**
     * Gets the value of the resolveDescendantKeywords property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isResolveDescendantKeywords() {
        return resolveDescendantKeywords;
    }

    /**
     * Sets the value of the resolveDescendantKeywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setResolveDescendantKeywords(Boolean value) {
        this.resolveDescendantKeywords = value;
    }

    /**
     * Gets the value of the resultLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getResultLimit() {
        return resultLimit;
    }

    /**
     * Sets the value of the resultLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setResultLimit(Long value) {
        this.resultLimit = value;
    }

}
