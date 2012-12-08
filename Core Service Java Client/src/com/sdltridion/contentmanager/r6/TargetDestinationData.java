
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetDestinationData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetDestinationData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProtocolData" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="ProtocolSchema" type="{http://www.sdltridion.com/ContentManager/R6}LinkToSchemaData" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetDestinationData", propOrder = {
    "protocolData",
    "protocolSchema",
    "title"
})
public class TargetDestinationData {

    @XmlElement(name = "ProtocolData", nillable = true)
    protected String protocolData;
    @XmlElement(name = "ProtocolSchema", nillable = true)
    protected LinkToSchemaData protocolSchema;
    @XmlElement(name = "Title", nillable = true)
    protected String title;

    /**
     * Gets the value of the protocolData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolData() {
        return protocolData;
    }

    /**
     * Sets the value of the protocolData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolData(String value) {
        this.protocolData = value;
    }

    /**
     * Gets the value of the protocolSchema property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToSchemaData }
     *     
     */
    public LinkToSchemaData getProtocolSchema() {
        return protocolSchema;
    }

    /**
     * Sets the value of the protocolSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToSchemaData }
     *     
     */
    public void setProtocolSchema(LinkToSchemaData value) {
        this.protocolSchema = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
