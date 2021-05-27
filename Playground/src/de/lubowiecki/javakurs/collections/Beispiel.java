package de.lubowiecki.javakurs.collections;

public class Beispiel {
	
	// Wir schreiben ein Strategie-Spiel.
	// Es gibt eine Einheit (Reiter, Bogenschützen, Arbeiter) mit Atrributen wie Kraft, Schnelligkeit etc.
	// Diese Einheit kann mehrere Ausrüstungsgegenstände haben
	// Diese Einheit kann als Gruppe mit anderen Einheiten bewegt werden.
	
//	Einheit (Abstrakte Klasse)
//		Eigenschaften: Kraft, Schnelligkeit etc
//		Methoden: Bewegen
//			
//	Reiter, Bogenschütze, Arbeiter extends Einheit IS-A
//		HAS-A Gegenstand
//	
//	Gegenstand
//	
//	Gruppe
//		HAS-A Einheiten
	
	

	// Banksoftware:
	// Ein Kunde kann beliebig viele Konten haben und ein Konto kann beliebig viele Umsätze haben
	// Ein Kunde kann eine Privatperson oder eine Firma sein
	
//	Kunde (Abstrakte Klasse)
//	
//	Privatperson, Firma extends Kunde (IS-A)
//		HAS-A Konto (1:n)
//	
//	Konto 
//		HAS-A Person oder Firma (Bidirektional) (gehört immer nur einer Person doder Firma)
//		HAS-A Umsätze
//	
//	Umsatz
//		HAS-A Konto (Bidirektional)
}
