package de.lubowiecki.javakurs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class ZeitTest1 {

	public static void main(String[] args) {
		
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		
		// ld = LocalDate.of(2021, 13, 17); // DateTimeException
		ld = LocalDate.of(2021, Month.MAY, 17);
		
		lt = LocalTime.of(10, 15, 32);
		
		ldt = LocalDateTime.of(ld, lt);
		
		Year y = Year.of(2021);
		YearMonth ym = y.atMonth(5);
		
		ld = ym.atDay(10); // Tag des Monats
		
		ld = y.atDay(200); // Tag des Jahres
		
		
		// plus- und minus-Methoden sind Instanzmethoden d.h. sie nutzen den ursprünglichen Wert als Ausgangswert
		// Alle 3 Varianten auch für minus vorhanden
		LocalDate ld2 = ld.plusDays(100).plusMonths(2); // plus und minus erzeugen IMMER ein neues LocalDate
		
		// ChronoUnit bietet Zeiteinheiten, die mit LocalDate, LocalTime und LocalDateTime benutzt werden können
		ld2 = ld.plus(100, ChronoUnit.WEEKS);
		
		System.out.println(ld2);
		
		Period p = Period.ofDays(100);
		ld2 = ld.plus(p);
		
		LocalTime lt2 = lt.plusHours(10); // plus und minus erzeugen IMMER ein neues LocalTime
		// Zeitraum für LocalTime wird mit Duration angegeben
		
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		
		Period p2 = Period.parse("P10Y25M15D"); // Tage lassen sich nicht normalisieren
		p2 = Period.ofWeeks(10);
		p2 = p2.normalized();
		System.out.println(p2);
		System.out.println(p2.getYears());
		System.out.println(p2.getMonths());
		System.out.println(p2.getDays());
		
		// of-Methoden sind statische Methoden
		p2 = Period.ofWeeks(10).ofMonths(2); // im p2 liegt nur die Period von 2 Monaten
		p2 = Period.ofWeeks(10).plusMonths(2); // Die Period von 10 Wochen wird um 2 Monate erweitert
		
		// um plus- oder minus-Methoden zu benutzen muss bereits ein Period (LocalDate, LocalTime etc.) Objekt vorhanden sein
		// p2 = Period.plusWeeks(10).plusMonths(2); // Error: plus ist keine statische Methode
		System.out.println(p2);
		
		// Beispiel:
		// ofMonths (statische Methode) erzeugt eine neue Period von 2 Monaten 
		// plusMonths (instanz Methode) erzeugt eine neue Period aus der alten Period plus 2 Monaten
		
		// between ist statisch und erzeugt eine Period als Zeitraum ZWISCHEN zwei LocalDates
		Period p3 = Period.between(LocalDate.of(2022, 6, 15), LocalDate.now());
		System.out.println(p3);
		

	}

}
