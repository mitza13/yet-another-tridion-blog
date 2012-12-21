package mitza.coreservice.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * @author Mihai Cadariu
 */
public class Utils {

	private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	public static String printDocument(Document doc) throws IOException, TransformerException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		printDocument(doc, stream);
		return stream.toString();
	}

	public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		transformer.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(out, "UTF-8")));
	}

	public static String parseDateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
		return formatter.format(date);
	}

	public static Date parseStringToDate(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
			return formatter.parse(date);
		} catch (ParseException e) {
			// big bubu
		}

		return null;
	}
}
