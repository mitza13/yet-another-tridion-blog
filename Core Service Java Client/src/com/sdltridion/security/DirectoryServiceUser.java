
package com.sdltridion.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirectoryServiceUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirectoryServiceUser">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/Security}ExternalUser">
 *       &lt;sequence>
 *         &lt;element name="AdditionalAttributes" type="{http://www.sdltridion.com/Security}AdditionalAttributes" minOccurs="0"/>
 *         &lt;element name="DN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectoryServiceUser", propOrder = {
    "additionalAttributes",
    "dn"
})
public class DirectoryServiceUser
    extends ExternalUser
{

    @XmlElement(name = "AdditionalAttributes", nillable = true)
    protected AdditionalAttributes additionalAttributes;
    @XmlElement(name = "DN", nillable = true)
    protected String dn;

    /**
     * Gets the value of the additionalAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalAttributes }
     *     
     */
    public AdditionalAttributes getAdditionalAttributes() {
        return additionalAttributes;
    }

    /**
     * Sets the value of the additionalAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalAttributes }
     *     
     */
    public void setAdditionalAttributes(AdditionalAttributes value) {
        this.additionalAttributes = value;
    }

    /**
     * Gets the value of the dn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDN() {
        return dn;
    }

    /**
     * Sets the value of the dn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDN(String value) {
        this.dn = value;
    }

}
