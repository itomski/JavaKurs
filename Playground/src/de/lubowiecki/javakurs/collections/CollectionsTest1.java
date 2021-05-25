package de.lubowiecki.javakurs.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CollectionsTest1 {

	public static void main(String[] args) {
		
		Iterable<Integer> c1 = new ArrayList<>(Arrays.asList(1,2,3,5,9,22,17,8));
		
		// enhanced loop oder das forEach sind gute alternativen
		
		Iterator<Integer> itr = c1.iterator();
		while(itr.hasNext()) { // Prüft, ob ein nächstes Element da ist
			int i = itr.next(); // Liefert das nächste Element zurück
			System.out.println(i);
		}
		
		System.out.println();
		
		// seit Java 8
		// void accept(T t)
		c1.forEach(e -> System.out.println(e * 10));
		
		System.out.println();
		
		// Das was hier durchlaufen wird muss entweder ein array oder Iterable sein
		for(int i : c1) {
			System.out.println(i);
		}
		
		System.out.println();
		
		// Ohne Cast hier nicht möglich, da Iterable keine size und get Methode anbietet
		for(int i = 0; i < ((ArrayList)c1).size(); i++) {
			System.out.println(((ArrayList)c1).get(i));
		}
		
//		Object s = "Hallo";
//		System.out.println(((String)s).toUpperCase());
		
	}

}
