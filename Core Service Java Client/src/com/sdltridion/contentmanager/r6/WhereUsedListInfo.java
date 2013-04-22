
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;


/**
 * <p>Java class for WhereUsedListInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WhereUsedListInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ListInfo">
 *       &lt;sequence>
 *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommentToken" type="{http://www.sdltridion.com/ContentManager/R6}WhereUsedCommentToken" minOccurs="0"/>
 *         &lt;element name="Versions" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WhereUsedListInfo", propOrder = {
    "comment",
    "commentToken",
    "versions"
})
public class WhereUsedListInfo
    extends ListInfo
{

    @XmlElement(name = "Comment", nillable = true)
    protected String comment;
    @XmlElement(name = "CommentToken", nillable = true)
    protected WhereUsedCommentToken commentToken;
    @XmlElement(name = "Versions", nillable = true)
    protected ArrayOfint versions;

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the commentToken property.
     * 
     * @return
     *     possible object is
     *     {@link WhereUsedCommentToken }
     *     
     */
    public WhereUsedCommentToken getCommentToken() {
        return commentToken;
    }

    /**
     * Sets the value of the commentToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link WhereUsedCommentToken }
     *     
     */
    public void setCommentToken(WhereUsedCommentToken value) {
        this.commentToken = value;
    }

    /**
     * Gets the value of the versions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfint }
     *     
     */
    public ArrayOfint getVersions() {
        return versions;
    }

    /**
     * Sets the value of the versions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfint }
     *     
     */
    public void setVersions(ArrayOfint value) {
        this.versions = value;
    }

}
