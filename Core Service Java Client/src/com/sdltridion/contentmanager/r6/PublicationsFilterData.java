
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublicationsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublicationsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}RepositoriesFilterData">
 *       &lt;sequence>
 *         &lt;element name="PublicationTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicationsFilterData", propOrder = {
    "publicationTypeName"
})
public class PublicationsFilterData
    extends RepositoriesFilterData
{

    @XmlElement(name = "PublicationTypeName", nillable = true)
    protected String publicationTypeName;

    /**
     * Gets the value of the publicationTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationTypeName() {
        return publicationTypeName;
    }

    /**
     * Sets the value of the publicationTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationTypeName(String value) {
        this.publicationTypeName = value;
    }

}
