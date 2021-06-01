package de.lubowiecki.javakurs.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest2 {

	public static void main(String[] args) {
		
		Path p1 = Paths.get("abc/cde/efg/io");
		Path p2 = Paths.get("abc/cde/ijk");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.relativize(p2)); // zeigt den relativen weg von p1 zu p2
		
		// relative und absolute Pfade dürfen nicht gemischt werden
		
		System.out.println();
		p1 = Paths.get("/usr/local/etc");
		p2 = Paths.get("/var/lib");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.relativize(p2));
		
		
		// resolve verbindet zwei Path-Objekte
		
		System.out.println();
		p1 = Paths.get("."); // relativer Pfad auf das aktuelle Verzeichnis
		System.out.println(p1);
		p1 = p1.resolve("data/iotest.txt");
		System.out.println(p1);
		
		// Verknüpfen von abluten Pfaden mit absoluten Pfaden macht keinen Sinn
		// relativ + relativ geht, oder absolut + relativ
		// zweiter Pfad sollte IMMER relativ sein
		// ist der zweite Pfad absolut ist das Ergebnis gleich diesm Pfad
		
		p1 = Paths.get(".").toAbsolutePath();
		p1 = p1.resolve("../data");
		System.out.println(p1);
		System.out.println(p1.normalize());

	}

}
