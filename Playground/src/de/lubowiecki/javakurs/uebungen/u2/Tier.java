package de.lubowiecki.javakurs.uebungen.u2;

public abstract class Tier implements Sozialisiert {

	private final String name;

	public Tier(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
