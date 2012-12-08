
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRenderedItemData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRenderedItemData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RenderedItemData" type="{http://www.sdltridion.com/ContentManager/R6}RenderedItemData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRenderedItemData", propOrder = {
    "renderedItemData"
})
public class ArrayOfRenderedItemData {

    @XmlElement(name = "RenderedItemData", nillable = true)
    protected List<RenderedItemData> renderedItemData;

    /**
     * Gets the value of the renderedItemData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the renderedItemData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRenderedItemData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RenderedItemData }
     * 
     * 
     */
    public List<RenderedItemData> getRenderedItemData() {
        if (renderedItemData == null) {
            renderedItemData = new ArrayList<RenderedItemData>();
        }
        return this.renderedItemData;
    }

}
