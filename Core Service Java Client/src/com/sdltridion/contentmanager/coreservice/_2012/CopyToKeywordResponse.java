
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.KeywordData;


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
 *         &lt;element name="CopyToKeywordResult" type="{http://www.sdltridion.com/ContentManager/R6}KeywordData" minOccurs="0"/>
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
    "copyToKeywordResult"
})
@XmlRootElement(name = "CopyToKeywordResponse")
public class CopyToKeywordResponse {

    @XmlElement(name = "CopyToKeywordResult", nillable = true)
    protected KeywordData copyToKeywordResult;

    /**
     * Gets the value of the copyToKeywordResult property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordData }
     *     
     */
    public KeywordData getCopyToKeywordResult() {
        return copyToKeywordResult;
    }

    /**
     * Sets the value of the copyToKeywordResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordData }
     *     
     */
    public void setCopyToKeywordResult(KeywordData value) {
        this.copyToKeywordResult = value;
    }

}
