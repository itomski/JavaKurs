package de.lubowiecki.javakurs.localization;

import java.util.Locale;

public class LocaleBuilderTest {

	public static void main(String[] args) {
		
		Locale loc = new Locale.Builder().setLanguage("de").build();
		loc = new Locale.Builder().build();
		
		Locale.Builder b = new Locale.Builder();
		
		Locale loc1 = b.setLanguage("de").build(); // nur mit Sprache
		Locale loc2 = b.setRegion("DE").build(); // mit Sprache und Land

	}

}
