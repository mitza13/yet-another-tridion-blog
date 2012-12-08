
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}RepositoryLocalObjectData">
 *       &lt;sequence>
 *         &lt;element name="ActivityDefinitions" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfActivityDefinitionData" minOccurs="0"/>
 *         &lt;element name="StoreSnapshot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessDefinitionData", propOrder = {
    "activityDefinitions",
    "storeSnapshot"
})
@XmlSeeAlso({
    TridionProcessDefinitionData.class
})
public class ProcessDefinitionData
    extends RepositoryLocalObjectData
{

    @XmlElement(name = "ActivityDefinitions", nillable = true)
    protected ArrayOfActivityDefinitionData activityDefinitions;
    @XmlElement(name = "StoreSnapshot", nillable = true)
    protected Boolean storeSnapshot;

    /**
     * Gets the value of the activityDefinitions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfActivityDefinitionData }
     *     
     */
    public ArrayOfActivityDefinitionData getActivityDefinitions() {
        return activityDefinitions;
    }

    /**
     * Sets the value of the activityDefinitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfActivityDefinitionData }
     *     
     */
    public void setActivityDefinitions(ArrayOfActivityDefinitionData value) {
        this.activityDefinitions = value;
    }

    /**
     * Gets the value of the storeSnapshot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStoreSnapshot() {
        return storeSnapshot;
    }

    /**
     * Sets the value of the storeSnapshot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStoreSnapshot(Boolean value) {
        this.storeSnapshot = value;
    }

}
