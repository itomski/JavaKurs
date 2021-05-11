package de.lubowiecki.javakurs;

import java.util.ArrayList;
import java.util.List;

public class SchleifenTest {

	public static void main(String[] args) {
		
		List<Integer> zahlen = new ArrayList<>();
		
		while(!zahlen.isEmpty()) {
			
		}
		
		for(;!zahlen.isEmpty();) {
			
		}
		
		for(int i = 0; i < 10; i++) {
			
		}
		
		int i = 0;
		while(i < 10) {
			i++;
		}
		
		for(int j = 0; j < 100; System.out.println("Moin")) 
			j++; 
		
		{
			
		}
		
		
		// Laufvariable (j) MUSS innerhalb der for-Klammern deklariert werden
		for(int j : zahlen) {
			
		}
		
		int[][] zahlenMatrix = new int[5][5];
		
		for(int[] j : zahlenMatrix) {
			for(int k : j) {
				
			}
		}
		
		for(int j : new int[]{1,2,3,4,5,6}) {
			
			break; // Bricht die Kontrollstruktur ab (for, while, do-while, switch)
			// continue; // Springt zum nächsten Durchlauf der Schleife (for, while, do-while)
		}
		
		// lab ist ein Label
		lab: for(int[] j : zahlenMatrix) {
			
			for(int k : j) {
				// break / continue beziehen sich immer auf die Struktur, die ihnen am nächsten ist
				//break / continue mit label können auchg andere Strukturen ansprechen
				break lab;
			}
		}
		
//		01010
//		10100
//		10 & 20; // 0
		
		int x = 10;
		x &= 20; 
		// x = 0
		
		int z;
		{
			z = 10;
		}
		System.out.println(z);
		
		boolean b = true;
		if(b = false) { // Bei boolean ist eine Zuweisung auch im if möglich, weil b einen boolischen Inhalt hat
			
		}
		System.out.println(b);
		
		
	}

}
