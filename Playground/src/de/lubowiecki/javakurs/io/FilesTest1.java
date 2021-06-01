package de.lubowiecki.javakurs.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FilesTest1 {

	public static void main(String[] args) {
		
		Path dir = Paths.get(System.getProperty("user.home"));
		try {
			Path file = Files.createTempFile(dir, "temp", "");
			
			List<String> lines = new ArrayList<>();
			lines.add("Peter Parker");
			lines.add("Steve Rogers");
			lines.add("Natasha Romanoff");
			lines.add("Bruce Banner");
			
			Files.write(file, lines);
			
			//Thread.sleep(10000);
			
			Path p1 = Paths.get(".").toAbsolutePath();
			Path p2 = Paths.get("."); // . = aktuelles Verzeichnis
			System.out.println(p1);
			System.out.println(p2);
			System.out.println(Files.isSameFile(p1, p2));
			
			// Java verenedet automatisch UTF-16
			// Charset: eichenkodierung
			try(BufferedWriter writer = Files.newBufferedWriter(file, Charset.forName("UTF-8"))) {
				writer.write("Das ist ein Haus von Nikigraus! öäÜ&");
			}
			
			// Kopieren
			Files.copy(file, Paths.get("data/temp_data.txt"), StandardCopyOption.REPLACE_EXISTING);
			
			// Bewegen
			Files.move(Paths.get("data/temp_data.txt"), Paths.get("temp_data_copy.txt"), StandardCopyOption.REPLACE_EXISTING);
			
			Files.deleteIfExists(file);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
