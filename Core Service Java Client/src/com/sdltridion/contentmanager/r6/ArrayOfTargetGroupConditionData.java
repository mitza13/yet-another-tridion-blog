
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTargetGroupConditionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTargetGroupConditionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TargetGroupConditionData" type="{http://www.sdltridion.com/ContentManager/R6}TargetGroupConditionData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTargetGroupConditionData", propOrder = {
    "targetGroupConditionData"
})
public class ArrayOfTargetGroupConditionData {

    @XmlElement(name = "TargetGroupConditionData", nillable = true)
    protected List<TargetGroupConditionData> targetGroupConditionData;

    /**
     * Gets the value of the targetGroupConditionData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetGroupConditionData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetGroupConditionData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetGroupConditionData }
     * 
     * 
     */
    public List<TargetGroupConditionData> getTargetGroupConditionData() {
        if (targetGroupConditionData == null) {
            targetGroupConditionData = new ArrayList<TargetGroupConditionData>();
        }
        return this.targetGroupConditionData;
    }

}
