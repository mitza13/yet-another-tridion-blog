
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublishPriority.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PublishPriority">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Low"/>
 *     &lt;enumeration value="Normal"/>
 *     &lt;enumeration value="High"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PublishPriority")
@XmlEnum
public enum PublishPriority {

    @XmlEnumValue("Low")
    LOW("Low"),
    @XmlEnumValue("Normal")
    NORMAL("Normal"),
    @XmlEnumValue("High")
    HIGH("High"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    PublishPriority(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PublishPriority fromValue(String v) {
        for (PublishPriority c: PublishPriority.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
