package de.lubowiecki.javakurs.designpatterns.strategy;

public class DBNavigator extends AbstractNavi {

	public DBNavigator() {
		setStrategie(new BahnStrategie());
	}
	
}
