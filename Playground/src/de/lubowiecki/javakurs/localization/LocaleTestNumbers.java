package de.lubowiecki.javakurs.localization;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleTestNumbers {

	public static void main(String[] args) {
		
		double preis = 1235.99;
		System.out.println(preis);
		
		System.out.printf("%.2f %n", preis); // liefert einen String, der an die DefaultSprache angepasst ist
		
		NumberFormat deForm = NumberFormat.getNumberInstance();
		System.out.println(deForm.format(preis));
		
		NumberFormat deFormCur = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(deFormCur.format(preis));
		
	}

}
