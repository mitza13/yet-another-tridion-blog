
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublishLocationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublishLocationInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}LocationInfo">
 *       &lt;sequence>
 *         &lt;element name="PublishLocationPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublishLocationUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublishPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublishLocationInfo", propOrder = {
    "publishLocationPath",
    "publishLocationUrl",
    "publishPath"
})
public class PublishLocationInfo
    extends LocationInfo
{

    @XmlElement(name = "PublishLocationPath", nillable = true)
    protected String publishLocationPath;
    @XmlElement(name = "PublishLocationUrl", nillable = true)
    protected String publishLocationUrl;
    @XmlElement(name = "PublishPath", nillable = true)
    protected String publishPath;

    /**
     * Gets the value of the publishLocationPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublishLocationPath() {
        return publishLocationPath;
    }

    /**
     * Sets the value of the publishLocationPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishLocationPath(String value) {
        this.publishLocationPath = value;
    }

    /**
     * Gets the value of the publishLocationUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublishLocationUrl() {
        return publishLocationUrl;
    }

    /**
     * Sets the value of the publishLocationUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishLocationUrl(String value) {
        this.publishLocationUrl = value;
    }

    /**
     * Gets the value of the publishPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublishPath() {
        return publishPath;
    }

    /**
     * Sets the value of the publishPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishPath(String value) {
        this.publishPath = value;
    }

}
