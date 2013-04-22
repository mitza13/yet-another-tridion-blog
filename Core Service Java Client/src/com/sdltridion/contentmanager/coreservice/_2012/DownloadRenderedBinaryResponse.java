
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
 *         &lt;element name="DownloadRenderedBinaryResult" type="{http://schemas.microsoft.com/Message}StreamBody"/>
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
    "downloadRenderedBinaryResult"
})
@XmlRootElement(name = "DownloadRenderedBinaryResponse")
public class DownloadRenderedBinaryResponse {

    @XmlElement(name = "DownloadRenderedBinaryResult", required = true)
    protected byte[] downloadRenderedBinaryResult;

    /**
     * Gets the value of the downloadRenderedBinaryResult property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDownloadRenderedBinaryResult() {
        return downloadRenderedBinaryResult;
    }

    /**
     * Sets the value of the downloadRenderedBinaryResult property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDownloadRenderedBinaryResult(byte[] value) {
        this.downloadRenderedBinaryResult = ((byte[]) value);
    }

}
