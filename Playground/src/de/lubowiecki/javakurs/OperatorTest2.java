package de.lubowiecki.javakurs;

import java.util.ArrayList;

public class OperatorTest2 {

	public static void main(String[] args) {
		
		// ++x prefix increment
		// x++ postfix increment
		// --x prefix decrement
		// x-- postfix decrement
		
		
		int x = 3;
		int y = ++x * 5 / x-- + --x; // bei x-- wird sofort eine Vormerkung für spätere Änderung gesetzt
		// ++x: 4 * 5 / 4 + 2
		System.out.println(y);
		
		x = 3;
		y = ++x; // Keine Vormerkung, da die Erhöhung sofort erfolgt
		System.out.println(y);
		
		x = 3;
		y = x++; // Vormerkung für spätere Änderung (Änderung an x erfolgt nach der Zuweisung)
		System.out.println(y);
		
		x = 3;
		System.out.println(x-- + --x); // 3 + (1.postfix)(2. prefix)3
		
		x = 0;
		
		// 0 + 1 + 2 // letztes postfix ist erst nach der Ausgabe dran
		// postfix wird immer vor der nächsten Aktion auf der gleichen Variable ausgeführt
		System.out.println(x++ + ++x); // das postfix wird vor dem prefix ausgeführt
		System.out.println(++x + x++); // Vormerkung für die Änderung für das postfix als erstes
		
		x = 0;
		x++;
		x++;
		x++;
		System.out.println(x);
		
		x = 0;
		++x;
		++x;
		++x;
		System.out.println(x);
		
		System.out.println();
		
		for(int i = 0; i < 10; ++i) {
			System.out.println(i);
		}
		
		System.out.println();
		
		for(int i = 0; i < 10;) {
			System.out.println(i++); // Erst Ausgeben, dann ändern
			System.out.println(++i); // ändern, dann Ausgeben
		}
		
		x = x++; // Vormerkung wird überschrieben, daher die Variable nachträglich NICHT geändert
		
		Object s = "";
		
		System.out.println();
		
		System.out.println(s instanceof String); // IS-A
		System.out.println(s instanceof CharSequence); // IS-A, String und StringBuilder implementieren die CharSequence
		System.out.println(s instanceof Object); // IS-A
		System.out.println(s instanceof Integer); // IS-A
		
		{
			//...
		}
		
		// Object.class // Ist ein Objekt, dass die Klasse Objekt beschriebt
		
		ArrayList list = null; // Statische Methoden werden im Speicher hinterlegt
		
	}

}
