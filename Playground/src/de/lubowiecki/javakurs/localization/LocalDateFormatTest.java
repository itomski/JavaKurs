package de.lubowiecki.javakurs.localization;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LocalDateFormatTest {

	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		
		
		LocalDateTime now = LocalDateTime.now();
		ZonedDateTime now2 = ZonedDateTime.now();
		
		// Augeben
		System.out.println(dtf2.format(now2));
		System.out.println(now2.format(dtf2));
		
		// Einlesen
		//LocalDateTime ld1 = dtf.parse("15.03.2025 10:15:32"); // Liefert etwas vom Interface-Typ
		LocalDateTime ld1 = LocalDateTime.parse("15.03.2025 10:15:32", dtf);
		System.out.println(ld1);
		
		
		String preisStr = String.format("%.2f", 10.99);
		System.out.println(preisStr);
	}
}
