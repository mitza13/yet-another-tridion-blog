
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UsedItemsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsedItemsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WhereUsedFilterData">
 *       &lt;sequence>
 *         &lt;element name="IncludeBlueprintParentItem" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeExternalLinks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsedItemsFilterData", propOrder = {
    "includeBlueprintParentItem",
    "includeExternalLinks"
})
public class UsedItemsFilterData
    extends WhereUsedFilterData
{

    @XmlElement(name = "IncludeBlueprintParentItem", nillable = true)
    protected Boolean includeBlueprintParentItem;
    @XmlElement(name = "IncludeExternalLinks", nillable = true)
    protected Boolean includeExternalLinks;

    /**
     * Gets the value of the includeBlueprintParentItem property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeBlueprintParentItem() {
        return includeBlueprintParentItem;
    }

    /**
     * Sets the value of the includeBlueprintParentItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeBlueprintParentItem(Boolean value) {
        this.includeBlueprintParentItem = value;
    }

    /**
     * Gets the value of the includeExternalLinks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeExternalLinks() {
        return includeExternalLinks;
    }

    /**
     * Sets the value of the includeExternalLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeExternalLinks(Boolean value) {
        this.includeExternalLinks = value;
    }

}
