
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ItemType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Publication"/>
 *     &lt;enumeration value="Folder"/>
 *     &lt;enumeration value="StructureGroup"/>
 *     &lt;enumeration value="Schema"/>
 *     &lt;enumeration value="Component"/>
 *     &lt;enumeration value="ComponentTemplate"/>
 *     &lt;enumeration value="Page"/>
 *     &lt;enumeration value="PageTemplate"/>
 *     &lt;enumeration value="TargetGroup"/>
 *     &lt;enumeration value="Category"/>
 *     &lt;enumeration value="Keyword"/>
 *     &lt;enumeration value="TemplateBuildingBlock"/>
 *     &lt;enumeration value="VirtualFolder"/>
 *     &lt;enumeration value="PublicationTarget"/>
 *     &lt;enumeration value="TargetType"/>
 *     &lt;enumeration value="TargetDestination"/>
 *     &lt;enumeration value="MultimediaType"/>
 *     &lt;enumeration value="User"/>
 *     &lt;enumeration value="Group"/>
 *     &lt;enumeration value="DirectoryService"/>
 *     &lt;enumeration value="DirectoryGroupMapping"/>
 *     &lt;enumeration value="MultipleOperations"/>
 *     &lt;enumeration value="PublishTransaction"/>
 *     &lt;enumeration value="ApprovalStatus"/>
 *     &lt;enumeration value="ProcessDefinition"/>
 *     &lt;enumeration value="ProcessInstance"/>
 *     &lt;enumeration value="ProcessHistory"/>
 *     &lt;enumeration value="ActivityDefinition"/>
 *     &lt;enumeration value="ActivityInstance"/>
 *     &lt;enumeration value="ActivityHistory"/>
 *     &lt;enumeration value="WorkItem"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ItemType")
@XmlEnum
public enum ItemType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Publication")
    PUBLICATION("Publication"),
    @XmlEnumValue("Folder")
    FOLDER("Folder"),
    @XmlEnumValue("StructureGroup")
    STRUCTURE_GROUP("StructureGroup"),
    @XmlEnumValue("Schema")
    SCHEMA("Schema"),
    @XmlEnumValue("Component")
    COMPONENT("Component"),
    @XmlEnumValue("ComponentTemplate")
    COMPONENT_TEMPLATE("ComponentTemplate"),
    @XmlEnumValue("Page")
    PAGE("Page"),
    @XmlEnumValue("PageTemplate")
    PAGE_TEMPLATE("PageTemplate"),
    @XmlEnumValue("TargetGroup")
    TARGET_GROUP("TargetGroup"),
    @XmlEnumValue("Category")
    CATEGORY("Category"),
    @XmlEnumValue("Keyword")
    KEYWORD("Keyword"),
    @XmlEnumValue("TemplateBuildingBlock")
    TEMPLATE_BUILDING_BLOCK("TemplateBuildingBlock"),
    @XmlEnumValue("VirtualFolder")
    VIRTUAL_FOLDER("VirtualFolder"),
    @XmlEnumValue("PublicationTarget")
    PUBLICATION_TARGET("PublicationTarget"),
    @XmlEnumValue("TargetType")
    TARGET_TYPE("TargetType"),
    @XmlEnumValue("TargetDestination")
    TARGET_DESTINATION("TargetDestination"),
    @XmlEnumValue("MultimediaType")
    MULTIMEDIA_TYPE("MultimediaType"),
    @XmlEnumValue("User")
    USER("User"),
    @XmlEnumValue("Group")
    GROUP("Group"),
    @XmlEnumValue("DirectoryService")
    DIRECTORY_SERVICE("DirectoryService"),
    @XmlEnumValue("DirectoryGroupMapping")
    DIRECTORY_GROUP_MAPPING("DirectoryGroupMapping"),
    @XmlEnumValue("MultipleOperations")
    MULTIPLE_OPERATIONS("MultipleOperations"),
    @XmlEnumValue("PublishTransaction")
    PUBLISH_TRANSACTION("PublishTransaction"),
    @XmlEnumValue("ApprovalStatus")
    APPROVAL_STATUS("ApprovalStatus"),
    @XmlEnumValue("ProcessDefinition")
    PROCESS_DEFINITION("ProcessDefinition"),
    @XmlEnumValue("ProcessInstance")
    PROCESS_INSTANCE("ProcessInstance"),
    @XmlEnumValue("ProcessHistory")
    PROCESS_HISTORY("ProcessHistory"),
    @XmlEnumValue("ActivityDefinition")
    ACTIVITY_DEFINITION("ActivityDefinition"),
    @XmlEnumValue("ActivityInstance")
    ACTIVITY_INSTANCE("ActivityInstance"),
    @XmlEnumValue("ActivityHistory")
    ACTIVITY_HISTORY("ActivityHistory"),
    @XmlEnumValue("WorkItem")
    WORK_ITEM("WorkItem"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    ItemType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ItemType fromValue(String v) {
        for (ItemType c: ItemType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
