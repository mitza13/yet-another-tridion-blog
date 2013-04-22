
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WhereUsedCommentToken.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WhereUsedCommentToken">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ParentItem"/>
 *     &lt;enumeration value="LocalCopy"/>
 *     &lt;enumeration value="OnlyOldVersions"/>
 *     &lt;enumeration value="OnlyCheckedOutVersion"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WhereUsedCommentToken")
@XmlEnum
public enum WhereUsedCommentToken {

    @XmlEnumValue("ParentItem")
    PARENT_ITEM("ParentItem"),
    @XmlEnumValue("LocalCopy")
    LOCAL_COPY("LocalCopy"),
    @XmlEnumValue("OnlyOldVersions")
    ONLY_OLD_VERSIONS("OnlyOldVersions"),
    @XmlEnumValue("OnlyCheckedOutVersion")
    ONLY_CHECKED_OUT_VERSION("OnlyCheckedOutVersion"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    WhereUsedCommentToken(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WhereUsedCommentToken fromValue(String v) {
        for (WhereUsedCommentToken c: WhereUsedCommentToken.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
