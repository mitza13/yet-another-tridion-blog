
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BluePrintFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BluePrintFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideListFilterData">
 *       &lt;sequence>
 *         &lt;element name="ForItem" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryLocalObjectData" minOccurs="0"/>
 *         &lt;element name="ForRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="IncludeWebDavUrlColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BluePrintFilterData", propOrder = {
    "forItem",
    "forRepository",
    "includeWebDavUrlColumn"
})
public class BluePrintFilterData
    extends SystemWideListFilterData
{

    @XmlElement(name = "ForItem", nillable = true)
    protected LinkToRepositoryLocalObjectData forItem;
    @XmlElement(name = "ForRepository", nillable = true)
    protected LinkToRepositoryData forRepository;
    @XmlElement(name = "IncludeWebDavUrlColumn", nillable = true)
    protected Boolean includeWebDavUrlColumn;

    /**
     * Gets the value of the forItem property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryLocalObjectData }
     *     
     */
    public LinkToRepositoryLocalObjectData getForItem() {
        return forItem;
    }

    /**
     * Sets the value of the forItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryLocalObjectData }
     *     
     */
    public void setForItem(LinkToRepositoryLocalObjectData value) {
        this.forItem = value;
    }

    /**
     * Gets the value of the forRepository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getForRepository() {
        return forRepository;
    }

    /**
     * Sets the value of the forRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setForRepository(LinkToRepositoryData value) {
        this.forRepository = value;
    }

    /**
     * Gets the value of the includeWebDavUrlColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeWebDavUrlColumn() {
        return includeWebDavUrlColumn;
    }

    /**
     * Sets the value of the includeWebDavUrlColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeWebDavUrlColumn(Boolean value) {
        this.includeWebDavUrlColumn = value;
    }

}
