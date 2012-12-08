
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.VersionedItemData;


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
 *         &lt;element name="UndoCheckOutResult" type="{http://www.sdltridion.com/ContentManager/R6}VersionedItemData" minOccurs="0"/>
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
    "undoCheckOutResult"
})
@XmlRootElement(name = "UndoCheckOutResponse")
public class UndoCheckOutResponse {

    @XmlElement(name = "UndoCheckOutResult", nillable = true)
    protected VersionedItemData undoCheckOutResult;

    /**
     * Gets the value of the undoCheckOutResult property.
     * 
     * @return
     *     possible object is
     *     {@link VersionedItemData }
     *     
     */
    public VersionedItemData getUndoCheckOutResult() {
        return undoCheckOutResult;
    }

    /**
     * Sets the value of the undoCheckOutResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionedItemData }
     *     
     */
    public void setUndoCheckOutResult(VersionedItemData value) {
        this.undoCheckOutResult = value;
    }

}
