
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TridionProcessDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TridionProcessDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ProcessDefinitionData">
 *       &lt;sequence>
 *         &lt;element name="Diagram" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TridionProcessDefinitionData", propOrder = {
    "diagram"
})
public class TridionProcessDefinitionData
    extends ProcessDefinitionData
{

    @XmlElement(name = "Diagram", nillable = true)
    protected byte[] diagram;

    /**
     * Gets the value of the diagram property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDiagram() {
        return diagram;
    }

    /**
     * Sets the value of the diagram property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDiagram(byte[] value) {
        this.diagram = ((byte[]) value);
    }

}
