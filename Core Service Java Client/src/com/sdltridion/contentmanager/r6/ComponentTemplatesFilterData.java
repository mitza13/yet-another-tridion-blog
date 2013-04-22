
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComponentTemplatesFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComponentTemplatesFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SubjectRelatedListFilterData">
 *       &lt;sequence>
 *         &lt;element name="AllowedOnPage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RelatedTo" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToRepositoryLocalObjectData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComponentTemplatesFilterData", propOrder = {
    "allowedOnPage",
    "relatedTo"
})
public class ComponentTemplatesFilterData
    extends SubjectRelatedListFilterData
{

    @XmlElement(name = "AllowedOnPage", nillable = true)
    protected Boolean allowedOnPage;
    @XmlElement(name = "RelatedTo", nillable = true)
    protected ArrayOfLinkToRepositoryLocalObjectData relatedTo;

    /**
     * Gets the value of the allowedOnPage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowedOnPage() {
        return allowedOnPage;
    }

    /**
     * Sets the value of the allowedOnPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowedOnPage(Boolean value) {
        this.allowedOnPage = value;
    }

    /**
     * Gets the value of the relatedTo property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToRepositoryLocalObjectData }
     *     
     */
    public ArrayOfLinkToRepositoryLocalObjectData getRelatedTo() {
        return relatedTo;
    }

    /**
     * Sets the value of the relatedTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToRepositoryLocalObjectData }
     *     
     */
    public void setRelatedTo(ArrayOfLinkToRepositoryLocalObjectData value) {
        this.relatedTo = value;
    }

}
