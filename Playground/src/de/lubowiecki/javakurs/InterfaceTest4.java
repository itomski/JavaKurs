package de.lubowiecki.javakurs;

public class InterfaceTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

interface IC extends IA {
	
}

interface IA {
	default void machWas() {
		System.out.println("A");
	}
}

interface IB {
	default void machWas() {
		System.out.println("A");
	}
	
	// Error: Interfaces dürfen keine Default-Implementierungen für Methoden von Object haben
//	default String toString() {  
//		return "";
//	}
	
	@Override
	String toString(); // Methode ist bereits in Object definiert, daher muss sie nicht implementiert werden
}

class C implements IA, IB {
	
	@Override
	public void machWas() {
		System.out.println("C");
	}
	
}
