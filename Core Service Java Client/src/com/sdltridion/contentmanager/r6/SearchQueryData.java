
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for SearchQueryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchQueryData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Author" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="BaseColumns" type="{http://www.sdltridion.com/ContentManager/R6}ListBaseColumns" minOccurs="0"/>
 *         &lt;element name="BasedOnSchemas" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfBasedOnSchemaData" minOccurs="0"/>
 *         &lt;element name="BlueprintStatus" type="{http://www.sdltridion.com/ContentManager/R6}SearchBlueprintStatus" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FromRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *         &lt;element name="FullTextQuery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsDescriptionCaseSensitive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsPublished" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsTitleCaseSensitive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ItemTypes" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfItemType" minOccurs="0"/>
 *         &lt;element name="LockType" type="{http://www.sdltridion.com/ContentManager/R6}LockType" minOccurs="0"/>
 *         &lt;element name="LockUser" type="{http://www.sdltridion.com/ContentManager/R6}LinkToUserData" minOccurs="0"/>
 *         &lt;element name="ModifiedAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ModifiedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ResultLimit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SearchIn" type="{http://www.sdltridion.com/ContentManager/R6}LinkToIdentifiableObjectData" minOccurs="0"/>
 *         &lt;element name="SearchInSubtree" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsedKeywords" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfLinkToKeywordData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchQueryData", propOrder = {
    "author",
    "baseColumns",
    "basedOnSchemas",
    "blueprintStatus",
    "description",
    "fromRepository",
    "fullTextQuery",
    "isDescriptionCaseSensitive",
    "isPublished",
    "isTitleCaseSensitive",
    "itemTypes",
    "lockType",
    "lockUser",
    "modifiedAfter",
    "modifiedBefore",
    "resultLimit",
    "searchIn",
    "searchInSubtree",
    "title",
    "usedKeywords"
})
public class SearchQueryData {

    @XmlElement(name = "Author", nillable = true)
    protected LinkToUserData author;
    @XmlElement(name = "BaseColumns", nillable = true)
    protected ListBaseColumns baseColumns;
    @XmlElement(name = "BasedOnSchemas", nillable = true)
    protected ArrayOfBasedOnSchemaData basedOnSchemas;
    @XmlElement(name = "BlueprintStatus", nillable = true)
    protected SearchBlueprintStatus blueprintStatus;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "FromRepository", nillable = true)
    protected LinkToRepositoryData fromRepository;
    @XmlElement(name = "FullTextQuery", nillable = true)
    protected String fullTextQuery;
    @XmlElement(name = "IsDescriptionCaseSensitive")
    protected Boolean isDescriptionCaseSensitive;
    @XmlElement(name = "IsPublished", nillable = true)
    protected Boolean isPublished;
    @XmlElement(name = "IsTitleCaseSensitive")
    protected Boolean isTitleCaseSensitive;
    @XmlElement(name = "ItemTypes", nillable = true)
    protected ArrayOfItemType itemTypes;
    @XmlList
    @XmlElement(name = "LockType", nillable = true)
    protected List<String> lockType;
    @XmlElement(name = "LockUser", nillable = true)
    protected LinkToUserData lockUser;
    @XmlElement(name = "ModifiedAfter", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date modifiedAfter;
    @XmlElement(name = "ModifiedBefore", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date modifiedBefore;
    @XmlElement(name = "ResultLimit", nillable = true)
    protected Integer resultLimit;
    @XmlElement(name = "SearchIn", nillable = true)
    protected LinkToIdentifiableObjectData searchIn;
    @XmlElement(name = "SearchInSubtree", nillable = true)
    protected Boolean searchInSubtree;
    @XmlElement(name = "Title", nillable = true)
    protected String title;
    @XmlElement(name = "UsedKeywords", nillable = true)
    protected ArrayOfLinkToKeywordData usedKeywords;

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setAuthor(LinkToUserData value) {
        this.author = value;
    }

    /**
     * Gets the value of the baseColumns property.
     * 
     * @return
     *     possible object is
     *     {@link ListBaseColumns }
     *     
     */
    public ListBaseColumns getBaseColumns() {
        return baseColumns;
    }

    /**
     * Sets the value of the baseColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListBaseColumns }
     *     
     */
    public void setBaseColumns(ListBaseColumns value) {
        this.baseColumns = value;
    }

    /**
     * Gets the value of the basedOnSchemas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBasedOnSchemaData }
     *     
     */
    public ArrayOfBasedOnSchemaData getBasedOnSchemas() {
        return basedOnSchemas;
    }

    /**
     * Sets the value of the basedOnSchemas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBasedOnSchemaData }
     *     
     */
    public void setBasedOnSchemas(ArrayOfBasedOnSchemaData value) {
        this.basedOnSchemas = value;
    }

    /**
     * Gets the value of the blueprintStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SearchBlueprintStatus }
     *     
     */
    public SearchBlueprintStatus getBlueprintStatus() {
        return blueprintStatus;
    }

    /**
     * Sets the value of the blueprintStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchBlueprintStatus }
     *     
     */
    public void setBlueprintStatus(SearchBlueprintStatus value) {
        this.blueprintStatus = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the fromRepository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getFromRepository() {
        return fromRepository;
    }

    /**
     * Sets the value of the fromRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setFromRepository(LinkToRepositoryData value) {
        this.fromRepository = value;
    }

    /**
     * Gets the value of the fullTextQuery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullTextQuery() {
        return fullTextQuery;
    }

    /**
     * Sets the value of the fullTextQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullTextQuery(String value) {
        this.fullTextQuery = value;
    }

    /**
     * Gets the value of the isDescriptionCaseSensitive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDescriptionCaseSensitive() {
        return isDescriptionCaseSensitive;
    }

    /**
     * Sets the value of the isDescriptionCaseSensitive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDescriptionCaseSensitive(Boolean value) {
        this.isDescriptionCaseSensitive = value;
    }

    /**
     * Gets the value of the isPublished property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPublished() {
        return isPublished;
    }

    /**
     * Sets the value of the isPublished property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPublished(Boolean value) {
        this.isPublished = value;
    }

    /**
     * Gets the value of the isTitleCaseSensitive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsTitleCaseSensitive() {
        return isTitleCaseSensitive;
    }

    /**
     * Sets the value of the isTitleCaseSensitive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsTitleCaseSensitive(Boolean value) {
        this.isTitleCaseSensitive = value;
    }

    /**
     * Gets the value of the itemTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItemType }
     *     
     */
    public ArrayOfItemType getItemTypes() {
        return itemTypes;
    }

    /**
     * Sets the value of the itemTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItemType }
     *     
     */
    public void setItemTypes(ArrayOfItemType value) {
        this.itemTypes = value;
    }

    /**
     * Gets the value of the lockType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lockType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLockType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLockType() {
        if (lockType == null) {
            lockType = new ArrayList<String>();
        }
        return this.lockType;
    }

    /**
     * Gets the value of the lockUser property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToUserData }
     *     
     */
    public LinkToUserData getLockUser() {
        return lockUser;
    }

    /**
     * Sets the value of the lockUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToUserData }
     *     
     */
    public void setLockUser(LinkToUserData value) {
        this.lockUser = value;
    }

    /**
     * Gets the value of the modifiedAfter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getModifiedAfter() {
        return modifiedAfter;
    }

    /**
     * Sets the value of the modifiedAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifiedAfter(Date value) {
        this.modifiedAfter = value;
    }

    /**
     * Gets the value of the modifiedBefore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getModifiedBefore() {
        return modifiedBefore;
    }

    /**
     * Sets the value of the modifiedBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifiedBefore(Date value) {
        this.modifiedBefore = value;
    }

    /**
     * Gets the value of the resultLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResultLimit() {
        return resultLimit;
    }

    /**
     * Sets the value of the resultLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResultLimit(Integer value) {
        this.resultLimit = value;
    }

    /**
     * Gets the value of the searchIn property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public LinkToIdentifiableObjectData getSearchIn() {
        return searchIn;
    }

    /**
     * Sets the value of the searchIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToIdentifiableObjectData }
     *     
     */
    public void setSearchIn(LinkToIdentifiableObjectData value) {
        this.searchIn = value;
    }

    /**
     * Gets the value of the searchInSubtree property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchInSubtree() {
        return searchInSubtree;
    }

    /**
     * Sets the value of the searchInSubtree property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchInSubtree(Boolean value) {
        this.searchInSubtree = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the usedKeywords property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkToKeywordData }
     *     
     */
    public ArrayOfLinkToKeywordData getUsedKeywords() {
        return usedKeywords;
    }

    /**
     * Sets the value of the usedKeywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkToKeywordData }
     *     
     */
    public void setUsedKeywords(ArrayOfLinkToKeywordData value) {
        this.usedKeywords = value;
    }

}
