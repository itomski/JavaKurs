package de.lubowiecki.javakurs.collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		
		// HashBasierterContainer
		Set<Integer> zahlen = new HashSet<>();
		
		zahlen.add(10);
		zahlen.add(15);
		zahlen.add(22);
		zahlen.add(1);
		zahlen.add(100);
		
		zahlen.remove(1);
		
		System.out.println(zahlen);
		

	}
}
