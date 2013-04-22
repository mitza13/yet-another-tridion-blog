
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import com.sdltridion.contentmanager.r6.ArrayOfWeakLink;


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
 *         &lt;element name="subjectLinks" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfWeakLink" minOccurs="0"/>
 *         &lt;element name="keywordIdsToRemove" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="keywordIdsToAdd" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
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
    "subjectLinks",
    "keywordIdsToRemove",
    "keywordIdsToAdd"
})
@XmlRootElement(name = "BatchReClassify")
public class BatchReClassify {

    @XmlElement(nillable = true)
    protected ArrayOfWeakLink subjectLinks;
    @XmlElement(nillable = true)
    protected ArrayOfstring keywordIdsToRemove;
    @XmlElement(nillable = true)
    protected ArrayOfstring keywordIdsToAdd;

    /**
     * Gets the value of the subjectLinks property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWeakLink }
     *     
     */
    public ArrayOfWeakLink getSubjectLinks() {
        return subjectLinks;
    }

    /**
     * Sets the value of the subjectLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWeakLink }
     *     
     */
    public void setSubjectLinks(ArrayOfWeakLink value) {
        this.subjectLinks = value;
    }

    /**
     * Gets the value of the keywordIdsToRemove property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getKeywordIdsToRemove() {
        return keywordIdsToRemove;
    }

    /**
     * Sets the value of the keywordIdsToRemove property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setKeywordIdsToRemove(ArrayOfstring value) {
        this.keywordIdsToRemove = value;
    }

    /**
     * Gets the value of the keywordIdsToAdd property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getKeywordIdsToAdd() {
        return keywordIdsToAdd;
    }

    /**
     * Sets the value of the keywordIdsToAdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setKeywordIdsToAdd(ArrayOfstring value) {
        this.keywordIdsToAdd = value;
    }

}
