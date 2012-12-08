
package com.sdltridion.contentmanager.r6;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for PublishTransactionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublishTransactionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideObjectData">
 *       &lt;sequence>
 *         &lt;element name="Creator" type="{http://www.sdltridion.com/ContentManager/R6}LinkWithDescriptionUserData" minOccurs="0"/>
 *         &lt;element name="DeployerAction" type="{http://www.sdltridion.com/ContentManager/R6}DeployerAction" minOccurs="0"/>
 *         &lt;element name="HasRenderFailures" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Information" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instruction" type="{http://www.sdltridion.com/ContentManager/R6}PublishInstructionBaseData" minOccurs="0"/>
 *         &lt;element name="Items" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToIdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://www.sdltridion.com/ContentManager/R6}PublishPriority" minOccurs="0"/>
 *         &lt;element name="PublishContexts" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfPublishContextData" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.sdltridion.com/ContentManager/R6}PublishTransactionState" minOccurs="0"/>
 *         &lt;element name="StateChangeDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublishTransactionData", propOrder = {
    "creator",
    "deployerAction",
    "hasRenderFailures",
    "information",
    "instruction",
    "items",
    "priority",
    "publishContexts",
    "state",
    "stateChangeDateTime"
})
public class PublishTransactionData
    extends SystemWideObjectData
{

    @XmlElement(name = "Creator", nillable = true)
    protected LinkWithDescriptionUserData creator;
    @XmlElement(name = "DeployerAction", nillable = true)
    protected DeployerAction deployerAction;
    @XmlElement(name = "HasRenderFailures", nillable = true)
    protected Boolean hasRenderFailures;
    @XmlElement(name = "Information", nillable = true)
    protected String information;
    @XmlElement(name = "Instruction", nillable = true)
    protected PublishInstructionBaseData instruction;
    @XmlElement(name = "Items", nillable = true)
    protected ArrayOfLinkToIdentifiableObjectData items;
    @XmlElement(name = "Priority", nillable = true)
    protected PublishPriority priority;
    @XmlElement(name = "PublishContexts", nillable = true)
    protected ArrayOfPublishContextData publishContexts;
    @XmlElement(name = "State", nillable = true)
    protected PublishTransactionState state;
    @XmlElement(name = "StateChangeDateTime", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date stateChangeDateTime;

    /**
     * Gets the value of the creator property.
     * 
     * @return
     *     possible object is
     *     {@link LinkWithDescriptionUserData }
     *     
     */
    public LinkWithDescriptionUserData getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkWithDescriptionUserData }
     *     
     */
    public void setCreator(LinkWithDescriptionUserData value) {
        this.creator = value;
    }

    /**
     * Gets the value of the deployerAction property.
     * 
     * @return
     *     possible object is
     *     {@link DeployerAction }
     *     
     */
    public DeployerAction getDeployerAction() {
        return deployerAction;
    }

    /**
     * Sets the value of the deployerAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeployerAction }
     *     
     */
    public void setDeployerAction(DeployerAction value) {
        this.deployerAction = value;
    }

    /**
     * Gets the value of the hasRenderFailures property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasRenderFailures() {
        return hasRenderFailures;
    }

    /**
     * Sets the value of the hasRenderFailures property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasRenderFailures(Boolean value) {
        this.hasRenderFailures = value;
    }

    /**
     * Gets the value of the information property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformation() {
        return information;
    }

    /**
     * Sets the value of the information property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformation(String value) {
        this.information = value;
    }

    /**
     * Gets the value of the instruction property.
     * 
     * @return
     *     possible object is
     *     {@link PublishInstructionBaseData }
     *     
     */
    public PublishInstructionBaseData getInstruction() {
        return instruction;
    }

    /**
     * Sets the value of the instruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublishInstructionBaseData }
     *     
     */
    public void setInstruction(PublishInstructionBaseData value) {
        this.instruction = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToIdentifiableObjectData }
     *     
     */
    public ArrayOfLinkToIdentifiableObjectData getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToIdentifiableObjectData }
     *     
     */
    public void setItems(ArrayOfLinkToIdentifiableObjectData value) {
        this.items = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link PublishPriority }
     *     
     */
    public PublishPriority getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublishPriority }
     *     
     */
    public void setPriority(PublishPriority value) {
        this.priority = value;
    }

    /**
     * Gets the value of the publishContexts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPublishContextData }
     *     
     */
    public ArrayOfPublishContextData getPublishContexts() {
        return publishContexts;
    }

    /**
     * Sets the value of the publishContexts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPublishContextData }
     *     
     */
    public void setPublishContexts(ArrayOfPublishContextData value) {
        this.publishContexts = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link PublishTransactionState }
     *     
     */
    public PublishTransactionState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublishTransactionState }
     *     
     */
    public void setState(PublishTransactionState value) {
        this.state = value;
    }

    /**
     * Gets the value of the stateChangeDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getStateChangeDateTime() {
        return stateChangeDateTime;
    }

    /**
     * Sets the value of the stateChangeDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateChangeDateTime(Date value) {
        this.stateChangeDateTime = value;
    }

}
