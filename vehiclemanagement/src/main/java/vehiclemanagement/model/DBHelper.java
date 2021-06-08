package vehiclemanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	private static final String URI = "jdbc:sqlite:" + System.getProperty("user.home") + "/vehiclemanagement/data.db";

	//TODO: die Erzeugung des Ordners implementieren
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URI);			
	}
}
