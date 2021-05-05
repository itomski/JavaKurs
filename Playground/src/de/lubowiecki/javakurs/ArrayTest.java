package de.lubowiecki.javakurs;

public class ArrayTest {
	
	static int a = 100;

	public static void main(String[] args) {
		
		// ArrayList: standard capacity 10
		// ArrayList: neue capacity = alte capacity * 3 / 2
		
		int y = 100; // Variable is in dem Block verfügbar, wo sie deklariert wurde und in allen Unter-Blöcken
		
		{
			int x = 0;
			x++;
			
			y++;
			
			
			int[] a = {1,2,3}; // diese Schreibweise nur bei gleichzeitiger deklaration und initialisierung möglich
			int[] b = new int[]{1,2,3}; // immer erelaubt
			
			//b = {1,2,3}; // diese Schreibweise nur bei gleichzeitiger deklaration und initialisierung möglich
			a = new int[]{1,2,3};
			
			int[] c;
			// c = {1,2,3}; // nicht erlaubt, da c variable bereits deklariert
			c = new int[]{1,2,3};
			
			// die in diesem Block deklarierten Variablen werden entfernt
		}
		
//		System.out.println(x);
		
		System.out.println(a); // statische variable wird angezeigt
		
//		for(int x =0; ;) {
//			x++;
//			int z = 0;
//			
//		}
		
		int array[][] = new int[2][]; //[null, null]
		array[1] = new int[3]; // [null, [0,0,0]]
		array[1][0] = 1; // [null, [1,0,0]]
		
		int array2[][] = new int[2][2]; //[[0,0], [0,0]]
		
		System.out.println("-----------------");
		
		// final bei Objekten bedautet die Referenz auf das Objekt im Heap darf nicht neu gesetzt werden
		// Zustand/Inhalt des Objekts kann sich ändern
		final int[] arr = new int[3];
		// arr = null; // Error: Änderung der Referenz
		//arr = new int[4]; // Error: Änderung der Referenz
		arr[1] = 7;
		arr[0] = 15;
		
		int a1 = 5; // arr2[0]
		int a2 = 15; // arr2[1]
		int a3 = 10; // arr2[2]
		
		int[] arr2 = {5,15,10};
		
		
	}

}
