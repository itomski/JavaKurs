package de.lubowiecki.javakurs;

public class OperatorTest {

	public static void main(String[] args) {
		
		int i = 10;
		int j = i++; // Vormerkung für i bleibt erhalten, solange i nicht neu zugewisen wird
		System.out.println(j);
		System.out.println(i);
		
		if(i == 100)
			return; // Bricht die Methode ab. Anweisungen dahinter sind nicht mehr erreichbar
		
		i = i++; // Vermerkung für Erhöhung geht verloren
		System.out.println(i);
		
		System.out.println();
		
		i = 10;
		j = ++i;
		System.out.println(j);
		System.out.println(i);
		
		System.out.println();
		
		byte b = 100;
//		char c = 1_000_000;
//		System.out.println(c);
		
		
		//System.out.println("A" + 2 * 3 - 5);
		//System.out.println("A6" - 5);
		
		// increment/dekrement und zusammengestzte Operatoren nur auf Variablen
		int x; // Lokale Variablemen bekommen keine Standardwerte
		//System.out.println(1 - --x + 3); // Error: x ist NICHT initialisiert
		
		int k = 0; // 1 / 11 / 12
		int m = 10;
		k = ++k;
		k = k++ + m; // 1 + 10, postfix wird vergessen
		System.out.println(++k);
		
		System.out.println("-------------");
		
		int y = 10;
		
		// short circuite d.h. Aktion wird abgebrochen, wenn das Ergebnis feststeht
		if(y > 20 && --y > 10); // Rechte Seite der Bedingung wird nur ausgeführt, wenn die linke true ergibt
		
		// NICHT short circuite
		if(y > 20 & --y > 10); // Beide Seite der Bedingung werden IMMER ausgeführt
		
		// short circuite
		if(y > 20 || y > 10); // Rechte Seite der Bedingung wird nur ausgeführt, wenn die linke false ergibt
		
		// NICHT short circuite
		if(y > 20 | --y > 10);
		
		System.out.println(y);
		
		byte i2 = 1;
		i2++; // i2 = (byte)(i2 + 1)
		i2 += 2; // i2 = (byte)(i2 + 2)
		
		i2 = (byte) (i2 + 1); // Compiler-Error, Cast auf byte nötig
		
		
		Integer i3 = 10;
		Integer i4 = 10;
		
		System.out.println(i3 == i4); // Referenzvergleich
		System.out.println(i3 < i4);
		System.out.println(i3 > i4);
		
		i3 += 7; // i3 = (Integer)(i3 + 7);
		
		
		System.out.println("--- Variablen --");
		
		boolean b2 = false;
		
		while(b2) { // Auswertung erfolgt erst zur Laufzeit
			System.out.println("Moin");
		}
		
		
		boolean b3 = true;
		
//		while(b3) { // Auswertung erfolgt erst zur Laufzeit
//		}
//		System.out.println("Moin");
		
		
		System.out.println("--- KONSTANTEN --");
		
		// Compile-Time Konstanten
		final boolean b4 = false;
		
//		while(b4) { // Auswertung erfolgt bereits zur Compilezeit, b4 wird durch false ersetzt
//			System.out.println("Moin");
//		}
		
		// Runtime-Time Konstanten
		final boolean b5;
		b5 = true; // Initialisierung erfolgt erst zur Laufzeit
		
//		while(b5) { // Auswertung erfolgt erst zur Laufzeit
//		}
//		System.out.println("Moin");
		
		
		System.out.println("--- LITERALE --");
		
//		while(false) { // Auswertung erfolgt bereits zur Compilezeit
//			System.out.println("Moin");
//		}
//		
//		while(true) { // Auswertung erfolgt bereits zur Compilezeit
//			// Nur erlaubt, wenn eine Möglichkeit für das Verlassen der Schleife existiert
//		}
//		System.out.println("Moin");
		
//		for(;; System.out.println(10)) { // endless, letzter Block ist eine Anweisung
//		}
		
		int[] arr3 = {1,2,3,4,5};
		int zahl = 0;
//		for(zahl : arr3) { // Laufvariable darf bei diesm Loop NICHT außerhalb der Klammern definiert werden
//		}
		
		
	}
}
