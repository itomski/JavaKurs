package de.lubowiecki.javakurs;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TryCatchTest2 {

	// main: 
	public static void main(String[] args) {
		
		System.out.println("START");
		try { /* handle */
			doSomething();
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		System.out.println("ENDE");
		
		
		try {
			throw new FileNotFoundException();
		}
		catch(IOException e) {
			
		}
		
		
		Throwable t1 = new Exception();
		t1 = new Error();
		
		// Error ist unchecked und sollte NICHT behandelt werden!!!!!!
		
		try {
			throw new Error("GRRRR!!!!!"); // Verält sich wie UncheckedExceptions
		}
		catch(Error e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// throws: legt fest, dass die Methode die Exception (falls diese sie auftaucht) nicht selbst behandelt, sondern weiterreicht
	public static void doSomething() /* declare */ throws IOException { // FileNotFoundException IS-A IOException
		System.out.println("INNER START");
		throw new FileNotFoundException(); // Wirft eine Exception
		//System.out.println("INNER ENDE");
	}
}
