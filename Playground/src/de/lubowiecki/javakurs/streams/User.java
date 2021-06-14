package de.lubowiecki.javakurs.streams;

import java.time.LocalDate;

public class User {
	
	private static int count = 0; 
	
	private final int id = ++count;
	private String firstname;
	private String lastname;
	private LocalDate birthDate;
	
	public User() {
	}
	
	public User(String firstname, String lastname, LocalDate birthDate) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
	}
	
	public int getId() {
		return id;
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthDate=" + birthDate + "]";
	}

	
}
