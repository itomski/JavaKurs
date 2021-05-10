package de.lubowiecki.javakurs;

public class ImmutableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


// Immutable
class Person {
	
	private final String vorname;
	private final String nachname;
	private final String email;
	
	public Person(String vorname, String nachname, String email) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
	}
	
	public String getVorname() {
		return vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public String getEmail() {
		return email;
	}
}
