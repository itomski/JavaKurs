package de.lubowiecki.javakurs.kaffeehaus;

//kann public oder package-private sein
public interface KaffeeAutomat {
	
	// Alle Eigenschaften vom Interface sind public static final
	String marke = "KaffeeAutomat"; // Konstante
	
	// Alle Eigenschaften und Methoden des Interface sind IMMER public, auch wenn nichts davor steht
	
	// public und abstract
	Kaffee bereiteKaffeeZu();
	
	// statische Methoden dürgen nicht abstrakt sein
	static void info() {
		// Können nur das statische Inventar des Interface nutzen
		System.out.println("Ich bin ein " + marke);
	}
	
	// Können nur Eigenschaften und Methoden des Interface benutzen
	default boolean reinigung() {
		System.out.println("Die Reinigungs-Funktion ist derzeit nicht verfügbar.");
		return false;
	}
}
