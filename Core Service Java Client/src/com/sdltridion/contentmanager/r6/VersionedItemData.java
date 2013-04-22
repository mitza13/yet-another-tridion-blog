
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VersionedItemData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VersionedItemData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}RepositoryLocalObjectData">
 *       &lt;sequence>
 *         &lt;element name="DynamicVersionInfo" type="{http://www.sdltridion.com/ContentManager/R6}DynamicVersionInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersionedItemData", propOrder = {
    "dynamicVersionInfo"
})
@XmlSeeAlso({
    SchemaData.class,
    PageData.class,
    TemplateData.class,
    ComponentData.class
})
public class VersionedItemData
    extends RepositoryLocalObjectData
{

    @XmlElement(name = "DynamicVersionInfo", nillable = true)
    protected DynamicVersionInfo dynamicVersionInfo;

    /**
     * Gets the value of the dynamicVersionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicVersionInfo }
     *     
     */
    public DynamicVersionInfo getDynamicVersionInfo() {
        return dynamicVersionInfo;
    }

    /**
     * Sets the value of the dynamicVersionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicVersionInfo }
     *     
     */
    public void setDynamicVersionInfo(DynamicVersionInfo value) {
        this.dynamicVersionInfo = value;
    }

}
