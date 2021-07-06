package de.lubowiecki.javakurs.designpatterns.strategy;

public class FahrradStrategie implements NavigationsStrategie {


	@Override
	public void wegBerechnen() {
		System.out.println("Berechneter Weg mit über Straßen und Wege");
	}
	
}
