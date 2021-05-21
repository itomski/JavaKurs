package de.lubowiecki.javakurs;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class InterfaceTest6 {

	public static void main(String[] args) {
		
		Tester t1 = (Object o) -> o.equals("");
		Tester t2 = o -> o.equals("");
		
		Tester<String> t3 = s -> s.indexOf('A') > -1;
		
		Iz1 i1 = new Iz1() {};
		//Iz2 i2 = (Iz2) i1; // Mit Casting zum Interface-Typ ist es kompilierbar
		
		Az1 a1 = new Az1();
		//Az2 a2 = (Az2) a1; // Mit Casting zum Klassen-Typ ist es NICHT kompilierbar
		
		System.out.println();
		
		float d1 = 0.3f;
		float d2 = 0.0f;
		
		System.out.println(d1/d2);
		
		//Az1 az = (Az1)(new Object());
		
		String str;
		boolean b = false;
		
		if(b = true)
			str = "true";
		
		//str = (b) ? str : "false";
		//System.out.println(str);
		
//		Int hat 32bit, das sind 4 Bytes
//		00000000 + 00000000 + 00000000 + 00000000
		
		Period p = Period.of(1, 1, 0);
		System.out.println(p.getDays());
		System.out.println(p.getMonths());
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/M/d");
		LocalDate ld = LocalDate.parse("2000/11/5", f);
		System.out.println(ld); //2000-01-05
		System.out.println(ld.format(f));
		
		//ChronoUnit.DAYS
		System.out.println(ChronoField.valueOf("MINUTE_OF_DAY"));
		ld.getLong(ChronoField.valueOf("MINUTE_OF_DAY"));
		
		
		
	}
}

class Az1 {
	
}

class Az2 {
	
}

interface Iz1 {
	
}

interface Iz2 {
	
}


interface Tester<T> {
	
	boolean test(T s);
	
}

interface NextTester<T> {
	
	T test(int s);
	
}

class MyTester implements Tester<Double> {

	@Override
	public boolean test(Double s) {
		// TODO Auto-generated method stub
		return false;
	}	
}
