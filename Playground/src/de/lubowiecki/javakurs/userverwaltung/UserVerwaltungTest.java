package de.lubowiecki.javakurs.userverwaltung;

import java.time.LocalDate;

public class UserVerwaltungTest {

	public static void main(String[] args) {
		
		User u = new User("Peter", "Parker");
		u.setBirthDate("25.07.1982");
		u.setBirthDate(LocalDate.of(1982, 7, 25));
		System.out.println(u);
	}

}
