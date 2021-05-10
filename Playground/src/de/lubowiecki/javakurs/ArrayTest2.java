package de.lubowiecki.javakurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest2 {

	public static void main(String[] args) {
		
		// Nur bei gleichzeitiger Deklaration und Initialisierung
		int[] arr1 = {1,2,3}; // gleich die Werte vorgeben. Anzahl der Werte ist automatisch die Größe
		
		// arr1 = {2,3,4}; // Error
		arr1 = new int[]{2,3,4}; // Ok, mit Werten
		arr1 = new int[4]; // Ok, Leer
		//arr1 = new int[3]{2,3,4}; // Error. Entweder Leer oder mit Werten!
		
		arr1[0]++;
		arr1[0] += 10;
		
		int pos = 0;
		arr1[++pos] += 10;
		arr1[pos++] += 10;
		
		
		for(int i = 0; i < arr1.length;) {
			System.out.println(arr1[i++]);
		}
		
		int[] arr2 = new int[10]; // Größe wird vorgegeben. Inhalt: 10x 0
		boolean[] arr3 = new boolean[10]; // Inhalt: 10x false
		
		// Bei komplexen Datentypen ist der Stanbdardwert immer null
		Integer[] arr4 = new Integer[10]; // Inhalt: 10x null
		String[] arr5 = new String[10]; // Inhalt: 10x null
		
		System.out.println(arr5.length); // bei Array eine Eigenschaft
		
		// Arrays sind Objekt, daher gibt es für Arrays kein primitiv widening und kein Autoboxing
		
		Object o = arr1;
		//double[] arr6 = (double[]) o;
		int[] arr6 = (int[]) o;
		
		System.out.println();
		//Integer[] arr7 = (Integer[]) o;
		
		System.out.println();
		// Referenz erlaubt die Aufnahme aller Objekte
		// Das String-Array auf dem Heap erlaubt aber nur Strings
		Object[] objects = new String[10]; 
		objects[0] = "Moin";
		//objects[1] = 1; // ArrayStoreException
		
		//machWas(new String[] {"A", "B", "C"});
		
		
		int[] arr8, arr9[], arr10;
		
		System.out.println("---- Mehrdimensional ----");
		
		String[][] namen = {{"A","B"}, {"C","D","E"}};
		namen = new String[][]{{"A","B"}, {"C","D","E"},{"F"}};
		
		// Klasse Arrays bietet statische Methoden für Arrays
		
		String[] arr11 = {"C","D","E"};
		arr11 = Arrays.copyOf(arr11, arr11.length + 2); // copyOf ermittelt den Rückgabe-Typ aus dem Eingangsparameter
		
		for(String s : arr11) {
			System.out.println(s);
		}
		
		System.out.println();
		
		int[] ints = {10,22,17,1,8,12,39};
		showPrimitiveArray(ints);
		System.out.println(Arrays.binarySearch(ints, 15)); // Erg. nicht voraussehnbar
		
		Arrays.sort(ints);
		showPrimitiveArray(ints);
		
		// Array muss vor binarySearch sortiert werden
		// Zurückgegeben wird die Position
		// Wenn Wert nicht enthalten, dann Rückgabe voraussichtliche Position als Minuswert + -1
		System.out.println(Arrays.binarySearch(ints, 15));
		
		System.out.println();
		
		// Arrays.asList erzeugt eine Fix-Size Liste
		List<Integer> ints2 = Arrays.asList(1,2,5,7,9,20); // Aus den Werten wird eine Liste gebaut
		// ints2.add(15); // UnsupportedOperationException
		// ints2.remove(0); // UnsupportedOperationException
		ints2.set(3, 15);
		
		Integer[] arr12 = {1,2,5,7,9,20};
		ints2 = Arrays.asList(arr12); // Aus dem Array wird eine Liste gebaut
		
		System.out.println(arr12);
		
		System.out.println(Arrays.deepToString(arr12));
		
		System.out.println(Arrays.toString(arr12));
		
		// ints2 ist jetzt nicht mehr Fix-Sized
		ints2 = new ArrayList<>(Arrays.asList(1,2,5,7,9,20));
		
		String _1öä;
		
	}
	
	static void machWas(Object[] objects) {
		// Gefahr für ArrayStoreException
		
	}
	
	static void showArray(Object[] objects) {
		// enhanced loop
		// rechts: Menge: Array oder Collection
		// links: Variable, die auf das aktuelle Element zeigt 
		for(Object o : objects) {
			System.out.println(o);
		}
	}
	
	static void showPrimitiveArray(int[] werte) {
		//System.out.println(String.join(",", Arrays.asList(werte)));
		
		for(int e : werte) {
			System.out.print(e + ", ");
		}
		System.out.println();
	}

}
