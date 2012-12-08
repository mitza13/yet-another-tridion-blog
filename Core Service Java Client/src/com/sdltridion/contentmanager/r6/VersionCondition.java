
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VersionCondition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VersionCondition">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AllVersions"/>
 *     &lt;enumeration value="OnlyLatestVersions"/>
 *     &lt;enumeration value="OnlyLatestAndCheckedOutVersions"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VersionCondition")
@XmlEnum
public enum VersionCondition {

    @XmlEnumValue("AllVersions")
    ALL_VERSIONS("AllVersions"),
    @XmlEnumValue("OnlyLatestVersions")
    ONLY_LATEST_VERSIONS("OnlyLatestVersions"),
    @XmlEnumValue("OnlyLatestAndCheckedOutVersions")
    ONLY_LATEST_AND_CHECKED_OUT_VERSIONS("OnlyLatestAndCheckedOutVersions");
    private final String value;

    VersionCondition(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VersionCondition fromValue(String v) {
        for (VersionCondition c: VersionCondition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
