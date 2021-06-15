package de.lubowiecki.javakurs.lambda;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SupplierTest {

	public static void main(String[] args) {
		
		Supplier<Integer> w6 = () -> (int)(Math.random() * 6 + 1);
		Supplier<Integer> w100 = () -> (int)(Math.random() * 100 + 1);
		Supplier<Integer> w10 = () -> (int)(Math.random() * 10 + 1);
		
		int[] arr = makeRandoms(10_000, w6); // 10.000 x 1...6
		arr = makeRandoms(10, w100); // 10 x 1...100
		arr = makeRandoms(100, w10); // 100 x 1...10
		arr = makeRandoms(100, () -> 10); // 100 x 10
		
		System.out.println("----------");
		
		Supplier<User> userSup = () -> new User("Unbekannt", "Unbekannt");
		
		Supplier<User> randUserSup = () ->  {
			
			String[] firstname = {"Peter", "Carol", "Bruce", "Tony", "Natasha", "Steve"};
			String[] lastname = {"Parker", "Wayne", "Banner", "Stark"};
			
			Random r = new Random();
			
			return new User(firstname[r.nextInt(firstname.length - 1)], lastname[r.nextInt(lastname.length - 1)]);
		};
		
		//User u = userSup.get();
		User u = randUserSup.get();
		System.out.println(u.getFirstname() + " " + u.getLastname());
		

		Supplier<String> strSup = () ->  "";
		
		System.out.println("-------------");
		
		// IntSupplier: Supplier für primitive ints, gibt noch für Double und Long
		IntSupplier randW6 = () -> (int)(Math.random() * 6 + 1);
		IntSupplier randW100 = () -> (int)(Math.random() * 100 + 1);
		
		// Stream von primitiven ints
		IntStream.generate(randW100)
			.limit(10)
			.forEach(i -> System.out.println(i));
		
		System.out.println("-------------");
		
		Stream.generate(randUserSup)
			.limit(10)
			.forEach(user -> System.out.println(user.getFirstname() + " " + user.getLastname()));
		
		
	}
	
	public static int[] makeRandoms(int size, Supplier<Integer> sup) {
		
		int[] arr = new int[size];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sup.get();
		}	
		
		return arr;
	}
}

class User {
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	private String firstname;
	private String lastname;
	
	public User() {
	}
	
	public User(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
