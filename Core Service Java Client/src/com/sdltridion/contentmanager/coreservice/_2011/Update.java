
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.IdentifiableObjectData;
import com.sdltridion.contentmanager.r6.ReadOptions;


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
 *         &lt;element name="deltaData" type="{http://www.sdltridion.com/ContentManager/R6}IdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="readBackOptions" type="{http://www.sdltridion.com/ContentManager/R6}ReadOptions" minOccurs="0"/>
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
    "deltaData",
    "readBackOptions"
})
@XmlRootElement(name = "Update")
public class Update {

    @XmlElement(nillable = true)
    protected IdentifiableObjectData deltaData;
    @XmlElement(nillable = true)
    protected ReadOptions readBackOptions;

    /**
     * Gets the value of the deltaData property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifiableObjectData }
     *     
     */
    public IdentifiableObjectData getDeltaData() {
        return deltaData;
    }

    /**
     * Sets the value of the deltaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifiableObjectData }
     *     
     */
    public void setDeltaData(IdentifiableObjectData value) {
        this.deltaData = value;
    }

    /**
     * Gets the value of the readBackOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ReadOptions }
     *     
     */
    public ReadOptions getReadBackOptions() {
        return readBackOptions;
    }

    /**
     * Sets the value of the readBackOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadOptions }
     *     
     */
    public void setReadBackOptions(ReadOptions value) {
        this.readBackOptions = value;
    }

}
