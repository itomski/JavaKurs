package de.lubowiecki.javakurs.designpatterns.observer;

import java.time.LocalDateTime;

import de.lubowiecki.javakurs.designpatterns.observer.Nachricht.Typ;

public class ObserverTest {

	// GOF : Gang Of Four
	public static void main(String[] args) {
		
		// Observer
		NachrichtenSender tagesschau = new NachrichtenSender("Tagesschau", Typ.POLITIK, Typ.WIRTSCHAFT); 
		NachrichtenSender ran = new NachrichtenSender("Ran", Typ.SPORT); 
		NachrichtenSender dRadioKultur = new NachrichtenSender("D-Radio Kultur", Typ.KULTUR);
		NachrichtenSender polit = new NachrichtenSender("Polit-Zeug", Typ.POLITIK);
		
		// Observable
		NachrichtenAgentur agentur = new NachrichtenAgentur("Reuters");
		
		agentur.addObserver(tagesschau);
		agentur.addObserver(ran);
		agentur.addObserver(dRadioKultur);
		agentur.addObserver(polit);
		
		// Wir ändern den Zustand des Observable
		agentur.addNachricht(new Nachricht(LocalDateTime.now(), "COVID-19 vorbei", "...", Typ.POLITIK, Typ.WIRTSCHAFT));
		System.out.println();
		agentur.addNachricht(new Nachricht(LocalDateTime.now(), "Euro 2021 zu ende", "...", Typ.SPORT));
	}
}
