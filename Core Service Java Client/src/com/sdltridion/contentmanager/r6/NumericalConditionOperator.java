
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumericalConditionOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NumericalConditionOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Equals"/>
 *     &lt;enumeration value="GreaterThan"/>
 *     &lt;enumeration value="LessThan"/>
 *     &lt;enumeration value="NotEqual"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NumericalConditionOperator")
@XmlEnum
public enum NumericalConditionOperator {

    @XmlEnumValue("Equals")
    EQUALS("Equals"),
    @XmlEnumValue("GreaterThan")
    GREATER_THAN("GreaterThan"),
    @XmlEnumValue("LessThan")
    LESS_THAN("LessThan"),
    @XmlEnumValue("NotEqual")
    NOT_EQUAL("NotEqual"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    NumericalConditionOperator(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NumericalConditionOperator fromValue(String v) {
        for (NumericalConditionOperator c: NumericalConditionOperator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
