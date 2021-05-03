package de.lubowiecki.javakurs.a;

public class Mutter {
	
	private int zahlA = 100; // Nur für diese Klasse sichtbar
	int zahlB = 100; // default, Nur für Klassen im gleich Package sichtbar
	protected int zahl = 100; // Nur für Klassen im gleich Package und erbende Klassen aus anderen Packages sichtbar

}
