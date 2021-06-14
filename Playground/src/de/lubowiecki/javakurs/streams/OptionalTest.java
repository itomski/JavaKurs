package de.lubowiecki.javakurs.streams;

import java.util.Optional;

public class OptionalTest {
	
	public static void main(String[] args) {
		
		// Seit Java 7 Standard für optionale Werte/Rückgaben
		
		Optional<String> op = Optional.of("Hallo");
		
		System.out.println(op.get()); // Optional wird ausgepackt
		
		op = Optional.empty(); // Liefert ein leeres Optional zurück
		//System.out.println(op.get()); // Exception wenn leer
		System.out.println(op.orElse("Leer")); // Wenn null dann wir eine Alternative verwendet
		
		// Erwartet einen Supplier
		// Wenn leer dann wird der Supplier verwendet um eine ALternative zu erzeugen
		System.out.println(op.orElseGet(() -> "Supplier"));
		
		
		try {
			// Wenn leer dann wird eine Exception geworfen
			System.out.println(op.orElseThrow(() -> new RuntimeException("Grrrr")));
		}
		catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		if(op.isPresent()) { // ist ein Inhalt vorhanden?
			System.out.println(op.get());
		}
		
		op.ifPresent(System.out::println); // Der Consumer wird nur aufgerufen, wenn OIptional nicht leer ist
		
	}

}
