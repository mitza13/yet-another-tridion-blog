
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
 *         &lt;element name="subjectIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="applicationIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
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
    "subjectIds",
    "applicationIds"
})
@XmlRootElement(name = "ReadApplicationDataForSubjectsIds")
public class ReadApplicationDataForSubjectsIds {

    @XmlElement(nillable = true)
    protected ArrayOfstring subjectIds;
    @XmlElement(nillable = true)
    protected ArrayOfstring applicationIds;

    /**
     * Gets the value of the subjectIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getSubjectIds() {
        return subjectIds;
    }

    /**
     * Sets the value of the subjectIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setSubjectIds(ArrayOfstring value) {
        this.subjectIds = value;
    }

    /**
     * Gets the value of the applicationIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getApplicationIds() {
        return applicationIds;
    }

    /**
     * Sets the value of the applicationIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setApplicationIds(ArrayOfstring value) {
        this.applicationIds = value;
    }

}
