package de.lubowiecki.javakurs;

public class VariablenTest {

	// Instanzvariable
	private int zahl = 10;
	
	// Klassenvariable
	private static double andereZahl = 20; // primitive promotion, widening
	
	public static void main(String[] args) {
		
		// Nicht erlaubt! statische Methode greift auf instanzvariablen zu
		//System.out.println(zahl);
		
		// Erlaubt! statische Methode greift auf statische Variablen zu
		System.out.println(andereZahl);
		
		// Instanz
		VariablenTest test1 = new VariablenTest();
		VariablenTest test2 = new VariablenTest();
		System.out.println(test1.zahl); // Erlaubt! Aufruf über eine Instanz
		
		System.out.println(test1.andereZahl); // Erlaubt! Aufruf einer statischen Variable über eine Instanz
		// Klasse der Instanz wird ermittelt und der Aufruf erfolgt direkt auf der Klasse

		
	}
}
