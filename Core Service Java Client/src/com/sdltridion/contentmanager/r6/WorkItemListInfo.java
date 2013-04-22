
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
 * <p>Java class for WorkItemListInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkItemListInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ListInfo">
 *       &lt;sequence>
 *         &lt;element name="ActivityCreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ActivityDefinitionTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActivityStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ActivityState" type="{http://www.sdltridion.com/ContentManager/R6}ActivityState" minOccurs="0"/>
 *         &lt;element name="ActivityType" type="{http://www.sdltridion.com/ContentManager/R6}ActivityType" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsPublished" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SubType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkItemListInfo", propOrder = {
    "activityCreationDate",
    "activityDefinitionTitle",
    "activityStartDate",
    "activityState",
    "activityType",
    "fileName",
    "isPublished",
    "subType"
})
public class WorkItemListInfo
    extends ListInfo
{

    @XmlElement(name = "ActivityCreationDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date activityCreationDate;
    @XmlElement(name = "ActivityDefinitionTitle", nillable = true)
    protected String activityDefinitionTitle;
    @XmlElement(name = "ActivityStartDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date activityStartDate;
    @XmlList
    @XmlElement(name = "ActivityState", nillable = true)
    protected List<String> activityState;
    @XmlElement(name = "ActivityType", nillable = true)
    protected ActivityType activityType;
    @XmlElement(name = "FileName", nillable = true)
    protected String fileName;
    @XmlElement(name = "IsPublished", nillable = true)
    protected Boolean isPublished;
    @XmlElement(name = "SubType", nillable = true)
    protected Integer subType;

    /**
     * Gets the value of the activityCreationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getActivityCreationDate() {
        return activityCreationDate;
    }

    /**
     * Sets the value of the activityCreationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityCreationDate(Date value) {
        this.activityCreationDate = value;
    }

    /**
     * Gets the value of the activityDefinitionTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityDefinitionTitle() {
        return activityDefinitionTitle;
    }

    /**
     * Sets the value of the activityDefinitionTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityDefinitionTitle(String value) {
        this.activityDefinitionTitle = value;
    }

    /**
     * Gets the value of the activityStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getActivityStartDate() {
        return activityStartDate;
    }

    /**
     * Sets the value of the activityStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityStartDate(Date value) {
        this.activityStartDate = value;
    }

    /**
     * Gets the value of the activityState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activityState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActivityState() {
        if (activityState == null) {
            activityState = new ArrayList<String>();
        }
        return this.activityState;
    }

    /**
     * Gets the value of the activityType property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityType }
     *     
     */
    public ActivityType getActivityType() {
        return activityType;
    }

    /**
     * Sets the value of the activityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityType }
     *     
     */
    public void setActivityType(ActivityType value) {
        this.activityType = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the isPublished property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPublished() {
        return isPublished;
    }

    /**
     * Sets the value of the isPublished property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPublished(Boolean value) {
        this.isPublished = value;
    }

    /**
     * Gets the value of the subType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubType(Integer value) {
        this.subType = value;
    }

}
