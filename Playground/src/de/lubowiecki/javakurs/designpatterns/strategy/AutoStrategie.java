package de.lubowiecki.javakurs.designpatterns.strategy;

public class AutoStrategie implements NavigationsStrategie {

	@Override
	public void wegBerechnen() {
		System.out.println("Berechneter Weg über Straßen, Landstraßen und Autobahnen");
	}
}
