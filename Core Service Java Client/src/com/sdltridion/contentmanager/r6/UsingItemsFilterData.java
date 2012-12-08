
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UsingItemsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsingItemsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WhereUsedFilterData">
 *       &lt;sequence>
 *         &lt;element name="ExcludeTaxonomyRelations" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeLocalCopies" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeVersionsColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludedVersions" type="{http://www.sdltridion.com/ContentManager/R6}VersionCondition" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsingItemsFilterData", propOrder = {
    "excludeTaxonomyRelations",
    "includeLocalCopies",
    "includeVersionsColumn",
    "includedVersions"
})
public class UsingItemsFilterData
    extends WhereUsedFilterData
{

    @XmlElement(name = "ExcludeTaxonomyRelations", nillable = true)
    protected Boolean excludeTaxonomyRelations;
    @XmlElement(name = "IncludeLocalCopies", nillable = true)
    protected Boolean includeLocalCopies;
    @XmlElement(name = "IncludeVersionsColumn", nillable = true)
    protected Boolean includeVersionsColumn;
    @XmlElement(name = "IncludedVersions")
    protected VersionCondition includedVersions;

    /**
     * Gets the value of the excludeTaxonomyRelations property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExcludeTaxonomyRelations() {
        return excludeTaxonomyRelations;
    }

    /**
     * Sets the value of the excludeTaxonomyRelations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExcludeTaxonomyRelations(Boolean value) {
        this.excludeTaxonomyRelations = value;
    }

    /**
     * Gets the value of the includeLocalCopies property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeLocalCopies() {
        return includeLocalCopies;
    }

    /**
     * Sets the value of the includeLocalCopies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeLocalCopies(Boolean value) {
        this.includeLocalCopies = value;
    }

    /**
     * Gets the value of the includeVersionsColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeVersionsColumn() {
        return includeVersionsColumn;
    }

    /**
     * Sets the value of the includeVersionsColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeVersionsColumn(Boolean value) {
        this.includeVersionsColumn = value;
    }

    /**
     * Gets the value of the includedVersions property.
     * 
     * @return
     *     possible object is
     *     {@link VersionCondition }
     *     
     */
    public VersionCondition getIncludedVersions() {
        return includedVersions;
    }

    /**
     * Sets the value of the includedVersions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionCondition }
     *     
     */
    public void setIncludedVersions(VersionCondition value) {
        this.includedVersions = value;
    }

}
