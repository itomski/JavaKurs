package de.lubowiecki.javakurs.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest1 {

	public static void main(String[] args) {
		
		Stream<Integer> zahlen1 = Stream.of(5,7,8,12,22,1,6,15,19,100);
		System.out.println(zahlen1);
		
		List<Integer> zahlenList = Arrays.asList(5,7,8,12,22,1,6,15,19,100);
		zahlen1 = zahlenList.stream();
		
		// arbeitet mit primitiven int-Werten. Gibts noch LongStream, DoubleStream
		IntStream zahlen2 = IntStream.of(5,7,8,12,22,1,6,15,19,100);
		
		LongStream zahlen3 = LongStream.of(5,7,8,12,22,1,6,15,19,100); // primitiv widening von int zu long
		//Stream<Long> zahlen4 = Stream.of(5,7,8,12,22,1,6,15,19,100); // Error, int zu Long nicht möglich
		
		zahlen2 = IntStream.range(0, 1000); // Zahlen von 0 bis inkl 999
		zahlen2 = IntStream.rangeClosed(0, 1000); // Zahlen von 0 bis inkl 1000
		
		// IntConsumer: void accept(int i);
		zahlen2.forEach(i -> System.out.print(i + ",")); // Die Zahlen werden erst bei der Verarbeitung produziert
		// Benötigtes Element wird produziert, dann verarbeitet und dann wird erst das nächste Element produziert
		
		// zahlen2.forEach(i -> System.out.print(i + ",")); // IllegalStateException: bereits verarbeitet
		// Ein Stream kann nur ein einiziges mal verarbeitet werden. Danach ist er verbraucht.
		
		System.out.println();
		
		// Supplier<T>: T get();
		// IntSupplier: int get();
		IntSupplier iSup = () -> (int)((Math.random() * 10) + 1);
		// generate Prodsuziert einen neuen Stream
		zahlen2 = IntStream.generate(iSup); // generate produziert hier noch keine Werte - Es ist Lazy
		
		// Zufallszahlen zwischen 1 und 10 werden produziert und ausgegeben
		//zahlen2.forEach(i -> System.out.println(i)); // Hier werden die Werte Produziert und verarbeitet
		
		
		// IntPredicate: boolean test(int i);
		
		// IntUnaryOperator: int applyAsInt(int i); // Wenn retur primitiv ist, wird ein AsInt, AsDouble oder AsLong an die Methode drangehängt 
		// IntFunction<T>: T apply(int i);
		zahlen2.filter(i -> i < 8) // intermediate geben immer einen Stream zurück
				.map(i -> i + 120) // beim IntStream primitiv zu primitiv
				.mapToObj(i -> (char)i) // primitiv zu Komplex: Gibt ein Stream von Chars zurück
				.limit(100) // Verarbeitet nur 100 Character
				.forEach(i -> System.out.println(i)); // forEach ist terminierend d.h. Ende eines Streams
				
		
		zahlen2 = IntStream.generate(iSup);
		int summe = zahlen2.limit(100_000_000).sum(); // sum ist auch terminierend
		System.out.println(summe);		
		
		
	}

}
