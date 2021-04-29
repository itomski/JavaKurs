package de.lubowiecki.javakurs;

public class VariablenTest2 {

	public static void main(String[] args) {
		
		// Nicht erlaubt! statische Methode greift auf instanzvariablen zu
		// System.out.println(LogikUnit.zahl);
		
		// Erlaubt! statische Methode greift auf statische Variablen zu
		System.out.println(LogikUnit.andereZahl);
		
		LogikUnit test1 = new LogikUnit();
		LogikUnit test2 = new LogikUnit();
		System.out.println(test1.zahl); // Erlaubt! Aufruf über eine Instanz
		
		System.out.println(test1.andereZahl); // Erlaubt! Aufruf einer statischen Variable über eine Instanz
		// Klasse der Instanz wird ermittelt und der Aufruf erfolgt direkt auf der Klasse
		
		// Nicht erlaubt! statische Methode greift auf instanzmethode direkt(über die Klasse) zu
		// LogikUnit.machWas();
		
		// Erlaubt! statische Methode greift auf andere statische Methode zu
		LogikUnit.machWasStatic();
		
		test1.machWas(); // Erlaubt! Aufruf einer Instanzmethode über eine Instanz
		test1.machWasStatic(); // Erlaubt! Aufruf einer statischen Methode über eine Instanz
		// Klasse der Instanz wird ermittelt und der Aufruf erfolgt direkt auf der Klasse
		
		// Statische Methoden dürfen nur statisches Inventar direkt benutzen
		// Instanz Methoden dürfen statisches und Instanz-Inventar benutzen
		
	}

}
