package de.lubowiecki.javakurs;

public class InterfaceTest {
	
	public static void main(String[] args) {
		
		CX cx = new CX();
		System.out.println(cx.zahl); // Static Eigenschaften des Interface werden vererbt
		//cx.machWas(); // ERROR: Static Methoden des Interface werden nicht vererbt
		X.machWas(); // Aufruf der Methode muss direkt auf dem Interface erfolgen
		
		CY cy = new CY();
		System.out.println(cy.zahl); // Static Eigenschaften des Class werden vererbt
		cy.machWas(); // Static Methoden der Klasse werden vererbt
		
	}
}

interface X {
	
	// public static final per default
	int zahl = 10;
	
	// public per default
	static void machWas() {
		System.out.println("INTERFACE");
	}
}

class Y {
	
	public static final int zahl = 10;
	
	public static void machWas() {
		System.out.println("CLASS");
	}
}

class CX implements X {
}

class CY extends Y {
}