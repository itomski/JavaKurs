package de.lubowiecki.javakurs.uebungen.u2;

public class Wolf extends Tier {

	public Wolf(String name) {
		super(name);
	}
	
	@Override
	public void doFresszeit() {
		System.out.println(getClass().getSimpleName() + ": frisst");
		
	}

	@Override
	public void doNachtruhe() {
		System.out.println(getClass().getSimpleName() + ": geht auf die Jagd");
		
	}
}
