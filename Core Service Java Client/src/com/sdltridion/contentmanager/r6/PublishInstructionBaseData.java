
package com.sdltridion.contentmanager.r6;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for PublishInstructionBaseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublishInstructionBaseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtensionXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResolveInstruction" type="{http://www.sdltridion.com/ContentManager/R6}ResolveInstructionData" minOccurs="0"/>
 *         &lt;element name="RollbackOnFailure" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StartAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublishInstructionBaseData", propOrder = {
    "extensionXml",
    "resolveInstruction",
    "rollbackOnFailure",
    "startAt"
})
@XmlSeeAlso({
    PublishInstructionData.class,
    UnPublishInstructionData.class
})
public class PublishInstructionBaseData {

    @XmlElement(name = "ExtensionXml", nillable = true)
    protected String extensionXml;
    @XmlElement(name = "ResolveInstruction", nillable = true)
    protected ResolveInstructionData resolveInstruction;
    @XmlElement(name = "RollbackOnFailure", nillable = true)
    protected Boolean rollbackOnFailure;
    @XmlElement(name = "StartAt", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date startAt;

    /**
     * Gets the value of the extensionXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensionXml() {
        return extensionXml;
    }

    /**
     * Sets the value of the extensionXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensionXml(String value) {
        this.extensionXml = value;
    }

    /**
     * Gets the value of the resolveInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link ResolveInstructionData }
     *     
     */
    public ResolveInstructionData getResolveInstruction() {
        return resolveInstruction;
    }

    /**
     * Sets the value of the resolveInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResolveInstructionData }
     *     
     */
    public void setResolveInstruction(ResolveInstructionData value) {
        this.resolveInstruction = value;
    }

    /**
     * Gets the value of the rollbackOnFailure property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRollbackOnFailure() {
        return rollbackOnFailure;
    }

    /**
     * Sets the value of the rollbackOnFailure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRollbackOnFailure(Boolean value) {
        this.rollbackOnFailure = value;
    }

    /**
     * Gets the value of the startAt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getStartAt() {
        return startAt;
    }

    /**
     * Sets the value of the startAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartAt(Date value) {
        this.startAt = value;
    }

}
