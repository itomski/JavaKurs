package de.lubowiecki.javakurs;

import java.util.function.Predicate;

public class VererbungTest5 {

	public static void main(String[] args) {
		
		// NextBasicZeug Objekt wird als Bestandteil von NextZeug instanziert
		NextZeug nz = new NextZeug(); // Konstruktor von NextBasicZeug ruft die show Methode auf Objekt von NextZeug
		
		NextBasicZeug nbz = new NextBasicZeug(); // Konstruktor von NextBasicZeug ruft die eigne show Methode auf
		
		machWas(x -> x.startsWith("A"));
		machWas(new Axz());
	}
	
//	public static void machWas(Axz a) {
//		
//	}
	
	public static void machWas(Predicate<String> a) {
		
	}

}

class Axz implements Predicate<String> {

	@Override
	public boolean test(String t) {
		// TODO Auto-generated method stub
		return false;
	}
}


class NextBasicZeug {
	
	public int parentCount = 1;
	
	public NextBasicZeug() { // #1
		show(); // Wird hier show() aus der Kindklasse, währen der Instanzierung aufgerufen sind die Instanzvariablen des Kindobjektes noch
		// mit ihren Typ abhängigen Standardwerten belegt und erst nach diesem Konstruktor mit werten initialisiert 
	}
	
	public void show() {
		System.out.println("NextBasicZeug");
	}
}

class NextZeug extends NextBasicZeug {
	
	private int count = parentCount; // am anfang 0 und wenn der super-Konstruktor fertig ist mit wert von parentCount ersetzt
	
//	public NextZeug() {
//		super(); // Hier wird der Konstruktor der Elternklasse (#1) aufgerufen
//	}

	public void show() {
		System.out.println("NextZeug: " + count);
	}
}

// 1. Konstruktor von NextZeug wird aufgerufen
// 2. Eigenschaften werden erstmal mit Standardwerten belegt
// 3. Konstrutor der Elternklasse wird aufgerufen
// 4. Eigenschaften werden initialisiert

