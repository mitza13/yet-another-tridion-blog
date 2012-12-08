
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfPublicationType;


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
 *         &lt;element name="GetListPublicationTypesResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfPublicationType" minOccurs="0"/>
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
    "getListPublicationTypesResult"
})
@XmlRootElement(name = "GetListPublicationTypesResponse")
public class GetListPublicationTypesResponse {

    @XmlElement(name = "GetListPublicationTypesResult", nillable = true)
    protected ArrayOfPublicationType getListPublicationTypesResult;

    /**
     * Gets the value of the getListPublicationTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPublicationType }
     *     
     */
    public ArrayOfPublicationType getGetListPublicationTypesResult() {
        return getListPublicationTypesResult;
    }

    /**
     * Sets the value of the getListPublicationTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPublicationType }
     *     
     */
    public void setGetListPublicationTypesResult(ArrayOfPublicationType value) {
        this.getListPublicationTypesResult = value;
    }

}
