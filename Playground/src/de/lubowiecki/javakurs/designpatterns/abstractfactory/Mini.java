package de.lubowiecki.javakurs.designpatterns.abstractfactory;

public class Mini implements Vehicle {

	@Override
	public String getType() {
		return "MINI";
	}

	@Override
	public String makeSound() {
		return "WRUM WRUM WRUM";
	}

}
