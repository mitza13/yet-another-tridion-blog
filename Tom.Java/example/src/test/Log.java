package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	private final String TIME_PATTERN = "HH:mm:ss.S";

	private Date t;

	public void debug(String message) {
		DateFormat dateFormat = new SimpleDateFormat(TIME_PATTERN);
		Date now = new Date();

		if (t == null) {
			System.out.println(String.format("[%1$s] %2$s", dateFormat.format(now), message));
		} else {
			System.out.println(String.format("[%1$s] %2$s (%3$.3fs)", dateFormat.format(now), message,
					(now.getTime() - t.getTime()) / 1000.0));
		}

		t = now;
	}
}
