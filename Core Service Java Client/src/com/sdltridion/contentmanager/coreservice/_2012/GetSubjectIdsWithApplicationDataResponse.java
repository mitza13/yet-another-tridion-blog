
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfTcmUri;


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
 *         &lt;element name="GetSubjectIdsWithApplicationDataResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfTcmUri" minOccurs="0"/>
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
    "getSubjectIdsWithApplicationDataResult"
})
@XmlRootElement(name = "GetSubjectIdsWithApplicationDataResponse")
public class GetSubjectIdsWithApplicationDataResponse {

    @XmlElement(name = "GetSubjectIdsWithApplicationDataResult", nillable = true)
    protected ArrayOfTcmUri getSubjectIdsWithApplicationDataResult;

    /**
     * Gets the value of the getSubjectIdsWithApplicationDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTcmUri }
     *     
     */
    public ArrayOfTcmUri getGetSubjectIdsWithApplicationDataResult() {
        return getSubjectIdsWithApplicationDataResult;
    }

    /**
     * Sets the value of the getSubjectIdsWithApplicationDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTcmUri }
     *     
     */
    public void setGetSubjectIdsWithApplicationDataResult(ArrayOfTcmUri value) {
        this.getSubjectIdsWithApplicationDataResult = value;
    }

}
