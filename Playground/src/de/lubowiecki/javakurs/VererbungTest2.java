package de.lubowiecki.javakurs;

public class VererbungTest2 {

	public static void main(String[] args) {
		
		// jedes B ist ein A
		A a = new B(); // B IS-A A
		
		// Aber nicht jedes A istr ein B
		//B b = new A(); // Kompiler-Error A IS-NOT B
		
		// Über eine Referenz von A sehen ich nur den Teil von B, den A beschreibt
		// Die Referenz beschreibt die Sichtbarkeit, Methoden werden aber trotzdem auf dem B aufgerufen
		System.out.println(a.calc(10, 10));
		
		
		// links: Referenztyp, entscheidet was sichtbar ist
		// rechts: Objekttyp, entscheidet auf welchem Objekt die Aufrufe erfolgen
		
		B b = new B();
		// Über eine Referenz von B sehe ich alles was B bereitstellt
		System.out.println(b.calc(10.0, 10.0));
		System.out.println(b.calc(10, 10));
		
		
		// Student extends Mensch
		// jeder Student ist ein Mensch
		// Nicht jeder Mensch ist ein Student
				
		//Mensch m = new Student(); // OK: jeder Student ist ein Mensch
		// Über eine Mensch Referenz ist nur das sichtbar, was alle Menschen gemeinsam haben
		
		final StringBuilder sb = new StringBuilder();
		sb.append("Hallo"); // Ok: Änderung des Zustandes
		//sb = new StringBuilder(); // Nicht ok: Änderung der Referenz
		
		final int i = 100;
		// i = 101; // primitive final Variablen dürfen sich nicht ändern
		
		machWas(100);
		machWasAnderes(sb);
		
	}
	
	public static void machWas(final int i) {
		// i darf sich in dieser Methode nicht ändern
	}
	
	public static void machWasAnderes(final StringBuilder sb) {
		// sb darf nicht neu zugewiesen werden, darf aber seinen Zustand ändern
	}
}

class A {
	
	public int calc(int a, int b) {
		System.out.println("A int");
		return a + b;
	}
	
}

class B extends A {
	
	//public B() { // Default-Konstruktor
		//super(); // Es wird ein Objekt der Elternklasse (A) erzeugt
		// Und dann mit dem Inventar von B erweitert
	//}
	
	public double calc(double a, double b) {
		System.out.println("B double");
		return a + b;
	}
	
//	@Override // Die geerbte Methode von A wird durch eine neue Version ersetzt
//	public int calc(int a, int b) {
//		System.out.println("B int");
//		return a + b;
//	}
	
}
