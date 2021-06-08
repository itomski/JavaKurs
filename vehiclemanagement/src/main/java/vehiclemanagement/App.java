package vehiclemanagement;

import java.sql.SQLException;

import vehiclemanagement.model.User;
import vehiclemanagement.model.UserMapper;

public class App {

	// MVC - Model View Controller
	public static void main(String[] args) {
		
		try { 
			UserMapper mapper = new UserMapper();
			
			// find all
//			for(User u : mapper.find()) {
//				System.out.println(u.getFirstname() + " " + u.getLastname());
//				System.out.println(u.getBirthDate());
//			}
			
			// find one by ID
			User u = mapper.find(1);
//			System.out.println(u.getFirstname() + " " + u.getLastname());
//			System.out.println(u.getBirthDate());
			
			mapper.delete(u); // Löschen mit einem User-Objekt
			System.out.println(u.getId());
			
//			mapper.delete(2); // Löschen ohne User-Objekt
//			
//			for(User u : mapper.find()) {
//				System.out.println(u.getFirstname() + " " + u.getLastname());
//				System.out.println(u.getBirthDate());
//			}
			
		}
		catch(SQLException e) {
			System.out.println("Probleme mit der Datenbank!");
			//System.out.println(e.getMessage());
		}
	}
}
