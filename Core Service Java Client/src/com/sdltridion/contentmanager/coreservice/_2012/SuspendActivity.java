
package com.sdltridion.contentmanager.coreservice._2012;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.sdltridion.contentmanager.r6.ReadOptions;
import org.w3._2001.xmlschema.Adapter1;


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
 *         &lt;element name="activityInstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resumeAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="resumeBookmark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="readBackOptions" type="{http://www.sdltridion.com/ContentManager/R6}ReadOptions" minOccurs="0"/>
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
    "activityInstanceId",
    "reason",
    "resumeAt",
    "resumeBookmark",
    "readBackOptions"
})
@XmlRootElement(name = "SuspendActivity")
public class SuspendActivity {

    @XmlElement(nillable = true)
    protected String activityInstanceId;
    @XmlElement(nillable = true)
    protected String reason;
    @XmlElement(type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date resumeAt;
    @XmlElement(nillable = true)
    protected String resumeBookmark;
    @XmlElement(nillable = true)
    protected ReadOptions readBackOptions;

    /**
     * Gets the value of the activityInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityInstanceId() {
        return activityInstanceId;
    }

    /**
     * Sets the value of the activityInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityInstanceId(String value) {
        this.activityInstanceId = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the resumeAt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getResumeAt() {
        return resumeAt;
    }

    /**
     * Sets the value of the resumeAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResumeAt(Date value) {
        this.resumeAt = value;
    }

    /**
     * Gets the value of the resumeBookmark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResumeBookmark() {
        return resumeBookmark;
    }

    /**
     * Sets the value of the resumeBookmark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResumeBookmark(String value) {
        this.resumeBookmark = value;
    }

    /**
     * Gets the value of the readBackOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ReadOptions }
     *     
     */
    public ReadOptions getReadBackOptions() {
        return readBackOptions;
    }

    /**
     * Sets the value of the readBackOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadOptions }
     *     
     */
    public void setReadBackOptions(ReadOptions value) {
        this.readBackOptions = value;
    }

}
