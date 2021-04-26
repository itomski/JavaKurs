package de.lubowiecki.javakurs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest5 {

	public static void main(String[] args) {
		
		readFromFile();
		
	}
	
	public static String readFromFile() {
		
		FileReader reader = null;
		
		//System.out.println(System.getProperties());
		String sys = System.getProperty("os.name");
		System.out.println(sys);
		
		try {
			//reader = new FileReader(System.getProperty("user.home") + "/data.txt");
			reader = new FileReader("data.txt");
			String inhalt;
			inhalt = "..."; // Inhalt wird ausgelesen
			return inhalt;
		}
		catch(FileNotFoundException e) {
			System.out.println("Datei nicht gefunden.");
			return null;
		}
		catch(IOException e) {
			System.out.println("Ein Problem beim Lesen.");
			return null;
		}
		finally {
			System.out.println("Reader wird geschlossen.");
			// reader.close();
		}
	}
}
