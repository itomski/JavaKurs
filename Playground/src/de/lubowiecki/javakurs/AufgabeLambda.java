package de.lubowiecki.javakurs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.function.Predicate;

public class AufgabeLambda {

	public static void main(String[] args) {
		// baue 10 Lambda-Ausdrücke, die zu den nachfolgenden FunctionalInterfaces passen
		
		// I1
		// boolean test(int a, int b);
		
		I1 i1_1 = (x, y) -> x == y;
		I1 i1_2 = (x, y) -> x < 10 && y > 20;
		I1 i1_3 = (x, y) -> true;
		
		// I2
		// void show(String s);
		I2 i2_1 = (s) -> System.out.println(s);
		I2 i2_2 = (s) -> {
			s += "...";
		};
		
		// I3<T>
		// void test(T a, T b);
		I3<String> i3_1 = (s1, s2) -> System.out.println(s1.concat(s2));
		I3<Integer> i3_2 = (s1, s2) -> System.out.println((s1 + s2) < Integer.MAX_VALUE);
		
		// I4<T>
		// void show(T s);
		I4<LocalTime> i4_1 = (s1) -> System.out.println(LocalTime.now());
		I4<Student> i4_2 = (s1) -> System.out.println(s1); // toString von Student wird verwendet
		
		// String produce();
		I5 i5_1 = () -> "Moin!";
		
		I6<Integer> i6_1 = () -> (int)(Math.random() * 6) + 1;
		
//		while(true) {
//			System.out.println(i6_1.produce());
//		}
		
		// 5 Lambda-Ausdrücke für das Predicate. Verwende dabei Unterschiedliche generische Typen
		
		// Predicate<T>
		// boolean test(T t);
		Predicate<String> p1 = w -> w.startsWith("A");
		
		Predicate<Integer> p2 = w -> w.doubleValue() * 5 < 100;
		
		Predicate<Student> p3 = w -> w.getBirthdate().isBefore(LocalDate.now());
		
		int j;
		j = 100; // Muss keine Kompiletime-Konstante sein
		// j = 20; // j (lokale Variable) darf nicht verändert werden: muss final oder effektiv final sein
		Predicate<Integer> p4 = w -> w < j;
		
		Predicate p5 = w -> true; // w ist ein Object
		
		p5.test("Moin");
		p5.test(120);
		p5.test(new Student("A", "B", LocalDate.now()));
		
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

interface I6<T> {
	T produce();
}