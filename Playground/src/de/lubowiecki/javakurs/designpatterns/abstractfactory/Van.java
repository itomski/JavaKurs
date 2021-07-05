package de.lubowiecki.javakurs.designpatterns.abstractfactory;

public class Van implements Vehicle {
	
	private Type type;
	
	public Van(Type t) {
		type = t;
	}
	
	public String getType() {
		return type.toString();
	}

	@Override
	public String makeSound() {
		return "GRRRRRR GRRRRRR";
	}
}
	

