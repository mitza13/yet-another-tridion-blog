
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UndoState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UndoState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotApplicable"/>
 *     &lt;enumeration value="NoActionRequired"/>
 *     &lt;enumeration value="Removed"/>
 *     &lt;enumeration value="Reverted"/>
 *     &lt;enumeration value="RevertFailed"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UndoState")
@XmlEnum
public enum UndoState {

    @XmlEnumValue("NotApplicable")
    NOT_APPLICABLE("NotApplicable"),
    @XmlEnumValue("NoActionRequired")
    NO_ACTION_REQUIRED("NoActionRequired"),
    @XmlEnumValue("Removed")
    REMOVED("Removed"),
    @XmlEnumValue("Reverted")
    REVERTED("Reverted"),
    @XmlEnumValue("RevertFailed")
    REVERT_FAILED("RevertFailed"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    UndoState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UndoState fromValue(String v) {
        for (UndoState c: UndoState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
