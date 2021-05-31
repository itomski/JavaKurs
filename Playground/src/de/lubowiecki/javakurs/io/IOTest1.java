package de.lubowiecki.javakurs.io;

import java.io.File;
import java.io.IOException;
import java.io.FilenameFilter;

public class IOTest1 {

	public static void main(String[] args) {
		
		
		File d1 = new File("data"); // relativ
		File f1 = new File(d1, "iodata.txt"); // data/iodata.txt
		
		// Auch möglich
		f1 = new File("data", "iodata.txt"); // data/iodata.txt
		
		// Auch möglich
		f1 = new File("data/iodata.txt"); // data/iodata.txt
		
		// Erzeugt den Ordner/die Ordner wenn noch nicht da 
		if(!d1.exists()) {
			//d1.mkdir(); // make one directory
			d1.mkdirs(); // make all directories
		}
		
		try {
			if(!f1.exists()) {
				// Erzeugt die Datei wenn noch nicht da
				f1.createNewFile();
			}
			
			System.out.println("Dir: " + f1.isDirectory());
			System.out.println("File: " + f1.isFile());
			System.out.println("Versteckt: " + f1.isHidden());
			
			System.out.println("Lesen: " + f1.canRead());
			System.out.println("Ausführen: " + f1.canExecute());
			System.out.println("Schreiben: " + f1.canWrite());
			
			System.out.println("Bearbeitet: " + f1.lastModified());
			
			System.out.println("relativ: " + f1);
			System.out.println("absolute: " + f1.getAbsolutePath());
			
			System.out.println();
			
			File d2 = new File("src");
			
			for(String path : d2.list()) { // liefert ein Array von Pfaden als Strings
				System.out.println(path);
			}
			
			System.out.println();
			
			list(d2); // Verarbeitung von File-Objekten bietet mehr Möglichkeiten
			
			System.out.println();
			
			list(d2); 
			
			System.out.println();
			
			// boolean accept(File dir, String name);
			FilenameFilter filter = (f, s) -> s.endsWith(".java");
			
			File  d3 = new File("src/de/lubowiecki/javakurs");
			for(String path : d3.list(filter)) { // liefert ein Array von Pfaden als Strings, die die Endung .java haben
				System.out.println(path);
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void list(File file) {
		
		for(File path : file.listFiles()) { // liefert ein Array von Pfaden als File-Objekte
			System.out.println(path);
			if(path.isDirectory()) { // Kann Methoden von File benutzen
				list(path); // Rekursiv, ruft sich selbst auf
			}	
		}
	}
}
