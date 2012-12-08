
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeployerAction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeployerAction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Commit"/>
 *     &lt;enumeration value="Wait"/>
 *     &lt;enumeration value="Abort"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeployerAction")
@XmlEnum
public enum DeployerAction {

    @XmlEnumValue("Commit")
    COMMIT("Commit"),
    @XmlEnumValue("Wait")
    WAIT("Wait"),
    @XmlEnumValue("Abort")
    ABORT("Abort"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    DeployerAction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeployerAction fromValue(String v) {
        for (DeployerAction c: DeployerAction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
