package de.lubowiecki.javakurs;

public class AufgabeLambda {

	public static void main(String[] args) {
		// baue 10 Lambda-Ausdrücke, die zu den nachfolgenden FunctionalInterfaces passen
		
		// 5 Lambda-Ausdrücke für das Predicate. Verende dabei Unterschiedliche generische Typen
		
	}
}

// abstrakte Klassen dürfen NICHT als FunctionalInterfaces benutzt werden

// Normales implementieren
class IC2 implements I1 {
	public boolean test(int a, int b) {
		return true;
	}
}

interface Ix { // Kein FunctionalInterface, da es mehr als eine abstrakte Methode gibt
	
	boolean test(int a, int b);
	
	boolean test(int a);
}


// Interfaces für die Aufgabe
@FunctionalInterface
interface I1 {
	boolean test(int a, int b);
	
	@Override
	String toString(); // Alle Methoden von Object werden nicht als abstrakte Methoden mitgezählt, da sie bereits in Object implementiert sind
	// Sie müssen späeter auch nicht implementiert werden
	// Object-Methoden: toString, hashCode, equals, wait, notify, notifyAll 
	
	@Override
	int hashCode(); // Für FunctionalInterface neutral
}

@FunctionalInterface
interface I2 {
	void show(String s);
}

// Annotaion ist optional
interface I3<T> {
	void test(T a, T b);
}

@FunctionalInterface
interface I4<T> {
	void show(T s);
	
	// Kann beliebig viele default und static Methoden haben
	// Aber nur eine einzige abstrakte Methode
}

interface I5 {
	String produce();
}