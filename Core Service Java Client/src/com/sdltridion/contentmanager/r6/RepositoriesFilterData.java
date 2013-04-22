
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RepositoriesFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RepositoriesFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideListFilterData">
 *       &lt;sequence>
 *         &lt;element name="IncludeWebDavUrlColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeRootOrganizationalItemsColumns" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepositoriesFilterData", propOrder = {
    "includeWebDavUrlColumn",
    "includeRootOrganizationalItemsColumns"
})
@XmlSeeAlso({
    PublicationsFilterData.class
})
public class RepositoriesFilterData
    extends SystemWideListFilterData
{

    @XmlElement(name = "IncludeWebDavUrlColumn", nillable = true)
    protected Boolean includeWebDavUrlColumn;
    @XmlElement(name = "IncludeRootOrganizationalItemsColumns", nillable = true)
    protected Boolean includeRootOrganizationalItemsColumns;

    /**
     * Gets the value of the includeWebDavUrlColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeWebDavUrlColumn() {
        return includeWebDavUrlColumn;
    }

    /**
     * Sets the value of the includeWebDavUrlColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeWebDavUrlColumn(Boolean value) {
        this.includeWebDavUrlColumn = value;
    }

    /**
     * Gets the value of the includeRootOrganizationalItemsColumns property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeRootOrganizationalItemsColumns() {
        return includeRootOrganizationalItemsColumns;
    }

    /**
     * Sets the value of the includeRootOrganizationalItemsColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeRootOrganizationalItemsColumns(Boolean value) {
        this.includeRootOrganizationalItemsColumns = value;
    }

}
