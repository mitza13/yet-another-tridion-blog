
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeywordsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeywordsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}KeywordRelatedFilterData">
 *       &lt;sequence>
 *         &lt;element name="IsAbstract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsRoot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ResultLimit" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeywordsFilterData", propOrder = {
    "isAbstract",
    "isRoot",
    "resultLimit"
})
public class KeywordsFilterData
    extends KeywordRelatedFilterData
{

    @XmlElement(name = "IsAbstract", nillable = true)
    protected Boolean isAbstract;
    @XmlElement(name = "IsRoot", nillable = true)
    protected Boolean isRoot;
    @XmlElement(name = "ResultLimit", nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long resultLimit;

    /**
     * Gets the value of the isAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAbstract() {
        return isAbstract;
    }

    /**
     * Sets the value of the isAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAbstract(Boolean value) {
        this.isAbstract = value;
    }

    /**
     * Gets the value of the isRoot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRoot() {
        return isRoot;
    }

    /**
     * Sets the value of the isRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRoot(Boolean value) {
        this.isRoot = value;
    }

    /**
     * Gets the value of the resultLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getResultLimit() {
        return resultLimit;
    }

    /**
     * Sets the value of the resultLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setResultLimit(Long value) {
        this.resultLimit = value;
    }

}
