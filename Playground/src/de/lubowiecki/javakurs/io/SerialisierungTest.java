package de.lubowiecki.javakurs.io;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerialisierungTest {
	
	private static final File FILE = new File("data/werte.ser"); 

	public static void main(String[] args) {
		
		// ObjectOutputStream: erlaubt komplexe Daten d.h. Java-Objekte in Dateien zu speichern
		// Es kann ein Objekt oder ein ganzer Objektbaum gespeichert werden
		
//		List<String> data = new ArrayList<>();
//		data.add("Peter");
//		data.add("Carol");
//		data.add("Bruce");
//		data.add("Natasha");
		
//		Map<String, User> data = new HashMap<>();
//		data.put("spiderman", new User("Peter", "Parker", LocalDate.of(1992, 12, 2), "spiderman@shield.org"));
//		data.put("ironman", new User("Tony", "Stark", LocalDate.of(1976, 5, 5), "ironman@shield.org"));
//		data.put("hulk", new User("Bruce", "Banner", LocalDate.of(1983, 10, 11), "hulk@shield.org"));
//		
//		// Schreiben
//		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
//			out.writeObject(data); // Die komplette Liste inkl. Inhalt wird gespeichert
//		} 
//		catch (IOException e) {
//			System.out.println("Daten konnten nicht gespeichert werden.");
//		}
		
		Map<String, User> dest = null;
		
		// Lesen
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
			dest = (Map<String, User>) in.readObject(); // Der Inhalt der Datei wird eingelesen und in Objekte übersetzt
		} 
		catch (IOException | ClassNotFoundException e) { // Multi-Catch
			System.out.println("Daten konnten nicht gelesen werden.");
		}

		System.out.println(dest);
		
		System.out.println(dest.get("hulk"));
		
		User u = dest.get("hulk");
		System.out.println(u.getFirstname() + " " + u.getLastname());
		
		// Alles was gespeichert oder wiederhergestellt wird, muss das (Marker-)Interface Serializable implementieren
		
		
	}
}


class User implements Serializable {
	
	private String firstname;
	private String lastname;
	private LocalDate birthDate;
	private String email;
	
	public User(String firstname, String lastname, LocalDate birthDate, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", birthDate=" + birthDate + ", email="
				+ email + "]";
	}
}
