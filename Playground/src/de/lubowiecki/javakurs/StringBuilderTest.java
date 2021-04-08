package de.lubowiecki.javakurs;

public class StringBuilderTest {

	public static void main(String[] args) {
		
		// Veränderbare Zeichenkette
		StringBuilder sb = new StringBuilder("..."); // Startkapazität: Anzahl Zeichen + 16
		System.out.println(sb.length() + " " + sb.capacity());
		sb.append("Das ist ein");
		System.out.println(sb.length() + " " + sb.capacity());
		sb.append(" Haus von Niki");
		System.out.println(sb.length() + " " + sb.capacity());
		// Vergrößerung: aktuelle Kapazität * 2 + 2
		sb.append("graus... das ist ein cooler Typ");
		System.out.println(sb.length() + " " + sb.capacity());
		
		System.out.println("--------");
		
		StringBuilder sb2 = new StringBuilder(100); // Startkapazität: wird vorgegeben
		System.out.println(sb2.length() + " " + sb2.capacity());
		for(int i = 0; i < 101; i++) {
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
	}

}
