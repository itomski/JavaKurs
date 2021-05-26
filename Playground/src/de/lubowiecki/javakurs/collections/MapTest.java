package de.lubowiecki.javakurs.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		
		Map<String, Integer> einwohner = new HashMap<>();
		einwohner.put("Hamburg", 1_900_000);
		einwohner.put("Berlin", 4_000_000);
		einwohner.put("München", 1_500_000); // Schlüssel-Wert-Paare
		
		einwohner.put("München", 2_500_000); // Value wird geändert
		
		einwohner.putIfAbsent("Ülzen", 20); // Füge hinzu, wenn abwesend
		
		// Suche nach Key liefert Value zurück
		System.out.println(einwohner.get("Berlin"));
		
		System.out.println("----");
		System.out.println(einwohner.remove("Hamburg"));
		System.out.println(einwohner.remove("Hamburg", 0)); // liefert 0 (Default-Wert) statt null, wenn nicht vorhanden
		System.out.println(einwohner.replace("München", 3_500_000));
		
		System.out.println(einwohner);
		
		for(int i : einwohner.values()) {
			System.out.println(i);
		}
		
		System.out.println();
		
		for(String key : einwohner.keySet()) {
			System.out.println(key + ": " + einwohner.get(key));
		}
		
		System.out.println();
		
		for(Map.Entry<String, Integer> e : einwohner.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		
		System.out.println("------------");
		
		Map<String, String> heros = new HashMap<>();
		heros.put("Peter Parker", "Spiderman");
		heros.put("Bruce Banner", "Hulk");
		
		Map<String, List<String>> heros2 = new HashMap<>();
		heros2.put("Peter Parker", Arrays.asList("Spiderman", "New York", "USA"));
		heros2.put("Bruce Banner", Arrays.asList("Hulk", "Denver", "USA"));
		
		System.out.println(heros2.getOrDefault("Peter Parker", new ArrayList<>()));
		
		// Bücherverwaltung - Map<String, Book> - String soll ISBN sein
		
		
	}

}
