
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ClassificationInfoData;


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
 *         &lt;element name="ReClassifyResult" type="{http://www.sdltridion.com/ContentManager/R6}ClassificationInfoData" minOccurs="0"/>
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
    "reClassifyResult"
})
@XmlRootElement(name = "ReClassifyResponse")
public class ReClassifyResponse {

    @XmlElement(name = "ReClassifyResult", nillable = true)
    protected ClassificationInfoData reClassifyResult;

    /**
     * Gets the value of the reClassifyResult property.
     * 
     * @return
     *     possible object is
     *     {@link ClassificationInfoData }
     *     
     */
    public ClassificationInfoData getReClassifyResult() {
        return reClassifyResult;
    }

    /**
     * Sets the value of the reClassifyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificationInfoData }
     *     
     */
    public void setReClassifyResult(ClassificationInfoData value) {
        this.reClassifyResult = value;
    }

}
