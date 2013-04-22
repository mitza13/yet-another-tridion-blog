
package com.sdltridion.contentmanager.r6;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for DynamicVersionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DynamicVersionInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}Info">
 *       &lt;sequence>
 *         &lt;element name="Revision" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RevisionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Revisor" type="{http://www.sdltridion.com/ContentManager/R6}LinkWithDescriptionUserData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DynamicVersionInfo", propOrder = {
    "revision",
    "revisionDate",
    "revisor"
})
public class DynamicVersionInfo
    extends Info
{

    @XmlElement(name = "Revision", nillable = true)
    protected Integer revision;
    @XmlElement(name = "RevisionDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date revisionDate;
    @XmlElement(name = "Revisor", nillable = true)
    protected LinkWithDescriptionUserData revisor;

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
     * Gets the value of the revisionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getRevisionDate() {
        return revisionDate;
    }

    /**
     * Sets the value of the revisionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevisionDate(Date value) {
        this.revisionDate = value;
    }

    /**
     * Gets the value of the revisor property.
     * 
     * @return
     *     possible object is
     *     {@link LinkWithDescriptionUserData }
     *     
     */
    public LinkWithDescriptionUserData getRevisor() {
        return revisor;
    }

    /**
     * Sets the value of the revisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkWithDescriptionUserData }
     *     
     */
    public void setRevisor(LinkWithDescriptionUserData value) {
        this.revisor = value;
    }

}
