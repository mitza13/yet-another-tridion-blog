
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SchemaPurpose.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SchemaPurpose">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Component"/>
 *     &lt;enumeration value="Multimedia"/>
 *     &lt;enumeration value="Embedded"/>
 *     &lt;enumeration value="Metadata"/>
 *     &lt;enumeration value="Protocol"/>
 *     &lt;enumeration value="VirtualFolderType"/>
 *     &lt;enumeration value="TemplateParameters"/>
 *     &lt;enumeration value="Bundle"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SchemaPurpose")
@XmlEnum
public enum SchemaPurpose {

    @XmlEnumValue("Component")
    COMPONENT("Component"),
    @XmlEnumValue("Multimedia")
    MULTIMEDIA("Multimedia"),
    @XmlEnumValue("Embedded")
    EMBEDDED("Embedded"),
    @XmlEnumValue("Metadata")
    METADATA("Metadata"),
    @XmlEnumValue("Protocol")
    PROTOCOL("Protocol"),
    @XmlEnumValue("VirtualFolderType")
    VIRTUAL_FOLDER_TYPE("VirtualFolderType"),
    @XmlEnumValue("TemplateParameters")
    TEMPLATE_PARAMETERS("TemplateParameters"),
    @XmlEnumValue("Bundle")
    BUNDLE("Bundle"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    SchemaPurpose(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SchemaPurpose fromValue(String v) {
        for (SchemaPurpose c: SchemaPurpose.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
