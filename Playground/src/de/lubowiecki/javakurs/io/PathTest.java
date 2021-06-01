package de.lubowiecki.javakurs.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	
	public static void main(String[] args) {
		
		Path data  = Paths.get("data", "iodata.txt");
		data  = Paths.get("data/iodata.txt");
		
		data  = Paths.get(URI.create("file:///usr/data/xyz/iodata.txt"));
		//data  = Paths.get(URI.create("http://www.lubowiecki.de"));
		
		data = FileSystems.getDefault().getPath("data", "iodata.txt");
		
		FileSystem sys = FileSystems.getDefault();
		//System.out.println(sys.provider());
		
		File f = new File("data/iodata.txt");
		
		Path p = f.toPath();
		f = p.toFile();
		
		data  = Paths.get("data", "xyz/iodata.txt"); // relativer Pfad
		System.out.println(data);
		System.out.println(data.getRoot()); // Relative Pfade enthalten null als Root
		
		System.out.println();
		
		data  = Paths.get("/usr/data", "xyz/iodata.txt"); // absoluter Pfad (unix, linux, macos)
		//data  = Paths.get("c:/usr/data", "xyz/iodata.txt"); // absoluter Pfad (win)
		
		System.out.println(data);
		System.out.println(data.getRoot()); // Relative Pfade enthalten null als Root
		
		System.out.println(data.getParent()); // Elternelement
		System.out.println(data.getFileName()); // Der letzte Teil des Pfades
		
		System.out.println(data.getName(0)); // 1. Teil des Pfades, Root wird hier nicht mitgezählt
		System.out.println(data.getName(1)); // 2. Teil des Pfades
		
		int count = data.getNameCount();
		System.out.println(data.subpath(0, count - 1)); // Teil des Pfades
		
		data  = Paths.get("data", "xyz/iodata.txt");
		System.out.println(data);
		System.out.println(data.toAbsolutePath());
		
		System.out.println();
		data  = Paths.get("data/iodata.txt2");
		
		try {
			System.out.println(data.toRealPath()); // Ein Path zu einer wirklich existierenden Datei. Normalisiert automatisch
			// Wenn Datei nicht existiert gibt es eine NoSuchFileException
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		data  = Paths.get("data/../data/../iodata.txt2");
		System.out.println(data); // wird nicht automatisch normalisiert
		System.out.println(data.normalize()); // entfernt redundante Schritte
		
		// ../ bedeutet den aktuellen Ordner verlassen
		data  = Paths.get("../../iodata.txt2").toAbsolutePath();
		System.out.println(data);
		System.out.println(data.normalize());
		
		data = Paths.get(System.getProperty("user.home"));
		data = data.resolve("test123");
		
		try {
			Files.createDirectory(data);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
