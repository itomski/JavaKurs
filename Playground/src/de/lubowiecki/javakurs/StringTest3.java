package de.lubowiecki.javakurs;

import java.util.ArrayList;
import java.util.List;

public class StringTest3 {

	public static void main(String[] args) {
		// String ist Immutable
		
		// "ABC" ist ein String-Literal
		String s = "Das ist das Haus von Nikigraus"; // Landet im Pool, String-LITERAL-Pool
		s = s.concat("..."); // Inhalt wird mit Parameter verbunden
		
		s = String.join(",", "ABC", new StringBuilder("CDE")); // Parameter muss von CharSequence abgeleitet sein 
		System.out.println(s);
		
		List<String> namen = new ArrayList<>();
		namen.add("Peter");
		namen.add("Bruce");
		namen.add("Carol");
		namen.add("Natasha");
		namen.add("Steve");
		
		s = String.join(", ", namen);
		System.out.println(s);
		
		System.out.println();

		System.out.println(s.charAt(0)); // liefert das Char an vorgegebener Position
		
		System.out.println(s.endsWith("Abc")); // endet mit? boolean
		System.out.println(s.startsWith("B")); // startet mit? boolean
		
		System.out.println(s.equalsIgnoreCase("...")); // ingnoriert beim Inhalts-Vergleich Groß/Klein-Schreibung
		
		int pos = s.indexOf("A"); // Liefert die Position für das erste vorkommen von Parameter
		System.out.println(s.indexOf("A", pos)); // Liefert die Position für das erste vorkommen von Parameter hinter pos
		System.out.println(s.lastIndexOf("A")); // Liefert die Position für das letzte vorkommen von Parameter
		
		// RegExp für OCA nicht relevant
		System.out.println(s.replace("A", "B")); // Ersetzt jedes vorkommen von A durch B
		System.out.println(s.replaceAll("[a-z]", "#")); // Ersetzt jedes vorkommen von kleinbuchstaben durch #
		
		System.out.println(s.substring(10)); // Liefert alles ab Pos 10 inkl
		// Startindex immer inkl., Endindex standardmäßig immer exkl.
		System.out.println(s.substring(10, 15)); // Liefert alles ab Pos 10 inkl bis Pos 20 exkl
		
		// Liefert ein gefülltes Muster (als String), Anzahl Plazhalter muss der Anzahl der Werte entsprechen
		// Muster wird erst zur Laufzeit verarbeitet
		s = String.format("Preise %f %.2f", 10.3, 5.7); // wir automatisch an die Landesformatierung angepasst
		System.out.println(s);
		
		System.out.println(s.contains("Peter")); // Prüft, ob Peter in der Zeichenkette enthalten ist true/false
		
		// %s für String
		// %d für Ganzzahlen (dezimal)
		System.out.printf("Name %s", "Peter"); // wird sofort ausgegeben
		
		System.out.println();
		
		// Für OCA nicht relevant
		System.out.printf("%-10s| %-10s %n", "Vorname", "Nachname"); // wird sofort ausgegeben
		System.out.println("----------------------------");
		System.out.printf("%-10s| %-10s %n", "Peter", "Parker"); // - Linksausrichtung, 10 = Anzahl Stellen
		System.out.printf("%-10s| %-10s %n", "Bruce", "Wayne"); // leer Rechtsausrichtung
		System.out.printf("%-10s| %-10s %n", "Tony", "Stark");
		
		System.out.println();
		
		// Für OCA nicht relevant
		"Das ist ein Haus von Nikigraus".chars().forEach(System.out::println); // System.out::println = Methodenreferenz
		
		System.out.println("\t     Moin ".trim());
		
		// HashCode
		
		
		// Byte-LITERAL-Pool, Byte-Constant-Pool ist bereits beim Start des Programms mit ganzzahligen Wrapper-Objekten
		// zwischen -128 und 127 gefüllt. Wird für Byte, Short, Integer und Long genutzt
		Integer i = 100; // 100 ist bereits im Pool und i ist eine Referenz darauf
		Integer j = 100; // ist eine Referenz darauf auf das gleich Objekt wie i
	}

}
