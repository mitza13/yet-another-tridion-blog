
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchBlueprintStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchBlueprintStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unspecified"/>
 *     &lt;enumeration value="Local"/>
 *     &lt;enumeration value="Localized"/>
 *     &lt;enumeration value="Shared"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchBlueprintStatus")
@XmlEnum
public enum SearchBlueprintStatus {

    @XmlEnumValue("Unspecified")
    UNSPECIFIED("Unspecified"),
    @XmlEnumValue("Local")
    LOCAL("Local"),
    @XmlEnumValue("Localized")
    LOCALIZED("Localized"),
    @XmlEnumValue("Shared")
    SHARED("Shared");
    private final String value;

    SearchBlueprintStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchBlueprintStatus fromValue(String v) {
        for (SearchBlueprintStatus c: SearchBlueprintStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
