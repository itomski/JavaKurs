package de.lubowiecki.javafxtest.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	private static final String LOCATION = System.getProperty("user.home") + "/einkaufsliste/data.db";
	private static final String URI = "jdbc:sqlite:" + LOCATION;

	/**
	 * Erzeugt den Ordner für die SQLite-Datei
	 * @throws IOException
	 */
	private static void createParentFolder() throws IOException {
		
		Path dir = Paths.get(LOCATION).getParent();
		
		if(Files.notExists(dir)) {
			Files.createDirectory(dir);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		createParentFolder();
		return DriverManager.getConnection(URI);			
	}
}
