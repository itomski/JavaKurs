package de.lubowiecki.javakurs.strings;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpSample {

	public static void main(String[] args) {
		
		// . beliebiges Zeichen
		// \d Zahlen
		// \D Keine Zahlen!
		// \w Buchstaben
		// \W Keine Buchstaben!
		// \s Steuerzeichen (Leerzeichen, Tab etc.)
		// \S Keine Steuerzeichen!
		// (ab|bc) Entweder der Text ab oder der Text bc
		// [a-z] nur Kleinbuchstaben
		// [A-Z] nur Großbuchstaben
		// [0-9] nur Zahlen
		// [^abc] Diese Zeichen dürfen nicht vorkommen
		// (^abc) abc darf nicht vorkommen
		// \\. ein echter Punkt, muss maskiert werden
		// (?i)   Case-insensitive (ASCII)
		// (?iu)  Case-insensitive (Unicode)
		
		// ^ Beginnt am Anfang des Strings
		// $ Arbeitet bis Ende
		// ^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,4}$ Der komplette String muss diesem Muster entsprechen
		
		// Multiplikatoren
		// + mindestens 1 Zeichen
		// * 0 oder beliebig viele Zeichen
		// ? 0 oder 1 mal
		// {2,4} mind. 2 Zeichen und max. 4 Zeichen
		// {0,1} 0 oder 1 mal
		
		String str = "Das ist abc@xyz.de meine Adresse t.lubowiecki@nordwerft.de Bla bla bla";
		
		String pattern = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,4}$";
		System.out.println(str.matches(pattern)); // Prüft ob der Text dem Muster entspricht 
		System.out.println(Arrays.asList(str.split(pattern))); // Splitet die Zeichenkette, Muster ist im Result nicht enthalten
		System.out.println(str.replaceFirst(pattern, "...")); // Ersetzt das erste Vorkommen des Musters
		str.replaceAll(pattern, "..."); // Ersetzt alle Vorkommen des Musters
		System.out.println(str.substring(str.split(pattern)[0].length()));
		
		System.out.println("\n--- PATTERN UND MATCHER ---");
		
		
		Pattern realPattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,4}");
		Matcher matcher = realPattern.matcher(str); // Pattern wird auf den Text angewandt
		
		StringBuffer buffer = new StringBuffer();
		
		while(matcher.find()) { // find: Wurde das Muster gefunden?
			System.out.println("Start-Index:" + matcher.start());
			System.out.println("End-Index:" + matcher.end());
			System.out.println(matcher.group()); // Gefundenes Vorkommen
			//matcher.appendReplacement(buffer, "...");
		}
		
		//matcher.appendTail(buffer); // wird mit appendReplacement verwendet um nach der letzten Fundstelle noch des Rest des Strings mitzunehmen
		System.out.println(buffer);
		
		str = "Das ist ein Haus von Nikigraus";
		System.out.println(str.matches(".*(Nikolaus|nikolaus|Nikigraus|nikigraus).*"));
		
		

	}

}
