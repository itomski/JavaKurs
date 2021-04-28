package de.lubowiecki.javakurs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TimeTest3 {

	public static void main(String[] args) {
		
		LocalDate ld1 = LocalDate.parse("2021-02-17");
		System.out.println(ld1);
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM); // Nur Datum
		DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM); // Nur Zeit
		DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM); // Nur Datum und Zeit
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("EEEE, 'der' d. MMMM yyyy GG"); // Nach Muster
		
		System.out.println(ld1.format(dtf1));
		System.out.println(LocalDateTime.now().format(dtf3));
		
		ld1 = LocalDate.parse("17.02.2021", dtf1);
		System.out.println(ld1);
		
		System.out.println(ld1.format(dtf4));
		
		ld1 = LocalDate.parse("Mittwoch, der 17. Februar 2021 n. Chr.", dtf4);
		System.out.println(ld1);

	}

}
