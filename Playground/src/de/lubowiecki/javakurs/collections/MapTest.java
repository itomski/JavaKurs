package de.lubowiecki.javakurs.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
		
		
		// System.out.println(System.getProperties()); // Properties sind Maps mit einigen extra Methoden, Keys sind Strings
		System.out.println(System.getProperties().get("java.library.path"));
		
		Map<Integer, String> map = new TreeMap<>();
		// Files: Utility-Klasse aus NIO zum Arbeiten mit Datein und Verzeichnissen
		// Path ist ein Pfad auf der aktuellen Rechner
		
		try {
		
			// wenn nicht weiter eingegeben, dann wird text.txt im Root-Ordener des Programms gesucht
			List<String> zeilen = Files.readAllLines(Paths.get("text.txt")); // liest den Inhalt der Datei aus und liefert alle Zeilen in einer Liste
			
			for(String zeile: zeilen) {
				map.put(zeile.length(), zeile);
			}
			
			System.out.println(map);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
