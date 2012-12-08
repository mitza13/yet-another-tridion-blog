
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}TrusteeData">
 *       &lt;sequence>
 *         &lt;element name="ClaimMappings" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfClaimMappingData" minOccurs="0"/>
 *         &lt;element name="Scope" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkWithIsEditableToRepositoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupData", propOrder = {
    "claimMappings",
    "scope"
})
public class GroupData
    extends TrusteeData
{

    @XmlElement(name = "ClaimMappings", nillable = true)
    protected ArrayOfClaimMappingData claimMappings;
    @XmlElement(name = "Scope", nillable = true)
    protected ArrayOfLinkWithIsEditableToRepositoryData scope;

    /**
     * Gets the value of the claimMappings property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClaimMappingData }
     *     
     */
    public ArrayOfClaimMappingData getClaimMappings() {
        return claimMappings;
    }

    /**
     * Sets the value of the claimMappings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClaimMappingData }
     *     
     */
    public void setClaimMappings(ArrayOfClaimMappingData value) {
        this.claimMappings = value;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkWithIsEditableToRepositoryData }
     *     
     */
    public ArrayOfLinkWithIsEditableToRepositoryData getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkWithIsEditableToRepositoryData }
     *     
     */
    public void setScope(ArrayOfLinkWithIsEditableToRepositoryData value) {
        this.scope = value;
    }

}
