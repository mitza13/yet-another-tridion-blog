package net.mitza.rel.util;

import java.text.ParseException;

import com.tridion.util.TCMURI;

public class Utils {

	public static int getItemId(Object value) {
		if (value == null) {
			return -1;
		}

		if (value instanceof Integer) {
			return (Integer) value;
		} else if (value instanceof TCMURI) {
			return ((TCMURI) value).getItemId();
		} else if (value instanceof String) {
			return getItemId((String) value);
		}

		return -1;
	}

	public static int getItemId(String value) {
		if (value == null) {
			return -1;
		}

		try {
			TCMURI tcmUri = new TCMURI(value);
			return tcmUri.getItemId();
		} catch (ParseException e) {
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException nfe) {
				return -1;
			}
		}
	}

	public static boolean isValidTcmUri(String value) {
		try {
			new TCMURI(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
