package de.lubowiecki.javakurs;

public class InterfaceTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface Ix1 {
	int zahl = 100;
	
	default void doSomething() {
		System.out.println("i1");
	}
}

interface Ix2 {
	int zahl = 200;
	
	default void doSomething() {
		System.out.println("i2");
	}
}

class TestClass implements Ix1, Ix2 {
	
	// Überlagern der geerbten Eigenschaft
	int zahl = 300;
	
	public void machWas() {
		// Werden von zwei Interfaces Eigenschaften mit dem gleichen namen vererbt, muss die erbende Klasse
		// diese vor der Verwendung der Eigenschaft diese überlagern, da ansonsten ein Namens-Konflikt besteht
		System.out.println(zahl);
		
	}
	
	// Werden von zwei Interfaces default Methoden mit gleicher Signatur vererbt, muss die erbende Klasse
	// diese Methoden überschreiben, da ansonsten Methoden-Konflikt besteht
	public void doSomething() {
		System.out.println("TestClass");
	}
}
