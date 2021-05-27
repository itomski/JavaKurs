package de.lubowiecki.javakurs.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Uni {
	
	public final static Uni UNBEKANNT = new Uni("Unbekannt");
	
	private String name;
	
	// Set, weil jeder Student nur ein mal in der Uni eingeschrieben sein darf
	private Set<Student> studenten = new HashSet<>();
	
	public Uni(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudenten() {
		// Option 1: Original Set wird zurückgegeben, in den meisten Fällen zu gefährlich
		//return studenten;
		
		// Option 2: Eine Kopie des Studenten-Sets wird zurückgegeben
		//return new HashSet<>(studenten);
		
		// Option 3: Ein nicht veränderbares Set wird zurückgegeben
		return Collections.unmodifiableSet(studenten);
	}

	// Der Standard-Setter würde das komplette Set überschreiben,
	// daher wird er gegen einen ausgetauscht, den nur einen Studenten zum Set hinzufügt
	public void addStudent(Student student) {
		if(!studenten.contains(student)) {
			this.studenten.add(student);
			student.setUni(this); // this ist eine Referenz auf das Objekt, auf dem gerade die addStudent-Methode aufgerufen wird
		}
	}	
}
