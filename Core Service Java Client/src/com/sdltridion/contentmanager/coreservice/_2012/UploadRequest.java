
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="UploadContent" type="{http://schemas.microsoft.com/Message}StreamBody"/>
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
    "uploadContent"
})
@XmlRootElement(name = "UploadRequest")
public class UploadRequest {

    @XmlElement(name = "UploadContent", required = true)
    protected byte[] uploadContent;

    /**
     * Gets the value of the uploadContent property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getUploadContent() {
        return uploadContent;
    }

    /**
     * Sets the value of the uploadContent property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setUploadContent(byte[] value) {
        this.uploadContent = ((byte[]) value);
    }

}
