
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ListType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Select"/>
 *     &lt;enumeration value="Edit"/>
 *     &lt;enumeration value="Radio"/>
 *     &lt;enumeration value="Checkbox"/>
 *     &lt;enumeration value="Tree"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ListType")
@XmlEnum
public enum ListType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Select")
    SELECT("Select"),
    @XmlEnumValue("Edit")
    EDIT("Edit"),
    @XmlEnumValue("Radio")
    RADIO("Radio"),
    @XmlEnumValue("Checkbox")
    CHECKBOX("Checkbox"),
    @XmlEnumValue("Tree")
    TREE("Tree"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    ListType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ListType fromValue(String v) {
        for (ListType c: ListType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
