package de.lubowiecki.javakurs.kita;

import java.time.LocalDate;

public class Kind {
	
	private String vorname;
	
	private String nachname;
	
	private LocalDate geburtsdatum;

	public Kind() {
	}
	
	public Kind(String vorname, String nachname, LocalDate geburtsdatum) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
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

	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	@Override
	public String toString() {
		return "Kind [vorname=" + vorname + ", nachname=" + nachname + ", geburtsdatum=" + geburtsdatum + "]";
	}
}
