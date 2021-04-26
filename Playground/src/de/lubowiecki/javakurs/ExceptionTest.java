package de.lubowiecki.javakurs;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ExceptionTest {

	public static void main(String[] args) {
		System.out.println("Start main");
		//machWas();
		
		machBenutzeDaten();
		
		machWasGanzAnderes();
		
		try {
			machWasGanzAnderes2();
		} 
		catch (IOException e) {
			System.out.println("Problem: " + e.getMessage());
		}
		
		System.out.println("Ende main");
	}
	
	public static void machWas() {
		System.out.println("Start machWas");
		machWasAnderes();
		System.out.println("Ende machWas");
	}
	
	public static void machWasAnderes() {
		System.out.println("Start machWasAnderes");
//		String xyz = null;
//		xyz.toUpperCase(); // Bei (unbehandelten) Exception wird die Ausführung der Methode sofort unterbrochen
		
//		String[] arr = {};
//		System.out.println(arr[1]);
		
//		String[] arr = new String[-1];
//		System.out.println(arr[1]);
		
		LocalDate date = LocalDate.of(2000, 15, 22);
		
		System.out.println("Ende machWasAnderes");
	}
	
	public static void machWasGanzAnderes() {
		
		System.out.println("Start machWasGanzAnderes");
		
		// handle or declare
		
		// handle
		// Konstruktor wirft eine CheckedException
		try {
			//FileWriter writer = new FileWriter("abc.txt");
			FileReader reader = new FileReader("abc.txt");
		} 
		catch (IOException e) {
			// Behandlung der Ausnahme
			//e.printStackTrace();
			System.out.println(e.getMessage()); 
		}
		// hier ist die Ausnahme bereits behandelt
		System.out.println("Ende machWasGanzAnderes");
	}
	
	public static void machWasGanzAnderes2() throws IOException {
		System.out.println("Start machWasGanzAnderes2");
		// declare
		//FileWriter writer = new FileWriter("abc.txt");
		FileReader reader = new FileReader("abc.txt");
		
		System.out.println("Start machWasGanzAnderes2");
	}
	
	public static String machBenutzeDaten() {
		throw new RuntimeException("Aktuell keine Daten da!");
		//throw new UnsupportedOperationException("...");
	}
}
