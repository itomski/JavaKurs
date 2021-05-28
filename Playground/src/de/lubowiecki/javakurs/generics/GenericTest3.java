package de.lubowiecki.javakurs.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenericTest3 {
	
	public static void main(String[] args) {
		
		// Wildcards werden immer nur für die Deklaration der Referenz verwendet (links)
		
		List<Number> l1 = new ArrayList<Number>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		
		List<?> l2 = new ArrayList<Double>();
		//l2.add(10.0); // Error: Hinzufügen von Elementen zu einer Collection mit Wildcard ist nicht erlaubt
		
		List<String> l3 = new ArrayList<>();
		l3.add("A");
		l3.add("B");
		l3.add("C");
		
		show(l1);
		show(l3);
		
		List<Integer> zahlen1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println(sum(zahlen1));
		
		List<Double> zahlen2 = Arrays.asList(1.5,2.5,3.5,4.5,5.2,6.2,7.2,8.2,9.2,10.7);
		System.out.println(sum(zahlen2));
		
		
		machWas(zahlen1);
		
		List<Number> zahlen3 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		machWas(zahlen3);
		
		List<Object> zahlen4 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		machWas(zahlen4);
		
		// T = Integer, Comparator<? super T>, hier kann ein Comparator für Integer, Number oder Object übergeben werden
		// das super hier ist keine Objektreferenz, sondern beschreibt die Richtung der Vererbung
		Comparator<Number> comp = (a, b) -> Double.compare(a.doubleValue(), b.doubleValue());
		Collections.sort(zahlen1, comp);
	}
	
	public static void show(List<?> list) { // ? = Wildcard, kann ein beliebiger Typ sein
		
		for(Object o : list) {
			System.out.println(o);
		}
	}
	
	public static double sum(List<? extends Number> list) { // Number oder eine Klindklasse davon sein
		double sum = 0;
		for(Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}
	
	public static void machWas(List<? super Integer> list) { // Es darf Integer oder eine Superklasse davon sein
	}
	
}
