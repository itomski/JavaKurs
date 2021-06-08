package vehiclemanagement.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
	
	public List<User> find() throws SQLException {
		
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			
			String sql  = "SELECT * FROM user"; // SQL
			ResultSet results = stmt.executeQuery(sql);
			
			List<User> users = new ArrayList<>();
			
			while(results.next()) {
				users.add(create(results)); 
			}
			
			return users;
		}
	}
	
	public User create(ResultSet rs) throws SQLException {
		LocalDate birthDate = LocalDate.parse(rs.getString("birthdate"));
		// Relationale Daten (Tabellen-Daten) in Objekte umwandeln
		return new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), birthDate);
	}
}
