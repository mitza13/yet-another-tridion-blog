
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfBundleTypeData;


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
 *         &lt;element name="ResolveBundleTypesResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfBundleTypeData" minOccurs="0"/>
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
    "resolveBundleTypesResult"
})
@XmlRootElement(name = "ResolveBundleTypesResponse")
public class ResolveBundleTypesResponse {

    @XmlElement(name = "ResolveBundleTypesResult", nillable = true)
    protected ArrayOfBundleTypeData resolveBundleTypesResult;

    /**
     * Gets the value of the resolveBundleTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBundleTypeData }
     *     
     */
    public ArrayOfBundleTypeData getResolveBundleTypesResult() {
        return resolveBundleTypesResult;
    }

    /**
     * Sets the value of the resolveBundleTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBundleTypeData }
     *     
     */
    public void setResolveBundleTypesResult(ArrayOfBundleTypeData value) {
        this.resolveBundleTypesResult = value;
    }

}
