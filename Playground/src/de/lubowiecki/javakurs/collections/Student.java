package de.lubowiecki.javakurs.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Vererbung definiert eine IS-A Beziehung
public class Student {
	
	private String vorname;
	
	private String nachname;
	
	private static int count;
	
	private final String matrikelNr;
	
	// Eigenschaften definieren eine HAS-A Beziehung
	// 1 : 1, Unidirektional
	private Kurs kurs;
	
	// 1 : n, Bidirektional
	private Uni uni;
	
	// n : m, Bidirektional
	private Set<Student> kommilitonen = new HashSet<>();
	
	public Student(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelNr = "" + vorname.charAt(0) + nachname.charAt(0) + ++count;
		this.uni = Uni.UNBEKANNT;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}

	public Uni getUni() {
		return uni;
	}

	public void setUni(Uni uni) {
		if(this.uni != uni) {
			this.uni = uni;
			uni.addStudent(this);
		}
	}

	public Set<Student> getKommilitonen() {
		// return kommilitonen;
		return Collections.unmodifiableSet(kommilitonen); // Unveränderbare Kopie wird zurückgegeben
	}

	public void addKommilitone(Student kommilitone) {
		
		
		// Beispiel: Peter Parker (this) fügen wir Tony Stak (kommilitone) als Kommilitonen dazu
		
		// dann wird geprüft, ob Tony Stak bereits in der Menge der Kommilitonen bei Peter Parker (this) enthalten ist
		if(!this.kommilitonen.contains(kommilitone)) {
			// wenn NEIN, dann wird er hinzugefügt
			this.kommilitonen.add(kommilitone);
			// und dann wir umgekehrt auch Peter Parker als Kommilitone bei Tony Stak eingetragen
			kommilitone.addKommilitone(this);
		}
	}

	public String getMatrikelNr() {
		return matrikelNr;
	}
}
