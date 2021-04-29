package de.lubowiecki.javakurs;

public class LogikUnit {
	
	// Instanzeigenschaft
	int zahl = 10;
	
	// Klassenvariable
	static double andereZahl = 20; // primitive promotion, widening
	
	Double ganzAndereZahl = 150.0; // boxing und dann widening (aufsteigen zur Elternklasse)

	// Instanzmethode
	public void machWas() {
		System.out.println(zahl); // instanz Methode darf instanzeigenschaften benutzen!
		System.out.println(andereZahl); // instanz Methode darf statische Eigenschaften benutzen!
		machWas(); // instanz Methode darf Instanzmethoden direkt benutzen!
		machWasAnderesStatic(); // instanz Methode darf statische Methoden benutzen!
	}
	
	// Klassenmethode
	public static void machWasStatic() {
		//System.out.println(zahl); // Kompilerfehler: statische Methode darf keine instanzeigenschaften benutzen!
		System.out.println(andereZahl); // statische Methode darf statische Eigenschaften benutzen!
		// machWas(); // Kompilerfehler: statische Methode darf keine Instanzmethoden direkt benutzen!
		machWasAnderesStatic(); // statische Methode darf statische Methoden benutzen!
	}
	
	public static void machWasAnderesStatic() {
		
	}
}
