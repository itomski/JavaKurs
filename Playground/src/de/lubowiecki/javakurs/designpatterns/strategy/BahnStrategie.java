package de.lubowiecki.javakurs.designpatterns.strategy;

public class BahnStrategie implements NavigationsStrategie {

	@Override
	public void wegBerechnen() {
		System.out.println("Berechneter Weg mit den ÖVs");
	}

}
