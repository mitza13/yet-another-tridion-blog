
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
 *         &lt;element name="DownloadBinaryContentByUserResult" type="{http://schemas.microsoft.com/Message}StreamBody"/>
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
    "downloadBinaryContentByUserResult"
})
@XmlRootElement(name = "DownloadBinaryContentByUserResponse")
public class DownloadBinaryContentByUserResponse {

    @XmlElement(name = "DownloadBinaryContentByUserResult", required = true)
    protected byte[] downloadBinaryContentByUserResult;

    /**
     * Gets the value of the downloadBinaryContentByUserResult property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDownloadBinaryContentByUserResult() {
        return downloadBinaryContentByUserResult;
    }

    /**
     * Sets the value of the downloadBinaryContentByUserResult property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDownloadBinaryContentByUserResult(byte[] value) {
        this.downloadBinaryContentByUserResult = ((byte[]) value);
    }

}
