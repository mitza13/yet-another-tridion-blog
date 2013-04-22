
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="baseUri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contextRepositoryUri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
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
    "baseUri",
    "contextRepositoryUri",
    "version"
})
@XmlRootElement(name = "GetTcmUri")
public class GetTcmUri {

    @XmlElement(nillable = true)
    protected String baseUri;
    @XmlElement(nillable = true)
    protected String contextRepositoryUri;
    @XmlElement(nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long version;

    /**
     * Gets the value of the baseUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Sets the value of the baseUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUri(String value) {
        this.baseUri = value;
    }

    /**
     * Gets the value of the contextRepositoryUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextRepositoryUri() {
        return contextRepositoryUri;
    }

    /**
     * Sets the value of the contextRepositoryUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextRepositoryUri(String value) {
        this.contextRepositoryUri = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVersion(Long value) {
        this.version = value;
    }

}
