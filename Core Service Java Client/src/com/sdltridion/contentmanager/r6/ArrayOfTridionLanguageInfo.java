
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTridionLanguageInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTridionLanguageInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TridionLanguageInfo" type="{http://www.sdltridion.com/ContentManager/R6}TridionLanguageInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTridionLanguageInfo", propOrder = {
    "tridionLanguageInfo"
})
public class ArrayOfTridionLanguageInfo {

    @XmlElement(name = "TridionLanguageInfo", nillable = true)
    protected List<TridionLanguageInfo> tridionLanguageInfo;

    /**
     * Gets the value of the tridionLanguageInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tridionLanguageInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTridionLanguageInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridionLanguageInfo }
     * 
     * 
     */
    public List<TridionLanguageInfo> getTridionLanguageInfo() {
        if (tridionLanguageInfo == null) {
            tridionLanguageInfo = new ArrayList<TridionLanguageInfo>();
        }
        return this.tridionLanguageInfo;
    }

}
