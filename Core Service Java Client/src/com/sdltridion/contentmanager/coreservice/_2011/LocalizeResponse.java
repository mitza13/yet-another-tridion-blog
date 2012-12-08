
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.RepositoryLocalObjectData;


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
 *         &lt;element name="LocalizeResult" type="{http://www.sdltridion.com/ContentManager/R6}RepositoryLocalObjectData" minOccurs="0"/>
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
    "localizeResult"
})
@XmlRootElement(name = "LocalizeResponse")
public class LocalizeResponse {

    @XmlElement(name = "LocalizeResult", nillable = true)
    protected RepositoryLocalObjectData localizeResult;

    /**
     * Gets the value of the localizeResult property.
     * 
     * @return
     *     possible object is
     *     {@link RepositoryLocalObjectData }
     *     
     */
    public RepositoryLocalObjectData getLocalizeResult() {
        return localizeResult;
    }

    /**
     * Sets the value of the localizeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepositoryLocalObjectData }
     *     
     */
    public void setLocalizeResult(RepositoryLocalObjectData value) {
        this.localizeResult = value;
    }

}
