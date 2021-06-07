package vehiclemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) {
		
//		System.out.println(System.getProperties());
//		String home = System.getProperty("user.home");
//		System.out.println(home + "/vehiclemanagement/data.db");
		
		try(Connection dbh = getConnection(); Statement stmt = dbh.createStatement()) { // Verbindung wird aufgebaut
			
			String sql  = "SELECT * FROM user"; // SQL
			ResultSet results = stmt.executeQuery(sql);
			
			while(results.next()) { // versetzt den Zeigen auf die nächste Position
				System.out.println(results.getInt("id"));
				System.out.println(results.getString("firstname") + " " + results.getString("lastname"));
				System.out.println(results.getString("birthdate"));
				System.out.println("---");
			}
			
			// Verbindung wird automatisch geschlossen
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static Connection getConnection() throws SQLException {
		String home = System.getProperty("user.home");
		return DriverManager.getConnection("jdbc:sqlite:" + home + "/vehiclemanagement/data.db");			
	}
}
