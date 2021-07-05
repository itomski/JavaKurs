package de.lubowiecki.javakurs.designpatterns.abstractfactory;

public interface Factory<T extends Vehicle> {
	
	T create();

}
