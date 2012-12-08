
package com.sdltridion.contentmanager.r6;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for PublishInstructionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublishInstructionData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}PublishInstructionBaseData">
 *       &lt;sequence>
 *         &lt;element name="DeployAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MaximumNumberOfRenderFailures" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="RenderInstruction" type="{http://www.sdltridion.com/ContentManager/R6}RenderInstructionData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublishInstructionData", propOrder = {
    "deployAt",
    "maximumNumberOfRenderFailures",
    "renderInstruction"
})
public class PublishInstructionData
    extends PublishInstructionBaseData
{

    @XmlElement(name = "DeployAt", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date deployAt;
    @XmlElement(name = "MaximumNumberOfRenderFailures", nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long maximumNumberOfRenderFailures;
    @XmlElement(name = "RenderInstruction", nillable = true)
    protected RenderInstructionData renderInstruction;

    /**
     * Gets the value of the deployAt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getDeployAt() {
        return deployAt;
    }

    /**
     * Sets the value of the deployAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeployAt(Date value) {
        this.deployAt = value;
    }

    /**
     * Gets the value of the maximumNumberOfRenderFailures property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaximumNumberOfRenderFailures() {
        return maximumNumberOfRenderFailures;
    }

    /**
     * Sets the value of the maximumNumberOfRenderFailures property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaximumNumberOfRenderFailures(Long value) {
        this.maximumNumberOfRenderFailures = value;
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

}
