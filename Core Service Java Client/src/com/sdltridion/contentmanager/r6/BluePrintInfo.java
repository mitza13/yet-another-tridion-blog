
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BluePrintInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BluePrintInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}Info">
 *       &lt;sequence>
 *         &lt;element name="IsLocalized" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsShared" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OwningRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BluePrintInfo", propOrder = {
    "isLocalized",
    "isShared",
    "owningRepository"
})
public class BluePrintInfo
    extends Info
{

    @XmlElement(name = "IsLocalized", nillable = true)
    protected Boolean isLocalized;
    @XmlElement(name = "IsShared", nillable = true)
    protected Boolean isShared;
    @XmlElement(name = "OwningRepository", nillable = true)
    protected LinkToRepositoryData owningRepository;

    /**
     * Gets the value of the isLocalized property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsLocalized() {
        return isLocalized;
    }

    /**
     * Sets the value of the isLocalized property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsLocalized(Boolean value) {
        this.isLocalized = value;
    }

    /**
     * Gets the value of the isShared property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsShared() {
        return isShared;
    }

    /**
     * Sets the value of the isShared property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsShared(Boolean value) {
        this.isShared = value;
    }

    /**
     * Gets the value of the owningRepository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getOwningRepository() {
        return owningRepository;
    }

    /**
     * Sets the value of the owningRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setOwningRepository(LinkToRepositoryData value) {
        this.owningRepository = value;
    }

}
