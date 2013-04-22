
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BinaryContentData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BinaryContentData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BinaryId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FileSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsExternal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MultimediaType" type="{http://www.sdltridion.com/ContentManager/R6}LinkToMultimediaTypeData" minOccurs="0"/>
 *         &lt;element name="UploadFromFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MimeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalBinaryUri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Size" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BinaryContentData", propOrder = {
    "binaryId",
    "fileSize",
    "filename",
    "isExternal",
    "multimediaType",
    "uploadFromFile",
    "mimeType",
    "externalBinaryUri",
    "size"
})
public class BinaryContentData {

    @XmlElement(name = "BinaryId", nillable = true)
    protected Integer binaryId;
    @XmlElement(name = "FileSize", nillable = true)
    protected Integer fileSize;
    @XmlElement(name = "Filename", nillable = true)
    protected String filename;
    @XmlElement(name = "IsExternal", nillable = true)
    protected Boolean isExternal;
    @XmlElement(name = "MultimediaType", nillable = true)
    protected LinkToMultimediaTypeData multimediaType;
    @XmlElement(name = "UploadFromFile", nillable = true)
    protected String uploadFromFile;
    @XmlElement(name = "MimeType", nillable = true)
    protected String mimeType;
    @XmlElement(name = "ExternalBinaryUri", nillable = true)
    protected String externalBinaryUri;
    @XmlElement(name = "Size", nillable = true)
    protected Long size;

    /**
     * Gets the value of the binaryId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBinaryId() {
        return binaryId;
    }

    /**
     * Sets the value of the binaryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBinaryId(Integer value) {
        this.binaryId = value;
    }

    /**
     * Gets the value of the fileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFileSize(Integer value) {
        this.fileSize = value;
    }

    /**
     * Gets the value of the filename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the value of the filename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    /**
     * Gets the value of the isExternal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsExternal() {
        return isExternal;
    }

    /**
     * Sets the value of the isExternal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsExternal(Boolean value) {
        this.isExternal = value;
    }

    /**
     * Gets the value of the multimediaType property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToMultimediaTypeData }
     *     
     */
    public LinkToMultimediaTypeData getMultimediaType() {
        return multimediaType;
    }

    /**
     * Sets the value of the multimediaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToMultimediaTypeData }
     *     
     */
    public void setMultimediaType(LinkToMultimediaTypeData value) {
        this.multimediaType = value;
    }

    /**
     * Gets the value of the uploadFromFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadFromFile() {
        return uploadFromFile;
    }

    /**
     * Sets the value of the uploadFromFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadFromFile(String value) {
        this.uploadFromFile = value;
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
     * Gets the value of the externalBinaryUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalBinaryUri() {
        return externalBinaryUri;
    }

    /**
     * Sets the value of the externalBinaryUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalBinaryUri(String value) {
        this.externalBinaryUri = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSize(Long value) {
        this.size = value;
    }

}
