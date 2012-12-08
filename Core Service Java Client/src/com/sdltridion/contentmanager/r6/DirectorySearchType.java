
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirectorySearchType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DirectorySearchType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Subtree"/>
 *     &lt;enumeration value="Group"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DirectorySearchType")
@XmlEnum
public enum DirectorySearchType {

    @XmlEnumValue("Subtree")
    SUBTREE("Subtree"),
    @XmlEnumValue("Group")
    GROUP("Group"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    DirectorySearchType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DirectorySearchType fromValue(String v) {
        for (DirectorySearchType c: DirectorySearchType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
