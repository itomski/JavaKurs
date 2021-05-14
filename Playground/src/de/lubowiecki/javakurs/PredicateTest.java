package de.lubowiecki.javakurs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
	
	private static int grenze = 10;

	public static void main(String[] args) {
		
		List<String> namen = new ArrayList<>();
		namen.add("Carol");
		namen.add("Bruce");
		namen.add("Peter");
		namen.add("Natasha");
		namen.add("Tony");
		namen.add("Steve");
		
		// SAM: Single Abstract Methode
		// boolean test(T t);
//		Predicate<String> p = (s) -> s.length() > 4;
//		p = (s) -> s.length() <= 4 || s.length() > 6;
//		p = (s) -> s.startsWith("P");
		
		//namen.removeIf(p); // entfernt alle Elemente für die das Predicate true ergeben hat
		namen.removeIf((s) -> s.startsWith("P")); // Verwendet ein Pradicate für Strings
		System.out.println(namen);
		
		System.out.println();
		
		List<Double> zahlen = new ArrayList<>();
		zahlen.add(10.0);
		zahlen.add(15.); // ist 15.0
		zahlen.add(.2); // ist 0.2
		zahlen.add(1.7);
		zahlen.add(13.5);
		zahlen.add(5d); // ist 5.0
		zahlen.add(22.); // ist 22.0
		
		
		Predicate<Double> p2 = d -> d > 10; // Klammern um die Parameter können bei einem Parameter weggelassen werden
		Predicate<Double> p3 = (d) -> d > 20;
		//zahlen.removeIf(p2.negate()); // Das benötigte Predicate wird immer an der generischen Typ der Liste angepasst (hier Double)
		zahlen.removeIf(p2.and(p3));
		
		System.out.println(zahlen);
		
		// Zugriff innerhalb des Lambdas auf Instanz oder Klassenvariablen
		Predicate<Double> p4 = d -> d > grenze;
		
		int andereGrenze = 5;
		Predicate<Double> p5 = d -> d > andereGrenze;
		// Lokale Variablen dürfen nur dann in Lambdas verwendet werden, wenn sie final oder effektiv final sind
		// effektiv final = wird nicht verändert 
		// andereGrenze = 6; // Im Lambda nicht verwendbar, da NICHT effektiv final
		
		// this und super in Lambdas bezieht sich nicht auf das Lambda, sondern auf das Objekt wo das Lambda definiert ist
		
		
		Predicate<String> p6 = w -> {
			if(w.length() > 5) {
				return true; // Predicate liefert ein boolean zurück
			}
			else {
				return false;
			}
		};
		
		p6 = (String w) -> { // Angabe von String als Datentyp ist hier optional
			if(w.length() > 10) {
				return true; // Predicate liefert ein boolean zurück
			}
			else {
				return false;
			}
		};
		
		// generische Datentypen sind IMMER komplex
		// arrow = Pfeil
		// => Fat-Arrow, in Java nicht im Einsatz
		Presenter<Integer> p10 = (t) -> System.out.println("<h1>" + t + "</h1>"); // t ist ein Integer
		p10.present(100);
		
		Presenter<String> p11 = (t) -> System.out.println("<h1>" + t + "</h1>"); // t ist ein String
		p11.present("Moin Moin!");
	}
}

// Eigenes 
interface Presenter<E> {
	void present(E t);
}

interface Presenter2<E> {
	E present(E t);
}

interface Presenter3<E> {
	E present(E a, E b);
}

