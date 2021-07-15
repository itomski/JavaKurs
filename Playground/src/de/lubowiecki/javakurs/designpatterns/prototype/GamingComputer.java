package de.lubowiecki.javakurs.designpatterns.prototype;

public class GamingComputer extends Computer {

	public GamingComputer(int ram, int hd) {
		super(ram, hd);
	}

	@Override
	public Computer copy() {
		GamingComputer computer = new GamingComputer(getRam(), getHd());
		return computer;
	}
}
