
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProcessType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Any"/>
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Historical"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProcessType")
@XmlEnum
public enum ProcessType {

    @XmlEnumValue("Any")
    ANY("Any"),
    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("Historical")
    HISTORICAL("Historical"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    ProcessType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProcessType fromValue(String v) {
        for (ProcessType c: ProcessType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
