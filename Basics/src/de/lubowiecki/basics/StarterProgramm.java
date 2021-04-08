// end-of-line Kommentar
package de.lubowiecki.basics;


public class StarterProgramm {
	/* multi-line Kommentar */
	
	// Methoden sind Funktionen im Kontext einer Klasse
	// Beim Start des Programms JRE (Virtual-Machine) startet die main-Methode
	public static void main(String[] args) {
		// main ist der Einstieg in ein ausführbares Programm
		
		int x = 10;
		machWas();
		
		// println schreibt eine Zeile ins Konsolenfenster
		System.out.println("Hallo Welt: " + x); // Schreibt mit Zeilenumbruch
		
		System.out.println(); // produziert eine Leerzeile
		
		x = 15;
		System.out.print("Hallo Welt: " + x); // Schreibt ohne Zeilenumbruch
		
		machWas();
		
		Object o; // Deklaration, Vorstellung einer Variable
		o = new Object(); // Zuweisung, Initialisierung (Erstzuweisung)
		o = new Object(); // Zuweisung
		o = null; // null bedeutet Nichts
		//o.hashCode();
		machWas();
	}
	
	private static void machWas() {
		double x = 20.5;
		System.out.println("Zahl: " + x);
	}
}