package de.lubowiecki.javakurs.streams;

import java.util.stream.IntStream;

public class ParallelTest {
	
	public static void main(String[] args) {
		
		IntStream ints = IntStream.rangeClosed(1, 100);
		
		// bei parallelen Streams ist eine Reihenfolge nicht mehr garantiert
		ints.parallel().map(i -> i * i).forEach(System.out::println);
		
		
	}
}
