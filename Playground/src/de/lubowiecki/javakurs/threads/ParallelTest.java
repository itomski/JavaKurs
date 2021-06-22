package de.lubowiecki.javakurs.threads;

import java.util.stream.Stream;

public class ParallelTest {
	
	public static void main(String[] args) {
		
		Stream<Integer> zahlen = Stream.of(1,2,3,4,5,6,7,8,9,10);
		zahlen.parallel().forEach(System.out::println);
		
		
		
	}

}
