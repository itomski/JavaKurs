package de.lubowiecki.javakurs.streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		
		// FILTER
		
		// genUser liefert ein Stream<User>
//		genUser(10_000)
//			.filter(u -> u.getFirstname().equals("Carol"))
//			.filter(u -> u.getBirthDate().isAfter(LocalDate.of(1970, 1, 1)))
//			.limit(100) // Es werden so lange User generiert bis 100 davon beide Filter mit true überstanden haben
//			.forEach(u -> System.out.println(u)); // generate > limit > filter > forEach
//		
//		System.out.println();
		
		long count = genUser(1_000)
		.filter(u -> u.getFirstname().equals("Carol"))
		.filter(u -> u.getBirthDate().isAfter(LocalDate.of(1970, 1, 1)))
		.count();
		
		System.out.println(count);
		System.out.println();
		
		Function<User, Map<String, String>> m1 = u -> {
				Map<String, String> m = new HashMap<>();
				m.put("fname", u.getFirstname());
				m.put("lname", u.getLastname());
				m.put("bdate", u.getBirthDate().toString());
				return m;
		};
		
		System.out.println();
		
		// MAP
		genUser(100)
				//.filter(u -> u.getFirstname().equals("Carol"))
				.filter(u -> u.getBirthDate().isAfter(LocalDate.of(1970, 1, 1)))
				//.mapToDouble(mapper) // User Objekt wird in ein double transformiert
				//.mapToInt(u -> u.getLastname().length()) // User Objekt wird in ein int transformiert
				//.mapToLong(mapper) // User Objekt wird in ein long transformiert
				.map(m1) //  map-Methode Änderung von komplex auf komplex. Wandelt User in HashMaps um. Kann eine Änderung des Objektes sein oder ein ganz neuer Typ
				.forEach(m -> System.out.println(m.getOrDefault("fname", "Unbekannt")));
		
		
		System.out.println();
		
		
		// FLATMAP
		Stream<String> stadt = Stream.of("Berlin", "Hamburg", "Köln", "Flensburg", "München");
		stadt.flatMap(s -> Arrays.stream(s.split("") /* Stadtname wir in ein Stream von Buchstaben umgewandelt */))
			 //.forEach(System.out::println); // der zweidemensionale Stream wird auf eine dimension flach gedrückt
			 .forEach(s -> System.out.println(s + "...")); // Bei einer Methoden-Referenz ist eine Anpassung des Parameters (z.B. Verbinden mit "...") nicht möglich
		
		// System.out::println ist eine Methodenreferenz. Statt ein Lambda-Ausdrück vorzugeben, kann man eine Referenz auf eine Methode
		// vorgeben, die das gleiche bereits implementiert
		
		//String[][] st = {{"K","ö", "l", "n"}, {"U", "l", "m"}};
		
		System.out.println();
		
		IntStream zahlen = IntStream.of(1,2,3,4,5,6,7,8,9,10);
		
		// PEEK - Gut für's Debugging
		// parallel() heißt, mehrere Threads (leichtgewichtige Prozesse / Sub-Prozesse) verarbeiten den Stream
		zahlen.parallel().peek(i -> System.out.print("#" + i + " ")) // Verlangt einen Consumer, kann aber das Objekt nicht dauerhaft ändern
			  .filter(i -> i > 5) // 1,2,3,4 und 5 werden rausgefiltert
			  .peek(i -> System.out.print("@" + i + " ")) // hier kommen nur 6 oder höher an
			  .map(i -> i * i)
			  .filter(i -> i <= 80) // alle ergebnisse über 80 werden rausgefiltert
			  .peek(i -> System.out.print("$" + i + " "))
			  .forEach(i -> System.out.print("?" + i + " "));
		
		
		System.out.println();
		
		zahlen = IntStream.of(1,2,3,4,5,6,7,8,9,10);
		
		// Ohne peek sieht man nur das Endergebnis
		zahlen // Quelle als Stream
			  .filter(i -> i > 5) // Intermediate Op
			  .map(i -> i * i) // Intermediate Op
			  .filter(i -> i <= 80) // Intermediate Op
			  .forEach(i -> System.out.print(i + " ")); // Terminal Op: Ohne Terminal-Op findet keine Verarbeitung statt
		
		
	}
	
	public static Stream<User> genUser(int num) {
		
		String[] firstname = {"Peter", "Carol", "Natasha", "Anna", "Tony", "Steve", "Bruce"};
		String[] lastname = {"Parker", "Müller", "Hansen", "Petersen", "Rogers", "Stark", "Banner"};
		
		// Supplier<T>: T get();
		// Supplier<User>: User get();
		
		Random rand = new Random();
		
		Supplier<User> uSup = () -> new User(firstname[rand.nextInt(7)], lastname[rand.nextInt(7)], LocalDate.of(rand.nextInt(100) + 1900, rand.nextInt(12) + 1, rand.nextInt(28) + 1));
		//Stream<User> users = Stream.generate(uSup);
		//return users.limit(num);
		
		return Stream.generate(uSup).limit(num);
	}

}
