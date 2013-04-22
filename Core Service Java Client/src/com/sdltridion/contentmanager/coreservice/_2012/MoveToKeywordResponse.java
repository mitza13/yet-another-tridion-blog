
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
 *         &lt;element name="MoveToKeywordResult" type="{http://www.sdltridion.com/ContentManager/R6}KeywordData" minOccurs="0"/>
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
    "moveToKeywordResult"
})
@XmlRootElement(name = "MoveToKeywordResponse")
public class MoveToKeywordResponse {

    @XmlElement(name = "MoveToKeywordResult", nillable = true)
    protected KeywordData moveToKeywordResult;

    /**
     * Gets the value of the moveToKeywordResult property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordData }
     *     
     */
    public KeywordData getMoveToKeywordResult() {
        return moveToKeywordResult;
    }

    /**
     * Sets the value of the moveToKeywordResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordData }
     *     
     */
    public void setMoveToKeywordResult(KeywordData value) {
        this.moveToKeywordResult = value;
    }

}
