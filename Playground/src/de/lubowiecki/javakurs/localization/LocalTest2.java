package de.lubowiecki.javakurs.localization;

import java.util.Locale;

public class LocalTest2 {

	public static void main(String[] args) {
		
		Locale loc = new Locale("de", "DE");
		loc = new Locale("de");
		loc = Locale.getDefault();
		
		
		System.out.println(loc);
		
		//Locale loc2 = Locale.ENGLISH;
		Locale loc2 = new Locale("ar");
		
		// Für die Ausgabe wird automatisch die Default-Sprache verwendet
		// Defult wird von Betriebssystem über JVM bereitgestellt
		System.out.println(loc.getDisplayLanguage());
		System.out.println(loc.getDisplayLanguage(loc2));
		System.out.println(loc.getDisplayCountry());
		System.out.println(loc.getDisplayCountry(loc2));
		System.out.println(loc.getDisplayName());
		System.out.println(loc.getDisplayName(loc2));
		
		for(Locale l : Locale.getAvailableLocales()) {
			System.out.print(l + " " + l.getDisplayName() + "\n");
		}
	}

}
