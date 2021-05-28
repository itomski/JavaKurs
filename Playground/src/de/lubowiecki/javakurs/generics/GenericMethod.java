package de.lubowiecki.javakurs.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethod {
	
	
	public static void main(String[] args) {
		
		String s = machWas("Hallo");
		int i = machWas(123);
		
		List<Integer> zahlen = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		Object[] objs = zahlen.toArray();
		
		Integer[] ints = zahlen.toArray(new Integer[0]); // Größe des Eigang-Arrays ist irrelevant, der Typ ist wichtig
		
		String[] namen = zahlen.toArray(new String[0]);
	}
	
	// <T> die Methode definiert einen eigenen Platzhalter
	// <T> stellt den Platzhalter vor, der gleich als Rückgabetyp oder Parameter nutzbar ist
	// Platzhalter kann für Eingangsparameter oder als Rückgabetyp verwendet werden
	public static <T> T machWas(T s) {
		return null;
	}
	
	public static <T,U> U machWasAnderes(T p1, U p2) {
		return null;
	}
}
