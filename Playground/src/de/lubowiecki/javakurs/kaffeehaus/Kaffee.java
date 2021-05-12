package de.lubowiecki.javakurs.kaffeehaus;

public class Kaffee {
	
	private KaffeeArt art;

	public Kaffee(KaffeeArt art) {
		this.art = art;
	}
	
	@Override
	public String toString() {
		return art.toString();
	}
}
