
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.security.DirectoryUsersFilter;


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
 *         &lt;element name="directoryServiceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filter" type="{http://www.sdltridion.com/Security}DirectoryUsersFilter" minOccurs="0"/>
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
    "directoryServiceName",
    "filter"
})
@XmlRootElement(name = "GetListDirectoryServiceUsers")
public class GetListDirectoryServiceUsers {

    @XmlElement(nillable = true)
    protected String directoryServiceName;
    @XmlElement(nillable = true)
    protected DirectoryUsersFilter filter;

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
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link DirectoryUsersFilter }
     *     
     */
    public DirectoryUsersFilter getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectoryUsersFilter }
     *     
     */
    public void setFilter(DirectoryUsersFilter value) {
        this.filter = value;
    }

}
