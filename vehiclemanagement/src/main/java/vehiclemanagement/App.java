package vehiclemanagement;

import java.sql.SQLException;
import java.time.LocalDate;

import vehiclemanagement.model.AbstractEntity;
import vehiclemanagement.model.Mapper;
import vehiclemanagement.model.User;
import vehiclemanagement.model.UserMapper;
import vehiclemanagement.model.Vehicle;
import vehiclemanagement.model.VehicleMapper;

public class App {

	// MVC - Model View Controller
	public static void main(String[] args) {
		
		try { 
			Mapper<User> mapper = new UserMapper();
			
			// find all
//			for(User u : mapper.find()) {
//				System.out.println(u.getFirstname() + " " + u.getLastname());
//				System.out.println(u.getBirthDate());
//			}
			
			// find one by ID
//			User u = mapper.find(1);
//			System.out.println(u.getFirstname() + " " + u.getLastname());
//			System.out.println(u.getBirthDate());
			
			// DELETE by User
//			mapper.delete(u); // Löschen mit einem User-Objekt
//			System.out.println(u.getId());
			
			// DELETE by id
//			mapper.delete(2); // Löschen ohne User-Objekt
//			
//			for(User u : mapper.find()) {
//				System.out.println(u.getFirstname() + " " + u.getLastname());
//				System.out.println(u.getBirthDate());
//			}
			
			// Neuer User - noch nicht in der DB
//			User u = new User();
//			u.setFirstname("Peter");
//			u.setLastname("Petersen");
//			u.setBirthDate(LocalDate.of(1950, 01, 10));
//			
//			// INSERT
//			System.out.println("ID vor dem Speichern: " + u.getId());
//			mapper.save(u);
//			System.out.println("ID nach dem Speichern: " + u.getId());
//			
////			User u = mapper.find(4);
//			u.setFirstname("Bob");
//			
//			// UPDATE
//			if(mapper.save(u)) {
//				System.out.println("Datensatz wurde geändert!");
//			}
			
//			AbstractEntity ae = new User();
//			ae = new Vehicle();
			
			
			Mapper<Vehicle> vMapper = new VehicleMapper();
//			Vehicle v = vMapper.find(1);
//			System.out.println(v.getNrPlate() + ", " + v.getBrand());
			
			for(Vehicle v : vMapper.find(0, 1)) { // erste Zahl ist der Start. Anfang der Tabelle beginnt bei 0
				System.out.println(v.getNrPlate() + ", " + v.getBrand());
			}
			
			
			
			
		}
		catch(SQLException e) {
			//System.out.println("Probleme mit der Datenbank!");
			System.out.println(e.getMessage());
		}
	}
}
