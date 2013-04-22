
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfResolvedBundleData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfResolvedBundleData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResolvedBundleData" type="{http://www.sdltridion.com/ContentManager/R6}ResolvedBundleData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfResolvedBundleData", propOrder = {
    "resolvedBundleData"
})
public class ArrayOfResolvedBundleData {

    @XmlElement(name = "ResolvedBundleData", nillable = true)
    protected List<ResolvedBundleData> resolvedBundleData;

    /**
     * Gets the value of the resolvedBundleData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resolvedBundleData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResolvedBundleData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResolvedBundleData }
     * 
     * 
     */
    public List<ResolvedBundleData> getResolvedBundleData() {
        if (resolvedBundleData == null) {
            resolvedBundleData = new ArrayList<ResolvedBundleData>();
        }
        return this.resolvedBundleData;
    }

}
