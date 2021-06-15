package de.lubowiecki.javakurs.streams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReductionTest {

	public static void main(String[] args) {
		
		// REDUCE - Reduziert eie Elemente eines Streams auf einen Immutable wert
		
		// Beispielzahlen, 1 ist der Startwert
		IntStream zahlen = IntStream.iterate(1, i -> i * 2);
		
		zahlen.limit(50).forEach(System.out::println);
		
		System.out.println();
		
		zahlen = IntStream.iterate(1, i -> i * 2);
		// Optional, weil wenn der Stream leer ist, die Aktion in Reduce 0x 
		//ausgeführt wird und keine gültige Rückgabe vorliegt
		// a = Startwert oder Erebnis der vorherigen Berechnung, b nächste Wert im Stream
		OptionalInt sum = zahlen.limit(30).reduce((a, b) -> a + b);
		sum.ifPresent(System.out::println);
		
		
		zahlen = IntStream.iterate(1, i -> i * 2);
		// Hier kein Optional, weil wenn der Stream leer ist und die Aktion in Reduce 0x
		//ausgeführt wird, wird der Startwert 0 zurückgegeben. Die 0 ist ein int
		int intSum = zahlen.limit(30).reduce(0, (a, b) -> a + b);
		System.out.println(intSum);
		
		
		Stream<String> buchstaben = Stream.of("A", "B", "C", "D", "E");
		Optional<String> op = buchstaben.reduce((a, b) -> a + ", " + b);
		op.ifPresent(s -> System.out.println(s));
		
		buchstaben = Stream.of("A", "B", "C", "D", "E");
		String str = buchstaben.reduce("", (a, b) -> a + ", " + b);
		System.out.println(str);
		
		// Wechsel von primitiv zu komplex
		// Stream von primitiven ints
		zahlen = IntStream.iterate(1, i -> i * 2);
		Stream<Integer> zahlenKomplex = zahlen.boxed(); //ints werden zu Integer geboxt
		
		System.out.println();
		
		// Wechsel von komplex zu primitiv
		Stream<Double> doubles = Stream.of(10.2, 2.7, 9.15, 22.19, 18.99);
		double dSum = doubles.mapToDouble(d -> d /* AutoUnboxing, da der Rpckgabe-Typ primitiv double ist */).sum();
		System.out.println(dSum);
		
	}

}
