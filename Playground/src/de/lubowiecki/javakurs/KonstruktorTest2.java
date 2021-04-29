package de.lubowiecki.javakurs;

public class KonstruktorTest2 {

	public static void main(String[] args) {
		
		PKW p = new PKW(1); // Steht sofort für GC zur Verfügung, da keine Referenz darauf zeigt
		p = null;
		System.gc(); // Bitte darum Müll abzuholen d.h. alle nicht mehr referenzierten Objekte auf dem Heap
	}
}

class Fahrzeug {
	
	private String kennzeichen;
	
	// Konstruktoren werden NICHT vererbt
	public Fahrzeug(String kennzeichen) {
		// super();
		System.out.println("Fahrzeug String");
		this.kennzeichen = kennzeichen;
	}
	
	// Der Default-Konstruktor wird nicht mehr automatisch bereitgestellt, sobald ein eigener gebaut wurde
	public Fahrzeug() {
		// super();
		System.out.println("Fahrzeug");
	}
}

class PKW extends Fahrzeug {
	
	private int speed;
	
	public PKW() {
		// super() oder this() Aufrufe, wenn vorhanden, müssen die erste Zeile im Konstruktor sein
		// super(); // Ruft den Konstruktor der Elternklasse
		System.out.println("PKW");
	}
	
	public PKW(double d) {
		this();
		System.out.println("PKW double");
	}
	
	public void PKW(double d1, double d2) { // ist kein Konstruktor, sondern eine Methode
		// this(); // Instanzmethoden dürfen den eigenen Konstruktor nicht aufrufen
		System.out.println("PKW double");
	}
	
	public PKW(int i) {
		this(i * 1.0); // Aufruf eines anderen eigenen Konstruktors DIESER  Klasse 
		this.speed = 10; // this ist eine Referenz auf ein fertiges Objekt
		// erst Objekt bauen, dann das Objekt manipulieren
		System.out.println("PKW int");
	}
	
	// Methode wird automatisch von GC aufgerufen, wenn das Objekt vom Speicher entfernt wird
	@Override
	public void finalize() { // Destructor
		System.out.println("UGH!!!!!!!!! AGRRRRRRR!!!!!");
	}
}