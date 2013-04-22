
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PredefinedBatchOperation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PredefinedBatchOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CheckIn"/>
 *     &lt;enumeration value="CheckOut"/>
 *     &lt;enumeration value="Classify"/>
 *     &lt;enumeration value="Copy"/>
 *     &lt;enumeration value="Delete"/>
 *     &lt;enumeration value="FinishActivity"/>
 *     &lt;enumeration value="ForceFinishProcess"/>
 *     &lt;enumeration value="Localize"/>
 *     &lt;enumeration value="Move"/>
 *     &lt;enumeration value="Publish"/>
 *     &lt;enumeration value="ReClassify"/>
 *     &lt;enumeration value="StartActivity"/>
 *     &lt;enumeration value="UnClassify"/>
 *     &lt;enumeration value="UnLocalize"/>
 *     &lt;enumeration value="UnPublish"/>
 *     &lt;enumeration value="UndoCheckOut"/>
 *     &lt;enumeration value="DeleteTaxonomyNode"/>
 *     &lt;enumeration value="SwitchUserEnabledState"/>
 *     &lt;enumeration value="CopyToKeyword"/>
 *     &lt;enumeration value="MoveToKeyword"/>
 *     &lt;enumeration value="ReAssignActivity"/>
 *     &lt;enumeration value="RestartActivity"/>
 *     &lt;enumeration value="SuspendActivity"/>
 *     &lt;enumeration value="ResumeActivity"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PredefinedBatchOperation")
@XmlEnum
public enum PredefinedBatchOperation {

    @XmlEnumValue("CheckIn")
    CHECK_IN("CheckIn"),
    @XmlEnumValue("CheckOut")
    CHECK_OUT("CheckOut"),
    @XmlEnumValue("Classify")
    CLASSIFY("Classify"),
    @XmlEnumValue("Copy")
    COPY("Copy"),
    @XmlEnumValue("Delete")
    DELETE("Delete"),
    @XmlEnumValue("FinishActivity")
    FINISH_ACTIVITY("FinishActivity"),
    @XmlEnumValue("ForceFinishProcess")
    FORCE_FINISH_PROCESS("ForceFinishProcess"),
    @XmlEnumValue("Localize")
    LOCALIZE("Localize"),
    @XmlEnumValue("Move")
    MOVE("Move"),
    @XmlEnumValue("Publish")
    PUBLISH("Publish"),
    @XmlEnumValue("ReClassify")
    RE_CLASSIFY("ReClassify"),
    @XmlEnumValue("StartActivity")
    START_ACTIVITY("StartActivity"),
    @XmlEnumValue("UnClassify")
    UN_CLASSIFY("UnClassify"),
    @XmlEnumValue("UnLocalize")
    UN_LOCALIZE("UnLocalize"),
    @XmlEnumValue("UnPublish")
    UN_PUBLISH("UnPublish"),
    @XmlEnumValue("UndoCheckOut")
    UNDO_CHECK_OUT("UndoCheckOut"),
    @XmlEnumValue("DeleteTaxonomyNode")
    DELETE_TAXONOMY_NODE("DeleteTaxonomyNode"),
    @XmlEnumValue("SwitchUserEnabledState")
    SWITCH_USER_ENABLED_STATE("SwitchUserEnabledState"),
    @XmlEnumValue("CopyToKeyword")
    COPY_TO_KEYWORD("CopyToKeyword"),
    @XmlEnumValue("MoveToKeyword")
    MOVE_TO_KEYWORD("MoveToKeyword"),
    @XmlEnumValue("ReAssignActivity")
    RE_ASSIGN_ACTIVITY("ReAssignActivity"),
    @XmlEnumValue("RestartActivity")
    RESTART_ACTIVITY("RestartActivity"),
    @XmlEnumValue("SuspendActivity")
    SUSPEND_ACTIVITY("SuspendActivity"),
    @XmlEnumValue("ResumeActivity")
    RESUME_ACTIVITY("ResumeActivity"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    PredefinedBatchOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PredefinedBatchOperation fromValue(String v) {
        for (PredefinedBatchOperation c: PredefinedBatchOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
