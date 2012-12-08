
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RenderMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RenderMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Publish"/>
 *     &lt;enumeration value="PreviewStatic"/>
 *     &lt;enumeration value="PreviewDynamic"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RenderMode")
@XmlEnum
public enum RenderMode {

    @XmlEnumValue("Publish")
    PUBLISH("Publish"),
    @XmlEnumValue("PreviewStatic")
    PREVIEW_STATIC("PreviewStatic"),
    @XmlEnumValue("PreviewDynamic")
    PREVIEW_DYNAMIC("PreviewDynamic"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    RenderMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RenderMode fromValue(String v) {
        for (RenderMode c: RenderMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
