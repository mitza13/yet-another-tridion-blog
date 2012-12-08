
package com.sdltridion.security;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserNameSearchMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UserNameSearchMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UserNameOnly"/>
 *     &lt;enumeration value="FullNameOnly"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UserNameSearchMode")
@XmlEnum
public enum UserNameSearchMode {

    @XmlEnumValue("UserNameOnly")
    USER_NAME_ONLY("UserNameOnly"),
    @XmlEnumValue("FullNameOnly")
    FULL_NAME_ONLY("FullNameOnly");
    private final String value;

    UserNameSearchMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UserNameSearchMode fromValue(String v) {
        for (UserNameSearchMode c: UserNameSearchMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
