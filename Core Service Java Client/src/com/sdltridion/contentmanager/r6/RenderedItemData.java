
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for RenderedItemData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RenderedItemData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Binaries" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfBinaryData" minOccurs="0"/>
 *         &lt;element name="ChildRenderedItems" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfRenderedItemData" minOccurs="0"/>
 *         &lt;element name="CodePage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="ExecutionTime" type="{http://schemas.microsoft.com/2003/10/Serialization/}duration" minOccurs="0"/>
 *         &lt;element name="Instructions" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="IsRenderedCompletely" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Metadata" type="{http://www.sdltridion.com/ContentManager/R6}SerializableXmlDocument" minOccurs="0"/>
 *         &lt;element name="RenderInstruction" type="{http://www.sdltridion.com/ContentManager/R6}RenderInstructionData" minOccurs="0"/>
 *         &lt;element name="ResolvedItem" type="{http://www.sdltridion.com/ContentManager/R6}ResolvedItemData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RenderedItemData", propOrder = {
    "binaries",
    "childRenderedItems",
    "codePage",
    "content",
    "executionTime",
    "instructions",
    "isRenderedCompletely",
    "metadata",
    "renderInstruction",
    "resolvedItem"
})
public class RenderedItemData {

    @XmlElement(name = "Binaries", nillable = true)
    protected ArrayOfBinaryData binaries;
    @XmlElement(name = "ChildRenderedItems", nillable = true)
    protected ArrayOfRenderedItemData childRenderedItems;
    @XmlElement(name = "CodePage")
    protected Integer codePage;
    @XmlElement(name = "Content", nillable = true)
    protected byte[] content;
    @XmlElement(name = "ExecutionTime")
    protected Duration executionTime;
    @XmlElement(name = "Instructions", nillable = true)
    protected String instructions;
    @XmlElement(name = "IsRenderedCompletely")
    protected Boolean isRenderedCompletely;
    @XmlElement(name = "Metadata", nillable = true)
    protected String metadata;
    @XmlElement(name = "RenderInstruction", nillable = true)
    protected RenderInstructionData renderInstruction;
    @XmlElement(name = "ResolvedItem", nillable = true)
    protected ResolvedItemData resolvedItem;

    /**
     * Gets the value of the binaries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBinaryData }
     *     
     */
    public ArrayOfBinaryData getBinaries() {
        return binaries;
    }

    /**
     * Sets the value of the binaries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBinaryData }
     *     
     */
    public void setBinaries(ArrayOfBinaryData value) {
        this.binaries = value;
    }

    /**
     * Gets the value of the childRenderedItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRenderedItemData }
     *     
     */
    public ArrayOfRenderedItemData getChildRenderedItems() {
        return childRenderedItems;
    }

    /**
     * Sets the value of the childRenderedItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRenderedItemData }
     *     
     */
    public void setChildRenderedItems(ArrayOfRenderedItemData value) {
        this.childRenderedItems = value;
    }

    /**
     * Gets the value of the codePage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodePage() {
        return codePage;
    }

    /**
     * Sets the value of the codePage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodePage(Integer value) {
        this.codePage = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setContent(byte[] value) {
        this.content = ((byte[]) value);
    }

    /**
     * Gets the value of the executionTime property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getExecutionTime() {
        return executionTime;
    }

    /**
     * Sets the value of the executionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setExecutionTime(Duration value) {
        this.executionTime = value;
    }

    /**
     * Gets the value of the instructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Sets the value of the instructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstructions(String value) {
        this.instructions = value;
    }

    /**
     * Gets the value of the isRenderedCompletely property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRenderedCompletely() {
        return isRenderedCompletely;
    }

    /**
     * Sets the value of the isRenderedCompletely property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRenderedCompletely(Boolean value) {
        this.isRenderedCompletely = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetadata(String value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the renderInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link RenderInstructionData }
     *     
     */
    public RenderInstructionData getRenderInstruction() {
        return renderInstruction;
    }

    /**
     * Sets the value of the renderInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenderInstructionData }
     *     
     */
    public void setRenderInstruction(RenderInstructionData value) {
        this.renderInstruction = value;
    }

    /**
     * Gets the value of the resolvedItem property.
     * 
     * @return
     *     possible object is
     *     {@link ResolvedItemData }
     *     
     */
    public ResolvedItemData getResolvedItem() {
        return resolvedItem;
    }

    /**
     * Sets the value of the resolvedItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResolvedItemData }
     *     
     */
    public void setResolvedItem(ResolvedItemData value) {
        this.resolvedItem = value;
    }

}
