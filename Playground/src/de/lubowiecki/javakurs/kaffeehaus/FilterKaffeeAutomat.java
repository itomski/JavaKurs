package de.lubowiecki.javakurs.kaffeehaus;

public class FilterKaffeeAutomat implements KaffeeAutomat {

	@Override
	public Kaffee bereiteKaffeeZu() {
		return new Kaffee(KaffeeArt.FILTER);
	}
	
	@Override
	public boolean reinigung() {
		System.out.println("Automat wird gespült");
		return true;
	}
}
