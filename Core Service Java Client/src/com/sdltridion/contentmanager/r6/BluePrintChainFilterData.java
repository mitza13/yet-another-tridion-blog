
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BluePrintChainFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BluePrintChainFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SubjectRelatedListFilterData">
 *       &lt;sequence>
 *         &lt;element name="Direction" type="{http://www.sdltridion.com/ContentManager/R6}BluePrintChainDirection" minOccurs="0"/>
 *         &lt;element name="IncludeWebDavUrlColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BluePrintChainFilterData", propOrder = {
    "direction",
    "includeWebDavUrlColumn"
})
public class BluePrintChainFilterData
    extends SubjectRelatedListFilterData
{

    @XmlElement(name = "Direction")
    protected BluePrintChainDirection direction;
    @XmlElement(name = "IncludeWebDavUrlColumn", nillable = true)
    protected Boolean includeWebDavUrlColumn;

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link BluePrintChainDirection }
     *     
     */
    public BluePrintChainDirection getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link BluePrintChainDirection }
     *     
     */
    public void setDirection(BluePrintChainDirection value) {
        this.direction = value;
    }

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

}
