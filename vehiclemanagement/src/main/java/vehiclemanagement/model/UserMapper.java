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
		
		try(Connection dbh = DBHelper.getConnection()) {
		
			boolean block1 = false;
			boolean block2 = false;
			
			// PreparedStatment ist wie eine Schablone, die an die DB gegeben wird und später
			// konkrete Werte an die mit Platzhaltern markierten Stellen einsetzt
			// Werte werden dabei NIE als SQL-Befehle ausgeführt!
			String sql  = "UPDATE " + TABLE + " SET firstname = ?, lastname = ?, birthdate = ? WHERE id = ?";
			
			try(PreparedStatement stmt = dbh.prepareStatement(sql)) {
				
				stmt.setString(1, u.getFirstname());
				stmt.setString(2, u.getLastname());
				stmt.setString(3, u.getBirthDate().toString());
				stmt.setInt(4, u.getId());
				stmt.execute();
				
				block1 = stmt.getUpdateCount() > 0;
			}
			
			// TODO: In eine eigene Methode auslagern 
			if(u.getVehicles().size() > 0) {
				sql = "INSERT INTO user_to_vehicles (user, vehicle) VALUES(?, ?)";
				
				try(PreparedStatement stmt = dbh.prepareStatement(sql)) {
					// Prepared Statement wird als Schablone 1x an die DB übergeben
					// und kann beim execute jeweils mit neuen Werten belegt werden
					
					for(Vehicle v : u.getVehicles()) {
						// Die Platzhalter in der Schablone werden mit aktuellen Werten gefüllt
						stmt.setInt(1, u.getId());
						stmt.setInt(2, v.getId());
						stmt.execute();
					}
					block2 = true;
				}
				catch(SQLException e) {
					block2 = false;
				}
			}
			else {
				// Wenn keine Fahrzeuge für den User hinterlegt sind, dann gibt das Update der
				// Userdaten ein return
				return block1;
			}
			// Wenn Fahrzeuge für den User hinterlegt sind, dann gibt das Update der
			// Userdaten UND Update der Verbindung ein return
			return block1 && block2;
		}
	}
	
	public List<User> findByFirstname(String firstname) throws SQLException {
		return findBy("firstname", firstname);
	}
	
	public List<User> findByLastname(String lastname) throws SQLException {
		return findBy("lastname",lastname);
	}
	
	public User create(ResultSet rs) throws SQLException {
		LocalDate birthDate = LocalDate.parse(rs.getString("birthdate"));
		// Relationale Daten (Tabellen-Daten) in Objekte umwandeln
		return new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), birthDate);
	}
}
