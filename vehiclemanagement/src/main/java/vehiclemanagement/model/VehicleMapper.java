package vehiclemanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// AbstractMapper implementiert das Interface Mapper
// Beim erben von AbstractMapper wird automatisch aus das Interface geerbt
public class VehicleMapper extends AbstractMapper<Vehicle> {

	public VehicleMapper() {
		super("vehicles");
	}
	
	@Override
	public Vehicle create(ResultSet rs) throws SQLException {
		Vehicle v = new Vehicle();
		v.setId(rs.getInt("id"));
		v.setNrPlate(rs.getString("nr_plate"));
		v.setBrand(rs.getString("brand"));
		v.setModel(rs.getString("model"));
		v.setType(rs.getString("type"));
		v.setPower(rs.getInt("power"));
		v.setColor(rs.getString("color"));
		v.setNotice(rs.getString("notice"));
		v.setStatus(rs.getInt("status"));
		return v;
	}

	public Set<Vehicle> findByUser(User u) throws SQLException {
		
		String sql = "SELECT v.* FROM vehicles v, user_to_vehicles uv WHERE v.id = uv.vehicle AND uv.user = ?";
		
		// executeSelect liefert eine List gebraucht wird aber ein Set
		return new LinkedHashSet<>(executeSelect(sql, Arrays.asList(u.getId())));
		
//		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
//			
//			String sql = "SELECT v.* FROM vehicles v, user_to_vehicles uv WHERE v.id = uv.vehicle AND uv.user = " + u.getId();
//			
//			ResultSet results = stmt.executeQuery(sql);
//			
//			Set<Vehicle> objs = new LinkedHashSet<>();
//			
//			while(results.next()) {
//				objs.add(create(results)); 
//			}
//			
//			return objs;
//		}
	}
	
	@Override
	boolean insert(Vehicle u) throws SQLException {
		
		// PreparedStatement: Eine SQL-Injection ist nicht mehr möglich
		String sql  = "INSERT INTO " + TABLE + " (nr_plate, brand, model, type, power, color, notice, status) "
						+ "VALUES(?,?,?,?,?,?,?,?)";
		
		// RETURN_GENERATED_KEYS sagt, dass wir die ids, die in der Datenbank vergeben werden, später haben wollen
		try(Connection dbh = DBHelper.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			// Zahl ist die Nummer des Fragezeichens
			// Platzhalter werden mit konkreten Daten ersetzt
			stmt.setString(1, u.getNrPlate());
			stmt.setString(2, u.getBrand());
			stmt.setString(3, u.getModel());
			stmt.setString(4, u.getType());
			stmt.setInt(5, u.getPower());
			stmt.setString(6, u.getColor());
			stmt.setString(7, u.getNotice());
			stmt.setInt(8, u.getStatus().getId());
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

	@Override
	boolean update(Vehicle v) throws SQLException {
		
		String sql  = "UPDATE " + TABLE + " SET nr_plate = ?, brand = ?, model = ?, type = ?, power = ?, color = ?, notice = ?, status = ? "
						+ " WHERE id = ?";
		
		try(Connection dbh = DBHelper.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql)) {
			
			stmt.setString(1, v.getNrPlate());
			stmt.setString(2, v.getBrand());
			stmt.setString(3, v.getModel());
			stmt.setString(4, v.getType());
			stmt.setInt(5, v.getPower());
			stmt.setString(6, v.getColor());
			stmt.setString(7, v.getNotice());
			stmt.setInt(8, v.getStatus().getId());
			stmt.setInt(9, v.getId());
			stmt.execute();
			
			return stmt.getUpdateCount() > 0;
		}
		
	}

}
