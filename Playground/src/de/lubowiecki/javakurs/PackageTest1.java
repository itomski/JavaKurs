package de.lubowiecki.javakurs;

import java.util.Date;
import static java.lang.System.*;
import static java.lang.Math.PI;

import de.lubowiecki.javakurs.data.Thing;

public class PackageTest1 {
	
	// Instanzvariable
	private int zahl;
	
	// Klassenvariable
	private static int andereZahl;
	

	public static void main(String[] args) {
		
		Thing t1 = new Thing("Zange");
		System.out.println(t1.getName());
		
		Date d = new Date();
		java.sql.Date d2 = new java.sql.Date(1L);
		
		out.print(PI * 2);
		
		System.out.println("-----------");
		
		// Klassenvariable
		andereZahl = 10;
		System.out.println(andereZahl);
		
		// Instanzvariable
		PackageTest1 pt1 = new PackageTest1();
		pt1.zahl = 20;
		System.out.println(pt1.zahl);
		pt1.andereZahl = 25; // Über die Referenz wird auf die Variable im Bauplan zugegriffen
		
		
		PackageTest1 pt2 = new PackageTest1();
		pt2.zahl = 15;
		System.out.println(pt2.zahl);
		pt2.andereZahl = 27; // Nutzt die gleich Variable aus dem Bauplan
		
		
		PackageTest1 pt3 = pt1;
		
		String s1 = "Moin";
		// String-Literal-Pool kommt zum einsatz
		String s2 = "Moin";
		
		s1 = s1.toUpperCase(); // Neues Objekt auf dem Heap (MOIN)
	}
}