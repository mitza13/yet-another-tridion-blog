
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetTypeData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetTypeData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}PublishingTargetData">
 *       &lt;sequence>
 *         &lt;element name="AccessControlList" type="{http://www.sdltridion.com/ContentManager/R6}AccessControlListData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetTypeData", propOrder = {
    "accessControlList"
})
public class TargetTypeData
    extends PublishingTargetData
{

    @XmlElement(name = "AccessControlList", nillable = true)
    protected AccessControlListData accessControlList;

    /**
     * Gets the value of the accessControlList property.
     * 
     * @return
     *     possible object is
     *     {@link AccessControlListData }
     *     
     */
    public AccessControlListData getAccessControlList() {
        return accessControlList;
    }

    /**
     * Sets the value of the accessControlList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessControlListData }
     *     
     */
    public void setAccessControlList(AccessControlListData value) {
        this.accessControlList = value;
    }

}
