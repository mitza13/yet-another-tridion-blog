
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TemplateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TemplateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HasBinaryContent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MimeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WebDavFileExtensionMappings" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfWebDavFileExtensionMapping" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemplateType", propOrder = {
    "hasBinaryContent",
    "id",
    "mimeType",
    "name",
    "title",
    "webDavFileExtensionMappings"
})
public class TemplateType {

    @XmlElement(name = "HasBinaryContent")
    protected Boolean hasBinaryContent;
    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElement(name = "MimeType", nillable = true)
    protected String mimeType;
    @XmlElement(name = "Name", nillable = true)
    protected String name;
    @XmlElement(name = "Title", nillable = true)
    protected String title;
    @XmlElement(name = "WebDavFileExtensionMappings", nillable = true)
    protected ArrayOfWebDavFileExtensionMapping webDavFileExtensionMappings;

    /**
     * Gets the value of the hasBinaryContent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasBinaryContent() {
        return hasBinaryContent;
    }

    /**
     * Sets the value of the hasBinaryContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasBinaryContent(Boolean value) {
        this.hasBinaryContent = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the mimeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Sets the value of the mimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMimeType(String value) {
        this.mimeType = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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

    /**
     * Gets the value of the webDavFileExtensionMappings property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWebDavFileExtensionMapping }
     *     
     */
    public ArrayOfWebDavFileExtensionMapping getWebDavFileExtensionMappings() {
        return webDavFileExtensionMappings;
    }

    /**
     * Sets the value of the webDavFileExtensionMappings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWebDavFileExtensionMapping }
     *     
     */
    public void setWebDavFileExtensionMappings(ArrayOfWebDavFileExtensionMapping value) {
        this.webDavFileExtensionMappings = value;
    }

}
