package de.lubowiecki.javakurs.designpatterns.observer;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

public class NachrichtenAgentur extends Observable {

	private String name;
	
	private Queue<Nachricht> nachrichten = new LinkedList<>();
	
	public NachrichtenAgentur(String name) {
		this.name = name;
	}

	public void addNachricht(Nachricht nachricht) {
		nachrichten.offer(nachricht);
		setChanged(); // Zustand von NachrichtenAgentur hat sich geändert
		informieren();
	}
	
	private void informieren() {
		while(!(nachrichten.size() == 0)) {
			notifyObservers(nachrichten.poll()); // Beobachter werden über die Änderung benachrichtigt
		}
	}
}
