package vehiclemanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserMapper extends AbstractMapper<User> {
	
	
	// Default-Konstruktor ruft den parameterlosen Konstruktor seiner Elternklasse
	public UserMapper() {
		super("user"); // Aufruf des Konstruktors der Elternklasse mit einem Parameter 
	}
	
	
	// CRUD - Create Read Update Delete
	
	public User find(int id) throws SQLException {
		
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			
			String sql  = "SELECT * FROM " + TABLE + " WHERE id = " + id;
			ResultSet results = stmt.executeQuery(sql); // executeQuery ist nur für SELECT nutzbar
			
			if(results.next()) {
				return create(results); 
			}
			
			return null;
		}
	}
	
	boolean insert(User u) throws SQLException {
		
		// PreparedStatement: Eine SQL-Injection ist nicht mehr möglich
		String sql  = "INSERT INTO " + TABLE + " (firstname, lastname, birthdate) VALUES(?, ?, ?)";
		
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
	
	boolean update(User u) throws SQLException {
		
		// PreparedStatment ist wie eine Schablone, die an die DB gegeben wird und später
		// konkrete Werte an die mit Platzhaltern markierten Stellen einsetzt
		// Werte werden dabei NIE als SQL-Befehle ausgeführt!
		String sql  = "UPDATE " + TABLE + " SET firstname = ?, lastname = ?, birthdate = ? WHERE id = ?";
		
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
			
			String sql  = "DELETE FROM " + TABLE + " WHERE id = " + id;
			return stmt.executeUpdate(sql) > 0; // executeUpdate aktuallisiert Tabellen und Daten, liefert die Anzahl betrofferen Datensätze
		}
	}
	
	public User create(ResultSet rs) throws SQLException {
		LocalDate birthDate = LocalDate.parse(rs.getString("birthdate"));
		// Relationale Daten (Tabellen-Daten) in Objekte umwandeln
		return new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), birthDate);
	}
}
