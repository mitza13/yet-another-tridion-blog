
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
 * <p>Java class for PurgeOldVersionsInstructionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PurgeOldVersionsInstructionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Containers" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToIdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="KeepVersionsModifiedAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="KeepVersionsWithinDaysBeforeLastCheckIn" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="MaxResolvedVersionedItemsCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Recursive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VersionsToKeep" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurgeOldVersionsInstructionData", propOrder = {
    "containers",
    "keepVersionsModifiedAfter",
    "keepVersionsWithinDaysBeforeLastCheckIn",
    "maxResolvedVersionedItemsCount",
    "recursive",
    "versionsToKeep"
})
public class PurgeOldVersionsInstructionData {

    @XmlElement(name = "Containers", nillable = true)
    protected ArrayOfLinkToIdentifiableObjectData containers;
    @XmlElement(name = "KeepVersionsModifiedAfter", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date keepVersionsModifiedAfter;
    @XmlElement(name = "KeepVersionsWithinDaysBeforeLastCheckIn", nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long keepVersionsWithinDaysBeforeLastCheckIn;
    @XmlElement(name = "MaxResolvedVersionedItemsCount", nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maxResolvedVersionedItemsCount;
    @XmlElement(name = "Recursive", nillable = true)
    protected Boolean recursive;
    @XmlElement(name = "VersionsToKeep", nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long versionsToKeep;

    /**
     * Gets the value of the containers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToIdentifiableObjectData }
     *     
     */
    public ArrayOfLinkToIdentifiableObjectData getContainers() {
        return containers;
    }

    /**
     * Sets the value of the containers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToIdentifiableObjectData }
     *     
     */
    public void setContainers(ArrayOfLinkToIdentifiableObjectData value) {
        this.containers = value;
    }

    /**
     * Gets the value of the keepVersionsModifiedAfter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getKeepVersionsModifiedAfter() {
        return keepVersionsModifiedAfter;
    }

    /**
     * Sets the value of the keepVersionsModifiedAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeepVersionsModifiedAfter(Date value) {
        this.keepVersionsModifiedAfter = value;
    }

    /**
     * Gets the value of the keepVersionsWithinDaysBeforeLastCheckIn property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getKeepVersionsWithinDaysBeforeLastCheckIn() {
        return keepVersionsWithinDaysBeforeLastCheckIn;
    }

    /**
     * Sets the value of the keepVersionsWithinDaysBeforeLastCheckIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setKeepVersionsWithinDaysBeforeLastCheckIn(Long value) {
        this.keepVersionsWithinDaysBeforeLastCheckIn = value;
    }

    /**
     * Gets the value of the maxResolvedVersionedItemsCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxResolvedVersionedItemsCount() {
        return maxResolvedVersionedItemsCount;
    }

    /**
     * Sets the value of the maxResolvedVersionedItemsCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxResolvedVersionedItemsCount(Long value) {
        this.maxResolvedVersionedItemsCount = value;
    }

    /**
     * Gets the value of the recursive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecursive() {
        return recursive;
    }

    /**
     * Sets the value of the recursive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecursive(Boolean value) {
        this.recursive = value;
    }

    /**
     * Gets the value of the versionsToKeep property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVersionsToKeep() {
        return versionsToKeep;
    }

    /**
     * Sets the value of the versionsToKeep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVersionsToKeep(Long value) {
        this.versionsToKeep = value;
    }

}
