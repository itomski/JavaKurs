package vehiclemanagement;

import java.sql.SQLException;

import vehiclemanagement.model.User;
import vehiclemanagement.model.UserMapper;

public class App {

	// MVC - Model View Controller
	public static void main(String[] args) {
		
		try { 
			UserMapper mapper = new UserMapper();
			for(User u : mapper.find()) {
				System.out.println(u.getFirstname() + " " + u.getLastname());
				System.out.println(u.getBirthDate());
			}
		}
		catch(SQLException e) {
			System.out.println("Probleme mit der Datenbank!");
			//System.out.println(e.getMessage());
		}
	}
}
