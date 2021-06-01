package de.lubowiecki.javakurs.io;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;
import java.util.function.*;

public class WalkTheLineTest1 {

	public static void main(String[] args) {
		
		Path path = Paths.get(".");
		
		try {
			// walk - Verzeichnisse durchlaufen
			
			// Stream sind sein Java 1.8 neu drin
			//Stream<Path> str = Files.walk(path, 5, FileVisitOption.FOLLOW_LINKS); // 5 = Tiefe/Ebene
			Stream<Path> str = Files.walk(path); // Tiefe ist automatisch Integer.MAX_VALUE
			str.filter(p -> p.toString().endsWith(".java"))
				.limit(20)
				.forEach(p -> System.out.println(p));
			
			// find - Suchen
			// BiPredicate: nimmt 2 Parameter entgegen und liefert einen boolean
			
			long now = System.currentTimeMillis();
			long filter = 2 * 60 * 60 * 1000;
			
			System.out.println();
			
			BiPredicate<Path, BasicFileAttributes> pred = (p, a) -> {
				return p.toString().endsWith(".java") && a.lastModifiedTime().toMillis() > (now - filter);
			};
			
			// Liefert nur Path-Objekte zurück, für die das BiPredicate true ergibt
			Files.find(path, Integer.MAX_VALUE, pred)
				.forEach(p -> System.out.println(p));
			
			
			System.out.println();
			
			path = Paths.get("data/mobydick.txt");
			
			// Liefert nur Stream von Strings zurück
			Files.lines(path)
				.forEach(s -> System.out.println(s.toUpperCase()));
			
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
