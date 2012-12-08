
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
 *         &lt;element name="UploadBinaryByteArrayResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "uploadBinaryByteArrayResult"
})
@XmlRootElement(name = "UploadBinaryByteArrayResponse")
public class UploadBinaryByteArrayResponse {

    @XmlElement(name = "UploadBinaryByteArrayResult", nillable = true)
    protected String uploadBinaryByteArrayResult;

    /**
     * Gets the value of the uploadBinaryByteArrayResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadBinaryByteArrayResult() {
        return uploadBinaryByteArrayResult;
    }

    /**
     * Sets the value of the uploadBinaryByteArrayResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadBinaryByteArrayResult(String value) {
        this.uploadBinaryByteArrayResult = value;
    }

}
