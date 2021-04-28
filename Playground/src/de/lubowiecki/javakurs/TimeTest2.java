package de.lubowiecki.javakurs;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class TimeTest2 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		Instant s = Instant.now();
		
		// Period ist Immutable
		Period p1 = Period.of(2, 3, 15); // Zeitraum
		Period p2 = Period.ofYears(10); 
		Period p3 = Period.ofMonths(6); 

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		p1 = p1.plus(p2);
		p1.plusDays(3);
		
		LocalDate d1 = LocalDate.now();
		System.out.println(d1.plus(p1));
		System.out.println(d1.minus(p1));
		
		LocalDate d2 = LocalDate.now();
		LocalDate d3 = LocalDate.of(1979, 1, 1);
		
		System.out.println(Period.between(d3, d2));
		System.out.println(Period.between(d3, d2).get(ChronoUnit.DAYS));
		
		p1 = Period.parse("P10Y5m");
		System.out.println(p1.getYears());
		
		d3 = d3.plus(p1); // Zeitraum wird zu dem Datum dazuaddiert
		
		long end = System.currentTimeMillis();
		Instant e = Instant.now();
		
		System.out.println("---------------");
		
		System.out.println(end - start + "ms");
		System.out.println(Duration.between(s, e).toNanos() + "ns");
		
		System.out.println("---------------");
		
		Year y = Year.now();
		YearMonth ym = y.atMonth(Month.FEBRUARY);
		LocalDate ld1 = ym.atDay(15);
		
	}

}
