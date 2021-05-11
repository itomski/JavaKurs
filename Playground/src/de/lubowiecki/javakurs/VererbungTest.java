package de.lubowiecki.javakurs;

import java.io.IOException;

public class VererbungTest {

	public static void main(String[] args) {
		
		Hammer h = new Hammer();
		h.execute(); // Hammer
		
		System.out.println(h.weight); // 10.0 von Hammer
		
		System.out.println(h.name);
		h.doIt();
		
		System.out.println();
		
		// links: Referenztyp
		// rechts: Objekttyp (Typ auf dem Heap))
		Tool t = new Hammer();
		t.execute(); // Instanz-Methoden werden IMMER auf dem Objekttyp ausgeführt - Hammer
		// Die Methoden verwenden die Variablen des Objekttyps
		
		// Methoden und Eigenschaften der Kindklasse sind über die Referenz der Elternklasse NICHT sichtbar!
		//System.out.println(t.name); // Kompilererror
		//t.doIt(); // Kompilererror
		
		
		// Für Eigenschaften gibt es keine Polymorphie
		// Aufruf der Instanzeigenschaften erfolgt auf dem Referenztyp
		System.out.println(t.weight); // 0.0 von Tool
		
		System.out.println();
		
		// Geerbte und NICHT überschriebene Instanz-Methoden verwenden die Eigenschaften der Klasse, wo sie definiert sind
		h.showWeight(); // Ref. Hammer, Methode ist nicht in Hammer definiert, wird auf Tool ausgefüht
		
		t.showWeight(); // Ref. Tool, Methode ist in der Klasse verfügbar und nutzt die eigene Eigenschaft
		
		
		System.out.println();
		
		// Statische Methoden und Eigenschaften werden IMMER auf dem Referenztyp ausgeführt
		h.staticExecute(); // Hammer.staticExecute()
		t.staticExecute(); // Tool.staticExecute()
		System.out.println(h.sWeight); // Hammer.sWeight
		System.out.println(t.sWeight); // Tool.sWeight
		
		// Statische Methoden dürfen nicht als Instanz-Methoden in der Kindklasse überschrieben werden
		// Instanz-Methoden dürfen nicht als Statische Methoden in der Kindklasse überschrieben werden
		// Für Eigenschaften gilt diese Regel nicht. Eigenschaften werden NICHT überschrieben, sondern nur
		// Überlagert (versteckt)
		
		CharSequence cs = "";
		
		
	}
	
	public VererbungTest() {
		// super // Eine Referenz auf ein Objekt der Elternklasse
	}

}


// Kindklasse hat Zugriff auf (nicht private) Eigenschaften und Methoden der Elternklasse
// Elternklasse hat KEINEN Zugriff auf Eigenschaften und Methoden der Kindklasse

class Tool {
	
	double weight;
	static double sWeight;
	
//	public Tool(int i) {
//	}
	
	public void execute() {
		System.out.println("execute (Tool): " + weight);
	}
	
	// Ruft die Eigenschaft im eigenen Umfeld
	public void showWeight() {
		System.out.println("showWeight(Tool): " + weight);
	}
	
	public static void staticExecute() {
		System.out.println("static execute (Tool)");
	}
	
	public Object doIt() {
		System.out.println("doIt (Tool)");
		return 1;
	}
}

class Hammer extends Tool {
	
	public Hammer() {
		// Falls die Elternklasse keine Konstruktor definiert, wird hier der Default-Konstruktor verwendet
		// Falls ein Parameterloser-Konstruktor in der Elternklasse existiert, wird dieser verwendet
		super(); 
	}
	
	static double weight = 10.0; // hiding, überlagert das weight aus der Elternklasse
	String name = "Hammer";
	
	static double sWeight = 20.0;
	
	@Override
	public void execute() {
		// Die Methode sucht die Eigenschaft in ihrer nähe (gleiche Klasse)
		// Falls nicht vorhanden, wird die Eigenschaft in der Elternklasse gesucht
		System.out.println("execute (Hammer): " + weight);
		
		int weight = 20;
		
		System.out.println(this.weight); // Das eigene weight wird verwendet 
		System.out.println(super.weight); // Das weight aus dem Elternobjekt wird verwendet 
		this.doIt(); // Das eigene doIt wird verwendet
		doIt(); // Ist gleich wie this.doIt()
		super.doIt(); // Das doIt aus dem Elternobjekt wird verwendet 
	}
	
	public static void staticExecute() {
		System.out.println("static execute (Hammer):");
	}
	
	// primitive Datentypen als Rückgabe-Typen müssen beim Überschreiben gleich bleiben
	// CoVarianz gibt es nur für komplexe Datentypen
	public Integer doIt() { // Integer IS-A Object
		System.out.println("doIt (Hammer)");
		return 2;
	}
}
