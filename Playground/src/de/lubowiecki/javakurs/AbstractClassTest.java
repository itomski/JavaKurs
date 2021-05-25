package de.lubowiecki.javakurs;

import java.time.LocalDate;

public class AbstractClassTest {

	public static void main(String[] args) { 

		// AbstractPerson ap = new AbstractPerson();
		
		ConcretePerson cp = new ConcretePerson();
		
		cp.setVorname("Peter");
		System.out.println(cp.getVorname());

		System.out.println();
		
		// Abstrakte Klassen können wie Interfaces als Referenztypen genutzt werden
		AbstractPerson ap = new NextConcretePerson();
		ap.setVorname("Hans");
		ap.setNachname("Wurst");
		
		// Referenztyp zeigt mir, was aufrufbar ist...
		ap.machWas(); // ...aber die Instanzmethoden werden IMMER auf dem Objekttyp aufgerufen
		// System.out.println(ap.getGeburtsdatum());
		
		System.out.println();
		
		cp.machWas();
		System.out.println(cp.getGeburtsdatum());
		
	}
}

// Werden häufig als Teil-Umsetzung (Zwischenstuffe) verwendet
abstract class AbstractPerson {
	
	private int id;
	
	private String vorname;
	
	private String nachname;
	
	// Abstrakte Klasse kann alle Access-Modi verwenden, Interface nur public
	// Abstrakte Klasse kann konkrete und abstrakte Methoden enthalten
	
	// Wenn Interface- und Klassen-Vererbung das gleiche vererbt, ist eine Interface-Vererbung  vorzuziehen
	
	// Konkrete und Abstrakte Klassen vererben Fuktionalität - gibt fertige Methoden und ggfl. Eigenschaften weiter 
	// Interfaces vererben Abstraktion - gibt vor, was vorhanden sein muss, aber nicht wie es umgesetzt werden muss
	
	
	public AbstractPerson() {
		// super();
		System.out.println("Const: AbstractPerson");
	}
	
	
	// in abstrakten Klassen müssen abstrakte Methoden mit dem Schlüsselwort "abstract" markiert werden
	abstract void machWas();

	// default Methoden gibt es nur in Interfaces

	// final: Methode darf in der Kindklasse nicht überschrieben werden
	public final int getId() {
		return id;
	}

	// final: Methode darf in der Kindklasse nicht überschrieben werden
	public final void setId(int id) {
		this.id = id;
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
}

class ConcretePerson extends AbstractPerson {
	
//	private int id = 100;
	
	private LocalDate geburtsdatum;
	
	
	public ConcretePerson() {
		// super();
		System.out.println("Const: ConcretePerson");
	}

	@Override
	void machWas() { // Implementiert die abstrakte Methode der Elternklasse
		//System.out.println(vorname); // Kindklasse kann nur nicht-privates Inventar der Elternklasse benutzen
		System.out.println(getVorname() + "...");
	}

	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
}

class NextConcretePerson extends AbstractPerson {
	
	@Override
	void machWas() {
		System.out.println(getVorname() + " " + getNachname());
	}
}
