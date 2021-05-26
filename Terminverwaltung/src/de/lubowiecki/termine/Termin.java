package de.lubowiecki.termine;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// Serializable: erlaubt, dass dieses Objekt serialisiert wird
// sonst entsteht eine NotSerializableException
// Comparable<Termin> bedeutet dass ein Termin nur mit einem Termin vergleichbar ist
public class Termin implements Serializable, Comparable<Termin> {
	
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

	@Override
	public int compareTo(Termin other) {
		
		//return LocalDateTime.of(this.datum, this.uhrzeit).compareTo(LocalDateTime.of(other.getDatum(), other.getUhrzeit()));
		
		// Reverse
		return LocalDateTime.of(other.getDatum(), other.getUhrzeit()).compareTo(LocalDateTime.of(this.datum, this.uhrzeit));
	}
}
