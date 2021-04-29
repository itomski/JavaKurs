package de.lubowiecki.javakurs;

import java.util.ArrayList; // importiert eine Klasse
import java.util.*; // importiert alle Klassen aus dem Paket, aber keine Sub-Pakete
import java.util.function.BiFunction; // importiert eine Klassen aus dem Sub-Paket von java.util

// Instanz-Inventar einer Klasse kann nicht importiert werden

import static java.lang.Math.PI; // importiert statisches Inventar (Feld/Egenschaft/Member-Variable)
import static java.lang.Math.abs; // importiert statisches Inventar (Methode)

public class ImportTest {
	
	
	public static void main(String[] args) {
		
		// liegt in java.lang d.h. muss nicht extra importiert werden
		StringBuilder sb = new StringBuilder();
		
		// muss importiert werden
		ArrayList<Integer> al = new ArrayList<>();
		
		// Es muss alles (Klassen, Interfaces, Enums) importiert werden, was nicht im 
		// gleichen Package oder in java.lang liegt

		System.out.println(PI); 
		// nach dem statischen Import kann das statische Invenar so als wäre es hier definiert verwendet werden
		
		System.out.println(abs(-15));
		System.out.println(Math.abs(-15));
		
	}
}
