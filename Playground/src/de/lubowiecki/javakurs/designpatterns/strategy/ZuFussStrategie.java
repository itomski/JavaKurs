package de.lubowiecki.javakurs.designpatterns.strategy;

public class ZuFussStrategie implements NavigationsStrategie {

	@Override
	public void wegBerechnen() {
		System.out.println("Berechneter Weg mit und Wege und Pfade");
	}
}
