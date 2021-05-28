package de.lubowiecki.javakurs.collections;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class NavigableMapTest {
	
	public static void main(String[] args) {
		
		NavigableMap<LocalDate, String> termine = new TreeMap<>();
		
		termine.put(LocalDate.of(2020, 11, 17), "Projekt A finalisieren");
		termine.put(LocalDate.of(2020, 12, 11), "Projekt B finalisieren");
		termine.put(LocalDate.of(2020, 10, 3), "Projekt A vorbereiten");
		termine.put(LocalDate.of(2021, 2, 3), "Projekt C vorbereiten");
		termine.put(LocalDate.of(2021, 2, 4), "Projekt C anfangen");
		termine.put(LocalDate.of(2021, 5, 15), "Projekt D planen");
		termine.put(LocalDate.of(2021, 6, 2), "Projekt D anfangen");
		termine.put(LocalDate.of(2021, 6, 3), "Projekt D Diagramme entwerfen");
		
		System.out.println(termine);
		
		System.out.println();
		
		// NavigableMap
		System.out.println(termine.higherEntry(LocalDate.of(2021, 1, 1))); // nächste als
		System.out.println(termine.lowerEntry(LocalDate.of(2021, 1, 1))); // vorherige als
		System.out.println(termine.ceilingEntry(LocalDate.of(2021, 1, 1))); // wenn Key da ist, dann dieses, sonst das nächste
		System.out.println(termine.floorEntry(LocalDate.of(2021, 1, 1))); // wenn Key da ist, dann dieses, sonst das vorherige
		
		System.out.println();
		
		TreeMap<LocalDate, String> termine2 = (TreeMap<LocalDate, String>) termine;
		
		LocalDate ld = LocalDate.of(2021, 1, 1);
		
		// SortedMap
		System.out.println("Nach " + ld);
		System.out.println(termine2.tailMap(ld)); // vom Key bis Ende der Map
		
		System.out.println("Davor " + ld);
		System.out.println(termine2.headMap(ld)); // Vom Angfang der Map bis zu dem Key
		
		System.out.println("Ab heute 7 Tage Übersicht");
		
		SortedMap<LocalDate, String> termine3 = termine2.subMap(LocalDate.now(), LocalDate.now().plusDays(8)); // Vom Key1 bis Key2
		
		System.out.println(termine3);
		
		System.out.println("Es gibt " + ((termine3.size() > 1) ?  termine3.size() + " Termine." : (termine3.size() == 0) ? "keinen Termin" : "einen Termin"));
		
		for(Entry<LocalDate, String> e : termine3.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		
//		Set<String> set = new LinkedHashSet<>();
//		set.add(new String("Chicago"));
//		set.add(new String("Boston"));
//		set.add(new String("Alabama"));
//		set.add(new String("Chicago"));
//		
//		System.out.println(set);
		
	}
}
