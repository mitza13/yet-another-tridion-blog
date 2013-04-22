
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublishTransactionState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PublishTransactionState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ScheduledForPublish"/>
 *     &lt;enumeration value="WaitingForPublish"/>
 *     &lt;enumeration value="InProgress"/>
 *     &lt;enumeration value="ScheduledForDeployment"/>
 *     &lt;enumeration value="WaitingForDeployment"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="Success"/>
 *     &lt;enumeration value="Warning"/>
 *     &lt;enumeration value="Resolving"/>
 *     &lt;enumeration value="Rendering"/>
 *     &lt;enumeration value="Throttled"/>
 *     &lt;enumeration value="ReadyForTransport"/>
 *     &lt;enumeration value="Transporting"/>
 *     &lt;enumeration value="Deploying"/>
 *     &lt;enumeration value="PreparingDeployment"/>
 *     &lt;enumeration value="PreCommittingDeployment"/>
 *     &lt;enumeration value="CommittingDeployment"/>
 *     &lt;enumeration value="WaitingForUndo"/>
 *     &lt;enumeration value="Undoing"/>
 *     &lt;enumeration value="Undone"/>
 *     &lt;enumeration value="UndoFailed"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PublishTransactionState")
@XmlEnum
public enum PublishTransactionState {

    @XmlEnumValue("ScheduledForPublish")
    SCHEDULED_FOR_PUBLISH("ScheduledForPublish"),
    @XmlEnumValue("WaitingForPublish")
    WAITING_FOR_PUBLISH("WaitingForPublish"),
    @XmlEnumValue("InProgress")
    IN_PROGRESS("InProgress"),
    @XmlEnumValue("ScheduledForDeployment")
    SCHEDULED_FOR_DEPLOYMENT("ScheduledForDeployment"),
    @XmlEnumValue("WaitingForDeployment")
    WAITING_FOR_DEPLOYMENT("WaitingForDeployment"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("Success")
    SUCCESS("Success"),
    @XmlEnumValue("Warning")
    WARNING("Warning"),
    @XmlEnumValue("Resolving")
    RESOLVING("Resolving"),
    @XmlEnumValue("Rendering")
    RENDERING("Rendering"),
    @XmlEnumValue("Throttled")
    THROTTLED("Throttled"),
    @XmlEnumValue("ReadyForTransport")
    READY_FOR_TRANSPORT("ReadyForTransport"),
    @XmlEnumValue("Transporting")
    TRANSPORTING("Transporting"),
    @XmlEnumValue("Deploying")
    DEPLOYING("Deploying"),
    @XmlEnumValue("PreparingDeployment")
    PREPARING_DEPLOYMENT("PreparingDeployment"),
    @XmlEnumValue("PreCommittingDeployment")
    PRE_COMMITTING_DEPLOYMENT("PreCommittingDeployment"),
    @XmlEnumValue("CommittingDeployment")
    COMMITTING_DEPLOYMENT("CommittingDeployment"),
    @XmlEnumValue("WaitingForUndo")
    WAITING_FOR_UNDO("WaitingForUndo"),
    @XmlEnumValue("Undoing")
    UNDOING("Undoing"),
    @XmlEnumValue("Undone")
    UNDONE("Undone"),
    @XmlEnumValue("UndoFailed")
    UNDO_FAILED("UndoFailed"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    PublishTransactionState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PublishTransactionState fromValue(String v) {
        for (PublishTransactionState c: PublishTransactionState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
