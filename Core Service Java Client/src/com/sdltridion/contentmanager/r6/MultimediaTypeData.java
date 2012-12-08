
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultimediaTypeData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultimediaTypeData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideObjectData">
 *       &lt;sequence>
 *         &lt;element name="FileExtensions" type="{http://www.sdltridion.com/ContentManager/R6}FileExtensionsList" minOccurs="0"/>
 *         &lt;element name="MimeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultimediaTypeData", propOrder = {
    "fileExtensions",
    "mimeType"
})
public class MultimediaTypeData
    extends SystemWideObjectData
{

    @XmlElement(name = "FileExtensions", nillable = true)
    protected FileExtensionsList fileExtensions;
    @XmlElement(name = "MimeType", nillable = true)
    protected String mimeType;

    /**
     * Gets the value of the fileExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link FileExtensionsList }
     *     
     */
    public FileExtensionsList getFileExtensions() {
        return fileExtensions;
    }

    /**
     * Sets the value of the fileExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileExtensionsList }
     *     
     */
    public void setFileExtensions(FileExtensionsList value) {
        this.fileExtensions = value;
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

}
