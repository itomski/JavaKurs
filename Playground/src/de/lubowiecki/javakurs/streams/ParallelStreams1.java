package de.lubowiecki.javakurs.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams1 {
	
	private List<Integer> list;
	
	public ParallelStreams1() {
		// Die gesamte Verarbeitung erfolgt sequentiell
		list = getRandStream().parallel().boxed().sequential().collect(Collectors.toList());
	}
	
	boolean noneParallel() {
		return list.stream().allMatch((i) -> i <= 900);
	}
	
	boolean parallel() {
		return list.parallelStream().allMatch((i) -> i <= 900);
	}
	
	IntStream getRandStream() {
		return IntStream.generate(() -> (int)(Math.random() * 900 + 1)).limit(1_000_000);
	}
	
	void forEach() {
		IntStream.range(1, 1000).parallel().forEach(i -> System.out.println(Thread.currentThread().getName() + ": " + i));
	}
	
	void forEachOrderd() {
		IntStream.range(1, 1000).parallel().forEachOrdered(i -> System.out.println(Thread.currentThread().getName() + ": " + i));
	}
	
	String reduce() {
		return Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J").reduce("", (a, b) -> a + b);
	}
	
	String parallelReduce() {
		return Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J").parallel().reduce("", (a, b) -> a + b);
	}
}
