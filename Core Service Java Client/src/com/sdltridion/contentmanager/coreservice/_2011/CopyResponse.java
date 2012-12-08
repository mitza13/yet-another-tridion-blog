
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
 *         &lt;element name="CopyResult" type="{http://www.sdltridion.com/ContentManager/R6}RepositoryLocalObjectData" minOccurs="0"/>
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
    "copyResult"
})
@XmlRootElement(name = "CopyResponse")
public class CopyResponse {

    @XmlElement(name = "CopyResult", nillable = true)
    protected RepositoryLocalObjectData copyResult;

    /**
     * Gets the value of the copyResult property.
     * 
     * @return
     *     possible object is
     *     {@link RepositoryLocalObjectData }
     *     
     */
    public RepositoryLocalObjectData getCopyResult() {
        return copyResult;
    }

    /**
     * Sets the value of the copyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepositoryLocalObjectData }
     *     
     */
    public void setCopyResult(RepositoryLocalObjectData value) {
        this.copyResult = value;
    }

}
