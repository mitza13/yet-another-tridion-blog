
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * <p>Java class for BundleTypeData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BundleTypeData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SchemaData">
 *       &lt;sequence>
 *         &lt;element name="MappedItems" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="ResolvedBundles" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfResolvedBundleData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BundleTypeData", propOrder = {
    "mappedItems",
    "resolvedBundles"
})
public class BundleTypeData
    extends SchemaData
{

    @XmlElement(name = "MappedItems", nillable = true)
    protected ArrayOfstring mappedItems;
    @XmlElement(name = "ResolvedBundles", nillable = true)
    protected ArrayOfResolvedBundleData resolvedBundles;

    /**
     * Gets the value of the mappedItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getMappedItems() {
        return mappedItems;
    }

    /**
     * Sets the value of the mappedItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setMappedItems(ArrayOfstring value) {
        this.mappedItems = value;
    }

    /**
     * Gets the value of the resolvedBundles property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfResolvedBundleData }
     *     
     */
    public ArrayOfResolvedBundleData getResolvedBundles() {
        return resolvedBundles;
    }

    /**
     * Sets the value of the resolvedBundles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfResolvedBundleData }
     *     
     */
    public void setResolvedBundles(ArrayOfResolvedBundleData value) {
        this.resolvedBundles = value;
    }

}
