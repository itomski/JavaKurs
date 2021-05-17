package de.lubowiecki.javakurs;

import java.io.FileWriter;
import java.io.IOException;

public class TryCatchTest3 {

	public static void main(String[] args) {
		
		System.out.println("START");
		
		
		// unchecked Exception: Kompiler sichert eine Behandlung NICHT zu
		
		try { // optional, da ArithmeticException eine unchecked Exception ist
			int x = 0;
			System.out.println(10 / x); // ArithmeticException
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("ENDE");
		
		
		System.out.println("START");
		
			// checked Exception: Compiler sichert eine Behandlung der Exception zu. D.h. handle or declare
		
		try {
			FileWriter out = new FileWriter("data.txt"); // kann eine checked Exception (IOException) werfen
		}
		catch(IOException e) { // ist eine checked Exception d.h. entweder handle (try/catch) oder declare (throws)
			System.out.println(e.getMessage());
		}
		
		
		try {
			// Hier kann eine RuntimeException auftauchen
			// Kompiler prüft NICHT, ob die Code es möglich macht.
			// Bei allen RuntimeExceptions, sowie Exception und Throwable
		}
		catch(NullPointerException e) { // Subklasse
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) { // Elternklasse von NullPointerException
			System.out.println(e.getMessage());
		}
		catch(Exception e) { // Elternklasse von RuntimeException
			System.out.println(e.getMessage());
		}
		
//		try {
//			// Bei allen NICHT RuntimeExceptions unterhalb von Exception 
//			// prüft der Kompiler, ob sie im try überhaupt möglich sind.
//		}
//		catch(IOException e) {
//			System.out.println(e.getMessage());
//		}
		
		System.out.println("ENDE");
		
		// checked: IMMER handle or declare
		//throw new Throwable("Das ist ein Haus von Nikigraus."); // checked
		//throw new Exception("Das ist ein Haus von Nikigraus."); // checked
		//throw new IOException("Das ist ein Haus von Nikigraus."); // checked, weil IS-A Exception
		
		// unchecked: handle or declare sind optional
		//throw new Error("Das ist ein Haus von Nikigraus."); // unchecked
		//throw new RuntimeException("Das ist ein Haus von Nikigraus."); // unchecked
		//throw new NullPointerException("Das ist ein Haus von Nikigraus."); // unchecked, weil IS-A RuntimeException

	}

}
