
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import com.sdltridion.contentmanager.r6.PublishPriority;
import com.sdltridion.contentmanager.r6.ReadOptions;
import com.sdltridion.contentmanager.r6.UnPublishInstructionData;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ids" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="unPublishInstruction" type="{http://www.sdltridion.com/ContentManager/R6}UnPublishInstructionData" minOccurs="0"/>
 *         &lt;element name="targets" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://www.sdltridion.com/ContentManager/R6}PublishPriority" minOccurs="0"/>
 *         &lt;element name="readOptions" type="{http://www.sdltridion.com/ContentManager/R6}ReadOptions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ids",
    "unPublishInstruction",
    "targets",
    "priority",
    "readOptions"
})
@XmlRootElement(name = "UnPublish")
public class UnPublish {

    @XmlElement(nillable = true)
    protected ArrayOfstring ids;
    @XmlElement(nillable = true)
    protected UnPublishInstructionData unPublishInstruction;
    @XmlElement(nillable = true)
    protected ArrayOfstring targets;
    @XmlElement(nillable = true)
    protected PublishPriority priority;
    @XmlElement(nillable = true)
    protected ReadOptions readOptions;

    /**
     * Gets the value of the ids property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getIds() {
        return ids;
    }

    /**
     * Sets the value of the ids property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setIds(ArrayOfstring value) {
        this.ids = value;
    }

    /**
     * Gets the value of the unPublishInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link UnPublishInstructionData }
     *     
     */
    public UnPublishInstructionData getUnPublishInstruction() {
        return unPublishInstruction;
    }

    /**
     * Sets the value of the unPublishInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnPublishInstructionData }
     *     
     */
    public void setUnPublishInstruction(UnPublishInstructionData value) {
        this.unPublishInstruction = value;
    }

    /**
     * Gets the value of the targets property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getTargets() {
        return targets;
    }

    /**
     * Sets the value of the targets property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setTargets(ArrayOfstring value) {
        this.targets = value;
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
     * Gets the value of the readOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ReadOptions }
     *     
     */
    public ReadOptions getReadOptions() {
        return readOptions;
    }

    /**
     * Sets the value of the readOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadOptions }
     *     
     */
    public void setReadOptions(ReadOptions value) {
        this.readOptions = value;
    }

}
