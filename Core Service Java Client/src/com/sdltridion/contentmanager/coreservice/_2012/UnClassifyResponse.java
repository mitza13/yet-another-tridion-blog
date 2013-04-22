
package com.sdltridion.contentmanager.coreservice._2012;

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
 *         &lt;element name="UnClassifyResult" type="{http://www.sdltridion.com/ContentManager/R6}ClassificationInfoData" minOccurs="0"/>
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
    "unClassifyResult"
})
@XmlRootElement(name = "UnClassifyResponse")
public class UnClassifyResponse {

    @XmlElement(name = "UnClassifyResult", nillable = true)
    protected ClassificationInfoData unClassifyResult;

    /**
     * Gets the value of the unClassifyResult property.
     * 
     * @return
     *     possible object is
     *     {@link ClassificationInfoData }
     *     
     */
    public ClassificationInfoData getUnClassifyResult() {
        return unClassifyResult;
    }

    /**
     * Sets the value of the unClassifyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificationInfoData }
     *     
     */
    public void setUnClassifyResult(ClassificationInfoData value) {
        this.unClassifyResult = value;
    }

}
