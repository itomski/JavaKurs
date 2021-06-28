package de.lubowiecki.javakurs.designpatterns.observer;

import java.util.EnumSet;
import java.util.Observable;
import java.util.Observer;

import de.lubowiecki.javakurs.designpatterns.observer.Nachricht.Typ;

public class NachrichtenSender implements Observer {
	
	private EnumSet<Typ> typen;
	
	private String name;
	
	public NachrichtenSender(String name, Typ... typ) {
		this.name = name;
		this.typen = EnumSet.noneOf(Nachricht.Typ.class);
		for(Typ t : typ) {
			this.typen.add(t);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		Nachricht n = (Nachricht) arg;
		
		if(check(n.getTypen())) {
			System.out.println(name + " sendet: " + n.getDatum() + " - " + n.getTitel() + ", " + n.getInhalt());
		}
	}
	
	private boolean check(EnumSet<Typ> nachrichtenTypen) {
		boolean enthalten = false;
		
		for(Typ t : typen) {
			if(nachrichtenTypen.contains(t)) {
				enthalten = true;
				break;
			}
		}
		
		return enthalten;
	}
	
}
