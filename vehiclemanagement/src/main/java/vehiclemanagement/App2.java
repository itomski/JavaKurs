package vehiclemanagement;

import java.sql.SQLException;
import java.util.Optional;

import vehiclemanagement.model.Mapper;
import vehiclemanagement.model.User;
import vehiclemanagement.model.UserMapper;
import vehiclemanagement.model.Vehicle;
import vehiclemanagement.model.VehicleMapper;

public class App2 {

	public static void main(String[] args) {
		
		try {
			
			Mapper<User> uMapper = new UserMapper();
			VehicleMapper vMapper = new VehicleMapper();
			
			Optional<User> ou = uMapper.find(5);
			User u = ou.get();
			
//			for(Vehicle v : vMapper.findByUser(u)) {
//				System.out.println(v.getNrPlate());
//			}
			
			for(Vehicle v : u.getVehicles()) {
				System.out.println(v.getNrPlate());
			}
			
			// Keine neue Anfrage an die DB
			for(Vehicle v : u.getVehicles()) {
				System.out.println(v.getNrPlate());
			}
			
			
//			Vehicle v1 = vMapper.find(3);
//			Vehicle v2 = vMapper.find(3);
//			u.addVehicle(v1);
//			u.addVehicle(v2);
			
//			for(Vehicle v : u.getVehicles()) {
//				System.out.println(v.getNrPlate());
//			}
			
//			
//			if(uMapper.save(u)) {
//				System.out.println("Update war erfolgreich.");
//			}
			
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
