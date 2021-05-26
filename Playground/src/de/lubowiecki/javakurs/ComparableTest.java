package de.lubowiecki.javakurs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ComparableTest {

	public static void main(String[] args) {
		
		
		Gewicht g1 = new Gewicht(1.0);
		Gewicht g2 = new Gewicht(2.0);
		Gewicht g3 = new Gewicht(2.5);
		Gewicht g4 = new Gewicht(4.0);
		Gewicht g5 = new Gewicht(2.0);
		
		Set<Gewicht> gewichte = new HashSet<>(); // ungeordnet (Schaut nur auf hashCode und equals)
		
		// Standardkonstruktor von TreeSet setzt voraus, dass die Objekte Comparable sind
		gewichte = new TreeSet<>(); // immer sortiert  (Schaut auf compareTo, 0 heißt gleiches Objekt)
		gewichte.add(g1);
		gewichte.add(g4);
		gewichte.add(g3);
		gewichte.add(g2);
		gewichte.add(g5);
		
		System.out.println(gewichte);
		
		System.out.println();
		
		for(Gewicht g : gewichte) {
			System.out.println(g.hashCode());
		}
		
		// Comparator - Künstliche Reihenfolge, Externes Vergleichobjekt
		// Da der Comparator ein FunctionalInterface ist wird er heute per Lambda implementiert
		
		// int compare(T o1, T o2);
		Comparator<Gewicht> comp1 = (a, b) -> (b.getKg() < a.getKg()) ? -1 : (b.getKg() == a.getKg()) ? 0 : 1;
		
		gewichte = new TreeSet<>(comp1);
		gewichte.add(g1);
		gewichte.add(g4);
		gewichte.add(g3);
		gewichte.add(g2);
		gewichte.add(g5);
		
		System.out.println(gewichte);
		
		System.out.println();
		
		List<Gewicht> list = new ArrayList<>(); // hat eine Einfügereihenfolge
		list.add(g1);
		list.add(g4);
		list.add(g3);
		list.add(g2);
		list.add(g5);
		System.out.println(list);
		
		System.out.println();
		Collections.sort(list); // Sortiert nach der natürlichen Reihenfolge, Comparable
		
		Collections.sort(list, comp1); // wird nach dem Comparator sortiert
		list.sort(comp1); // wird nach dem Comparator sortiert
		// Beide Varianten führen zum gleichen Ergebnis
		
		System.out.println(list);
		
		
		System.out.println();
		
		SortedSet<Gewicht> sortGewichte = new TreeSet<>(comp1);
		sortGewichte.add(g1);
		sortGewichte.add(g4);
		sortGewichte.add(g3);
		sortGewichte.add(g2);
		sortGewichte.add(g5);
		
		sortGewichte.first(); // Liefert das erste Element nach dem sortieren
		sortGewichte.last(); // Liefert das erste Element nach dem sortieren
		
		NavigableSet<Gewicht> navSet = (NavigableSet<Gewicht>) sortGewichte;
		System.out.println(navSet.headSet(g1));
	}
}

// Ist Immutable
class Gewicht implements Comparable<Gewicht> { // Gewicht soll mit Gewicht vergleichbar sein
	
	private final double kg;
	
	public Gewicht(double kg) {
		this.kg = kg;
	}

	public double getKg() {
		return kg;
	}
	
	@Override
	public String toString() {
		return kg + "kg";
	}
	
	@Override
	public int hashCode() {
		// Gleicher HashCode beim gleicher Anzahl kg
		return (int)(kg * 31);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(obj instanceof Gewicht) {
			// Gleichheit bei beim gleicher Anzahl kg
			return this.kg == ((Gewicht) obj).kg;
		}
		
		return false;
	}

	@Override
	public int compareTo(Gewicht o) { // Natürliche Reihenfolge, Standard-Reihenfolge
		return Double.compare(this.kg, o.getKg());
	}
}
