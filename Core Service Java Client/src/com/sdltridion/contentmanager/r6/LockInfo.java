
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
 * <p>Java class for LockInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LockInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}Info">
 *       &lt;sequence>
 *         &lt;element name="LockDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LockType" type="{http://www.sdltridion.com/ContentManager/R6}LockType" minOccurs="0"/>
 *         &lt;element name="LockUser" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LockInfo", propOrder = {
    "lockDate",
    "lockType",
    "lockUser"
})
public class LockInfo
    extends Info
{

    @XmlElement(name = "LockDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date lockDate;
    @XmlList
    @XmlElement(name = "LockType", nillable = true)
    protected List<String> lockType;
    @XmlElement(name = "LockUser", nillable = true)
    protected LinkToUserData lockUser;

    /**
     * Gets the value of the lockDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getLockDate() {
        return lockDate;
    }

    /**
     * Sets the value of the lockDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLockDate(Date value) {
        this.lockDate = value;
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
     * Gets the value of the lockUser property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getLockUser() {
        return lockUser;
    }

    /**
     * Sets the value of the lockUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setLockUser(LinkToUserData value) {
        this.lockUser = value;
    }

}
