package de.lubowiecki.javakurs.streams;

public class Customer {
	
	private static int count = 0;
	
	private final int nr = ++count;
	
	private String firstname;
	
	private String lastname;
	
	private Type type;

	public Customer(String firstname, String lastname, Type type) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
	}

	public String getNr() {
		return "" + lastname.toLowerCase().charAt(0) + firstname.toLowerCase().charAt(0) + nr;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Customer [nr=" + nr + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}
