package de.lubowiecki.javakurs.designpatterns.strategy;

public abstract class AbstractNavi {
	
	private NavigationsStrategie strategie = new AutoStrategie();

	public void setStrategie(NavigationsStrategie strategie) {
		this.strategie = strategie;
	}
	
	public void berechnen() {
		strategie.wegBerechnen();
	}
}
