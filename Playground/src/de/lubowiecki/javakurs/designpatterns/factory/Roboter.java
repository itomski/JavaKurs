package de.lubowiecki.javakurs.designpatterns.factory;

import static de.lubowiecki.javakurs.designpatterns.factory.RoboterTyp.*;
import static de.lubowiecki.javakurs.designpatterns.factory.RoboterQualitaet.*;
import static de.lubowiecki.javakurs.designpatterns.factory.Status.*;

public class Roboter {
	
	private RoboterTyp typ;
	private RoboterQualitaet qualitaet;
	private Status status;

	private Roboter(RoboterTyp typ, RoboterQualitaet qualitaet, Status status) {
		this.typ = typ;
		this.qualitaet = qualitaet;
		this.status = status;
	}
	
	// Factory
	public static Roboter createStabdard() {
		return new Roboter(HAUSHALT, NORMAL, NEU);
	}
	
	public static Roboter createNormal(RoboterTyp typ) throws Exception {
		
		switch (typ) {
			case HAUSHALT:
				return new Roboter(HAUSHALT, NORMAL, NEU);
				
			case SICHERHEIT:
				return new Roboter(SICHERHEIT, NORMAL, NEU);
				
			case GARTEN:
				return new Roboter(GARTEN, NORMAL, NEU);
				
			case FORSCHUNG:
				return new Roboter(FORSCHUNG, NORMAL, NEU);
				
			default:
				throw new Exception("Roboter-Typ ist unbekannt");
		}
	}
}
