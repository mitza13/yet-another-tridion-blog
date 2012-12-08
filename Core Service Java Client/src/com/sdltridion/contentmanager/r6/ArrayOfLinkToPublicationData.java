
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfLinkToPublicationData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLinkToPublicationData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LinkToPublicationData" type="{http://www.sdltridion.com/ContentManager/R6}LinkToPublicationData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLinkToPublicationData", propOrder = {
    "linkToPublicationData"
})
public class ArrayOfLinkToPublicationData {

    @XmlElement(name = "LinkToPublicationData", nillable = true)
    protected List<LinkToPublicationData> linkToPublicationData;

    /**
     * Gets the value of the linkToPublicationData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkToPublicationData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkToPublicationData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkToPublicationData }
     * 
     * 
     */
    public List<LinkToPublicationData> getLinkToPublicationData() {
        if (linkToPublicationData == null) {
            linkToPublicationData = new ArrayList<LinkToPublicationData>();
        }
        return this.linkToPublicationData;
    }

}
