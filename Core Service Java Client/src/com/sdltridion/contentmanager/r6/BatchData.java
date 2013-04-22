
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
 * <p>Java class for BatchData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideObjectData">
 *       &lt;sequence>
 *         &lt;element name="NumberOfDoneOperations" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Operations" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfBatchOperationData" minOccurs="0"/>
 *         &lt;element name="Performer" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="StartAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="TotalNumberOfOperations" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchData", propOrder = {
    "numberOfDoneOperations",
    "operations",
    "performer",
    "startAt",
    "totalNumberOfOperations"
})
public class BatchData
    extends SystemWideObjectData
{

    @XmlElement(name = "NumberOfDoneOperations", nillable = true)
    protected Integer numberOfDoneOperations;
    @XmlElement(name = "Operations", nillable = true)
    protected ArrayOfBatchOperationData operations;
    @XmlElement(name = "Performer", nillable = true)
    protected LinkToUserData performer;
    @XmlElement(name = "StartAt", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date startAt;
    @XmlElement(name = "TotalNumberOfOperations", nillable = true)
    protected Integer totalNumberOfOperations;

    /**
     * Gets the value of the numberOfDoneOperations property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfDoneOperations() {
        return numberOfDoneOperations;
    }

    /**
     * Sets the value of the numberOfDoneOperations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfDoneOperations(Integer value) {
        this.numberOfDoneOperations = value;
    }

    /**
     * Gets the value of the operations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBatchOperationData }
     *     
     */
    public ArrayOfBatchOperationData getOperations() {
        return operations;
    }

    /**
     * Sets the value of the operations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBatchOperationData }
     *     
     */
    public void setOperations(ArrayOfBatchOperationData value) {
        this.operations = value;
    }

    /**
     * Gets the value of the performer property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getPerformer() {
        return performer;
    }

    /**
     * Sets the value of the performer property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setPerformer(LinkToUserData value) {
        this.performer = value;
    }

    /**
     * Gets the value of the startAt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getStartAt() {
        return startAt;
    }

    /**
     * Sets the value of the startAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartAt(Date value) {
        this.startAt = value;
    }

    /**
     * Gets the value of the totalNumberOfOperations property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalNumberOfOperations() {
        return totalNumberOfOperations;
    }

    /**
     * Sets the value of the totalNumberOfOperations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalNumberOfOperations(Integer value) {
        this.totalNumberOfOperations = value;
    }

}
