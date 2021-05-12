package de.lubowiecki.javakurs.kaffeehaus;

public class InterfaceTest2 {

	public static void main(String[] args) {
		
		// Referenztyp: KaffeeAutomat
		// Objekttyp: EspressoAutomat
		KaffeeAutomat automat = new EspressoAutomat();
		
		// Instanzmethoden werden auf dem Objekttyp ausgeführt
		Kaffee tasse1 = automat.bereiteKaffeeZu();
		System.out.println(tasse1);
		
	}
}