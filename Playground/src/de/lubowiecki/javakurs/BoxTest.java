package de.lubowiecki.javakurs;

import de.lubowiecki.javakurs.data.Box;

public class BoxTest {

	public static void main(String[] args) {
		
		Box b1 = new Box();
		
		b1.setInhalt("Das ist ein Haus von Nikigraus");
		b1.setInhalt("...");
		System.out.println(b1.getInhalt());
		
		System.out.println("----------");
		
		b1.setContent("Das ist ein Haus von Nikigraus");
		b1.setContent("...");
		System.out.println(b1.getContent());
		
		System.out.println("---------------");
		
		String s1 = "Hallo"; // Landet im String-Literal-Pool
		String s2 = "Hallo"; // s2 zeigt auf das im Pool vorhandene String-Objekt
		System.out.println(s1 == s2);
		
		String s3 = new String("Hallo"); // Landet NICHT im String-Literal-Pool, wird immer neu auf dem Heap erzeugt
		String s4 = new String("Hallo");
		System.out.println(s3 == s4);
		
		String s5 = s1; // zeigt auf das im Pool vorhandene String-Objekt
		s5 += "Hi"; // Referenz zeigt auf ein neues Objekt im Pool
		System.out.println(s5 == s1);
		
		System.out.println("---------------");
		
		System.out.println(s1);
		System.out.println(s1.toUpperCase()); // Ändert nicht das Original sondern erzeugt eine neue Version
		System.out.println(s1);
	}

}
