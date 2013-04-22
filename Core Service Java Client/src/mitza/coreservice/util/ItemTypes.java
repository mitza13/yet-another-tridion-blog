package mitza.coreservice.util;

public enum ItemTypes {

    NONE("None", 0),
    PUBLICATION("Publication", 1),
    FOLDER("Folder", 2),
    STRUCTURE_GROUP("StructureGroup", 4),
    SCHEMA("Schema", 8),
    COMPONENT("Component", 16),
    COMPONENT_TEMPLATE("ComponentTemplate", 32),
    PAGE("Page", 64),
    PAGE_TEMPLATE("PageTemplate", 128),
    TARGET_GROUP("TargetGroup", 256),
    CATEGORY("Category", 512),
    KEYWORD("Keyword", 1024),
    TEMPLATE_BUILDING_BLOCK("TemplateBuildingBlock", 2048),
    VIRTUAL_FOLDER("VirtualFolder", 8192),
    PUBLICATION_TARGET("PublicationTarget", 65537),
    TARGET_TYPE("TargetType", 65538),
    TARGET_DESTINATION("TargetDestination", 65540),
    MULTIMEDIA_TYPE("MultimediaType", 65544),
    USER("User", 65552),
    GROUP("Group", 65568),
    DIRECTORY_SERVICE("DirectoryService", 65664),
    DIRECTORY_GROUP_MAPPING("DirectoryGroupMapping", 65792),
    MULTIPLE_OPERATIONS("MultipleOperations", 66048),
    PUBLISH_TRANSACTION("PublishTransaction", 66560),
    APPROVAL_STATUS("ApprovalStatus", 131073),
    PROCESS_DEFINITION("ProcessDefinition", 131074),
    PROCESS_INSTANCE("ProcessInstance", 131076),
    PROCESS_HISTORY("ProcessHistory", 131080),
    ACTIVITY_DEFINITION("ActivityDefinition", 131088),
    ACTIVITY_INSTANCE("ActivityInstance", 131104),
    ACTIVITY_HISTORY("ActivityHistory", 131136),
    WORK_ITEM("WorkItem", 131200),
    UNKNOWN_BY_CLIENT("UnknownByClient", -2147483648);

    private final String name;
    private final int value;

    ItemTypes(String name, int value) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static ItemTypes fromName(String name) {
        for (ItemTypes type: ItemTypes.values()) {
            if (type.name.equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException(name);
    }

    public static ItemTypes fromValue(int value) {
        for (ItemTypes type: ItemTypes.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("" + value);
    }

    public static ItemTypes fromValue(String value) {
    	int intValue = Integer.parseInt(value);
        for (ItemTypes type: ItemTypes.values()) {
            if (type.value == intValue) {
                return type;
            }
        }
        throw new IllegalArgumentException("" + value);
    }
}
