
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessedItemData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessedItemData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HasRenderFailure" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsRendered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReasonOfRenderFailure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenderTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResolvedItem" type="{http://www.sdltridion.com/ContentManager/R6}ResolvedItemData" minOccurs="0"/>
 *         &lt;element name="UndoState" type="{http://www.sdltridion.com/ContentManager/R6}UndoState" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessedItemData", propOrder = {
    "hasRenderFailure",
    "isRendered",
    "reasonOfRenderFailure",
    "renderTime",
    "resolvedItem",
    "undoState"
})
public class ProcessedItemData {

    @XmlElement(name = "HasRenderFailure", nillable = true)
    protected Boolean hasRenderFailure;
    @XmlElement(name = "IsRendered", nillable = true)
    protected Boolean isRendered;
    @XmlElement(name = "ReasonOfRenderFailure", nillable = true)
    protected String reasonOfRenderFailure;
    @XmlElement(name = "RenderTime", nillable = true)
    protected String renderTime;
    @XmlElement(name = "ResolvedItem", nillable = true)
    protected ResolvedItemData resolvedItem;
    @XmlElement(name = "UndoState", nillable = true)
    protected UndoState undoState;

    /**
     * Gets the value of the hasRenderFailure property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasRenderFailure() {
        return hasRenderFailure;
    }

    /**
     * Sets the value of the hasRenderFailure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasRenderFailure(Boolean value) {
        this.hasRenderFailure = value;
    }

    /**
     * Gets the value of the isRendered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRendered() {
        return isRendered;
    }

    /**
     * Sets the value of the isRendered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRendered(Boolean value) {
        this.isRendered = value;
    }

    /**
     * Gets the value of the reasonOfRenderFailure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonOfRenderFailure() {
        return reasonOfRenderFailure;
    }

    /**
     * Sets the value of the reasonOfRenderFailure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonOfRenderFailure(String value) {
        this.reasonOfRenderFailure = value;
    }

    /**
     * Gets the value of the renderTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenderTime() {
        return renderTime;
    }

    /**
     * Sets the value of the renderTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenderTime(String value) {
        this.renderTime = value;
    }

    /**
     * Gets the value of the resolvedItem property.
     * 
     * @return
     *     possible object is
     *     {@link ResolvedItemData }
     *     
     */
    public ResolvedItemData getResolvedItem() {
        return resolvedItem;
    }

    /**
     * Sets the value of the resolvedItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResolvedItemData }
     *     
     */
    public void setResolvedItem(ResolvedItemData value) {
        this.resolvedItem = value;
    }

    /**
     * Gets the value of the undoState property.
     * 
     * @return
     *     possible object is
     *     {@link UndoState }
     *     
     */
    public UndoState getUndoState() {
        return undoState;
    }

    /**
     * Sets the value of the undoState property.
     * 
     * @param value
     *     allowed object is
     *     {@link UndoState }
     *     
     */
    public void setUndoState(UndoState value) {
        this.undoState = value;
    }

}
