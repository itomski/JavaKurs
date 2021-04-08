package de.lubowiecki.javakurs.uebungen.u1;

public class Rechner {
	
	private String protocol = "";
	
	public double add(double a, double b) {
		double erg = a + b;
		writeProtocol(a + " + " + b + " = " + erg);
		return erg;
	}
	
	public double minus(double a, double b) {
		double erg = a - b;
		writeProtocol(a + " - " + b + " = " + erg);
		return erg;
	}
	
	public double multi(double a, double b) {
		double erg = a * b;
		writeProtocol(a + " * " + b + " = " + erg);
		return erg;
	}
	
	public double div(double a, double b) {
		double erg = a / b;
		writeProtocol(a + " / " + b + " = " + erg);
		return erg;
	}
	
	private void writeProtocol(String s) {
		protocol += s + "\n";
	}
	
	public String getProtocol() {
		return protocol;
	}
}
