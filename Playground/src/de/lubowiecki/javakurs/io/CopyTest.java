package de.lubowiecki.javakurs.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyTest {
	
	public static void main(String[] args) {
		
		// Reader und Writer werden für Unicode-Texte verwendet (reiner Text ohne Formatierung). 
		// Dateien, die mit einfachen Text-Editoren, wie note-pad geöffnet werden können
		
		// InputStream und OutputStream werden für Binär-Daten verwendet, wie Zip, Bilder, Videos, Audio, Text mit Formatierung (8-bit text, z.B. word, excel etc)
		
		File src = new File("data/hamburg.jpg"); // das ist nur ein Pfad
		File dest = new File("data/hamburg_copy.jpg");
		
		
		long start = System.currentTimeMillis();
		
		// FileInputStream, FileOutputStream sind beim lesen von Zeichen-Daten langsamer als Reader und Writer
		// Für Binär-Daten sind sie perfekt
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(src)); 
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {
			
			int b; // read() liefert einen int und nicht byte
			while((b = in.read()) != -1) { // -1 bedautet, dass das Ende der Datei erreicht wurde
				out.write(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start + "ms");
		
		start = System.currentTimeMillis();
		
		src = new File("data/mobydick.txt"); // das ist nur ein Pfad
		dest = new File("data/mobydick_copy.txt");
		
		
//		 Werden Binär-Daten zeichen-basiert geschrieben, gehen die Daten dabei kaputt
//		 BufferedReader und BufferedWriter sind schneller
//		try(FileReader in = new FileReader(src); FileWriter out = new FileWriter(dest)) {
//			
//			int b; // read() liefert einen int in dem das char liegt
//			while((b = in.read()) != -1) { // -1 bedautet, dass das Ende der Datei erreicht wurde
//				out.write(b);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		try(BufferedReader in = new BufferedReader(new FileReader(src)); 
				BufferedWriter out = new BufferedWriter(new FileWriter(dest))) {
			
			String line;
			while((line = in.readLine()) != null) { // null bedautet, dass das Ende der Datei erreicht wurde
				out.write(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		end = System.currentTimeMillis();
		
		System.out.println(end - start + "ms");
	}

}
