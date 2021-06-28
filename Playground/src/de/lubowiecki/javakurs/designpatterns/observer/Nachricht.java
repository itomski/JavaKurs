package de.lubowiecki.javakurs.designpatterns.observer;

import java.time.LocalDateTime;
import java.util.EnumSet;

public class Nachricht {
	
	private final EnumSet<Typ> typen;
	private final String titel;
	private final String inhalt;
	private final LocalDateTime datum;
	
	public Nachricht(LocalDateTime datum, String titel, String inhalt, Typ... typ) { // VarArg
		this.datum = datum;
		this.titel = titel;
		this.inhalt = inhalt;
		this.typen = EnumSet.noneOf(Nachricht.Typ.class);
		for(Typ t : typ) {
			this.typen.add(t);
		}
	}
	
	public EnumSet<Typ> getTypen() {
		return typen;
	}
	
	public String getTitel() {
		return titel;
	}

	public String getInhalt() {
		return inhalt;
	}
	
	public LocalDateTime getDatum() {
		return datum;
	}

	// Innere-Klasse
	// static: kann auch ohne ein Objekt von Nachricht verwerndet werden
	public static enum Typ {
		SPORT, POLITIK, WIRTSCHAFT, KULTUR; 
	}
}
