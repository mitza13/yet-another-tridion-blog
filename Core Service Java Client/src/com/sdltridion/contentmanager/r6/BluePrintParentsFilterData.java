
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BluePrintParentsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BluePrintParentsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideListFilterData">
 *       &lt;sequence>
 *         &lt;element name="CurrentParents" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="ForRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BluePrintParentsFilterData", propOrder = {
    "currentParents",
    "forRepository"
})
public class BluePrintParentsFilterData
    extends SystemWideListFilterData
{

    @XmlElement(name = "CurrentParents", nillable = true)
    protected ArrayOfLinkToRepositoryData currentParents;
    @XmlElement(name = "ForRepository", nillable = true)
    protected LinkToRepositoryData forRepository;

    /**
     * Gets the value of the currentParents property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToRepositoryData }
     *     
     */
    public ArrayOfLinkToRepositoryData getCurrentParents() {
        return currentParents;
    }

    /**
     * Sets the value of the currentParents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToRepositoryData }
     *     
     */
    public void setCurrentParents(ArrayOfLinkToRepositoryData value) {
        this.currentParents = value;
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

}
