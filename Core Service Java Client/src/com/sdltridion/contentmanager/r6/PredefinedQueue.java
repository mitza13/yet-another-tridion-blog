
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PredefinedQueue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PredefinedQueue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PublishQueue"/>
 *     &lt;enumeration value="DeployQueue"/>
 *     &lt;enumeration value="SearchQueue"/>
 *     &lt;enumeration value="WorkflowAgentQueue"/>
 *     &lt;enumeration value="BatchQueue"/>
 *     &lt;enumeration value="UnknownByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PredefinedQueue")
@XmlEnum
public enum PredefinedQueue {

    @XmlEnumValue("PublishQueue")
    PUBLISH_QUEUE("PublishQueue"),
    @XmlEnumValue("DeployQueue")
    DEPLOY_QUEUE("DeployQueue"),
    @XmlEnumValue("SearchQueue")
    SEARCH_QUEUE("SearchQueue"),
    @XmlEnumValue("WorkflowAgentQueue")
    WORKFLOW_AGENT_QUEUE("WorkflowAgentQueue"),
    @XmlEnumValue("BatchQueue")
    BATCH_QUEUE("BatchQueue"),
    @XmlEnumValue("UnknownByClient")
    UNKNOWN_BY_CLIENT("UnknownByClient");
    private final String value;

    PredefinedQueue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PredefinedQueue fromValue(String v) {
        for (PredefinedQueue c: PredefinedQueue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
