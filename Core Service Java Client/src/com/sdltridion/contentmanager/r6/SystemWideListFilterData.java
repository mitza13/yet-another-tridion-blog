
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SystemWideListFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SystemWideListFilterData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}StronglyTypedFilterData">
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
@XmlType(name = "SystemWideListFilterData")
@XmlSeeAlso({
    TargetTypesFilterData.class,
    RepositoryLocalObjectsFilterData.class,
    PublicationTargetsFilterData.class,
    MultimediaTypesFilterData.class,
    BluePrintFilterData.class,
    BluePrintParentsFilterData.class,
    RepositoriesFilterData.class,
    PublishingListFilterData.class,
    TrusteesFilterData.class,
    WorkflowManagerFilterData.class
})
public class SystemWideListFilterData
    extends StronglyTypedFilterData
{


}
