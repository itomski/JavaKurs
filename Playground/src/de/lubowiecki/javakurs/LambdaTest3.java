package de.lubowiecki.javakurs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest3 {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		list.add(new Student("Peter", "Parker", LocalDate.of(1982, 10, 25)));
		list.add(new Student("Steve", "Rogers", LocalDate.of(1922, 11, 10)));
		list.add(new Student("Bruce", "Banner", LocalDate.of(1975, 1, 12)));
		
		// int compare(T o1, T o2);
		Comparator<Student> c1 = (s1, s2) -> s1.getFirstname().compareTo(s2.getFirstname());
		Comparator<Student> c2 = (s1, s2) -> s1.getLastname().compareTo(s2.getLastname());
		Comparator<Student> c3 = (s1, s2) -> s1.getBirthdate().compareTo(s2.getBirthdate());
		
		Collections.sort(list, c3);
		
		System.out.println(list);
	}
}

class Student {
	
	private String firstname;
	
	private String lastname;
	
	private LocalDate birthdate;
	
	public Student(String firstname, String lastname, LocalDate birthdate) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate + "]";
	}
}
