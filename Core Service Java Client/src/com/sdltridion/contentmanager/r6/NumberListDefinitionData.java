
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble;


/**
 * <p>Java class for NumberListDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NumberListDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ListDefinitionData">
 *       &lt;sequence>
 *         &lt;element name="Entries" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfdouble"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumberListDefinitionData", propOrder = {
    "entries"
})
public class NumberListDefinitionData
    extends ListDefinitionData
{

    @XmlElement(name = "Entries", required = true, nillable = true)
    protected ArrayOfdouble entries;

    /**
     * Gets the value of the entries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfdouble }
     *     
     */
    public ArrayOfdouble getEntries() {
        return entries;
    }

    /**
     * Sets the value of the entries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfdouble }
     *     
     */
    public void setEntries(ArrayOfdouble value) {
        this.entries = value;
    }

}
