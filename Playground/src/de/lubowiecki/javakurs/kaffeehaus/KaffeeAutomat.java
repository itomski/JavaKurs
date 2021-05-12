package de.lubowiecki.javakurs.kaffeehaus;

//kann public oder package-private sein
public interface KaffeeAutomat {
	
	// Alle Eigenschaften und Methoden des Interface sind IMMER public, auch wenn nichts davor steht
	
	// public und abstract
	Kaffee bereiteKaffeeZu();
	
	// statische Methoden dürgen nicht abstrakt sein
	static void info() {
		System.out.println("Ich bin ein KaffeeAutomat");
	}
	
	default boolean reinigung() {
		System.out.println("Die Reinigungs-Funktion ist derzeit nicht verfügbar.");
		return false;
	}
}
