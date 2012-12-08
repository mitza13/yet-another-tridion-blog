
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StronglyTypedFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StronglyTypedFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}FilterData">
 *       &lt;sequence>
 *         &lt;element name="IncludeAllowedActionsColumns" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StronglyTypedFilterData", propOrder = {
    "includeAllowedActionsColumns"
})
@XmlSeeAlso({
    SubjectRelatedListFilterData.class,
    SystemWideListFilterData.class
})
public class StronglyTypedFilterData
    extends FilterData
{

    @XmlElement(name = "IncludeAllowedActionsColumns")
    protected Boolean includeAllowedActionsColumns;

    /**
     * Gets the value of the includeAllowedActionsColumns property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeAllowedActionsColumns() {
        return includeAllowedActionsColumns;
    }

    /**
     * Sets the value of the includeAllowedActionsColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAllowedActionsColumns(Boolean value) {
        this.includeAllowedActionsColumns = value;
    }

}
