package de.lubowiecki.javakurs;

public class WrapperTest2 {

	public static void main(String[] args) {
		
		// Autoboxing nur von primitiv zu Wrapper
		// AutoUnBoxing nur von Wrapper zu primitiv
		
		// primitive widening: vom primitiv zu primitiv, kleineren typ zu größeren typ
		// primitive narrowing: vom primitiv zu primitiv, größeren zu kleinerer typ, nur mit Cast
		
		// komplex widening: Komplex zu Komplex, von Kindklasse zu Elternklasse
		// komplex narrowing: Komplex zu Komplex, von Elternklasse zu Kindklasse, nur mit Cast 
		
		Boolean b = true; // Autoboxing
		boolean b2 = b; // AutoUnBoxing
		
		Double d;
		//d = 100; // 1. Autoboxing (int zu Integer), 2. Widening (Integer zu Double, Error)
		d = (double) 100; // 1. Autoboxing (double zu Double)
		Number n = 100; // 1. Autoboxing, , 2. Widening (Integer zu Number, OK)

		int i;
		//i = d; // 2. AutoUnBoxing (Double zu double), 2. Narrowing (double zu int, Error)
		//i = (int) d; // Cast von Double auf int, Error
		i = d.intValue();
		
		Integer j = 10;
		double d2 = j; // 2. Autounboxing (Integer zu int), 2. Widening (int zu double, OK)
		
		Object o = "Hallo"; // komplex Widening
		String s;
		//s = o; // komplex Narrowing (geht nicht automatisch), Cast möglich
		s = (String) o; // Wenn o auf dem Heap kein String ist, dann ClassCastException
		
		System.out.println();
		
		int k = 100; // primitive bieten KEINE Methoden an
		Integer m = 100;
		
		System.out.println(m.equals(j)); // Inhaltsvergleich 
		System.out.println(m == j); // Referenzvergleich, da m und j komplex sind 
		System.out.println(i == j); // Inhaltsvergleich, j wird zu primitiv 
		
		// Alle Klassen in  der Java-Bibliothek haben eine eigene equals Implementierung
		// equals sollte nur in eigenen Klassen überschrieben werden
		
		Abc a1 = new Abc();
		Abc a2 = new Abc();
		a1.equals(a2); // equals von Object wird verwendet
		// wenn equals nicht überschrieben wird, dann funktioniert es gleich wie ==
		// wenn equals überschrieben wird, dann sollte zusammen auch hashCode überschrieben werden
		
	}
}

class Abc {
	
}