package de.lubowiecki.javakurs.threads;

import java.awt.Point;

public class Scout extends Thread {
	
	private Tracker tracker;
	
	private Point position;

	public Scout() {
		this.position = new Point();
	}
	
	public Scout(String name) {
		this();
		setName(name);
	}
	
	public Scout(String name, Tracker tracker) {
		this(name);
		this.tracker = tracker;
	}
	
	public Scout(String name, Point position) {
		super(name);
		this.position = position;
	}
	
	// Beschreibt die Aufgabe, die der Thread ausführen soll
	@Override
	public void run() {
		for(int i = 0; i < 1_000_000; i++) {
			move(1, 1);
			//System.out.println(this);
		}
	}
	
	
	public void move(int x, int y) {
		position.x += x;
		position.y += y;
		if(tracker != null)
			tracker.addStep(); // Jeder Thread manipuliert den Zustand des Trackers erstmal lokal und erst dann wird der 
			// Zustand des Trackers im globalen Speicher verfügbar gemacht
	}

	@Override
	public String toString() {
		return getName() + ": " + position;
	}
}
