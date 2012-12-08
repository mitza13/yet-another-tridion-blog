
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BluePrintNodeData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BluePrintNodeData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}PublicationData">
 *       &lt;sequence>
 *         &lt;element name="Item" type="{http://www.sdltridion.com/ContentManager/R6}RepositoryLocalObjectData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BluePrintNodeData", propOrder = {
    "item"
})
public class BluePrintNodeData
    extends PublicationData
{

    @XmlElement(name = "Item", nillable = true)
    protected RepositoryLocalObjectData item;

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link RepositoryLocalObjectData }
     *     
     */
    public RepositoryLocalObjectData getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepositoryLocalObjectData }
     *     
     */
    public void setItem(RepositoryLocalObjectData value) {
        this.item = value;
    }

}
