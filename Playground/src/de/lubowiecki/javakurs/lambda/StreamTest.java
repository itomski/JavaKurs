package de.lubowiecki.javakurs.lambda;

import java.util.Arrays;
import java.util.Objects;

public class StreamTest {
	
	public static void main(String[] args) {
		
		
		Object[] words = {" ", '3', null, "2", 1, ""};
		Arrays.stream(words)
			.filter(Objects::nonNull) // Predicate<Object>, Klasse: Objects, Methode: boolean isNull(Object obj)
			.map(Objects::toString) // Function<Object, String>, Konvertiert alle Elemente zu String
			.map(String::trim) // Function<String, String>, Schneidet leerzeichen ab
			.filter(s -> ! s.isEmpty()) // Filtert leere Strings raus
			.map(Integer::parseInt) // Function<String, Integer>, Wandelt String in Integer um
			.sorted() // Sortiert die Elemente
			.forEach(System.out::println); // Consumer<Integer>, oder eine Methoden-Referenz, die das gleiche macht
			
		// Interface Function definiert eine Konvertierung von Typ A auf Typ B
		
		// Methoden-Referenz:
		// Methoden-Aufruf mit :: ist ein spezieller Aufruf bei dem man keine Klamern benutzen darf
		// Es werden automatisch die Elemente werden automatisch als Parameter an diese Methode übergeben
		
		// Bei normalen Methoden-Aufrufen darf die Klammer und Parameter nicht weggelassen werden
		
	}
}
