
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ReadOptions;


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
 *         &lt;element name="schemaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expandEmbeddedFields" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="readOptions" type="{http://www.sdltridion.com/ContentManager/R6}ReadOptions" minOccurs="0"/>
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
    "schemaId",
    "expandEmbeddedFields",
    "readOptions"
})
@XmlRootElement(name = "ReadSchemaFields")
public class ReadSchemaFields {

    @XmlElement(nillable = true)
    protected String schemaId;
    protected Boolean expandEmbeddedFields;
    @XmlElement(nillable = true)
    protected ReadOptions readOptions;

    /**
     * Gets the value of the schemaId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemaId() {
        return schemaId;
    }

    /**
     * Sets the value of the schemaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemaId(String value) {
        this.schemaId = value;
    }

    /**
     * Gets the value of the expandEmbeddedFields property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExpandEmbeddedFields() {
        return expandEmbeddedFields;
    }

    /**
     * Sets the value of the expandEmbeddedFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExpandEmbeddedFields(Boolean value) {
        this.expandEmbeddedFields = value;
    }

    /**
     * Gets the value of the readOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ReadOptions }
     *     
     */
    public ReadOptions getReadOptions() {
        return readOptions;
    }

    /**
     * Sets the value of the readOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadOptions }
     *     
     */
    public void setReadOptions(ReadOptions value) {
        this.readOptions = value;
    }

}
