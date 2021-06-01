package de.lubowiecki.javakurs.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.time.Instant;
import java.util.List;

public class FilesTest2 {

	public static void main(String[] args) {
		
		Path p = Paths.get("data/mobydick.txt");
		
		try {
			List<String> lines = Files.readAllLines(p);
			lines.forEach(s -> System.out.println(s));
			
			Files.setLastModifiedTime(p, FileTime.from(Instant.now()));
			
			System.out.println(Files.getOwner(p));
			
			// UserPrincipalLookupService: Suchdienst des Betriebssystems für registrierte Benutzer
			UserPrincipal user = p.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("tlubowiecki");
			Files.setOwner(p, user);
			
			// PosixFileAttributes gibt es nur auf Linux, Unix und MacOS
			PosixFileAttributes attr = Files.readAttributes(p, PosixFileAttributes.class);
			System.out.println(attr.permissions());
			
			// DosFileAttributes gibt es nur auf DOS und Windows Betriebssystemen
//			DosFileAttributes dosAttr = Files.readAttributes(p, DosFileAttributes.class);
//			System.out.println(dosAttr.isSystem());
			
			// BasicFileAttributes gibt es auf allen Betriebssystemen
			BasicFileAttributes basicAttr = Files.readAttributes(p, BasicFileAttributes.class);
			System.out.println(basicAttr.size());
			
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
