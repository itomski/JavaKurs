package de.lubowiecki.javakurs.designpatterns.prototype;

public class Laptop extends Computer {
	
	public Laptop(int ram, int hd) {
		super(ram, hd);
	}

	@Override
	public Computer copy() {
		Laptop computer = new Laptop(getRam(), getHd());
		return computer;
	}
}
