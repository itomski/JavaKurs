package de.lubowiecki.javakurs;

public class VarArgTest {
	
	// Überladen - wird nicht als Startmethode benutzt
	public static void main(String a) {
	}
	
	// ECHTE Main-Methode muss ein String Array oder String VarArgs aufnehmen
	public static void main(String[] butterbrot) {
		
		machWasAnderes(); // VarArg
		machWasAnderes(1); // INT
		machWasAnderes(1,2); // VarArg
		machWasAnderes(new int[] {1,2,3}); // VarArg
			
	}

	// i ist ein Pflichtparameter
	static void machWasAnderes(int i) {
		System.out.println("INT");
		System.out.println(i);
	}
	
//	static void machWasAnderes(int[] i) {
//		System.out.println("Array");
//		// i ist ein Array von ints
//		for(int zahl : i) {
//			System.out.println(zahl);
//		}
//	}
		
	static void machWasAnderes(int... i) {
		System.out.println("VarArg");
		// i ist ein Array von ints
		for(int zahl : i) {
			System.out.println(zahl);
		}
	}
	
	// VarArgs müssen immer letzter Parameter in der Parameterliste sein
	// d.h. max 1x VarArg pro Parameterliste
//	static void machWasAnderes(int... i, double...d) {
//		System.out.println("VarArg");
//		// i ist ein Array von ints
//		for(int zahl : i) {
//			System.out.println(zahl);
//		}
//	}
}
