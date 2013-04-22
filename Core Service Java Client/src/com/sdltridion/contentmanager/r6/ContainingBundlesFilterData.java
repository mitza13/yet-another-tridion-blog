
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContainingBundlesFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContainingBundlesFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SubjectRelatedListFilterData">
 *       &lt;sequence>
 *         &lt;element name="IncludeBundleTypeColumns" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeDescriptionColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OnlySpecifiedBluePrintVariant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SuppressLocalCopies" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContainingBundlesFilterData", propOrder = {
    "includeBundleTypeColumns",
    "includeDescriptionColumn",
    "onlySpecifiedBluePrintVariant",
    "suppressLocalCopies"
})
public class ContainingBundlesFilterData
    extends SubjectRelatedListFilterData
{

    @XmlElement(name = "IncludeBundleTypeColumns")
    protected Boolean includeBundleTypeColumns;
    @XmlElement(name = "IncludeDescriptionColumn")
    protected Boolean includeDescriptionColumn;
    @XmlElement(name = "OnlySpecifiedBluePrintVariant")
    protected Boolean onlySpecifiedBluePrintVariant;
    @XmlElement(name = "SuppressLocalCopies")
    protected Boolean suppressLocalCopies;

    /**
     * Gets the value of the includeBundleTypeColumns property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeBundleTypeColumns() {
        return includeBundleTypeColumns;
    }

    /**
     * Sets the value of the includeBundleTypeColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeBundleTypeColumns(Boolean value) {
        this.includeBundleTypeColumns = value;
    }

    /**
     * Gets the value of the includeDescriptionColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeDescriptionColumn() {
        return includeDescriptionColumn;
    }

    /**
     * Sets the value of the includeDescriptionColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeDescriptionColumn(Boolean value) {
        this.includeDescriptionColumn = value;
    }

    /**
     * Gets the value of the onlySpecifiedBluePrintVariant property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnlySpecifiedBluePrintVariant() {
        return onlySpecifiedBluePrintVariant;
    }

    /**
     * Sets the value of the onlySpecifiedBluePrintVariant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnlySpecifiedBluePrintVariant(Boolean value) {
        this.onlySpecifiedBluePrintVariant = value;
    }

    /**
     * Gets the value of the suppressLocalCopies property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSuppressLocalCopies() {
        return suppressLocalCopies;
    }

    /**
     * Sets the value of the suppressLocalCopies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuppressLocalCopies(Boolean value) {
        this.suppressLocalCopies = value;
    }

}
