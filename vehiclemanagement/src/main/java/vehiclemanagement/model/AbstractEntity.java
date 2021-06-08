package vehiclemanagement.model;

// ORM - Objekt Relationales Mapping
// Relationale Daten (aus Datenbanken) auf POJOs abbilden

// POJO - Plain Old Java Object

// ActiveRecord: Datenklasse (ValueObject, VO), Persistenz-Logik wird in die Datenklasse eingebaut

// DataMapper: Datenklasse + Persistenz-Klasse (je eine Persistenz-Klasse kümmert sich um die Verwaltung je einer Datenklasse)


public abstract class AbstractEntity {

	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
