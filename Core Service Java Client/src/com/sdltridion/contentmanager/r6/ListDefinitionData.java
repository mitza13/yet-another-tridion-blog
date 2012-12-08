
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListDefinitionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Type" type="{http://www.sdltridion.com/ContentManager/R6}ListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListDefinitionData", propOrder = {
    "height",
    "type"
})
@XmlSeeAlso({
    NumberListDefinitionData.class,
    SingleLineTextListDefinitionData.class,
    DateListDefinitionData.class
})
public class ListDefinitionData {

    @XmlElement(name = "Height")
    protected int height;
    @XmlElement(name = "Type", required = true)
    protected ListType type;

    /**
     * Gets the value of the height property.
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     */
    public void setHeight(int value) {
        this.height = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ListType }
     *     
     */
    public ListType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListType }
     *     
     */
    public void setType(ListType value) {
        this.type = value;
    }

}
