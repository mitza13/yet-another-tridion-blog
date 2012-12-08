
package com.sdltridion.contentmanager.coreservice._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sdltridion.contentmanager.r6.ArrayOfPublishContextData;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResolveItemsResult" type="{http://www.sdltridion.com/ContentManager/R6}ArrayOfPublishContextData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resolveItemsResult"
})
@XmlRootElement(name = "ResolveItemsResponse")
public class ResolveItemsResponse {

    @XmlElement(name = "ResolveItemsResult", nillable = true)
    protected ArrayOfPublishContextData resolveItemsResult;

    /**
     * Gets the value of the resolveItemsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPublishContextData }
     *     
     */
    public ArrayOfPublishContextData getResolveItemsResult() {
        return resolveItemsResult;
    }

    /**
     * Sets the value of the resolveItemsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPublishContextData }
     *     
     */
    public void setResolveItemsResult(ArrayOfPublishContextData value) {
        this.resolveItemsResult = value;
    }

}
