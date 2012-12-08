
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConditionOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConditionOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Equals"/>
 *     &lt;enumeration value="GreaterThan"/>
 *     &lt;enumeration value="LessThan"/>
 *     &lt;enumeration value="NotEqual"/>
 *     &lt;enumeration value="StringEquals"/>
 *     &lt;enumeration value="Contains"/>
 *     &lt;enumeration value="StartsWith"/>
 *     &lt;enumeration value="EndsWith"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConditionOperator")
@XmlEnum
public enum ConditionOperator {

    @XmlEnumValue("Equals")
    EQUALS("Equals"),
    @XmlEnumValue("GreaterThan")
    GREATER_THAN("GreaterThan"),
    @XmlEnumValue("LessThan")
    LESS_THAN("LessThan"),
    @XmlEnumValue("NotEqual")
    NOT_EQUAL("NotEqual"),
    @XmlEnumValue("StringEquals")
    STRING_EQUALS("StringEquals"),
    @XmlEnumValue("Contains")
    CONTAINS("Contains"),
    @XmlEnumValue("StartsWith")
    STARTS_WITH("StartsWith"),
    @XmlEnumValue("EndsWith")
    ENDS_WITH("EndsWith"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    ConditionOperator(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConditionOperator fromValue(String v) {
        for (ConditionOperator c: ConditionOperator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
