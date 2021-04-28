package de.lubowiecki.javakurs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TimeTest1 {

	public static void main(String[] args) {
		
		LocalDate d1 = LocalDate.now(); // Immutable
		System.out.println(d1);
		System.out.println(d1.getDayOfYear());
		
		System.out.println(d1.getMonthValue()); // liefert ein int zurück
		System.out.println(d1.getMonth()); // liefert Month-Object zurück
		
		System.out.println(d1.getYear());
		
		// ChronoField implementiert TemporalField
		System.out.println(d1.get(ChronoField.DAY_OF_WEEK)); // get liefert immer ein long zurück
		
		System.out.println(d1.isLeapYear()); // Schaltjahr?
		
		System.out.println();
		
		LocalDate d2 = d1.plusYears(2);
		d2 = d2.plusMonths(10);
		d2 = d2.plusDays(30);
		d2 = d2.minusDays(15);
		
		// ChronoUnit implementiert TemporalUnit
		d2 = d2.plus(10, ChronoUnit.YEARS);
		d2 = d2.minus(3, ChronoUnit.MONTHS);
		
		d2.isSupported(ChronoUnit.YEARS); // Fragt ab, ob eine Unit unterstützt wird
		d2.isSupported(ChronoField.DAY_OF_WEEK); // Fragt ab, ob ein Feld unterstützt wird
		
		System.out.println(d1);
		System.out.println(d2);
		
		d2 = d2.with(ChronoField.MONTH_OF_YEAR, 4); // Überschreibt einen bestimmten Bereich des Datums
		System.out.println(d2);
		
		d2 = LocalDate.of(2000, 1, 25);
		d2 = LocalDate.of(2000, Month.JANUARY, 25);
		
		LocalDate d3 = LocalDate.now();
		
		System.out.println(d3.isBefore(d2)); // Now vor d2 liegt
		System.out.println(d3.isAfter(d2)); // Now nach d2 liegt
		
		System.out.println();
		
		LocalDateTime dt1 = d2.atTime(10, 15, 32); // Erweitert das Datum um Uhrzeit
		
		System.out.println("---- LOCALTIME ----");
		
		LocalTime t1 = LocalTime.now();
		t1 = LocalTime.of(10, 10, 15, 150);
		System.out.println(t1);
		t1 = t1.plusHours(10);
		t1 = t1.plus(15, ChronoUnit.MINUTES);
		LocalDateTime dt2 = t1.atDate(d3);
		System.out.println(dt2);
		System.out.println(t1.get(ChronoField.HOUR_OF_DAY));
		
		System.out.println(LocalTime.MIDNIGHT);
		System.out.println(LocalTime.NOON);
		System.out.println(LocalTime.MIN);
		System.out.println(LocalTime.MAX);
		
		System.out.println();
		
		System.out.println(LocalDate.MIN);
		System.out.println(LocalDate.MAX);
		
		System.out.println("---- LOCALDATETIME ----");
		
		LocalDateTime dt3 = LocalDateTime.of(d2, t1);
		dt3 = LocalDateTime.of(2000,12,15,10,20,25,2500);
		
		System.out.println(dt3);
		
		//System.out.println(System.currentTimeMillis());
	}

}
