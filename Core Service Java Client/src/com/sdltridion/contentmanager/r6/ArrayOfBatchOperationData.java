
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBatchOperationData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBatchOperationData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatchOperationData" type="{http://www.sdltridion.com/ContentManager/R6}BatchOperationData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBatchOperationData", propOrder = {
    "batchOperationData"
})
public class ArrayOfBatchOperationData {

    @XmlElement(name = "BatchOperationData", nillable = true)
    protected List<BatchOperationData> batchOperationData;

    /**
     * Gets the value of the batchOperationData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the batchOperationData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBatchOperationData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BatchOperationData }
     * 
     * 
     */
    public List<BatchOperationData> getBatchOperationData() {
        if (batchOperationData == null) {
            batchOperationData = new ArrayList<BatchOperationData>();
        }
        return this.batchOperationData;
    }

}
