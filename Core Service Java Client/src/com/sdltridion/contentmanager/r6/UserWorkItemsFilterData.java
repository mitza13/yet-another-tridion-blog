
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserWorkItemsFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserWorkItemsFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}WorkflowManagerFilterData">
 *       &lt;sequence>
 *         &lt;element name="ActivityState" type="{http://www.sdltridion.com/ContentManager/R6}ActivityState" minOccurs="0"/>
 *         &lt;element name="ContextRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="Subject" type="{http://www.sdltridion.com/ContentManager/R6}LinkToVersionedItemData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserWorkItemsFilterData", propOrder = {
    "activityState",
    "contextRepository",
    "subject"
})
public class UserWorkItemsFilterData
    extends WorkflowManagerFilterData
{

    @XmlList
    @XmlElement(name = "ActivityState", nillable = true)
    protected List<String> activityState;
    @XmlElement(name = "ContextRepository", nillable = true)
    protected LinkToRepositoryData contextRepository;
    @XmlElement(name = "Subject", nillable = true)
    protected LinkToVersionedItemData subject;

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
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToVersionedItemData }
     *     
     */
    public LinkToVersionedItemData getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToVersionedItemData }
     *     
     */
    public void setSubject(LinkToVersionedItemData value) {
        this.subject = value;
    }

}
