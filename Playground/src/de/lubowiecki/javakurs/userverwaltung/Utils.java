package de.lubowiecki.javakurs.userverwaltung;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Utils {

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
	
	private Utils() {
	}
}
