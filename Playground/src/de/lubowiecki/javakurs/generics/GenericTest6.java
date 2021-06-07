package de.lubowiecki.javakurs.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest6 {

	public static void main(String[] args) {
		
		GenClass gc1 = new GenClass(); // RawTyp: Number
		GenClass<Integer> gc2 = new GenClass<>();
		GenClass<Number> gc3 = new GenClass<>();
		//GenClass<Number> gc4 = new GenClass<Double>(); // Error: Bei Generics muss der generisch Typ auf beiden Seiten GLEICH sein
		GenClass<Number> gc5 = new GenClass<>(); // Durch Type-Inferenz wird der Typ auf der linken Seite auch rechts verwendet
		
		GenClass<?> gc6 = new GenClass<Double>(); // Wildcard: Typ Rechts kann frei gewählt werden, Bound muss beachtet werden
		// gc6 verwendet als genereischen Typ Number nicht Double
		//GenClass<?> gc7 = new GenClass<String>(); // Error: String ist nicht von Number abgeleitet
		
		GenClass2<?> gc8 = new GenClass2<Double>(); // RawTyp: Object
		// gc8 verwendet als genereischen Typ Object nicht Double
		
		
		// Collections mit Wildcards erlauben kein add
		List<?> list = new ArrayList<Integer>();
		//list.add(1); // Error!
		
		for(Object o : list) {
			System.out.println(o);
		}
		
		System.out.println();
		
		Integer[] arr  = {1,2,3,4};
		Object[] oArr = (Object[]) arr;
		//oArr[2] = "Hallo"; // ArrayStoreException, Array auf dem Speicher erlaubt nur Integer
		
		
		// Upper-Bound, Grenze nach Oben in der Vererbungs-Hierarchie ist auf Number festgelegt
		// der generiche Typ darf frei gewählt werden, muss aber Number sein, oder von Number abgeleietet sein 
		List<? extends Number> list2 = new ArrayList<Integer>();
		// Wildcards mit upper-Bound erlauben kein add für Collections
		// Wildcard arbeitet mit Number, Original-Liste auf dem Heap arbeitet mit Integer
		//list2.add(100); // Error: Nicht jede Number ist ein Integer
		
		
		double sum = 0;
		for(Number n : list2) {
			sum += n.doubleValue();
		}
		System.out.println(sum);
		
		
		//List<Integer> ints = new ArrayList<>();
		//List<Integer> ints = Arrays.asList(100, 200, 300); // Die Liste ist fix-size lieste
		List<Integer> ints = new ArrayList<>(Arrays.asList(100, 200, 300)); // hier wird eine neue liste gebaut und alle elemente aus der alten übernommen
		ints.add(150);
		ints.add(250);
		ints.add(350);
		
		System.out.println(makeSum(ints));
		
		// Lower-Bound, Grenze nach Unten in der Vererbungs-Hierarchie ist auf Number festgelegt
		// der generiche Typ darf frei gewählt werden, muss aber Number sein, oder eine Elternklasse davon 
		List<? super Number> list3 = new ArrayList<Object>();
		// Wildcard arbeitet mit Number, Original-Liste auf dem Heap arbeitet mit Object
		list3.add(100); // Ok: jede Number ist ein Object
		//list3.add(new Object()); // Error: Wildcard erwartet eine Number
	}
	
	public static double makeSum(List<? extends Number> list) {
		double sum = 0;
		for(Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}
	
	

}

class GenClass<T extends Number> { // Genericher Typ darf Number oder eine Sub-Klasse von Number sein
	
	public T operation(T t) {
		return t;
	}
}

class GenClass2<T> { // Genericher Typ darf Number oder eine Sub-Klasse von Number sein
	
	public T operation(T t) {
		return t;
	}
}