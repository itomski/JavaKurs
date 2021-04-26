package de.lubowiecki.javakurs;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionTest3 {

	public static void main(String[] args) {
		
		// catch-Blöcke fangen die Exception von speziell zu generell
		try {
			machWas(11);
		} 
		catch (NullPointerException e) { // RuntimeException !IS-A NullPointerException 
			System.out.println("#1 Ist eine " + e.getClass().getName());
		}
		catch (RuntimeException e) { // NullPointerException IS-A RuntimeException
			System.out.println("#2 Ist eine " + e.getClass().getName());
		}
		catch (Exception e) { // NullPointerException IS-A RuntimeException
			System.out.println("#3 Ist eine " + e.getClass().getName());
		}
		
		System.out.println();
		
		// try/catch behandlung eine potenziell gefährlichen Methode/code
		try {
			machWasChecked(2);
		}
		catch (IOException e) {
			// e ist nur innerhalb der Klammern von catch sichtbar
			System.out.println("#1 Ist eine " + e.getClass().getName());
			System.out.println(e.getMessage());
			System.out.println(e.getCause()); // Grund für die Exception
			
		}
		catch (SQLException e) {
			System.out.println("#2 Ist eine " + e.getClass().getName());
		}
		catch (Exception e) {
			System.out.println("#3 Ist eine " + e.getClass().getName());
		}
		
		// System.out.println(e); // Hier ist e out of scope
	}
	
	static void machWas(int zahl) {
		
		if(zahl > 10) {
			throw new RuntimeException("A");
		}
		else if(zahl > 5 ) {
			throw new NullPointerException("B");
		}
		else {
			throw new ArrayIndexOutOfBoundsException("C");
		}
	}
	
	// throws ich markiere eine Methode als potenziell gefährlich
	// Jemand anderer muss sich um die behandlung kümmern
	static void machWasChecked(int zahl) throws IOException, SQLException, Exception {
		
		if(zahl > 10) {
			throw new Exception("A"); // throw wirft eine Exception auf
		}
		else if(zahl > 5 ) {
			throw new IOException("B");
		}
		else if(zahl > 2) {
			throw new SQLException("C");
		}
		else {
			System.out.println("Ohne Exception");
		}
	}
}
