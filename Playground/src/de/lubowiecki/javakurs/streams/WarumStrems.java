package de.lubowiecki.javakurs.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WarumStrems {

	public static void main(String[] args) {
		
		List<Integer> zahlen = new ArrayList<Integer>();
		zahlen.add(10);
		zahlen.add(15);
		zahlen.add(8);
		zahlen.add(9);
		zahlen.add(3);
		zahlen.add(22);
		zahlen.add(19);
		zahlen.add(15);
		zahlen.add(10);
		zahlen.add(1);
		zahlen.add(7);
		zahlen.add(99);
		zahlen.add(13);
		zahlen.add(12);
		
		List<Integer> treffer = new ArrayList<>();
		for(Integer i : zahlen) {
			if(i >= 10 && i < 20) {
				treffer.add(i);
			}
		}
		
		// Lösung mit Streams
		treffer = zahlen.parallelStream()
					.filter(i -> i >= 10 && i < 20)
					.distinct().sorted()
					.collect(Collectors.toList());
		
		System.out.println(treffer);
		
		
	}

}
