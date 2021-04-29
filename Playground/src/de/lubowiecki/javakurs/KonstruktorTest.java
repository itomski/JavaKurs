package de.lubowiecki.javakurs;

import java.time.LocalDate;
import java.time.LocalTime;

public class KonstruktorTest {

	public static void main(String[] args) {
		
//		Werkzeug w1 = new Werkzeug();
//		Werkzeug w2 = new Werkzeug("Zange");
		SpezialWerkzeug w3 = new SpezialWerkzeug();
		SpezialWerkzeug w4 = new SpezialWerkzeug();
		SpezialWerkzeug w5 = new SpezialWerkzeug();

	}
}

abstract class Werkzeug {
	
	// 1. Statische Variablen werden initialisiert
	// 2. Instanz Variablen werden initialisiert
	
	private static final int zahl; // Eine Zuweisung muss beim Einlesen der Klasse erfolgen. Konstruktor ist zu spät
	private static int zahl2;
	
	private int a; // Instanz und Klassenvariblen bekommen einen Defaultwert
	private int b = 10; // Können gleich initialisiert werden
	private int c = a + b + zahl; // a und b müssen existieren bevor c zugewewiesen werden kann
	private StringBuilder sb = new StringBuilder();
	
	// private static int zahl2 = c + 2; // Error: c ist erst später verfügbar und gehört zu einem Objekt
	
	// Static-Initializer: wird beim Laden der Klasse einmalig aufgerufen
	static {
		// hier kann normale Java-Code stehen
		System.out.println("STATIC INIT");
		if(LocalTime.now().isAfter(LocalTime.NOON)) {
			zahl = 0;
		}
		else {
			zahl = 1;
		}
		
		//zahl2 = zahl / 0; // ExceptionInInitializerError
	}
	
	// Instace-Initializer: wird für jedes Objekt vor dem Konstruktor aufgerufen
	{
		System.out.println("INSTANCE INIT");
//		int[] arr = {};
//		System.out.println(arr[10]);
	}
	
	// Konstruktor
	public Werkzeug() {
		// super(); // Wenn etwas direkt  vor dem Super-Konstruktor ausgeführt werden muss -> instance initializer
		System.out.println("KONSTRUKTOR K1");
	}
	
	// Überladen des Konstruktor
	public Werkzeug(String name) {
		System.out.println("KONSTRUKTOR K2");
	}
}


class SpezialWerkzeug extends Werkzeug {
	
	static {
		System.out.println("SUB STATIC INIT");
	}
	
	{
		System.out.println("SUB INSTANCE INIT");
	}
	
	public SpezialWerkzeug() {
		System.out.println("SUB KONSTRUKTOR K1");
	}
	
	public SpezialWerkzeug(String name) {
		System.out.println("SUB KONSTRUKTOR K2");
	}
	
}
