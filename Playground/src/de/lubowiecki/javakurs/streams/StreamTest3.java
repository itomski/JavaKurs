package de.lubowiecki.javakurs.streams;

import java.util.stream.IntStream;

public class StreamTest3 {

	public static void main(String[] args) {
		
		IntStream zahlen = IntStream.of(7,1,2,3,5,4,99,4,5,13,6,7,8,9,10);
		
		//SKIP
		zahlen.skip(5).forEach(System.out::println); // überspring  die ersten 5 elemente
		
		System.out.println();
		
		// LIMIT
		zahlen = IntStream.of(7,1,2,3,5,4,99,4,5,13,6,7,8,9,10);
		zahlen.limit(5).forEach(System.out::println); // bricht die verarbeitung nach 5 Elementen ab
		
		System.out.println();
		
		zahlen = IntStream.of(7,1,2,3,5,4,99,4,5,13,6,7,8,9,10);
		zahlen.distinct().forEach(System.out::println); // entfernt Duplikate
		// bei komplexen Datentypen muss hashCode und equals richtig eingebaut sein
		
		System.out.println();
		
		// SORTED
		zahlen = IntStream.of(7,1,2,3,5,4,99,4,5,13,6,7,8,9,10);
		zahlen.sorted().forEach(System.out::println); // sortiert die Elemente, Sammelt erstmal alle Elemente bevor sie sortiert werden
		// bei komplexen Datentypen muss Comparabel richtig implementiert oder ein Comparator vorgegeben werden

	}

}
