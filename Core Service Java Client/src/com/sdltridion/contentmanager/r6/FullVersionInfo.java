
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for FullVersionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FullVersionInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}LimitedVersionInfo">
 *       &lt;sequence>
 *         &lt;element name="CheckOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CheckOutUser" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="IsNew" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LockType" type="{http://www.sdltridion.com/ContentManager/R6}LockType" minOccurs="0"/>
 *         &lt;element name="Revision" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Revisor" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullVersionInfo", propOrder = {
    "checkOutDate",
    "checkOutUser",
    "isNew",
    "lockType",
    "revision",
    "revisor",
    "version"
})
public class FullVersionInfo
    extends LimitedVersionInfo
{

    @XmlElement(name = "CheckOutDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date checkOutDate;
    @XmlElement(name = "CheckOutUser", nillable = true)
    protected LinkToUserData checkOutUser;
    @XmlElement(name = "IsNew", nillable = true)
    protected Boolean isNew;
    @XmlList
    @XmlElement(name = "LockType", nillable = true)
    protected List<String> lockType;
    @XmlElement(name = "Revision", nillable = true)
    protected Integer revision;
    @XmlElement(name = "Revisor", nillable = true)
    protected LinkToUserData revisor;
    @XmlElement(name = "Version", nillable = true)
    protected Integer version;

    /**
     * Gets the value of the checkOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets the value of the checkOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckOutDate(Date value) {
        this.checkOutDate = value;
    }

    /**
     * Gets the value of the checkOutUser property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getCheckOutUser() {
        return checkOutUser;
    }

    /**
     * Sets the value of the checkOutUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setCheckOutUser(LinkToUserData value) {
        this.checkOutUser = value;
    }

    /**
     * Gets the value of the isNew property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNew() {
        return isNew;
    }

    /**
     * Sets the value of the isNew property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNew(Boolean value) {
        this.isNew = value;
    }

    /**
     * Gets the value of the lockType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lockType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLockType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLockType() {
        if (lockType == null) {
            lockType = new ArrayList<String>();
        }
        return this.lockType;
    }

    /**
     * Gets the value of the revision property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRevision() {
        return revision;
    }

    /**
     * Sets the value of the revision property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRevision(Integer value) {
        this.revision = value;
    }

    /**
     * Gets the value of the revisor property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getRevisor() {
        return revisor;
    }

    /**
     * Sets the value of the revisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setRevisor(LinkToUserData value) {
        this.revisor = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVersion(Integer value) {
        this.version = value;
    }

}
