package de.lubowiecki.javakurs;

public class VererbungTest4 {

	public static void main(String[] args) {
		
		AAAA b1 = new BBBB(); // BBBB IS-A AAAA
		System.out.println(b1.a); // Eigenschaften werden auf der Referenz aufgerufen
		System.out.println(b1.getA()); // Instanz-Methoden werden IMMER auf dem Objekttyp aufgerufen
		
		System.out.println();
		
		BBBB b2 = (BBBB) b1;
		System.out.println(b2.a); // Eigenschaften werden auf der Referenz aufgerufen
		System.out.println(b2.getA()); // Instanz-Methoden werden IMMER auf dem Objekttyp aufgerufen
		

		System.out.println(b2.a + " " + b2.getA());
		// System.out.println(10 + " " + 20); // zuvor Ausgabe aus 38
		
	}
}

class AAAA {
	
	public int a = 10;

	public int getA() {
		System.out.println("AAAA");
		return a;
	}	
}

class BBBB extends AAAA {
	public int a = 20;
	
	public int getA() {
		System.out.println("BBBB");
		return a;
	}
}
