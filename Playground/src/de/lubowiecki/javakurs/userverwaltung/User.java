package de.lubowiecki.javakurs.userverwaltung;

import java.time.LocalDate;

public class User {

	private String firstname;
	private String lastname;
	private LocalDate birthDate;
	
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
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public String getBirthDateStr() {
		return birthDate.format(Utils.DATE_FORMATTER);
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setBirthDate(String birthDateStr) {
		this.birthDate = LocalDate.parse(birthDateStr, Utils.DATE_FORMATTER);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vorname: ").append(firstname).append("\n");
		sb.append("Nachname: ").append(lastname).append("\n");
		sb.append("Geburtsdatum: ").append(getBirthDateStr()).append("\n");
		return sb.toString();
	}
	
}