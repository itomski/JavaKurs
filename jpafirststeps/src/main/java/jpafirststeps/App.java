package jpafirststeps;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Start");
		
		Service service = new Service();
		
		User u1 = new User();
		u1.setFirstname("Peter");
		u1.setLastname("Parker");
		u1.setBirthDate(LocalDate.of(1982, 10, 5));
		
		service.addUser(u1);
		
		System.out.println("Ende");
		

	}

}
