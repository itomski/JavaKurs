package de.lubowiecki.javakurs.kaffeehaus;

public class EspressoAutomat implements KaffeeAutomat {

	// abstrakte Methoden aus dem Interface müssen überschrieben werden
	@Override
	public Kaffee bereiteKaffeeZu() {
		return new Kaffee(KaffeeArt.ESPRESSO);
	}
	
	// default Methoden aus dem Interface können, müssen aber nicht überschrieben werden
}
