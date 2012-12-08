
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeleteTaxonomyNodeMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeleteTaxonomyNodeMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DeleteBranch"/>
 *     &lt;enumeration value="DeleteBranchIncludeChildPublications"/>
 *     &lt;enumeration value="RemoveParentFromChildren"/>
 *     &lt;enumeration value="AssignChildrenToGrandparents"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeleteTaxonomyNodeMode")
@XmlEnum
public enum DeleteTaxonomyNodeMode {

    @XmlEnumValue("DeleteBranch")
    DELETE_BRANCH("DeleteBranch"),
    @XmlEnumValue("DeleteBranchIncludeChildPublications")
    DELETE_BRANCH_INCLUDE_CHILD_PUBLICATIONS("DeleteBranchIncludeChildPublications"),
    @XmlEnumValue("RemoveParentFromChildren")
    REMOVE_PARENT_FROM_CHILDREN("RemoveParentFromChildren"),
    @XmlEnumValue("AssignChildrenToGrandparents")
    ASSIGN_CHILDREN_TO_GRANDPARENTS("AssignChildrenToGrandparents");
    private final String value;

    DeleteTaxonomyNodeMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeleteTaxonomyNodeMode fromValue(String v) {
        for (DeleteTaxonomyNodeMode c: DeleteTaxonomyNodeMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
