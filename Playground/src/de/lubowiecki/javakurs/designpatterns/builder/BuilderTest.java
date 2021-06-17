package de.lubowiecki.javakurs.designpatterns.builder;

public class BuilderTest {

	public static void main(String[] args) {
		
		//Kurs k1 = new Kurs(10, "abc", "....");
		
		// Builder baut mir eiun immutable-Objekt nach Vorgaben
		Kurs k2 = new Kurs.Builder().setName("Xyz").setNr(100).build();

	}
}
