
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumberFieldDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NumberFieldDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ItemFieldDefinitionData">
 *       &lt;sequence>
 *         &lt;element name="DefaultValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="FractionDigits" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IsMaxValueExclusive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsMinValueExclusive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="List" type="{http://www.sdltridion.com/ContentManager/R6}NumberListDefinitionData" minOccurs="0"/>
 *         &lt;element name="MaxValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="MinValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Pattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalDigits" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumberFieldDefinitionData", propOrder = {
    "defaultValue",
    "fractionDigits",
    "isMaxValueExclusive",
    "isMinValueExclusive",
    "list",
    "maxValue",
    "minValue",
    "pattern",
    "totalDigits"
})
public class NumberFieldDefinitionData
    extends ItemFieldDefinitionData
{

    @XmlElement(name = "DefaultValue", nillable = true)
    protected Double defaultValue;
    @XmlElement(name = "FractionDigits", nillable = true)
    protected Integer fractionDigits;
    @XmlElement(name = "IsMaxValueExclusive")
    protected Boolean isMaxValueExclusive;
    @XmlElement(name = "IsMinValueExclusive")
    protected Boolean isMinValueExclusive;
    @XmlElement(name = "List", nillable = true)
    protected NumberListDefinitionData list;
    @XmlElement(name = "MaxValue", nillable = true)
    protected Double maxValue;
    @XmlElement(name = "MinValue", nillable = true)
    protected Double minValue;
    @XmlElement(name = "Pattern", nillable = true)
    protected String pattern;
    @XmlElement(name = "TotalDigits", nillable = true)
    protected Integer totalDigits;

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDefaultValue(Double value) {
        this.defaultValue = value;
    }

    /**
     * Gets the value of the fractionDigits property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFractionDigits() {
        return fractionDigits;
    }

    /**
     * Sets the value of the fractionDigits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFractionDigits(Integer value) {
        this.fractionDigits = value;
    }

    /**
     * Gets the value of the isMaxValueExclusive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsMaxValueExclusive() {
        return isMaxValueExclusive;
    }

    /**
     * Sets the value of the isMaxValueExclusive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsMaxValueExclusive(Boolean value) {
        this.isMaxValueExclusive = value;
    }

    /**
     * Gets the value of the isMinValueExclusive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsMinValueExclusive() {
        return isMinValueExclusive;
    }

    /**
     * Sets the value of the isMinValueExclusive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsMinValueExclusive(Boolean value) {
        this.isMinValueExclusive = value;
    }

    /**
     * Gets the value of the list property.
     * 
     * @return
     *     possible object is
     *     {@link NumberListDefinitionData }
     *     
     */
    public NumberListDefinitionData getList() {
        return list;
    }

    /**
     * Sets the value of the list property.
     * 
     * @param value
     *     allowed object is
     *     {@link NumberListDefinitionData }
     *     
     */
    public void setList(NumberListDefinitionData value) {
        this.list = value;
    }

    /**
     * Gets the value of the maxValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the value of the maxValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxValue(Double value) {
        this.maxValue = value;
    }

    /**
     * Gets the value of the minValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMinValue() {
        return minValue;
    }

    /**
     * Sets the value of the minValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMinValue(Double value) {
        this.minValue = value;
    }

    /**
     * Gets the value of the pattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Sets the value of the pattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPattern(String value) {
        this.pattern = value;
    }

    /**
     * Gets the value of the totalDigits property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalDigits() {
        return totalDigits;
    }

    /**
     * Sets the value of the totalDigits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalDigits(Integer value) {
        this.totalDigits = value;
    }

}
