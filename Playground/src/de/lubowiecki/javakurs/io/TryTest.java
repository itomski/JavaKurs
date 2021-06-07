package de.lubowiecki.javakurs.io;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TryTest {

	public static void main(String[] args) {
		
		// bei normalen try muss ein catch oder ein finally oder beides folgen
		try {
			MyResource r = new MyResource();
			
			r.close(); // Resource muss geschlossen werden
		}
		finally {
			// brauch ich eigentlich nicht, aber es muss catch oder finally auf try folgen
		}
		
		
		// bei try-with-resources muss ist catch und finall optional (wenn die verwendeten Methoden kein throws mit checked Exceptions haben)
		try(MyResource r = new MyResource()) {
			
			// automatisch wird die r mit der close-Methode geschlossen
		}
		
		//void accept(T t);
		Consumer<String> htmlCons = (s) -> System.out.println("<h1>" + s.toUpperCase() + "</h1>");
		htmlCons.accept("Hallo Welt");
		
		System.out.println("----------");
		
		// Arrays.asList produziert eine fix-size Liste
		List<String> list = Arrays.asList("Kochen ohne Fett", "Backen ohn e Mehl", "Schneiden ohne Messer");
		list.forEach(htmlCons);
		
		// Error, da fix-size
		list.removeIf(s -> s.length() < 20);
		
		System.out.println(list);
		
//		Predicate: test
//		Consumer: accept
//		
//		Function: apply
//		Supplier: get
		
		
	}
}

class MyResource implements AutoCloseable {

	@Override
	public void close() { // sobald hier eine Checked-Exception geworfen werden kann, muss das try ein catch bekommen
		
	}
}
