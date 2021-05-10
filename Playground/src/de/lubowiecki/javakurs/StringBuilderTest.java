package de.lubowiecki.javakurs;

import java.time.Period;

public class StringBuilderTest {

	public static void main(String[] args) {
		
		// Veränderbare Zeichenkette
		StringBuilder sb = new StringBuilder("..."); // Startkapazität: Anzahl Zeichen + 16
		
		sb = new StringBuilder(100); // capacity: 100
		sb = new StringBuilder("100"); // capacity: 19
		
		sb = new StringBuilder(sb); // capacity: 19, aus dem alten StringBuilder wird nur der Inhalt verwendet
		System.out.println(sb.capacity());
		
		System.out.println();
		
		System.out.println(sb.length() + " " + sb.capacity());
		sb.append("Das ist ein");
		System.out.println(sb.length() + " " + sb.capacity());
		sb.append(" Haus von Niki");
		System.out.println(sb.length() + " " + sb.capacity());
		// Vergrößerung: aktuelle Kapazität * 2 + 2
		sb.append("graus... das ist ein cooler Typ");
		System.out.println(sb.length() + " " + sb.capacity());
		
		System.out.println("---LOOP---");
		
		// Vergrößerung: Neue capacity = Alte capacity * 2 + 2
		// 16 / 32+2 / 68+2 / 140 + 2
		
		StringBuilder sb2 = new StringBuilder(100); // Startkapazität: wird vorgegeben
		System.out.println(sb2.length() + " " + sb2.capacity());
		for(int i = 0; i < 100; i++) {
			sb2.append(i);
		}
		System.out.println(sb2.length() + " " + sb2.capacity());
		
		sb2.trimToSize(); // Reduziert die Kapazität auf die tatsächliche Anzahl der Zeichen
		System.out.println(sb2.length() + " " + sb2.capacity());

		System.out.println("--------");
		
		// Positionen beginnen mit 0
		StringBuilder sb3 = new StringBuilder("0123456789");
		sb3.delete(4, 8); // start inkl., ende excl.
		System.out.println(sb3); // automatisch wird für das Objekt die toString-Methode aufgerufen
		
		System.out.println("--------");
		
		StringBuilder sb4 = new StringBuilder("0123456789");
		String s = sb4.toString();
		//sb4.insert(8, "Hi"); // Hinzufügen nur möglich, wenn Position bereits mit Zeichen belegt ist
		sb4.replace(2,7, "Hi");
		sb4.replace(7,8, "Hi");
		sb4.reverse();
		System.out.println(sb4);
		
		// Object-Chaining
		StringBuilder sb5 = new StringBuilder(5).append("Hallo").append("Hallo").reverse();
		System.out.println(sb5.capacity());
		sb5.trimToSize(); // Kürzen der capacity auf die tatsächliche Anzahl von Zeichen
		System.out.println(sb5.capacity());
		
		// Object-Chaining wird mit Instanzmethoden gemacht
		Period p = Period.of(2, 6, 2).plusDays(10).plusMonths(2); // P2Y8M12D
		System.out.println(p);
		
		// Statische Methoden
		// ofYears liefert ein Period Objekt, ofMonths benutzt das Objekt um die Klasse zu ermitteln
		// und wird statisch auf dieser Klasse aufgerufen.
		// Erg, ofYears wird für ofMonths nicht verwendet
		p = Period.ofYears(2).ofMonths(10);
		System.out.println(p);
		
		// Referenz ist in Java immer 4 bytes
		String[] arr = new String[100]; // Preis für die Referenzen: 404 bytes + Objektgröße auf dem Heap
		
		// int 32bit / 4 bytes
		int[] arr2 = new int[100];  // 404 bytes
		
		// long 64bit / 8 bytes
		long[] arr3 = new long[100];  // 804 bytes
		long[][] arr5 = new long[100][100];  // 80.004 bytes, mehr als 80kb
		
		Integer[] arr4 = new Integer[100];  // 404 bytes für die Referenzen + Objektgröße auf dem Heap
		
		System.out.println(arr4[200]); // Zur Laufzeit: ArrayIndexOutOfBoundsException
		
	}

}
