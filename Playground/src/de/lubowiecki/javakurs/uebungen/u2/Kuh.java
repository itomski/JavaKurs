package de.lubowiecki.javakurs.uebungen.u2;

public class Kuh extends Tier {

	public Kuh (String name) {
		super(name);
	}
	
	@Override
	public void doFresszeit() {
		System.out.println(getClass().getSimpleName() + ": frisst Gras");
		
	}

	@Override
	public void doNachtruhe() {
		System.out.println(getClass().getSimpleName() + ": pennt");
		
	}
}
