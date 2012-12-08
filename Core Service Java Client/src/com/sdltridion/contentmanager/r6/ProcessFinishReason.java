
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessFinishReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProcessFinishReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CompletedNormally"/>
 *     &lt;enumeration value="ForceFinished"/>
 *     &lt;enumeration value="Terminated"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProcessFinishReason")
@XmlEnum
public enum ProcessFinishReason {

    @XmlEnumValue("CompletedNormally")
    COMPLETED_NORMALLY("CompletedNormally"),
    @XmlEnumValue("ForceFinished")
    FORCE_FINISHED("ForceFinished"),
    @XmlEnumValue("Terminated")
    TERMINATED("Terminated"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    ProcessFinishReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProcessFinishReason fromValue(String v) {
        for (ProcessFinishReason c: ProcessFinishReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
