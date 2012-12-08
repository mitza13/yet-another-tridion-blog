
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueueMessageAction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="QueueMessageAction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Insert"/>
 *     &lt;enumeration value="Update"/>
 *     &lt;enumeration value="Delete"/>
 *     &lt;enumeration value="Reset"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "QueueMessageAction")
@XmlEnum
public enum QueueMessageAction {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Insert")
    INSERT("Insert"),
    @XmlEnumValue("Update")
    UPDATE("Update"),
    @XmlEnumValue("Delete")
    DELETE("Delete"),
    @XmlEnumValue("Reset")
    RESET("Reset"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    QueueMessageAction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QueueMessageAction fromValue(String v) {
        for (QueueMessageAction c: QueueMessageAction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
