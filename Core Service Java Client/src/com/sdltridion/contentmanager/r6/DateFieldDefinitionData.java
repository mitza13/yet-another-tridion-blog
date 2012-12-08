
package com.sdltridion.contentmanager.r6;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for DateFieldDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DateFieldDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ItemFieldDefinitionData">
 *       &lt;sequence>
 *         &lt;element name="DefaultValue" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="IsMaxValueExclusive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsMinValueExclusive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="List" type="{http://www.sdltridion.com/ContentManager/R6}DateListDefinitionData" minOccurs="0"/>
 *         &lt;element name="MaxValue" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MinValue" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Pattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateFieldDefinitionData", propOrder = {
    "defaultValue",
    "isMaxValueExclusive",
    "isMinValueExclusive",
    "list",
    "maxValue",
    "minValue",
    "pattern"
})
public class DateFieldDefinitionData
    extends ItemFieldDefinitionData
{

    @XmlElement(name = "DefaultValue", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date defaultValue;
    @XmlElement(name = "IsMaxValueExclusive")
    protected Boolean isMaxValueExclusive;
    @XmlElement(name = "IsMinValueExclusive")
    protected Boolean isMinValueExclusive;
    @XmlElement(name = "List", nillable = true)
    protected DateListDefinitionData list;
    @XmlElement(name = "MaxValue", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date maxValue;
    @XmlElement(name = "MinValue", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date minValue;
    @XmlElement(name = "Pattern", nillable = true)
    protected String pattern;

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultValue(Date value) {
        this.defaultValue = value;
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
     *     {@link DateListDefinitionData }
     *     
     */
    public DateListDefinitionData getList() {
        return list;
    }

    /**
     * Sets the value of the list property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateListDefinitionData }
     *     
     */
    public void setList(DateListDefinitionData value) {
        this.list = value;
    }

    /**
     * Gets the value of the maxValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the value of the maxValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxValue(Date value) {
        this.maxValue = value;
    }

    /**
     * Gets the value of the minValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getMinValue() {
        return minValue;
    }

    /**
     * Sets the value of the minValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinValue(Date value) {
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

}
