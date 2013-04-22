
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubjectRelatedListFilterData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubjectRelatedListFilterData">
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
@XmlType(name = "SubjectRelatedListFilterData")
@XmlSeeAlso({
    ComponentTemplatesFilterData.class,
    BluePrintChainFilterData.class,
    PathToCategoryFilterData.class,
    DeletedReferencesFilterData.class,
    OrganizationalItemsFilterData.class,
    VersionsFilterData.class,
    ClassifiedItemsFilterData.class,
    GroupMembersFilterData.class,
    KeywordRelatedFilterData.class,
    ContainingBundlesFilterData.class,
    TaxonomiesFilterData.class,
    CategoryRelatedFilterData.class,
    OrganizationalItemAncestorsFilterData.class,
    WhereUsedFilterData.class,
    ItemsFilterData.class
})
public class SubjectRelatedListFilterData
    extends StronglyTypedFilterData
{


}
