
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BluePrintChainDirection.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BluePrintChainDirection">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Up"/>
 *     &lt;enumeration value="Down"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BluePrintChainDirection")
@XmlEnum
public enum BluePrintChainDirection {

    @XmlEnumValue("Up")
    UP("Up"),
    @XmlEnumValue("Down")
    DOWN("Down");
    private final String value;

    BluePrintChainDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BluePrintChainDirection fromValue(String v) {
        for (BluePrintChainDirection c: BluePrintChainDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
