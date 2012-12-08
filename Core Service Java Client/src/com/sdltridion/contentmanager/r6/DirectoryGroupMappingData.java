
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirectoryGroupMappingData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirectoryGroupMappingData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ClaimMappingData">
 *       &lt;sequence>
 *         &lt;element name="DirectoryServiceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SearchDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SearchType" type="{http://www.sdltridion.com/ContentManager/R6}DirectorySearchType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectoryGroupMappingData", propOrder = {
    "directoryServiceName",
    "searchDN",
    "searchType"
})
public class DirectoryGroupMappingData
    extends ClaimMappingData
{

    @XmlElement(name = "DirectoryServiceName", nillable = true)
    protected String directoryServiceName;
    @XmlElement(name = "SearchDN", nillable = true)
    protected String searchDN;
    @XmlElement(name = "SearchType")
    protected DirectorySearchType searchType;

    /**
     * Gets the value of the directoryServiceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectoryServiceName() {
        return directoryServiceName;
    }

    /**
     * Sets the value of the directoryServiceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectoryServiceName(String value) {
        this.directoryServiceName = value;
    }

    /**
     * Gets the value of the searchDN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchDN() {
        return searchDN;
    }

    /**
     * Sets the value of the searchDN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchDN(String value) {
        this.searchDN = value;
    }

    /**
     * Gets the value of the searchType property.
     * 
     * @return
     *     possible object is
     *     {@link DirectorySearchType }
     *     
     */
    public DirectorySearchType getSearchType() {
        return searchType;
    }

    /**
     * Sets the value of the searchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectorySearchType }
     *     
     */
    public void setSearchType(DirectorySearchType value) {
        this.searchType = value;
    }

}
