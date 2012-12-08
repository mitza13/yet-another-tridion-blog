
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResolveInstructionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResolveInstructionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtensionXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IncludeChildPublications" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeComponentLinks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IncludeWorkflow" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Purpose" type="{http://www.sdltridion.com/ContentManager/R6}ResolvePurpose" minOccurs="0"/>
 *         &lt;element name="StructureResolveOption" type="{http://www.sdltridion.com/ContentManager/R6}StructureResolveOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResolveInstructionData", propOrder = {
    "extensionXml",
    "includeChildPublications",
    "includeComponentLinks",
    "includeWorkflow",
    "purpose",
    "structureResolveOption"
})
public class ResolveInstructionData {

    @XmlElement(name = "ExtensionXml", nillable = true)
    protected String extensionXml;
    @XmlElement(name = "IncludeChildPublications")
    protected Boolean includeChildPublications;
    @XmlElement(name = "IncludeComponentLinks")
    protected Boolean includeComponentLinks;
    @XmlElement(name = "IncludeWorkflow")
    protected Boolean includeWorkflow;
    @XmlElement(name = "Purpose", nillable = true)
    protected ResolvePurpose purpose;
    @XmlElement(name = "StructureResolveOption")
    protected StructureResolveOption structureResolveOption;

    /**
     * Gets the value of the extensionXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensionXml() {
        return extensionXml;
    }

    /**
     * Sets the value of the extensionXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensionXml(String value) {
        this.extensionXml = value;
    }

    /**
     * Gets the value of the includeChildPublications property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeChildPublications() {
        return includeChildPublications;
    }

    /**
     * Sets the value of the includeChildPublications property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeChildPublications(Boolean value) {
        this.includeChildPublications = value;
    }

    /**
     * Gets the value of the includeComponentLinks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeComponentLinks() {
        return includeComponentLinks;
    }

    /**
     * Sets the value of the includeComponentLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeComponentLinks(Boolean value) {
        this.includeComponentLinks = value;
    }

    /**
     * Gets the value of the includeWorkflow property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeWorkflow() {
        return includeWorkflow;
    }

    /**
     * Sets the value of the includeWorkflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeWorkflow(Boolean value) {
        this.includeWorkflow = value;
    }

    /**
     * Gets the value of the purpose property.
     * 
     * @return
     *     possible object is
     *     {@link ResolvePurpose }
     *     
     */
    public ResolvePurpose getPurpose() {
        return purpose;
    }

    /**
     * Sets the value of the purpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResolvePurpose }
     *     
     */
    public void setPurpose(ResolvePurpose value) {
        this.purpose = value;
    }

    /**
     * Gets the value of the structureResolveOption property.
     * 
     * @return
     *     possible object is
     *     {@link StructureResolveOption }
     *     
     */
    public StructureResolveOption getStructureResolveOption() {
        return structureResolveOption;
    }

    /**
     * Sets the value of the structureResolveOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructureResolveOption }
     *     
     */
    public void setStructureResolveOption(StructureResolveOption value) {
        this.structureResolveOption = value;
    }

}
