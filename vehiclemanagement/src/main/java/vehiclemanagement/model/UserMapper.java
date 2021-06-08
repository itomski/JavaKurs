package vehiclemanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public boolean save(User u) throws SQLException {
		
		if(u.getId() > 0) {
			// User ist bereits in der DB gespeichert
			return update(u);
		}
		else {
			// User ist noch nicht in der DB gespeichert
			return insert(u);
		}
	}
	
	protected boolean insert(User u) throws SQLException {
		
		// PreparedStatement: Eine SQL-Injection ist nicht mehr möglich
		String sql  = "INSERT INTO user (firstname, lastname, birthdate) VALUES(?, ?, ?)";
		
		// RETURN_GENERATED_KEYS sagt, dass wir die ids, die in der Datenbank vergeben werden, später haben wollen
		try(Connection dbh = DBHelper.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			// Zahl ist die Nummer des Fragezeichens
			// Platzhalter werden mit konkreten Daten ersetzt
			stmt.setString(1, u.getFirstname());
			stmt.setString(2, u.getLastname());
			stmt.setString(3, u.getBirthDate().toString());
			stmt.execute(); // Die Anfrage mit aktuellen Daten wird ausgeführt
			
			if(stmt.getUpdateCount() > 0) {
				
				// getGeneratedKeys liefert die id, die in der Datenbank vergeben wurde
				ResultSet rs = stmt.getGeneratedKeys();
				rs.next(); // Cursor des ResultSets auf das erste Ergebnis verschieben
				u.setId(rs.getInt(1)); // Die erste Spalte (id) aus dem Ergebnis abfragen
				return true;
			}
			return false;
		}
	}
	
	protected boolean update(User u) throws SQLException {
		
		// PreparedStatment ist wie eine Schablone, die an die DB gegeben wird und später
		// konkrete Werte an die mit Platzhaltern markierten Stellen einsetzt
		// Werte werden dabei NIE als SQL-Befehle ausgeführt!
		String sql  = "UPDATE user SET firstname = ?, lastname = ?, birthdate = ? WHERE id = ?";
		
		try(Connection dbh = DBHelper.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql)) {
			
			stmt.setString(1, u.getFirstname());
			stmt.setString(2, u.getLastname());
			stmt.setString(3, u.getBirthDate().toString());
			stmt.setInt(4, u.getId());
			stmt.execute();
			
			return stmt.getUpdateCount() > 0;
		}
		
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
