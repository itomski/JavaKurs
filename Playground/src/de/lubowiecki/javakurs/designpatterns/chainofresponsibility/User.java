package de.lubowiecki.javakurs.designpatterns.chainofresponsibility;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User {
	
	private final String firstname;
	private final String lastname;
	private final LocalDate birthDate;
	
	private final Set<Privileg> privilegs = new HashSet<>();
	
	public User(String firstname, String lastname, LocalDate birthDate, Privileg... privilegs) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
		this.privilegs.addAll(Arrays.asList(privilegs));
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Set<Privileg> getPrivilegs() {
		return Collections.unmodifiableSet(privilegs);
	}
}
