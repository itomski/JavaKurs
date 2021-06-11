package vehiclemanagement;

import java.sql.SQLException;

import vehiclemanagement.model.Mapper;
import vehiclemanagement.model.User;
import vehiclemanagement.model.UserMapper;
import vehiclemanagement.model.Vehicle;
import vehiclemanagement.model.VehicleMapper;

public class App2 {

	public static void main(String[] args) {
		
		try {
			
			Mapper<User> uMapper = new UserMapper();
			Mapper<Vehicle> vMapper = new VehicleMapper();
			
			User u = uMapper.find(6);
			Vehicle v = vMapper.find(3);
			u.addVehicle(v);
			
			if(uMapper.save(u)) {
				System.out.println("Update war erfolgreich.");
			}
			
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
