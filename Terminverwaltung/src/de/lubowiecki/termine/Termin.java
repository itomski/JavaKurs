package de.lubowiecki.termine;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

// Serializable: erlaubt, dass dieses Objekt serialisiert wird
// sonst entsteht eine NotSerializableException
public class Termin implements Serializable {
	
	private LocalDate datum;
	
	private LocalTime uhrzeit;
	
	private String beschreibung;
	
	public Termin(LocalDate datum, LocalTime uhrzeit, String beschreibung) {
		this.datum = datum;
		this.uhrzeit = uhrzeit;
		this.beschreibung = beschreibung;
	}
	
	public Termin(String beschreibung) {
		this(LocalDate.now(), LocalTime.now(), beschreibung);
	}
	
	public Termin(LocalDate datum, LocalTime uhrzeit) {
		this(datum, uhrzeit, "");
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public LocalTime getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(LocalTime uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	@Override
	public String toString() {
		return "Termin [datum=" + datum + ", uhrzeit=" + uhrzeit + ", beschreibung=" + beschreibung + "]";
	}
}
