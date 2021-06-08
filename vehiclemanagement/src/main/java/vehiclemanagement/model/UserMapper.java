package vehiclemanagement.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
	
	// CRUD - Create Read Update Delete
	
	public List<User> find() throws SQLException {
		
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			
			String sql  = "SELECT * FROM user"; // SQL
			ResultSet results = stmt.executeQuery(sql);
			
			List<User> users = new ArrayList<>();
			
			while(results.next()) { // next springt zu der nächsten Zeile in der Ergebnis-Menge (ResultSet)
				users.add(create(results)); 
			}
			
			return users;
		}
	}
	
	public User find(int id) throws SQLException {
		
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			
			String sql  = "SELECT * FROM user WHERE id = " + id;
			ResultSet results = stmt.executeQuery(sql); // executeQuery ist nur für SELECT nutzbar
			
			if(results.next()) {
				return create(results); 
			}
			
			return null;
		}
	}
	
	public boolean insert(User u) throws SQLException {
		// TODO: implementieren!
		throw new UnsupportedOperationException();
	}
	
	public boolean update(User u) throws SQLException {
		// TODO: implementieren!
		throw new UnsupportedOperationException();
	}
	
	// Löscht einen Datensatz, verlangt ein User-Objekt als Attribut
	public boolean delete(User u) throws SQLException {
		if(delete(u.getId())) {
			u.setId(0);
			return true;
		}
		return false;
	}
	
	// Löscht einen Datensatz, verlangt nur die User-ID als Attribut
	public boolean delete(int id) throws SQLException {
		
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			
			String sql  = "DELETE FROM user WHERE id = " + id;
			return stmt.executeUpdate(sql) > 0; // executeUpdate aktuallisiert Tabellen und Daten, liefert die Anzahl betrofferen Datensätze
		}
	}
	
	public User create(ResultSet rs) throws SQLException {
		LocalDate birthDate = LocalDate.parse(rs.getString("birthdate"));
		// Relationale Daten (Tabellen-Daten) in Objekte umwandeln
		return new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), birthDate);
	}
}
