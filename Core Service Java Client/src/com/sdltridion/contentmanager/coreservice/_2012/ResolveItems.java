
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import com.sdltridion.contentmanager.r6.ReadOptions;
import com.sdltridion.contentmanager.r6.ResolveInstructionData;


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
 *         &lt;element name="resolveInstruction" type="{http://www.sdltridion.com/ContentManager/R6}ResolveInstructionData" minOccurs="0"/>
 *         &lt;element name="targets" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
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
    "resolveInstruction",
    "targets",
    "readOptions"
})
@XmlRootElement(name = "ResolveItems")
public class ResolveItems {

    @XmlElement(nillable = true)
    protected ArrayOfstring ids;
    @XmlElement(nillable = true)
    protected ResolveInstructionData resolveInstruction;
    @XmlElement(nillable = true)
    protected ArrayOfstring targets;
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
