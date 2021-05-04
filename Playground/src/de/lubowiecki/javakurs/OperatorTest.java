package de.lubowiecki.javakurs;

public class OperatorTest {

	public static void main(String[] args) {
		
		int i = 10;
		int j = i++; // Vormerkung für i bleibt erhalten, solange i nicht neu zugewisen wird
		System.out.println(j);
		System.out.println(i);
		
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
		
	}
}
