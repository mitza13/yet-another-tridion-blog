
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessDefinitionAssociationDictionary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessDefinitionAssociationDictionary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Item" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SubjectId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ProcessDefinitionAssociation" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessDefinitionAssociationDictionary", propOrder = {
    "item"
})
public class ProcessDefinitionAssociationDictionary {

    @XmlElement(name = "Item")
    protected List<ProcessDefinitionAssociationDictionary.Item> item;

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcessDefinitionAssociationDictionary.Item }
     * 
     * 
     */
    public List<ProcessDefinitionAssociationDictionary.Item> getItem() {
        if (item == null) {
            item = new ArrayList<ProcessDefinitionAssociationDictionary.Item>();
        }
        return this.item;
    }


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
     *         &lt;element name="SubjectId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ProcessDefinitionAssociation" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData"/>
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
        "subjectId",
        "processDefinitionAssociation"
    })
    public static class Item {

        @XmlElement(name = "SubjectId", required = true, nillable = true)
        protected String subjectId;
        @XmlElement(name = "ProcessDefinitionAssociation", required = true, nillable = true)
        protected LinkToProcessDefinitionData processDefinitionAssociation;

        /**
         * Gets the value of the subjectId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSubjectId() {
            return subjectId;
        }

        /**
         * Sets the value of the subjectId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSubjectId(String value) {
            this.subjectId = value;
        }

        /**
         * Gets the value of the processDefinitionAssociation property.
         * 
         * @return
         *     possible object is
         *     {@link LinkToProcessDefinitionData }
         *     
         */
        public LinkToProcessDefinitionData getProcessDefinitionAssociation() {
            return processDefinitionAssociation;
        }

        /**
         * Sets the value of the processDefinitionAssociation property.
         * 
         * @param value
         *     allowed object is
         *     {@link LinkToProcessDefinitionData }
         *     
         */
        public void setProcessDefinitionAssociation(LinkToProcessDefinitionData value) {
            this.processDefinitionAssociation = value;
        }

    }

}
