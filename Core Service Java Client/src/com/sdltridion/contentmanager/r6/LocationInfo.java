
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LocationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocationInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}Info">
 *       &lt;sequence>
 *         &lt;element name="ContextRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="OrganizationalItem" type="{http://www.sdltridion.com/ContentManager/R6}LinkToOrganizationalItemData" minOccurs="0"/>
 *         &lt;element name="Path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WebDavUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationInfo", propOrder = {
    "contextRepository",
    "organizationalItem",
    "path",
    "webDavUrl"
})
@XmlSeeAlso({
    PublishLocationInfo.class
})
public class LocationInfo
    extends Info
{

    @XmlElement(name = "ContextRepository", nillable = true)
    protected LinkToRepositoryData contextRepository;
    @XmlElement(name = "OrganizationalItem", nillable = true)
    protected LinkToOrganizationalItemData organizationalItem;
    @XmlElement(name = "Path", nillable = true)
    protected String path;
    @XmlElement(name = "WebDavUrl", nillable = true)
    protected String webDavUrl;

    /**
     * Gets the value of the contextRepository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getContextRepository() {
        return contextRepository;
    }

    /**
     * Sets the value of the contextRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setContextRepository(LinkToRepositoryData value) {
        this.contextRepository = value;
    }

    /**
     * Gets the value of the organizationalItem property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToOrganizationalItemData }
     *     
     */
    public LinkToOrganizationalItemData getOrganizationalItem() {
        return organizationalItem;
    }

    /**
     * Sets the value of the organizationalItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToOrganizationalItemData }
     *     
     */
    public void setOrganizationalItem(LinkToOrganizationalItemData value) {
        this.organizationalItem = value;
    }

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Gets the value of the webDavUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebDavUrl() {
        return webDavUrl;
    }

    /**
     * Sets the value of the webDavUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebDavUrl(String value) {
        this.webDavUrl = value;
    }

}
