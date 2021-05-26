package de.lubowiecki.termine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Verwaltung {

	private Scanner scanner = new Scanner(System.in);
	
	private String FILE = "data.ser";
	
	private Set<Termin> termine;
	
	public void start() {
		
		// In Datei gespeicherte Objekte werden gelesen und als Set in termine abgelegt
		if(!readFromFile()) {
			System.out.println("Altdaten konnten nicht gelesen werden.");
		}
		
		app: while(true) {
			System.out.print("Eingabe: ");
			
			switch(scanner.nextLine().trim().toLowerCase()) {
				
				case "n": 
					System.out.println("Neu");
					System.out.print("Beschreibung: "); 
					Termin termin = new Termin(scanner.nextLine());
					termine.add(termin);
					break;
					
				case "l": 
					System.out.println("Liste:");
					if(termine.isEmpty()) {
						System.out.println("Keine Termine vorhanden.");
					}
					else {
						termine.forEach(t -> System.out.println(t));
					}
					break;
					
				case "q": 
					break app;	
					
				default:
					System.out.println("Falsche Eingabe.");
					
			}
		}
		
		// Das termine-Set inkl. Inhalt wird in die Datei gespeichert 
		if(!saveToFile()) {
			System.out.println("Daten konnten nicht gespeichert werden.");
		}
		System.out.println("Programmende");
	}
	
	private boolean saveToFile() {
		
		// Speichert Objekt in Dateien
		// Snippet
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE)); // Verbindung (Schrei-Zugriff) zur Datei wird geöffnet
			out.writeObject(termine); // termine-Set wird in Text umgewandelt und in eine Datei geschrieben
			out.close(); // Verbindung zur Datei wird geschlossen
			return true;
		}
		catch (IOException e) {
			//..
			return false;
		}
	}
	
	private boolean readFromFile() {
		
		// Liest Objekt aus Dateien
		// Snippet
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE)); // Verbindung (Lese-Zugriff) zur Datei wird geöffnet
			termine = (Set<Termin>) in.readObject(); // Text wird gelesen und in ein Set von Terminen umgewandelt
			in.close(); // Verbindung zur Datei wird geschlossen
			return true;
		}
		catch (IOException e) {
			//..
		} 
		catch (ClassNotFoundException e) {
			//..
		}
		//termine = new HashSet<>(); // ungeordnet
		termine = new TreeSet<>(); // sortiert (immer)
		// Inhalt von Set muss das Comparable-Interface implementieren
		// Comparable bedeutet, dass die Objekte vergleichbar/sortierbar sind
		return false;
	}
}
