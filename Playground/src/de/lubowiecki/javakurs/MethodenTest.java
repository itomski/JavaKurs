package de.lubowiecki.javakurs;

public class MethodenTest {
	
	public static void main(String[] args) {
		
		machWasAnderes();
		// Außerhalb der Klasse
		MethodenTest.machWasAnderes();
		
		MethodenTest mt = new MethodenTest();
		mt.machWas();
		
		System.out.println(MethodenTest.genRand());
			
	}
	
	// Instanzmethode
	public void machWas() {
		System.out.println("machWas");
	}
	
	// Instanzmethode
	public void machDies() {
		//this.machWas();
		machWas();
	}
	
	// Klassenmethode
	public static void machWasAnderes() {
		System.out.println("machWasAnderes");
	}
	
	public static int genRand() {
		return (int) Math.floor(Math.random() * 10) + 1;
	}
	
}
