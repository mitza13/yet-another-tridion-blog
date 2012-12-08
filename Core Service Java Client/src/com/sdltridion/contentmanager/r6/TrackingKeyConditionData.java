
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrackingKeyConditionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrackingKeyConditionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ConditionData">
 *       &lt;sequence>
 *         &lt;element name="Keyword" type="{http://www.sdltridion.com/ContentManager/R6}LinkToKeywordData" minOccurs="0"/>
 *         &lt;element name="Operator" type="{http://www.sdltridion.com/ContentManager/R6}NumericalConditionOperator" minOccurs="0"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackingKeyConditionData", propOrder = {
    "keyword",
    "operator",
    "value"
})
public class TrackingKeyConditionData
    extends ConditionData
{

    @XmlElement(name = "Keyword", nillable = true)
    protected LinkToKeywordData keyword;
    @XmlElement(name = "Operator", nillable = true)
    protected NumericalConditionOperator operator;
    @XmlElement(name = "Value", nillable = true)
    protected Double value;

    /**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToKeywordData }
     *     
     */
    public LinkToKeywordData getKeyword() {
        return keyword;
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToKeywordData }
     *     
     */
    public void setKeyword(LinkToKeywordData value) {
        this.keyword = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link NumericalConditionOperator }
     *     
     */
    public NumericalConditionOperator getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericalConditionOperator }
     *     
     */
    public void setOperator(NumericalConditionOperator value) {
        this.operator = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValue(Double value) {
        this.value = value;
    }

}
