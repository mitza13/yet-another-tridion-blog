
package com.sdltridion.contentmanager.r6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPublishContextData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPublishContextData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PublishContextData" type="{http://www.sdltridion.com/ContentManager/R6}PublishContextData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPublishContextData", propOrder = {
    "publishContextData"
})
public class ArrayOfPublishContextData {

    @XmlElement(name = "PublishContextData", nillable = true)
    protected List<PublishContextData> publishContextData;

    /**
     * Gets the value of the publishContextData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publishContextData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublishContextData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PublishContextData }
     * 
     * 
     */
    public List<PublishContextData> getPublishContextData() {
        if (publishContextData == null) {
            publishContextData = new ArrayList<PublishContextData>();
        }
        return this.publishContextData;
    }

}
