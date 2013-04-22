
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


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
 *         &lt;element name="GetListDirectoryServiceNamesResult" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
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
    "getListDirectoryServiceNamesResult"
})
@XmlRootElement(name = "GetListDirectoryServiceNamesResponse")
public class GetListDirectoryServiceNamesResponse {

    @XmlElement(name = "GetListDirectoryServiceNamesResult", nillable = true)
    protected ArrayOfstring getListDirectoryServiceNamesResult;

    /**
     * Gets the value of the getListDirectoryServiceNamesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getGetListDirectoryServiceNamesResult() {
        return getListDirectoryServiceNamesResult;
    }

    /**
     * Sets the value of the getListDirectoryServiceNamesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setGetListDirectoryServiceNamesResult(ArrayOfstring value) {
        this.getListDirectoryServiceNamesResult = value;
    }

}
