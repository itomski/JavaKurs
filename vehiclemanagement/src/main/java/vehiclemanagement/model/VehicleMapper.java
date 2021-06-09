package vehiclemanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
		v.setStatus(rs.getString("status"));
		return v;
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
			stmt.setString(1, u.getBrand());
			stmt.setString(1, u.getModel());
			stmt.setString(1, u.getType());
			stmt.setInt(1, u.getPower());
			stmt.setString(1, u.getColor());
			stmt.setString(1, u.getNotice());
			//stmt.setInt(1, u.getStatus()); // TODO: An int anpassen
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
	boolean update(Vehicle u) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
