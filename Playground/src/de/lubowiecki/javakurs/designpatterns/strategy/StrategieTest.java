package de.lubowiecki.javakurs.designpatterns.strategy;

public class StrategieTest {

	public static void main(String[] args) {
		
		DBNavigator db = new DBNavigator();
		db.berechnen();
		
		ADACAutoNavigation adac = new ADACAutoNavigation();
		adac.berechnen();
		
		adac.setStrategie(new FahrradStrategie());
		adac.berechnen();

	}
}
