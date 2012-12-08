
package org.w3._2001.xmlschema;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Date>
{


    public Date unmarshal(String value) {
        return new Date(value);
    }

    public String marshal(Date value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

}
