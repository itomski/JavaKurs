package vehiclemanagement.model;

import java.sql.Connection;
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
	public boolean delete(Vehicle u) throws SQLException {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean update(Vehicle u) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
