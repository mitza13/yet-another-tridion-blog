
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChildKeywordsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChildKeywordsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}KeywordRelatedFilterData">
 *       &lt;sequence>
 *         &lt;element name="InCategory" type="{http://www.sdltridion.com/ContentManager/R6}LinkToCategoryData" minOccurs="0"/>
 *         &lt;element name="IsAbstract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChildKeywordsFilterData", propOrder = {
    "inCategory",
    "isAbstract"
})
public class ChildKeywordsFilterData
    extends KeywordRelatedFilterData
{

    @XmlElement(name = "InCategory", nillable = true)
    protected LinkToCategoryData inCategory;
    @XmlElement(name = "IsAbstract", nillable = true)
    protected Boolean isAbstract;

    /**
     * Gets the value of the inCategory property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToCategoryData }
     *     
     */
    public LinkToCategoryData getInCategory() {
        return inCategory;
    }

    /**
     * Sets the value of the inCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToCategoryData }
     *     
     */
    public void setInCategory(LinkToCategoryData value) {
        this.inCategory = value;
    }

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

}
