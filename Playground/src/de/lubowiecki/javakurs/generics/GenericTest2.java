package de.lubowiecki.javakurs.generics;

import java.time.LocalDate;

public class GenericTest2 {

	public static void main(String[] args) {
		
		Rechner<Double> r = new Rechner<>();
		System.out.println(r.add(10.0, 20.0));
		
		Rechner<Long> r2 = new Rechner<>();
		System.out.println(r2.add(10l, 20l));
		
		Rechner<Integer> r3 = new Rechner<>();
		System.out.println(r3.add(10, 20));
		
//		Double d1 = 10;
//		double d2 = 10;
		
		GenericBox<LocalDate> dateBox = new GenericBox<>();
		dateBox.set(LocalDate.now());
		LocalDate ld = dateBox.get();
		
//		DoubleRechner dr = new DoubleRechner();
//		dr.add(t1, t2);
		
		// RawType
		GenericBox box = new GenericBox();

	}

}

//class Data implements Comparable<Date> {
//}
