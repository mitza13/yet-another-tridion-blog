
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilterData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BaseColumns" type="{http://www.sdltridion.com/ContentManager/R6}ListBaseColumns" minOccurs="0"/>
 *         &lt;element name="SortExpression" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterData", propOrder = {
    "baseColumns",
    "sortExpression"
})
@XmlSeeAlso({
    StronglyTypedFilterData.class
})
public class FilterData {

    @XmlElement(name = "BaseColumns", nillable = true)
    protected ListBaseColumns baseColumns;
    @XmlElement(name = "SortExpression", nillable = true)
    protected String sortExpression;

    /**
     * Gets the value of the baseColumns property.
     * 
     * @return
     *     possible object is
     *     {@link ListBaseColumns }
     *     
     */
    public ListBaseColumns getBaseColumns() {
        return baseColumns;
    }

    /**
     * Sets the value of the baseColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListBaseColumns }
     *     
     */
    public void setBaseColumns(ListBaseColumns value) {
        this.baseColumns = value;
    }

    /**
     * Gets the value of the sortExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortExpression() {
        return sortExpression;
    }

    /**
     * Sets the value of the sortExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortExpression(String value) {
        this.sortExpression = value;
    }

}
