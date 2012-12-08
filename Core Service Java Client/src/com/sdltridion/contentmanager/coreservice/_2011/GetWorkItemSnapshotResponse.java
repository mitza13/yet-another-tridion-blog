
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.RenderedItemData;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetWorkItemSnapshotResult" type="{http://www.sdltridion.com/ContentManager/R6}RenderedItemData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getWorkItemSnapshotResult"
})
@XmlRootElement(name = "GetWorkItemSnapshotResponse")
public class GetWorkItemSnapshotResponse {

    @XmlElement(name = "GetWorkItemSnapshotResult", nillable = true)
    protected RenderedItemData getWorkItemSnapshotResult;

    /**
     * Gets the value of the getWorkItemSnapshotResult property.
     * 
     * @return
     *     possible object is
     *     {@link RenderedItemData }
     *     
     */
    public RenderedItemData getGetWorkItemSnapshotResult() {
        return getWorkItemSnapshotResult;
    }

    /**
     * Sets the value of the getWorkItemSnapshotResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenderedItemData }
     *     
     */
    public void setGetWorkItemSnapshotResult(RenderedItemData value) {
        this.getWorkItemSnapshotResult = value;
    }

}
