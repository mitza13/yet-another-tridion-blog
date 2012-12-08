
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganizationalItemAncestorsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationalItemAncestorsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SubjectRelatedListFilterData">
 *       &lt;sequence>
 *         &lt;element name="IncludePublishLocationColumns" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationalItemAncestorsFilterData", propOrder = {
    "includePublishLocationColumns"
})
public class OrganizationalItemAncestorsFilterData
    extends SubjectRelatedListFilterData
{

    @XmlElement(name = "IncludePublishLocationColumns", nillable = true)
    protected Boolean includePublishLocationColumns;

    /**
     * Gets the value of the includePublishLocationColumns property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludePublishLocationColumns() {
        return includePublishLocationColumns;
    }

    /**
     * Sets the value of the includePublishLocationColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludePublishLocationColumns(Boolean value) {
        this.includePublishLocationColumns = value;
    }

}
