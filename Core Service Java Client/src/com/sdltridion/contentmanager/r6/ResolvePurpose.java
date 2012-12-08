
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResolvePurpose.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResolvePurpose">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Publish"/>
 *     &lt;enumeration value="UnPublish"/>
 *     &lt;enumeration value="RePublish"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ResolvePurpose")
@XmlEnum
public enum ResolvePurpose {

    @XmlEnumValue("Publish")
    PUBLISH("Publish"),
    @XmlEnumValue("UnPublish")
    UN_PUBLISH("UnPublish"),
    @XmlEnumValue("RePublish")
    RE_PUBLISH("RePublish"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    ResolvePurpose(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResolvePurpose fromValue(String v) {
        for (ResolvePurpose c: ResolvePurpose.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
