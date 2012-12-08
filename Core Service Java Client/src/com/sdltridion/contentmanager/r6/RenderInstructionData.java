
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RenderInstructionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RenderInstructionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BinaryStoragePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExtensionXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenderMode" type="{http://www.sdltridion.com/ContentManager/R6}RenderMode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RenderInstructionData", propOrder = {
    "binaryStoragePath",
    "extensionXml",
    "renderMode"
})
public class RenderInstructionData {

    @XmlElement(name = "BinaryStoragePath", nillable = true)
    protected String binaryStoragePath;
    @XmlElement(name = "ExtensionXml", nillable = true)
    protected String extensionXml;
    @XmlElement(name = "RenderMode", nillable = true)
    protected RenderMode renderMode;

    /**
     * Gets the value of the binaryStoragePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBinaryStoragePath() {
        return binaryStoragePath;
    }

    /**
     * Sets the value of the binaryStoragePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBinaryStoragePath(String value) {
        this.binaryStoragePath = value;
    }

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
     * Gets the value of the renderMode property.
     * 
     * @return
     *     possible object is
     *     {@link RenderMode }
     *     
     */
    public RenderMode getRenderMode() {
        return renderMode;
    }

    /**
     * Sets the value of the renderMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenderMode }
     *     
     */
    public void setRenderMode(RenderMode value) {
        this.renderMode = value;
    }

}
