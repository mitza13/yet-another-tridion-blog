
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.SchemaFieldsData;


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
 *         &lt;element name="ReadSchemaFieldsResult" type="{http://www.sdltridion.com/ContentManager/R6}SchemaFieldsData" minOccurs="0"/>
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
    "readSchemaFieldsResult"
})
@XmlRootElement(name = "ReadSchemaFieldsResponse")
public class ReadSchemaFieldsResponse {

    @XmlElement(name = "ReadSchemaFieldsResult", nillable = true)
    protected SchemaFieldsData readSchemaFieldsResult;

    /**
     * Gets the value of the readSchemaFieldsResult property.
     * 
     * @return
     *     possible object is
     *     {@link SchemaFieldsData }
     *     
     */
    public SchemaFieldsData getReadSchemaFieldsResult() {
        return readSchemaFieldsResult;
    }

    /**
     * Sets the value of the readSchemaFieldsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemaFieldsData }
     *     
     */
    public void setReadSchemaFieldsResult(SchemaFieldsData value) {
        this.readSchemaFieldsResult = value;
    }

}
