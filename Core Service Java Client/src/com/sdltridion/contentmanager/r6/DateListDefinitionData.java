
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdateTime;


/**
 * <p>Java class for DateListDefinitionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DateListDefinitionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ListDefinitionData">
 *       &lt;sequence>
 *         &lt;element name="Entries" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfdateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateListDefinitionData", propOrder = {
    "entries"
})
public class DateListDefinitionData
    extends ListDefinitionData
{

    @XmlElement(name = "Entries", required = true, nillable = true)
    protected ArrayOfdateTime entries;

    /**
     * Gets the value of the entries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfdateTime }
     *     
     */
    public ArrayOfdateTime getEntries() {
        return entries;
    }

    /**
     * Sets the value of the entries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfdateTime }
     *     
     */
    public void setEntries(ArrayOfdateTime value) {
        this.entries = value;
    }

}
