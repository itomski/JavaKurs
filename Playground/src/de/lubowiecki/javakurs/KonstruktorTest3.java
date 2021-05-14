package de.lubowiecki.javakurs;

public class KonstruktorTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class AAA {
	
	public AAA(String s) {
		// super(); // Ruft den parameterlosen Konstruktor der Elternklasse d.h. Object auf
	}
	
}

class BBB extends AAA {
	
	public BBB() {
		// super(); // Ruft den parameterlosen Konstruktor der Elternklasse d.h. AAA auf
		// Error: parameterloser Konstruktor ist nicht da!
		super(null); // Auruf des String-Parameter-Konstruktors der Elternklasse d.h. AAA auf
	}
	
	public BBB(String s) {
		this(); // Ruft den parameterlosen Konstruktor DIESER Klasse d.h. BBB auf
	}
	
}