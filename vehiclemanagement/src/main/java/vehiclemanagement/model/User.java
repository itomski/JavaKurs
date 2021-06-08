package vehiclemanagement.model;

import java.time.LocalDate;

public class User extends AbstractEntity {
	
	private String firstname;
	private String lastname;
	private LocalDate birthDate;
	
	public User() {
	}
	
	public User(int id, String firstname, String lastname, LocalDate birthDate) {
		this.setId(id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
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
}
