
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrphanKeywordsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrphanKeywordsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}KeywordRelatedFilterData">
 *       &lt;sequence>
 *         &lt;element name="RootCategory" type="{http://www.sdltridion.com/ContentManager/R6}LinkToCategoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrphanKeywordsFilterData", propOrder = {
    "rootCategory"
})
public class OrphanKeywordsFilterData
    extends KeywordRelatedFilterData
{

    @XmlElement(name = "RootCategory", nillable = true)
    protected LinkToCategoryData rootCategory;

    /**
     * Gets the value of the rootCategory property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToCategoryData }
     *     
     */
    public LinkToCategoryData getRootCategory() {
        return rootCategory;
    }

    /**
     * Sets the value of the rootCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToCategoryData }
     *     
     */
    public void setRootCategory(LinkToCategoryData value) {
        this.rootCategory = value;
    }

}
