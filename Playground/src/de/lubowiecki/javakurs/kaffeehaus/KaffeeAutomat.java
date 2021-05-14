package de.lubowiecki.javakurs.kaffeehaus;

//kann public oder package-private sein
public interface KaffeeAutomat { // Interfaces erweitern andere Interfaces mit extends (NICHT implements)
	
	// Alle Eigenschaften vom Interface sind public static final
	String marke = "KaffeeAutomat"; // Konstante, muss sofort, oder initialisiert werden
	// In Klassen kann eine statische Konstante auch im static-Initializer initialisiert werden
	
	// Alle Eigenschaften und Methoden des Interface sind IMMER public, auch wenn nichts davor steht
	
	// public und abstract
	Kaffee bereiteKaffeeZu();
	
	// statische Methoden dürgen nicht abstrakt sein
	// statische Methoden eines Interface werden NICHT vererbt
	static void info() {
		// Können nur das statische Inventar des Interface nutzen
		System.out.println("Ich bin ein " + marke);
	}
	
	// Können nur Eigenschaften und Methoden des Interface benutzen
	// Methoden von Object dürfen nicht als default-Methoden in Interfaces eingebaut werden
	// Methoden von Object: toString, hashCode, equals, notify, notifyAll, wait
	// default = Default-Implementierung einer Instanzmethode
	default boolean reinigung() {
		System.out.println("Die Reinigungs-Funktion ist derzeit nicht verfügbar.");
		return false;
	}
	
}
