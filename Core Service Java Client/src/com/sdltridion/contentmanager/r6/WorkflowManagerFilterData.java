
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkflowManagerFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkflowManagerFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}SystemWideListFilterData">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowManagerFilterData")
@XmlSeeAlso({
    UserWorkItemsFilterData.class,
    ProcessDefinitionAssociationsFilterData.class,
    ApprovalStatusesFilterData.class,
    ProcessDefinitionsFilterData.class,
    ProcessesFilterData.class
})
public class WorkflowManagerFilterData
    extends SystemWideListFilterData
{


}
