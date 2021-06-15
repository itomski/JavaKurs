package de.lubowiecki.javakurs.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {

	public static void main(String[] args) {
		
		// FOR_EACH
		Stream<String> str =  Arrays.stream("Das ist ein Haus von Nikigraus".split(" "));
		// Consumer<String>: void accept(T s)
		//str.forEach(System.out::println);
		//str.forEach(StreamTest4::machWas);
		
//		Object[] objs = str.toArray(); // ist eine terminal Operation
//		
//		for(Object o : objs) {
//			System.out.println(o);
//		}
		
		// TO_ARRAY
		// IntFunction<A[]>
		String[] arr = str.toArray(i -> new String[i]);
		//String[] arr = str.toArray(String[]::new); // Methoden-Referenz auf den Konstruktor
		for(String s : arr) {
			System.out.println(s.toLowerCase());
		}
		
		// COLLECT
		str =  Arrays.stream("Das ist ein Haus von Nikigraus".split(" "));
		// BiConsumer<T, U> void accept(T t, U u)
		//List<String> list = str.collect(ArrayList::new, List::add, List::addAll);
		
		// Supplier
		// Erzeugt eine leere Collection
		// Supplier<HashSet<String>>: HashSet<String> get();
		Supplier<Set<String>> sup1 = () -> new HashSet<>();
		
		// Accumulator
		// Befüllt die Collection mit Werten des Streams
		// BiConsumer<Set<String>, String>: void accept(Set<String> set, String s)
		BiConsumer<Set<String>, String> accumulator1 = (set, s) -> set.add(s);
		
		// Combiner
		// Bei parallelen Streams, erzeugt jeder Stream eine eigene Collection und befüllt diese
		// danach müssen diese Collections zu einer zusammengesetzt werden
		// BiConsumer<Set<String>, Set<String>>: void accept(Set<String> set1, Set<String> set2)
		BiConsumer<Set<String>, Set<String>> combiner1 = (set1, set2) -> set1.addAll(set2);
		
		Set<String> list = str.collect(sup1, accumulator1, combiner1);
		
		str =  Arrays.stream("Das ist ein Haus von Nikigraus".split(" "));
		Supplier<Map<String, String>> sup2 = () -> new HashMap<>();
		BiConsumer<Map<String, String>, String> accumulator2 = (m, s) -> m.put(s, s);
		BiConsumer<Map<String, String>, Map<String, String>> combiner2 = (m1, m2) -> m1.putAll(m2);
		
		Map<String, String> map = str.collect(sup2, accumulator2, combiner2);
		System.out.println(map);
		
		str =  Arrays.stream("Das ist ein Haus von Nikigraus".split(" "));
		StringBuilder sb = str.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		
		str =  Arrays.stream("Das ist ein Haus von Nikigraus".split(" "));
		// Collectors: Util-Klasse mit verschiedenen Kollektoren
		List<String> list2 = str.collect(Collectors.toList());
		
		str =  Arrays.stream("Das ist ein Haus von Nikigraus".split(" "));
		Set<String> set2 = str.collect(Collectors.toSet());
		
		
		System.out.println();
		
		List<Customer> l = Arrays.asList(new Customer("Peter", "Parker", Type.BUSINESS), new Customer("Bruce", "Banner", Type.PRIVATE), new Customer("Tony", "Stark", Type.BUSINESS));
		
		
		//Stream<Customer> customers = Stream.of(new Customer("Peter", "Parker", Type.BUSINESS), new Customer("Bruce", "Banner", Type.PRIVATE), new Customer("Tony", "Stark", Type.BUSINESS));
		Stream<Customer> customers = l.stream();
		
		//Collectors.toMap(Methoden-Referenz für Key, Methoden-Referenz für Value)
		Map<String, String> map2 = customers.collect(Collectors.toMap(Customer::getNr, Customer::getLastname));
		System.out.println(map2);
		
		System.out.println();
		
		// customers = Stream.of(new Customer("Peter", "Parker", Type.BUSINESS), new Customer("Bruce", "Banner", Type.PRIVATE), new Customer("Tony", "Stark", Type.BUSINESS));
		customers = l.stream();
		
		// Es wird eine eigenschaft zum Gruppieren vorgegeben
		Map<Type, List<Customer>> map3 = customers.collect(Collectors.groupingBy(Customer::getType));
		System.out.println(map3.get(Type.BUSINESS));
		
		System.out.println();
		
		// customers = Stream.of(new Customer("Peter", "Parker", Type.BUSINESS), new Customer("Bruce", "Banner", Type.PRIVATE), new Customer("Tony", "Stark", Type.BUSINESS));
		
		customers = l.stream();
		
		// Es wird ein Predicate vorgegeben und die Objekte werden in zwei Gruppen eingeteilt.
		// Alle die das Predicate erfüllen in true und der Rest in false
		Map<Boolean, List<Customer>> map4 = customers.collect(Collectors.partitioningBy(c -> c.getFirstname().length() > 4));
		System.out.println(map4);
		// System.out.println(map4.get(true));
	}
	
	public static void machWas(String s) {
		System.out.println(s.toUpperCase());
	}
}
