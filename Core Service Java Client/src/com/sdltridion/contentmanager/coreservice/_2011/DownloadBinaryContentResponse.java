
package com.sdltridion.contentmanager.coreservice._2011;

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
 *         &lt;element name="DownloadBinaryContentResult" type="{http://schemas.microsoft.com/Message}StreamBody"/>
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
    "downloadBinaryContentResult"
})
@XmlRootElement(name = "DownloadBinaryContentResponse")
public class DownloadBinaryContentResponse {

    @XmlElement(name = "DownloadBinaryContentResult", required = true)
    protected byte[] downloadBinaryContentResult;

    /**
     * Gets the value of the downloadBinaryContentResult property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDownloadBinaryContentResult() {
        return downloadBinaryContentResult;
    }

    /**
     * Sets the value of the downloadBinaryContentResult property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDownloadBinaryContentResult(byte[] value) {
        this.downloadBinaryContentResult = ((byte[]) value);
    }

}
