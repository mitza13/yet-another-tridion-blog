
package org.w3._2001.xmlschema;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Date>
{


    public Date unmarshal(String value) {
        return (mitza.coreservice.util.Utils.parseStringToDate(value));
    }

    public String marshal(Date value) {
        return (mitza.coreservice.util.Utils.parseDateToString(value));
    }

}
