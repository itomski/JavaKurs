package jpafirststeps;

import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;

import java.util.logging.Logger;

public class App {

	public static void main(String[] args) {
		
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		
		System.out.println("Start");
		
		Service service = new Service();
		
		// ADD
//		User u1 = new User();
//		u1.setFirstname("Peter");
//		u1.setLastname("Parker");
//		u1.setBirthDate(LocalDate.of(1982, 10, 5));
//		service.addUser(u1);
		
		// GET BY ID
//		Optional<User> opt = service.getUserById(1);
//		opt.ifPresent(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));
		
		// EDIT
//		Optional<User> opt = service.getUserById(2);
//		if(opt.isPresent()) {
//			User u = opt.get();
//			u.setFirstname("Tony");
//			u.setLastname("Stark");
//			u.setBirthDate(LocalDate.of(1972, 6, 10));
//			service.updateUser(u);
//		}
		
		// GET ALL AS STREAM
		service.getAllUsersAsStream().forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));
		
		System.out.println("Ende");
		

	}

}
