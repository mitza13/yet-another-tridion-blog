
package com.sdltridion.contentmanager.coreservice._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.DeleteTaxonomyNodeMode;


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
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deleteTaxonomyNodeMode" type="{http://www.sdltridion.com/ContentManager/R6}DeleteTaxonomyNodeMode" minOccurs="0"/>
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
    "id",
    "deleteTaxonomyNodeMode"
})
@XmlRootElement(name = "DeleteTaxonomyNode")
public class DeleteTaxonomyNode {

    @XmlElement(nillable = true)
    protected String id;
    protected DeleteTaxonomyNodeMode deleteTaxonomyNodeMode;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the deleteTaxonomyNodeMode property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteTaxonomyNodeMode }
     *     
     */
    public DeleteTaxonomyNodeMode getDeleteTaxonomyNodeMode() {
        return deleteTaxonomyNodeMode;
    }

    /**
     * Sets the value of the deleteTaxonomyNodeMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteTaxonomyNodeMode }
     *     
     */
    public void setDeleteTaxonomyNodeMode(DeleteTaxonomyNodeMode value) {
        this.deleteTaxonomyNodeMode = value;
    }

}
