package de.lubowiecki.javakurs.kita;

import java.util.ArrayList;

public class KitaGruppe {
	
	private String name;
	
	private final ArrayList<Kind> kinder;
	
	// nr 1
	public KitaGruppe() {
		//super();
		kinder = new ArrayList<>(); // Das interne Array hat eine Größe von 10 Plätzen
	}
	
	// nr 2
	public KitaGruppe(int anzahl) {
		//super();
		kinder = new ArrayList<>(anzahl); // Das interne Array hat eine Größe von anzahl Plätzen
	}
	
	// nr 3
	public KitaGruppe(String name) {
		this(); // Aufruf des Konstruktors nr 1
		this.name = name;
	}
	
	public KitaGruppe(String name, int anzahl) {
		this(anzahl); // Aufruf eines des Konstruktors nr 2 
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Kind> getKinder() {
		return kinder;
	}

	public void addKind(Kind kind) {
		this.kinder.add(kind);
	}

	@Override
	public String toString() {
		return "KitaGruppe [name=" + name + ", kinder=" + kinder + "]";
	}
}
