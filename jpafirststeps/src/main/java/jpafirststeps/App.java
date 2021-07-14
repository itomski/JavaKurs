package jpafirststeps;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
//		
//		Comment c1 = new Comment(LocalDateTime.now(), "Das ist mein erster Kommentar");
//		Comment c2 = new Comment(LocalDateTime.now(), "Das ist mein zweiter Kommentar");
//		Comment c3 = new Comment(LocalDateTime.now(), "Bla bla bla...");
//		c1.setUser(u1);
//		service.addComment(c1);
//		
//		c2.setUser(u1);
//		service.addComment(c2);
//		
//		c3.setUser(u1);
//		service.addComment(c3);
		
		// CascadeTyp.ALL: Alle Aktionen für das User-Objekt werden auch auf die Comment-Objekte angewandt
		User u1 = new User();
		u1.setFirstname("Tony");
		u1.setLastname("Stark");
		u1.setBirthDate(LocalDate.of(1982, 10, 5));
		
		Comment c1 = new Comment(LocalDateTime.now(), "Das ist mein erster Kommentar");
		Comment c2 = new Comment(LocalDateTime.now(), "Das ist mein zweiter Kommentar");
		Comment c3 = new Comment(LocalDateTime.now(), "Bla bla bla...");
		u1.addComment(c1);
		u1.addComment(c2);
		u1.addComment(c3);
		
		service.addUser(u1);
		
		
		// GET BY ID
//		Optional<User> opt = service.getUserById(3);
//		opt.ifPresent(u -> {
//			System.out.println(u.getFirstname() + " " + u.getLastname() + ": ");
//			u.getComments().forEach(c -> System.out.println(c.getCreated() + " - " + c.getText()));
//		});
//		
//		opt.ifPresent(u -> {
//			// UPDATE COMMENT
//			//u.getComments().get(0).setText("Das ist ein neuer Kommentar...");
//			
//			// DELETE COMMENT
//			service.deleteComment(u.getComments().get(1));
//		});
//		
//		service.update();
		
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
//		service.getAllUsersAsStream().forEach(u -> System.out.println(u.getFirstname() + " " + u.getLastname()));
		
		System.out.println("Ende");
		

	}

}
