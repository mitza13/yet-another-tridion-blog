
package com.sdltridion.contentmanager.r6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContainingBundlesListInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContainingBundlesListInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sdltridion.com/ContentManager/R6}ListInfo">
 *       &lt;sequence>
 *         &lt;element name="BundleProcess" type="{http://www.sdltridion.com/ContentManager/R6}LinkToProcessDefinitionData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContainingBundlesListInfo", propOrder = {
    "bundleProcess"
})
public class ContainingBundlesListInfo
    extends ListInfo
{

    @XmlElement(name = "BundleProcess", nillable = true)
    protected LinkToProcessDefinitionData bundleProcess;

    /**
     * Gets the value of the bundleProcess property.
     * 
     * @return
     *     possible object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public LinkToProcessDefinitionData getBundleProcess() {
        return bundleProcess;
    }

    /**
     * Sets the value of the bundleProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkToProcessDefinitionData }
     *     
     */
    public void setBundleProcess(LinkToProcessDefinitionData value) {
        this.bundleProcess = value;
    }

}
