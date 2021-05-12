package de.lubowiecki.javakurs.kaffeehaus;

public class EspressoAutomat implements KaffeeAutomat {

	@Override
	public Kaffee bereiteKaffeeZu() {
		return new Kaffee(KaffeeArt.ESPRESSO);
	}
}
