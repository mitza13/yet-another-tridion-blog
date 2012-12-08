
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
 *         &lt;element name="RollbackResult" type="{http://www.sdltridion.com/ContentManager/R6}VersionedItemData" minOccurs="0"/>
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
    "rollbackResult"
})
@XmlRootElement(name = "RollbackResponse")
public class RollbackResponse {

    @XmlElement(name = "RollbackResult", nillable = true)
    protected VersionedItemData rollbackResult;

    /**
     * Gets the value of the rollbackResult property.
     * 
     * @return
     *     possible object is
     *     {@link VersionedItemData }
     *     
     */
    public VersionedItemData getRollbackResult() {
        return rollbackResult;
    }

    /**
     * Sets the value of the rollbackResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionedItemData }
     *     
     */
    public void setRollbackResult(VersionedItemData value) {
        this.rollbackResult = value;
    }

}
