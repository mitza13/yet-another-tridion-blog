
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
 * <p>Java class for ProcessHistoryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessHistoryData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ProcessData">
 *       &lt;sequence>
 *         &lt;element name="FinishDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FinishReason" type="{http://www.sdltridion.com/ContentManager/R6}ProcessFinishReason" minOccurs="0"/>
 *         &lt;element name="ProcessDefinitionTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessHistoryData", propOrder = {
    "finishDate",
    "finishReason",
    "processDefinitionTitle"
})
public class ProcessHistoryData
    extends ProcessData
{

    @XmlElement(name = "FinishDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date finishDate;
    @XmlElement(name = "FinishReason", nillable = true)
    protected ProcessFinishReason finishReason;
    @XmlElement(name = "ProcessDefinitionTitle", nillable = true)
    protected String processDefinitionTitle;

    /**
     * Gets the value of the finishDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * Sets the value of the finishDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinishDate(Date value) {
        this.finishDate = value;
    }

    /**
     * Gets the value of the finishReason property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessFinishReason }
     *     
     */
    public ProcessFinishReason getFinishReason() {
        return finishReason;
    }

    /**
     * Sets the value of the finishReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessFinishReason }
     *     
     */
    public void setFinishReason(ProcessFinishReason value) {
        this.finishReason = value;
    }

    /**
     * Gets the value of the processDefinitionTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessDefinitionTitle() {
        return processDefinitionTitle;
    }

    /**
     * Sets the value of the processDefinitionTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessDefinitionTitle(String value) {
        this.processDefinitionTitle = value;
    }

}
