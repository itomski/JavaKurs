package de.lubowiecki.javakurs.designpatterns.prototype;

public abstract class Computer {
	
	private int ram;
	private int hd;
	
	public Computer(int ram, int hd) {
		this.ram = ram;
		this.hd = hd;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getHd() {
		return hd;
	}
	
	public void setHd(int hd) {
		this.hd = hd;
	}

	public abstract Computer copy();
}
