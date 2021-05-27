package de.lubowiecki.javakurs.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Campus {
	
	public static void main(String[] args) {
		
		Student s1 = new Student("Peter", "Parker");
		Kurs k1 = new Kurs("Kochen ohne Fett");
		s1.setKurs(k1); // 1:1, Unidirektional
		
		// Student weiß welchen Kurs er besucht
		System.out.println(s1.getKurs().getName());
		
		// Kurs weiß nicht, welche Studenten ihn besuchen
		System.out.println(k1);
		
		Uni u1 = new Uni("Lübeck");
		//u1.addStudent(s1); // 1:n, Bidirektional
		s1.setUni(u1); // Da Bidirektional ist dies eine Alternative zu u1.addStudent(...)
		
		System.out.println(s1.getUni().getName()); // Über den Studenten kann ich die Uni abfragen
		
		System.out.println();
		
		// Über die Uni komme ich an die Studenten-Objekte ran
		u1.getStudenten().forEach(s -> System.out.println(s.getVorname() + " " + s.getNachname())); 
		
		System.out.println();
		
		Student s2 = new Student("Bruce", "Banner");
		s2.setUni(u1);
		
		// s1 ist Peter Parker
		// s2 ist Bruce Banner
		
		// Bruce Banner wird Peter Parker als Kommilitone hinzugefügt
		s1.addKommilitone(s2);
		
		// Tony Stark wird Peter Parker als Kommilitone hinzugefügt
		s1.addKommilitone(new Student("Tony", "Stark"));
		
		System.out.println("Kommilitonen von " + s1.getVorname() + " " + s1.getNachname());
		s1.getKommilitonen().forEach(s -> System.out.println(s.getVorname() + " " + s.getNachname())); 
		
		System.out.println();
		
		System.out.println("Kommilitonen von " + s2.getVorname() + " " + s2.getNachname());
		s2.getKommilitonen().forEach(s -> System.out.println(s.getVorname() + " " + s.getNachname()));
		
		// Für eine Map muss der Typ des Schlüssels bestimmt werden
		Map<String, Student> studenten = new HashMap<>();
		s1.getKommilitonen().forEach(s -> studenten.put(s.getMatrikelNr(), s));
		
		System.out.println(studenten);
		
		Map<String, List<String>> studenten2 = new HashMap<>();
		s1.getKommilitonen().forEach(s -> studenten2.put(s.getMatrikelNr(), Arrays.asList(s.getVorname(), s.getNachname(), s.getUni().getName())));
		System.out.println(studenten2);
				
		
		
		
		
	}

}
