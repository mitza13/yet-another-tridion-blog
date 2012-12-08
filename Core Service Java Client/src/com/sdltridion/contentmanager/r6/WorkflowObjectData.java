
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkflowObjectData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkflowObjectData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}IdentifiableObjectData">
 *       &lt;sequence>
 *         &lt;element name="ContextRepository" type="{http://www.sdltridion.com/ContentManager/R6}LinkToRepositoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowObjectData", propOrder = {
    "contextRepository"
})
@XmlSeeAlso({
    WorkItemData.class,
    ActivityData.class,
    ActivityDefinitionData.class,
    ProcessData.class
})
public class WorkflowObjectData
    extends IdentifiableObjectData
{

    @XmlElement(name = "ContextRepository", nillable = true)
    protected LinkToRepositoryData contextRepository;

    /**
     * Gets the value of the contextRepository property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public LinkToRepositoryData getContextRepository() {
        return contextRepository;
    }

    /**
     * Sets the value of the contextRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToRepositoryData }
     *     
     */
    public void setContextRepository(LinkToRepositoryData value) {
        this.contextRepository = value;
    }

}
