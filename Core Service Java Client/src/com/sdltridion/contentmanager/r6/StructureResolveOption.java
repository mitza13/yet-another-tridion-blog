
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StructureResolveOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StructureResolveOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OnlyItems"/>
 *     &lt;enumeration value="OnlyStructure"/>
 *     &lt;enumeration value="ItemsAndStructure"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StructureResolveOption")
@XmlEnum
public enum StructureResolveOption {

    @XmlEnumValue("OnlyItems")
    ONLY_ITEMS("OnlyItems"),
    @XmlEnumValue("OnlyStructure")
    ONLY_STRUCTURE("OnlyStructure"),
    @XmlEnumValue("ItemsAndStructure")
    ITEMS_AND_STRUCTURE("ItemsAndStructure"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    StructureResolveOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StructureResolveOption fromValue(String v) {
        for (StructureResolveOption c: StructureResolveOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
