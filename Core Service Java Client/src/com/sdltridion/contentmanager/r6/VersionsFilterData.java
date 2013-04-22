
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VersionsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VersionsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SubjectRelatedListFilterData">
 *       &lt;sequence>
 *         &lt;element name="IncludeRevisorDescriptionColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersionsFilterData", propOrder = {
    "includeRevisorDescriptionColumn"
})
public class VersionsFilterData
    extends SubjectRelatedListFilterData
{

    @XmlElement(name = "IncludeRevisorDescriptionColumn", nillable = true)
    protected Boolean includeRevisorDescriptionColumn;

    /**
     * Gets the value of the includeRevisorDescriptionColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeRevisorDescriptionColumn() {
        return includeRevisorDescriptionColumn;
    }

    /**
     * Sets the value of the includeRevisorDescriptionColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeRevisorDescriptionColumn(Boolean value) {
        this.includeRevisorDescriptionColumn = value;
    }

}
