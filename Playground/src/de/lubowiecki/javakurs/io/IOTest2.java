package de.lubowiecki.javakurs.io;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest2 {
	
	public static void main(String[] args) {
		
//		FileWriter o = null;
//		try {
//			o = new FileWriter("data/iodata.txt", true);
//			
//		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		} 
//		
//		try {
//			if(o != null)
//				o.close();
//		} 
//		catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
		try {
			//FileWriter out = new FileWriter("data/iodata.txt"); // Inhalt wird überschrieben
			FileWriter out = new FileWriter("data/iodata.txt", true); // Inhalt wird erweitert
			
			// Falls Datei nicht vorhanden, dann wird sie (die Datei, aber nicht die Ordner) automatisch angelegt
			
			out.write("Hallo File...\n");
			
			out.close(); // Verbindung zu der Datei wird geschlossen
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// try-with-resources
		
		// Hier kann jede Klasse eingesetzt werden, die das Interface AutoCloseable implementiert
		// Wird für Klartext verwendet
		try(FileWriter out = new FileWriter("data/iodata.txt", true)) {
			out.write("Hallo File...\n");
			// alle Resourcen, die inden Klammern von try geöffnet wurden, werden automatisch geschlossen
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// Wird für Binär-Daten verwendet: PDF, Bilder, Videos, Zip etc.
		try(FileOutputStream out = new FileOutputStream("data/iodata.txt", true)) { // FileOutputStream schreibt bytes
			out.write("Hallo Welt".getBytes());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		for(byte b : "@öÜ".getBytes()) {
			System.out.print(b + ", ");
		}
		System.out.println();
		System.out.println("Hallo Welt");
		
		
		
	}
}
