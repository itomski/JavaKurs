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
		
	}
}
