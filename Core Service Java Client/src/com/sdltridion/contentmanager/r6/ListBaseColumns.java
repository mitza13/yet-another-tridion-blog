
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListBaseColumns.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ListBaseColumns">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Id"/>
 *     &lt;enumeration value="IdAndTitle"/>
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="Extended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ListBaseColumns")
@XmlEnum
public enum ListBaseColumns {

    @XmlEnumValue("Id")
    ID("Id"),
    @XmlEnumValue("IdAndTitle")
    ID_AND_TITLE("IdAndTitle"),
    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("Extended")
    EXTENDED("Extended");
    private final String value;

    ListBaseColumns(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ListBaseColumns fromValue(String v) {
        for (ListBaseColumns c: ListBaseColumns.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
